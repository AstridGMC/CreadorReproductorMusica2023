
package CupYFlex.Listas;
import java_cup.runtime.* ;
import java_cup.runtime.Symbol;
import CupYFlex.Listas.sym;
import java.util.ArrayList;
import Backend.Pintor.PintarPalabras;
/*--------------2 Declaraciones ------------*/

%% 
%unicode
%public 
%class AnalizadorLexicoList
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
BLANCOS=[ \r\t\n]+
LetraS = [A-Za-zÑñ]
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


<YYINITIAL> "//"            {yybegin(COMENT_SIMPLE);}
<COMENT_SIMPLE> .           { pintar.pintaGris(yychar,yylength()); }
<COMENT_SIMPLE> "\n"        { pintar.pintaGris(yychar,yylength()); yybegin(YYINITIAL);}

//simbolos
<YYINITIAL> {

 ({BLANCOS})                         {}


//palabras reservadas
    ("lista")                                    {  pintar.pintaAzul(yychar,yylength());  return symbol(sym.LISTA, yytext(), yyline, yycolumn);}
    ("nombre")                              {  pintar.pintaAzul(yychar,yylength());  return symbol(sym.NOMBRE, yytext(), yyline, yycolumn);}
    ("pistas")                                 {  pintar.pintaAzul(yychar,yylength());  return symbol(sym.PISTAS, yytext(), yyline, yycolumn);}
    ("random"|"aleatoria")                              {  pintar.pintaAzul(yychar,yylength());  return symbol(sym.ALEATORIA, yytext(), yyline, yycolumn);}
    ("circuar")                                {  pintar.pintaAzul(yychar,yylength());  return symbol(sym.CIRCULAR, yytext(), yyline, yycolumn);}
   ("falso"|"false")                        {  pintar.pintaAzul(yychar,yylength()); return symbol(sym.BOOLF, yytext(), yyline, yycolumn);}
    ("verdadero"|"true")               {  pintar.pintaAzul(yychar,yylength()); return symbol(sym.BOOLT, yytext(), yyline, yycolumn);}
    


// signos de agrupacion
   "["                                     { return symbol(sym.CORCHETEIZ, yytext(), yyline, yycolumn);}
    "]"                                     { return symbol(sym.CORCHETEDER, yytext(), yyline, yycolumn);}
    "{"                                     { return symbol(sym.LLAVEABRE, yytext(), yyline, yycolumn);}
    "}"                                     { return symbol(sym.LLAVECIERRA, yytext(), yyline, yycolumn);}
   
     "/"                                     { return symbol(sym.DIV, yytext(), yyline, yycolumn);}  
    ":"                                     { return symbol(sym.DOSPUNTOS, yytext(), yyline, yycolumn);}
    ","                                     { return symbol(sym.COMA, yytext(), yyline, yycolumn);} 



// digitos
    ({Comilla})({LetraS}({LetraS}{1,9})|({LetraS}))({Comilla})    {pintar.pintaNara(yychar,yylength()); System.out.println( "cadena"); return symbol(sym.CADENA , yytext(), yyline, yycolumn);} 
    ({LetraS})({ID})                            {System.out.println( "ID"); pintar.pintaVerde(yychar,yylength()); System.out.println( "id"); return symbol(sym.IDENTIFICADOR , yytext(), yyline, yycolumn);} 
    
// caracteres de escape
   ( \t\r\n\f)+                        {/*IGNORAR*/}
    . {
        ErrorL nuevoError= new ErrorL(yytext(),yyline,yychar,"lexico");
        ErrorL.tablaErrores.add(nuevoError);
	System.out.println("Este es un error lexico: "+yytext()+
	", en la linea: "+yyline+", en la columna: "+yychar);
    }
}

