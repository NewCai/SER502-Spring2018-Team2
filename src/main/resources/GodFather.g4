grammar GodFather;

program : decls stmts;
decls : (decl)*;
decl : type=('int' | 'bool') ID ';';
stmts : (stmt)*;
stmt : ID '=' arith_expr ';' # stmtArithAssign
     | ID '=' bool_expr ';' # stmtBoolAssign
     | 'if' '(' bool_expr ')' '{' stmts '}' # stmtIf
     | 'if' '(' bool_expr ')' '{' stmts '}' 'else' '{' stmts '}' # stmtIfElse
     | 'while' '(' bool_expr ')' '{' stmts '}' # stmtWhile
     ;
bool_expr : arith_expr op=('==' | '!=' | '>' | '<' | '>=' | '<=') arith_expr #boolExprCmp
          | value=('true' | 'false') #boolExprValue
          ;
arith_expr : term (op=('+' | '-') term)*;
term : factor (op=('*' | '/' | '%') factor)*;
factor : NUMBER | '(' arith_expr ')' | ID;

LE : '<=';
SEMI : ';';
OR : '||';
GT : '>';
ASSIGN : '=';
GE : '>=';
EQ : '==';
PLUS : '+';
MINUS : '-';
NE : '!=';
MUL : '*';
LT : '<';
DIV : '/';
INT : 'int';
BOOL : 'bool';
NUMBER : [0-9]+ ;
TRUE : 'true';
FALSE: 'false';
ID : [a-z|A-Z]+ ;
WS : [ \t\r\n]+ -> skip ;