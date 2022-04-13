grammar Calculator;

MUL :'*';

DIV :'/';

ADD :'+';

SUB :'-';

NUMB :'-'?[0-9]+('.' [0-9]+)?;

NEWLINE : '\r'? '\n';

WS : [ \t]+ -> skip;

prog: expr;

expr
: NUMB                                          # Numb
| '(' expr ')'                                  # Parenth
| numb1 = expr op = ( MUL | DIV ) numb2 = expr  # MulOrDiv
| numb1 = expr op = ( ADD | SUB ) numb2 = expr  # AddOrSub
;