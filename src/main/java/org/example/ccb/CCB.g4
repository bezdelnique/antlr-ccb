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
 | return
// : assignment
// | OTHER {System.err.println("unknown char: " + $OTHER.text);}
 ;

//assignment
// : ID ASSIGN expr SCOL
// ;

if_stat
 : IF condition_block (THEN stat_block) (ELSE stat_block)
 ;

condition_block
 : OSBRACE expr CSBRACE
 | expr
 ;

stat_block
 : OSBRACE expr CSBRACE
 | expr
 ;

return
 : RETURN stat_block
 ;

expr
 : OPAR expr CPAR                                       #compareParenthesisExpr
 | NOT OPAR expr CPAR                                   #notExpr
 | expr op=(GT | LT | GTEQ | LTEQ | EQ | NEQ) expr      #compareExpr
 | expr op=(OR | AND) expr                              #logicalExpr
 | expr IN OPAR expr (',' expr)* CPAR                   #operatorIn
 | atom                                                 #atomExpr
 ;


atom
 : (INT | FLOAT)                        #numberAtom
 | (TRUE | FALSE)                       #booleanAtom
 | CO                                   #contextObjectAtom
 | MDBF                                 #mdbfAtom
 | STRING                               #stringAtom
 ;


OR : '||';
AND : '&&';
EQ : '=';
NEQ : ('!=' | '<>');
GT : '>';
LT : '<';
GTEQ : '>=';
LTEQ : '<=';
NOT : ('!' | 'NOT' | 'not');
//PLUS : '+';
//MINUS : '-';
//MULT : '*';
//DIV : '/';
//MOD : '%';
//POW : '^';

// SCOL : ';';
// ASSIGN : ':=';
OPAR : '(';
CPAR : ')';
//OBRACE : '{';
//CBRACE : '}';
OSBRACE : '[';
CSBRACE : ']';

TRUE : 'true' | 'TRUE' ;
FALSE : 'false' | 'FALSE';

// NIL : 'nil';
IF : 'if' | 'IF';
THEN : 'then' | 'THEN';
ELSE : 'else' | 'ELSE';
RETURN : 'return' | 'RETURN';
IN : 'IN' | 'in';
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
 | '\'' (~['\r\n] | '\'''\'' )* '\''
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
