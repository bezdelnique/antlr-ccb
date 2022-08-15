grammar CCB;

@header {
package org.example.ccb;
}

parse
 : block
// | block EOF
 ;

block
 : stat*
 ;

stat
 : if_stat
// : assignment
// | OTHER {System.err.println("unknown char: " + $OTHER.text);}
 ;

//assignment
// : ID ASSIGN expr SCOL
// ;

if_stat
 : IF condition_block (THEN stat_block) (ELSE stat_block)
 // | IF condition_block (ELSE IF condition_block)* (ELSE stat_block)?
 ;

condition_block
 : OSRACE expr CSRACE
 // | expr stat_block
 ;

stat_block
 : OSRACE expr CSRACE
 | expr
// | stat
 ;

expr
 : expr op=(EQ | NEQ) expr              #equalityExpr
 | atom                                 #atomExpr
// | atom
 ;

atom
 : (INT | FLOAT)                        #numberAtom
 | (TRUE | FALSE)                       #booleanAtom
 | CO                                   #contextObjectAtom
 | MDBF                                 #mdbfAtom
 | STRING                               #stringAtom
 ;


//OR : '||';
//AND : '&&';
EQ : '=';
NEQ : '!=';
//GT : '>';
//LT : '<';
//GTEQ : '>=';
//LTEQ : '<=';
//PLUS : '+';
//MINUS : '-';
//MULT : '*';
//DIV : '/';
//MOD : '%';
//POW : '^';
NOT : '!';

// SCOL : ';';
// ASSIGN : ':=';
OPAR : '(';
CPAR : ')';
OBRACE : '{';
CBRACE : '}';
OSRACE : '[';
CSRACE : ']';

TRUE : 'true' | 'TRUE' ;
FALSE : 'false' | 'FALSE';
NIL : 'nil';
IF : 'if' | 'IF';
THEN : 'then' | 'THEN';
ELSE : 'else' | 'ELSE';
// WHILE : 'while';
// LOG : 'log';

//ID
// : [a-zA-Z_] [a-zA-Z_0-9]*
// ;

CO
 // : [a-zA-Z_] [a-zA-Z_0-9]*
 // SA[EO:EO-TYPE]
 : 'SA[' [0-9A-Z-]* ':' [0-9A-Z-]* ']'
 ;

MDBF
 : 'MDBF[' [0-9A-Z;:_-]* ']'
 ;

INT
 : [0-9]+
 ;

FLOAT
 : [0-9]+ '.' [0-9]*
 | '.' [0-9]+
 ;

STRING
 : '"' (~["\r\n] | '""')* '"'
 | '\'' (~["\r\n] | '\'''\'' )* '\''
 ;

COMMENT
 : '#' ~[\r\n]* -> skip
 ;

SPACE
 : [ \t\r\n] -> skip
 ;

OTHER
 : .
 ;
