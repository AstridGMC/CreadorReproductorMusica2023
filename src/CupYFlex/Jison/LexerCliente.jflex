package CupYFlex;
import java_cup.runtime.* ;
import java_cup.runtime.Symbol;
import CupYFlex.sym;
import java.util.ArrayList;
import Backend.Pintor.PintarPalabras;
/*--------------2 Declaraciones ------------*/

%% 
%unicode
%public 
%class AnalizadorLexico 
%cupsym sym
%cup 
%char
%column
%line 

%{
    String cadena="";
    public PintarPalabras pintar = new PintarPalabras();

    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }

    private Symbol symbol(int type, Object value, int fila, int columna) {
        return new Symbol(type, yyline, yycolumn, value);}
%}

D = [0-9]+
LetraS = [A-Za-zÑñ]
simbol= [_@#$-]
Comilla = [\"]
ID = [A-Za-z|Ñ|ñ|0-9]*
OR = [\|]
%state COMENT_MULTI
%state COMENT_SIMPLE
%%



<YYINITIAL> "<-"            {yybegin(COMENT_MULTI);}
<COMENT_MULTI> "->"         {pintar.pintaGris(yychar,yylength()); yybegin(YYINITIAL);  }
<COMENT_MULTI>[^\n]         {}
<COMENT_MULTI> [\r|\r\n\f]  {}


<YYINITIAL> ">>"            {yybegin(COMENT_SIMPLE);}
<COMENT_SIMPLE> .           { pintar.pintaGris(yychar,yylength()); }
<COMENT_SIMPLE> "\n"        { pintar.pintaGris(yychar,yylength()); yybegin(YYINITIAL);}

//simbolos
<YYINITIAL> {


//palabras reservadas
    ("solicitud"|"Solicitud")               {  pintar.pintaAzul(yychar,yylength());  return symbol(sym.SOLICITUD, yytext(), yyline, yycolumn);}
    ("tipo"|"Tipo")                         {  pintar.pintaAzul(yychar,yylength());  return symbol(sym.TIPO, yytext(), yyline, yycolumn);}
    ("nombre"|"Nombre")                     {  pintar.pintaAzul(yychar,yylength());  return symbol(sym.NOMBRE, yytext(), yyline, yycolumn);}
    ("listas"|"Listas")                     {  pintar.pintaAzul(yychar,yylength());  return symbol(sym.LISTAS, yytext(), yyline, yycolumn);}
    ("aleatoria"|"Aleatoria")               {  pintar.pintaAzul(yychar,yylength());  return symbol(sym.ALEATORIA, yytext(), yyline, yycolumn);}
    ("lista"|"Lista")                       {  pintar.pintaAzul(yychar,yylength());  return symbol(sym.LISTA, yytext(), yyline, yycolumn);}
    ("duracion"|"Duracion")                 {  pintar.pintaAzul(yychar,yylength());  return symbol(sym.DURACION, yytext(), yyline, yycolumn);}


    ("canal"|"Canal")                       {  pintar.pintaAzul(yychar,yylength()); return symbol(sym.CANAL, yytext(), yyline, yycolumn);}
    ("Pista"|"pista")                       {  pintar.pintaAzul(yychar,yylength());  return symbol(sym.PISTA, yytext(), yyline, yycolumn);}
    ("Pistas"|"pistas")                     {  pintar.pintaAzul(yychar,yylength());  return symbol(sym.PISTAS, yytext(), yyline, yycolumn);}

    ("numero"|"Numero")                     {  pintar.pintaAzul(yychar,yylength()); return symbol(sym.NUMERO, yytext(), yyline, yycolumn);}
    ("nota"|"Nota")                         {  pintar.pintaAzul(yychar,yylength()); return symbol(sym.NOTA, yytext(), yyline, yycolumn);}
    ("frecuencia"|"Frecuencia")             {  pintar.pintaAzul(yychar,yylength()); return symbol(sym.FRECUENCIA, yytext(), yyline, yycolumn);}
    ("octava"|"Octava")                     {  pintar.pintaAzul(yychar,yylength()); return symbol(sym.OCTAVA, yytext(), yyline, yycolumn);}
    ("datos"|"Datos")                       {  pintar.pintaAzul(yychar,yylength()); return symbol(sym.DATOS, yytext(), yyline, yycolumn);}
    

// signos de agrupacion
    "("                                     { return symbol(sym.PARABRE, yytext(), yyline, yycolumn);}
    ")"                                     { return symbol(sym.PARCIERRA, yytext(), yyline, yycolumn);}
    "["                                     { return symbol(sym.CORCHETEIZ, yytext(), yyline, yycolumn);}
    "]"                                     { return symbol(sym.CORCHETEDER, yytext(), yyline, yycolumn);}
    "{"                                     { return symbol(sym.LLAVEABRE, yytext(), yyline, yycolumn);}
    "}"                                     { return symbol(sym.LLAVECIERRA, yytext(), yyline, yycolumn);}
    "/"                                     { return symbol(sym.DIV, yytext(), yyline, yycolumn);}  



// digitos
    ({Comilla})({LetraS}({LetraS}{1,9})|({LetraS}))({Comilla})    {pintar.pintaNara(yychar,yylength()); System.out.println( "cadena"); return symbol(sym.CADENA , yytext(), yyline, yycolumn);} 
    ({LetraS})({ID})                            {System.out.println( "ID"); pintar.pintaVerde(yychar,yylength()); System.out.println( "id"); return symbol(sym.IDENTIFICADOR , yytext(), yyline, yycolumn);} 
    ({D})(".")({D})                             { pintar.pintaMora(yychar,yylength()); return symbol(sym.DECIMAL , yytext(), yyline, yycolumn);} 
    ({D})                                       { pintar.pintaMora(yychar,yylength()); System.out.println( "int"); return symbol(sym.ENTERO , yytext(), yyline, yycolumn);} 
    ("'")({LetraS}|{D}|"#t"|"#n"|simbol)("'")   { pintar.pintaNara(yychar,yylength()); System.out.println( "char");return symbol(sym.CHAR , yytext(), yyline, yycolumn);} 


// OPERADORES RELACIONALES
    ">"                                      { return symbol(sym.MAYOR, yytext(), yyline, yycolumn);} 
    "<"                                      { return symbol(sym.MENOR, yytext(), yyline, yycolumn);} 
    "="                                      { return symbol(sym.IGUAL, yytext(), yyline, yycolumn);}


//SALTOS DE LINEA Y TAB

    (\n)+                                    { System.out.println( " LN "+ yytext());} 
    (\t)                                     { System.out.println( "TAB"+ yytext()); } 
// caracteres de escape
    (\r|\r\n)+ {/*IGNORAR*/}
    (" ")+ {}
    .                                       {System.out.println( "Caracter no reconocido: "+ yytext());}
}
