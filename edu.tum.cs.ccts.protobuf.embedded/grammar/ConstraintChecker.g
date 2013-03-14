/*--------------------------------------------------------------------------+
|                                                                          |
| Copyright 2008-2012 Technische Universitaet Muenchen                     |
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
 * A tree grammar that walks an Proto-language AST and checks syntactic and
 * semantic constraints.
 *
 * @author wolfgang.schwitzer
 * @author nvpopa
 */

tree grammar ConstraintChecker;

options {
	tokenVocab=Proto;
	ASTLabelType=CommonTree;
}

@header {
package edu.tum.cs.ccts.protobuf.embedded;

import java.util.HashSet;
import java.util.HashMap;
import java.util.Arrays;
}

@members {
private HashSet<String> nameScope = new HashSet<String>();
private HashSet<Integer> valueScope = new HashSet<Integer>();
String[] types = { "int32", "int64", "sint32", "sint64", "uint32", "uint64", "bool", "bytes", 
                    "string", "float", "double", "fixed32", "fixed64", "sfixed32", "sfixed64" };
private final HashSet<String> dataTypes = new HashSet<String>(Arrays.asList(types));
private HashSet<String> globalNameScope = new HashSet<String>();
public int constraintErrors = 0;
protected void constraintError(int line, String msg) { 
  System.err.println("Error in line " + line + ": " + msg);
  constraintErrors++;
}
private HashSet<String> annotations = new HashSet<String>();
public HashMap<String, Integer> topologicalOrder = new HashMap<String, Integer>();

}

proto 
	:	^(PROTO packageDecl? importDecl* declaration*)
	;
                
packageDecl
	:	^(PACKAGE qualifiedID) 
	;

importDecl
	:	^(IMPORT STRING) 	
	;

declaration
	:	optionDecl 
	| enumDecl
	|	messageDecl
	|	annotationDecl
	;

optionDecl 
  : ^(OPTION ID STRING)  
  ;

enumDecl
  @init { nameScope.clear(); valueScope.clear(); }
	:	^(ENUM ID enumElement*)
	  {
	    dataTypes.add($ID.text);
	    if (globalNameScope.contains($ID.text))
		    constraintError($ID.line, "duplicate enum name " + $ID.text);
	    globalNameScope.add($ID.text);
	  }
	;

enumElement
	:	^(ASSIGN ID INTEGER)
		{
		  int index = Integer.parseInt($INTEGER.text);
		  if (index < 0 || index > 127)
		    constraintError($INTEGER.line, "enum element " + index + " out of valid range [0..127]");
		  if (nameScope.contains($ID.text))
		    constraintError($ID.line, "duplicate element name " + $ID.text);
		  nameScope.add($ID.text);
		  if (valueScope.contains(index))
		    constraintError($INTEGER.line, "duplicate element value " + index);
		  valueScope.add(index);
		}
	;

messageDecl
  scope {
    String name;
  }
  @init { nameScope.clear(); valueScope.clear();}
	:	^(MESSAGE ID {$messageDecl::name=$ID.text;} messageElement*)
		{
		  if (globalNameScope.contains($ID.text))
        constraintError($ID.line, "duplicate message name " + $ID.text);
      globalNameScope.add($ID.text);
      if (!topologicalOrder.containsKey($ID.text))
        topologicalOrder.put($ID.text, 0);
		}
	;

annotationDecl
	:	^(ANNOTATION ID INTEGER)
		{
			if (!globalNameScope.isEmpty())
				constraintError($ID.line, "cannot use annotations after message/enum declarations");
			String name = $ID.text;
			if (!name.equals("max_repeated_length") && !name.equals("max_string_length") && !name.equals("max_bytes_length"))
				constraintError($ID.line, "unknown annotation " + name);
			if (annotations.contains(name))
				constraintError($ID.line, "duplicate annotation " + name);
			/* 
			 * 2^7 * 2^7 == 2^14 for "repated string".
			 * That's OK for size (maximum 2 byte varint), which has 14bit payload.
			 */
			int v = Integer.parseInt($INTEGER.text);
			if (v < 2 || v > 127)
				constraintError($ID.line, name + " must be within [2..127], but was " + v);
			annotations.add(name);
		}
	;

messageElement
	:	^(ASSIGN MODIFIER (t=TYPE | t=ID) n=ID tagVal=INTEGER (defaultVal=(INTEGER | REAL | STRING | ID))?)
	   {
	     int tag = Integer.parseInt($tagVal.text);
	     if (tag <= 0 || tag > 4095)
	       constraintError($tagVal.line, "tag: " + tag + " out of valid range [1..4095]");
	     if (nameScope.contains($n.text))
         constraintError($n.line, "duplicate element name " + $n.text);
	     nameScope.add($n.text);
	     if (valueScope.contains(tag))
         constraintError($tagVal.line, "duplicate tag value " + tag);
       valueScope.add(tag);
       //if (!dataTypes.contains($t.text) && globalNameScope.contains($t.text))
         //constraintError($t.line, "unsupported data type: " + $t.text + "\nData types must be natives, enums or embedded messages");
       if (!dataTypes.contains($t.text)) {
         Integer elementOrder = topologicalOrder.get($t.text);
         if (elementOrder == null)
           elementOrder = 0;
         Integer messageOrder = topologicalOrder.get($messageDecl::name);
         if (messageOrder == null)
           messageOrder = 0;
         elementOrder = Math.max(elementOrder, messageOrder + 1);
         topologicalOrder.put($t.text, elementOrder);
       }
	   }
	;

qualifiedID
	:	(i+=ID)+
	;
