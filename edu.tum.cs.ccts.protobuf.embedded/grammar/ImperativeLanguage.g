/**
 * A grammar for imperative specifications in Autofocus 3
 *
 * @author popa
 */

grammar ImperativeLanguage;

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

rule
  :
  ;

MODIFIER
  : 'required' | 'repeated'
  ;

TYPE
  : 'float' | 'int32' | 'bool' | 'string' 
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
  : '//'
  ;

AT
  : '@'
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
    | '_'
    ;

fragment SIGN
    :  '+' | '-'
    ;

WHITESPACE
    :   ('\t' | ' ' | '\r' | '\n'| '\u000C')+
        {$channel=HIDDEN;}
    ;
