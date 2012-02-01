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
 * A grammar for an embedded systems specific subset of the Proto-language
 * of google's protocol buffers.
 *
 * @author wolfgang.schwitzer
 * @author nvpopa
 */

grammar Proto;

options {
  output=AST;
  ASTLabelType=CommonTree;
}

tokens {
  PROTO;
  PACKAGE = 'package';
  IMPORT = 'import';
  OPTION = 'option';
  ENUM = 'enum';
  MESSAGE = 'message';
  DEFAULT = 'default';
  ASSIGN = '=';
} 

@parser::header {
package edu.tum.cs.ccts.protobuf.embedded;
}

@lexer::header {
package edu.tum.cs.ccts.protobuf.embedded;
}


proto
	:	packageDecl? importDecl* declaration*
    		->	^(PROTO packageDecl? importDecl* declaration*)  
	;
                
packageDecl
	:	PACKAGE^ qualifiedID ';'!	
	;

importDecl
	:	IMPORT^ STRING ';'!	
	;

declaration
	:	optionDecl
	|	enumDecl
	|	messageDecl
	|	annotationDecl
	;
	
optionDecl
	:	OPTION^ ID ASSIGN! STRING ';'!
	;

enumDecl
	:	ENUM^ ID '{'!  enumElement* '}'!
	;

enumElement
	:	ID ASSIGN^ INTEGER ';'!
	;

messageDecl
	:	MESSAGE^ ID '{'! messageElement* '}'!
	;
	
annotationDecl
	:	ANNOTATION^ ID ASSIGN! INTEGER
	;

messageElement
	:	MODIFIER (TYPE | ID) ID ASSIGN^ INTEGER ';'!
	;

qualifiedID
	:	ID ('.'! ID)*
	;

MODIFIER
	:	'required' | 'repeated'
	;

TYPE
	:	'float' | 'double' | 'int32' | 'int64' | 'sint32' | 'sint64' | 
	    'uint32' | 'unit64' | 'bool' | 'string' | 'fixed32' | 'fixed64' |
	      'sfixed32' | 'sfixed64' | 'bytes'
	;

STRING
    :   '"' (~('"'|'\n'|'\r') | '\\"')* '"'
        {
            /* Trim quotes and replace escaped quotes. */
            setText(getText().substring(1, getText().length() - 1).replace("\\\"", "\""));
        }
    ;

ID
    :   LETTER (LETTER | DIGIT)*
    ;

DOT
    :   '.'
    ;

COMMENT
	:	'//'
	;

AT
	:	'@'
	;

INTEGER
    :   SIGN? DIGIT+
    ;

REAL
    :   SIGN? DIGIT+ (
            (DOT DIGIT) => DOT DIGIT+ EXPONENT? {$type=REAL;}
            | EXPONENT {$type=REAL;}
            | {$type=INTEGER;}
        )
    ;

ANNOTATION
    :   COMMENT (
    		(AT) => AT {$type=ANNOTATION; setText("@");}
    		| (~('\n' | '\r'))* ('\n' | '\r'('\n')?)? {$channel=HIDDEN;}
    	)
	;

fragment EXPONENT
    :   ('e' | 'E') ('+' | '-')? DIGIT+
    ;
     
fragment DIGIT
    :   '0'..'9'
    ;

fragment LETTER
    :   'a'..'z'
    |   'A'..'Z'
    |	'_'
    ;

fragment SIGN
    :  '+' | '-'
    ;

WHITESPACE
    :   ('\t' | ' ' | '\r' | '\n'| '\u000C')+
        {$channel=HIDDEN;}
    ;
