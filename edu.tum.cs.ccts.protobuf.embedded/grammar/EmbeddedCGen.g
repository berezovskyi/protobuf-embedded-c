/*--------------------------------------------------------------------------+
|                                                                          |
| Copyright 2008-2011 Technische Universitaet Muenchen                     |
|                                                                          |
| Licensed under the Apache License, Version 2.0 (the "License");          |
| you may not use this file except in compliance with the License.         |
| You may obtain a copy of the License at                                  |
|                                                                          |
|    http://www.apache.org/licenses/LICENSE-2.0                            |
|                                                                          |
| Unless required by applicable law or agreed to in writing, software      |
| distributed under the License is distributed on an "AS IS" BASIS,        |
| WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. |
| See the License for the specific language governing permissions and      |
| limitations under the License.                                           |
+--------------------------------------------------------------------------*/

/**
 * A tree grammar that walks an Proto-language AST and generates output by
 * a string template.
 *
 * @author wolfgang.schwitzer
 * @author nvpopa
 */

tree grammar EmbeddedCGen;

options {
	tokenVocab=Proto;
	ASTLabelType=CommonTree;
	output=template;
}

@header {
package edu.tum.cs.ccts.protobuf.embedded;
}

@members {
String filename;
HashMap<String, String> typeMap = new HashMap<String, String>();
HashMap<String, Integer> annotationMap = new HashMap<String, Integer>();
int messageSize;
int elementCount;
}

proto [String filename]
	@init { this.filename = filename; }
	@after {
		Integer repeatedLength = annotationMap.get("max_repeated_length");
		if (repeatedLength == null) repeatedLength = 32;
		Integer stringLength = annotationMap.get("max_string_length");
		if (stringLength == null) stringLength = 32;
		Integer bytesLength = annotationMap.get("max_bytes_length");
		if (bytesLength == null) bytesLength = 32;
		retval.st.setAttribute("max_repeated_length", repeatedLength);
		retval.st.setAttribute("max_string_length", stringLength);
		retval.st.setAttribute("max_bytes_length", bytesLength);
	}
	:	^(PROTO p+=packageDecl? (i+=importDecl)* (d+=declaration)*)
			-> proto(packageDecl={$p}, importDecls={$i}, declarations={$d}, filename={$filename}) 
	;
                
packageDecl
	:	^(PACKAGE qualifiedID) 
			-> packageDecl(qualifiedID={$qualifiedID.st})	
	;

importDecl
	:	^(IMPORT STRING) 	
			-> importDecl(name={$STRING.text})
	;

declaration
	:	optionDecl 
	| enumDecl -> {$enumDecl.st}
	|	messageDecl -> {$messageDecl.st}
	|	annotationDecl
	;

optionDecl 
  : ^(OPTION ID STRING)  
  ;

enumDecl
	:	^(ENUM ID (e+=enumElement)*) 
			{typeMap.put($ID.text, "enum");}
			-> enumDecl(name={$ID.text}, elements={$e}, filename={filename}, line={$ENUM.line})
	;

enumElement
	:	^(ASSIGN ID INTEGER)
			-> enumElement(name={$ID.text}, value={$INTEGER.text})
	;

messageDecl
  @init { 
          messageSize = 2; /* 2 bytes length for (write|read)delimited. */
          elementCount = 0; /* initialisation of number of elements. */ 
        }
  @after { 
           retval.st.setAttribute("maxsize", messageSize);
           retval.st.setAttribute("empty", elementCount <= 0 ? Boolean.TRUE : Boolean.FALSE);
         }
	:	^(MESSAGE ID (e+=messageElement)*)
		{typeMap.put($ID.text, "message");}
			-> messageDecl(name={$ID.text}, elements={$e}, filename={filename}, line={$MESSAGE.line})
	;
	
annotationDecl
	:	^(ANNOTATION ID INTEGER)
		{
			annotationMap.put($ID.text, Integer.parseInt($INTEGER.text));
		}
	;

messageElement
	:	^(ASSIGN MODIFIER (t=TYPE | t=ID) n=ID INTEGER )
	   {
	      ++ elementCount;
         Integer repeatedLength;
         if ($MODIFIER.text.equals("repeated")) {
         	repeatedLength = annotationMap.get("max_repeated_length");
	     	if (repeatedLength == null) repeatedLength = 32;
	     } else {
	     	repeatedLength = 1;
	     }
	     String type = $t.text;
	     if (type.equals("int32")) {
	       messageSize += repeatedLength * (2 + 10);
	     } else if (type.equals("int64")) {
         messageSize += repeatedLength * (2 + 10);
       } else if (type.equals("sint32")) {
         messageSize += repeatedLength * (2 + 5);
       } else if (type.equals("sint64")) {
         messageSize += repeatedLength * (2 + 10);
       } else if (type.equals("uint32")) {
         messageSize += repeatedLength * (2 + 5);
       } else if (type.equals("uint64")) {
         messageSize += repeatedLength * (2 + 10);
       } else if (type.equals("string")) {
	       Integer stringLength = annotationMap.get("max_string_length");
	       if (stringLength == null) stringLength = 32;
	       messageSize += repeatedLength * (2 + 1 + stringLength);
	     } else if (type.equals("float")) {
	       messageSize += repeatedLength * (2 + 4);
	     } else if (type.equals("fixed32")) {
	       messageSize += repeatedLength * (2 + 4);
	     } else if (type.equals("fixed64")) {
	       messageSize += repeatedLength * (2 + 8);
	     } else if (type.equals("sfixed32")) {
	       messageSize += repeatedLength * (2 + 4);
	     } else if (type.equals("sfixed64")) {
	       messageSize += repeatedLength * (2 + 8);
	     } else if (type.equals("double")) {
         messageSize += repeatedLength * (2 + 8);
	     } else if (type.equals("bool")) {
         messageSize += repeatedLength * (2 + 1);
	     } else if (type.equals("bytes")) {
	       Integer bytesLength = annotationMap.get("max_bytes_length");
         if (bytesLength == null) bytesLength = 32;
         messageSize += repeatedLength * (2 + 1 + bytesLength);
       } else { 
         //enums
         messageSize += repeatedLength * (2 + 1);
       }
	   }
			-> messageAttribute(
			     modifier={$MODIFIER.text}, 
			     typeName={$t.text},
			     typeClass={typeMap.containsKey($t.text)?typeMap.get($t.text):"native"},
			     name={$n.text}, 
			     tag={$INTEGER.text} )
	;

qualifiedID
	:	(i+=ID)+
			-> qualifiedID(ids={$i})
	;
