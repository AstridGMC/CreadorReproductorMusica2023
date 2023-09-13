/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Expresiones;

import Backend.Compilador.AST;
import Backend.Compilador.Entorno;
import Backend.Compilador.Simbolo.Tipo;
import Backend.Interfaces.Expresion;
import CupYFlex.ErrorS;

/**
 *
 * @author astridmc
 */
public class Operacion implements Expresion {

    @Override
    public Object setValorImplicito() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public enum Operador {
        SUMA,
        RESTA,
        MULTIPLICACION,
        DIVISION,
        MODULO,
        POTENCIA,
        MENOS_UNARIO,
        MAYOR_QUE,
        MENOR_QUE,
        IGUAL_IGUAL,
        NOI_GUAL,
        DIFERENTE_QUE,
        NULO,
        OR,
        NOR,
        XOR,
        AND,
        NAND,
        NOT,
        MAYOR_IGUA_QUE,
        MENOR_IGUA_QUE,
        DESCONOCIDO
    }

    public int linea;
    public int columna;
    public Expresion op_izquierda;
    public Expresion op_derecho;
    public Operador operador;

    public Operacion(Expresion op_izquierda, Expresion op_derecho, Operador operador, int linea, int columna) {
        this.linea = linea;
        this.columna = columna;
        this.op_izquierda = op_izquierda;
        this.op_derecho = op_derecho;
        this.operador = operador;
    }

    @Override
    public Tipo getTipo(Entorno entorno, AST arbol) {
     Object valor = this.getValorImplicito(entorno, arbol);
        if(valor != null){
            Class c = valor.getClass();
            if(c.getName().contains("Boolean")){
                System.out.println("boolean");
                return Tipo.BOOL;
            }else if(c.getName().contains("String")){
                System.out.println("String");
                return Tipo.STRING;
            }else if(c.getName().contains("Integer")){
                System.out.println("Integer");
                return Tipo.INT;
            }else if(c.getName().contains("Double")){
                System.out.println("Double");
                return Tipo.STRING;
            }
        }else if(valor == null){
            System.out.println("nulo");
            return Tipo.NULL;
        }
        return Tipo.VOID;
    }

    @Override
    public Object getValorImplicito(Entorno entorno, AST arbol) {
        if (this.operador != Operador.MENOS_UNARIO && this.operador != Operador.NOT && this.operador != Operador.NULO) {
            Object op1 = this.op_izquierda.getValorImplicito(entorno, arbol);
            Object op2 = this.op_derecho.getValorImplicito(entorno, arbol);
            Class c = op1.getClass();
            Class c2 = op2.getClass();
            //suma
            if (this.operador == Operador.SUMA) {

                if ((c.getName().contains("Integer") || c.getName().contains("Double")) && (c2.getName().contains("Integer") || c.getName().contains("Double"))) {
                    if (c.getName().contains("Double") || c2.getName().contains("Double")) {
                        return (double) op1 + (double) op2;
                    } else {
                        return (int) op1 + (int) op2;
                    }
                } else if (c.getName().contains("string") || c2.getName().contains("string")) {
                    if (op1 == null) {
                        op1 = "null";
                    }
                    if (op2 == null) {
                        op2 = "null";
                    }
                    return op1.toString() + op2.toString();
                } else {
                    System.out.println("Error de tipos de datos no permitidos realizando una suma");
                    return null;
                }
            } //resta
            else if (this.operador == Operador.RESTA) {
                if (c.getName().contains("Double") || c2.getName().contains("Double")) {
                    return (double) op1 - (double) op2;
                } else if (c.getName().contains("Integer") || c2.getName().contains("Integer")) {
                    return (int) op1 - (int) op2;
                } else {
                    System.out.println("Error de tipos de datos no permitidos realizando una resta");
                    return null;
                }
            } //multiplicación
            else if (this.operador == Operador.MULTIPLICACION) {
                if (c.getName().contains("Double") || c2.getName().contains("Double")) {
                    return (double) op1 * (double) op2;
                } else if (c.getName().contains("Integer") || c2.getName().contains("Integer")) {
                    return (int) op1 * (int) op2;
                } else {
                    System.out.println("Error de tipos de datos no permitidos realizando una multiplicacion");
                    return null;
                }
            } //division
            else if (this.operador == Operador.DIVISION) {
                if (c.getName().contains("Double") || c2.getName().contains("Double")) {
                    if ((int) op2 == 0) {
                        System.out.println("Resultado indefinido, no puede ejecutarse operación sobre cero.");
                        return null;
                    }

                    return (double) op1 / (double) op2;

                } else if (c.getName().contains("Integer") || c2.getName().contains("Integer")) {
                    if ((int) op2 == 0) {
                        System.out.println("Resultado indefinido, no puede ejecutarse operación sobre cero.");
                        return null;
                    }
                    return (int) op1 / (int) op2;
                } else {
                    System.out.println("Error de tipos de datos no permitidos realizando una division");
                    return null;
                }
            } //modulo
            else if (this.operador == Operador.MODULO) {
                
                if (c.getName().contains("Double") || c2.getName().contains("Double")) {
                    if ((int) op2 == 0) {
                        System.out.println("Resultado indefinido, no puede ejecutarse operación sobre cero.");
                        return null;
                    }

                    return (double) op1 % (double) op2;

                } else if (c.getName().contains("Integer") || c2.getName().contains("Integer")) {
                    if ((int) op2 == 0) {
                        System.out.println("Resultado indefinido, no puede ejecutarse operación sobre cero.");
                        return null;
                    }
                    return (int) op1 % (int) op2;
                } else {
                    System.out.println("Error de tipos de datos no permitidos realizando un modulo");
                    return null;
                }
            } 
            //potencia
            else if (this.operador == Operador.POTENCIA) {
                
                if (c.getName().contains("Double") || c2.getName().contains("Double")) {
                    if ((int) op2 == 0) {
                        System.out.println("Resultado indefinido, no puede ejecutarse operación sobre cero.");
                        return null;
                    }

                    return Math.pow((double) op1, (double) op2);

                } else if (c.getName().contains("Integer") || c2.getName().contains("Integer")) {
                    if ((int) op2 == 0) {
                        System.out.println("Resultado indefinido, no puede ejecutarse operación sobre cero.");
                        return null;
                    }
                    return Math.pow((int) op1, (int) op2);
                } else {
                    System.out.println("Error de tipos de datos no permitidos realizando un modulo");
                    return null;
                }
            }
        
            
        //AND
            else if(this.operador == Operador.AND){
                Object valor1 = this.op_izquierda.getValorImplicito(entorno,arbol);
                if((int)valor1 == 0 || (double)valor1 == 0.0) valor1 = false;
                if((int)valor1 == 1 || (double)valor1 == 1.0) valor1 = true;  
               
               Object valor2 = this.op_derecho.getValorImplicito(entorno,arbol);
                if((int)valor2 == 0 || (double)valor2 == 0.0) valor2 = false;
                if((int)valor2 == 1 || (double)valor2 == 1.0) valor2 = true;
                
                Class v = valor1.getClass();
                Class v2 = valor2.getClass();
                
                if( v.getName().contains("Boolean")  && v2.getName().contains("Boolean") )
                    return (boolean)valor1 && (boolean)valor2 ;
                else{
                    //ERROR DE TIPOS DE DATOS PERMITIDOS PARA LA OPERACION
                    ErrorS error = new ErrorS("Error semantico, Error en tipos de datos permitidos para una expresion logica AND ",this.linea,this.columna,"SEMANTICO");
                    ErrorS.tablaErrores.add(error);
                    return null;
                }

            }
        //NAND    
            else if(this.operador == Operador.NAND){
                Object valor1 = this.op_izquierda.getValorImplicito(entorno,arbol);
                if((int)valor1 == 0 || (double)valor1 == 0.0) valor1 = false;
                if((int)valor1 == 1 || (double)valor1 == 1.0) valor1 = true;  
               
               Object valor2 = this.op_derecho.getValorImplicito(entorno,arbol);
                if((int)valor2 == 0 || (double)valor2 == 0.0) valor2 = false;
                if((int)valor2 == 1 || (double)valor2 == 1.0) valor2 = true;
                
                Class v = valor1.getClass();
                Class v2 = valor2.getClass();
                
                if( v.getName().contains("Boolean")  && v2.getName().contains("Boolean") )
                    return !((boolean)valor1 && (boolean)valor2) ;
                else{
                    //ERROR DE TIPOS DE DATOS PERMITIDOS PARA LA OPERACION
                    ErrorS error = new ErrorS("Error semantico, Error en tipos de datos permitidos para una expresion logica NAND ",this.linea,this.columna,"SEMANTICO");
                    ErrorS.tablaErrores.add(error);
                    return null;
                }
            }
        //OR
            else if(this.operador == Operador.OR){
                Object valor1 = this.op_izquierda.getValorImplicito(entorno,arbol);
                if((int)valor1 == 0 || (double)valor1 == 0.0) valor1 = false;
                if((int)valor1 == 1 || (double)valor1 == 1.0) valor1 = true;

                Object valor2 = this.op_derecho.getValorImplicito(entorno,arbol);
                if((int)valor2 == 0 || (double)valor2 == 0.0) valor2 = false;
                if((int)valor2 == 1 || (double)valor2 == 1.0) valor2 = true;
                
                Class v = valor1.getClass();
                Class v2 = valor2.getClass();

                if (v.getName().contains("Boolean")  && v2.getName().contains("Boolean"))
                    return ((boolean)valor1 || (boolean)valor2);
                else{
                     //ERROR DE TIPOS DE DATOS PERMITIDOS PARA LA OPERACION
                    ErrorS error = new ErrorS("Error semantico, Error en tipos de datos permitidos para una expresion logica OR ",this.linea,this.columna,"SEMANTICO");
                    ErrorS.tablaErrores.add(error);
                    return null;
                }
            }
        //NOR
            else if(this.operador == Operador.NOR){
                Object valor1 = this.op_izquierda.getValorImplicito(entorno,arbol);
                if((int)valor1 == 0 || (double)valor1 == 0.0) valor1 = false;
                if((int)valor1 == 1 || (double)valor1 == 1.0) valor1 = true;

                Object valor2 = this.op_derecho.getValorImplicito(entorno,arbol);
                if((int)valor2 == 0 || (double)valor2 == 0.0) valor2 = false;
                if((int)valor2 == 1 || (double)valor2 == 1.0) valor2 = true;
                
                Class v = valor1.getClass();
                Class v2 = valor2.getClass();

                if (v.getName().contains("Boolean")  && v2.getName().contains("Boolean"))
                    return !((boolean)valor1 || (boolean)valor2);
                else{
                     //ERROR DE TIPOS DE DATOS PERMITIDOS PARA LA OPERACION
                    ErrorS error = new ErrorS("Error semantico, Error en tipos de datos permitidos para una expresion logica OR ",this.linea,this.columna,"SEMANTICO");
                    ErrorS.tablaErrores.add(error);
                    return null;
                }
            }
        //XOR
            else if(this.operador == Operador.XOR){
                Object valor1 = this.op_izquierda.getValorImplicito(entorno,arbol);
                if((int)valor1 == 0 || (double)valor1 == 0.0) valor1 = false;
                if((int)valor1 == 1 || (double)valor1 == 1.0) valor1 = true;

                Object valor2 = this.op_derecho.getValorImplicito(entorno,arbol);
                if((int)valor2 == 0 || (double)valor2 == 0.0) valor2 = false;
                if((int)valor2 == 1 || (double)valor2 == 1.0) valor2 = true;
                
                        
                Class v = valor1.getClass();
                Class v2 = valor2.getClass();

                if (v.getName().contains("Boolean")  && v2.getName().contains("Boolean"))
                    return ((boolean)valor1 ^ !(boolean)valor2);
                else{
                     //ERROR DE TIPOS DE DATOS PERMITIDOS PARA LA OPERACION
                    ErrorS error = new ErrorS("Error semantico, Error en tipos de datos permitidos para una expresion logica XOR ",this.linea,this.columna,"SEMANTICO");
                    ErrorS.tablaErrores.add(error);
                return null;
                }
            }
            //IGUALIGUAL
            else if(this.operador == Operador.IGUAL_IGUAL){
            
                //OPERACION DE ENTEROS
                if (c.getName().contains("Integer")&& c2.getName().contains("Integer"))
                    return (int)op1 == (int)op2;
                else if(c.getName().contains("Integer") && c2.getName().contains("Double"))     // ENTERO - DOUBLE
                    return ((double) op1 == (double)op2);
                else if(c.getName().contains("Double") && c2.getName().contains("Integer")) // DOUBLE - ENTERO
                    return (double)op1 == (double)op2;
                 else if(c.getName().contains("Double") && c2.getName().contains("Double")) //FLOAT - FLOAT
                    return ((double)op1 == (double)(op2));
                else if (c.getName().contains("String") && c2.getName().contains("String"))   {    // CONCATENACIÓN STRINGS
                    if (op1 == null)  op1 = "";
                    if (op2 == null ) op1 = "";
                    return op1.equals((String)op2);
                }else{
                    //ERROR DE TIPOS DE DATOS PERMITIDOS PARA LA OPERACION
                    
                    ErrorS error = new ErrorS("Error semantico, Error en tipos de datos permitidos para una expresion relacional '==' ",this.linea,this.columna,"SEMANTICO");
                    ErrorS.tablaErrores.add(error);
                    return null;
                }
            }
            //NOIGUAL
            else if(this.operador == Operador.NOI_GUAL){

                //OPERACION DE ENTEROS
                if(c.getName().contains("Integer")&& c2.getName().contains("Integer"))
                     return (int)op1 != (int)op2;
                else if(c.getName().contains("Integer") && c2.getName().contains("Double"))     // ENTERO - DOUBLE
                    return (double) op1 != (double)op2;
                else if(c.getName().contains("Double") && c2.getName().contains("Integer")) // DOUBLE - ENTERO
                    return (double)op1 != (double)op2;
                 else if(c.getName().contains("Double") && c2.getName().contains("Double")) //FLOAT - FLOAT
                    return ((double)op1 != (double)(op2));
                 else if (c.getName().contains("String") && c2.getName().contains("String"))   {    // CONCATENACIÓN STRINGS
                    if (op1 == null)  op1 = "";
                    if (op2 == null ) op1 = "";
                    return (String)op2 != (String)op1;
                 }else{
                        //ERROR DE TIPOS DE DATOS PERMITIDOS PARA LA OPERACION
                    ErrorS error = new ErrorS("Error semantico, Error en tipos de datos permitidos para una expresion relacional '!=' ",this.linea,this.columna,"SEMANTICO");
                    ErrorS.tablaErrores.add(error);
                        return null;
                            }
            }
        //MAYOR
            else if(this.operador == Operador.MAYOR_QUE){

                //OPERACION DE ENTEROS
                if(c.getName().contains("Integer")&& c2.getName().contains("Integer"))
                     return (int)op1 > (int)op2;
                else if(c.getName().contains("Integer") && c2.getName().contains("Double"))     // ENTERO - DOUBLE
                    return (double) op1 > (double)op2;
                else if(c.getName().contains("Double") && c2.getName().contains("Integer")) // DOUBLE - ENTERO
                    return (double)op1 > (double)op2;
                 else if(c.getName().contains("Double") && c2.getName().contains("Double")) //FLOAT - FLOAT
                    return ((double)op1 > (double)(op2));
                 else if (c.getName().contains("String") && c2.getName().contains("String")){     // CONCATENACIÓN STRINGS
                    if (op1 == null)  op1 = "";
                    if (op2 == null ) op1 = "";
                    if (c.getName().contains("String")   && !c2.getName().contains("String")){ 
                        String var = (String)op1;
                         return ( var.length() > (int)op2);
                    }
                    else if (c2.getName().contains("String") && !c.getName().contains("String")){ 
                        String var2 = (String)op2;
                        return ((int)op1 >var2.length());
                    }
                    String var = (String)op1;
                    String var2 = (String)op2;
                    return (var.length() > var2.length());
                 }else{
                        //ERROR DE TIPOS DE DATOS PERMITIDOS PARA LA OPERACION
                        ErrorS error = new ErrorS("Error semantico, Error en tipos de datos permitidos para una expresion logica >",this.linea,this.columna,"SEMANTICO");
                        ErrorS.tablaErrores.add(error);
                        return null;
                    }
                }
         //MAYOR_IGUA_QUE
            else if(this.operador == Operador.MAYOR_IGUA_QUE){
            //OPERACION DE ENTEROS
                if (c.getName().contains("Integer")&& c2.getName().contains("Integer"))
                    return (int)op1 >= (int)op2;
                else if(c.getName().contains("Integer") && c2.getName().contains("Double"))     // ENTERO - FLOAT
                    return ((double) op1 >= (double)op2);
                else if(c.getName().contains("Double") && c2.getName().contains("Integer")) // FLOAT - ENTERO
                    return ((double)op1 >= (double)op2);
                else if(c.getName().contains("Double") && c2.getName().contains("Double")) //FLOAT - FLOAT
                    return ((double)op1 >= (double)(op2));
                else if (c.getName().contains("String") && c2.getName().contains("String"))   {    // CONCATENACIÓN STRINGS
                    if (op1 == null)  op1 = "";
                    if (op2 == null ) op1 = "";
                    c=op1.getClass();
                    c2=op2.getClass();
                    
                    if (c.getName().contains("String") && !c2.getName().contains("String")){
                        String var = (String)op1;
                        return ( var.length() >= (int)op2);
                    }else if(c2.getName().contains("String") && !c.getName().contains("String")){ 
                        String var2 = (String)op2;
                        return ((int)op1 >=var2.length());
                    }
                    String var = (String)op1;
                    String var2 = (String)op2;
                    return (var.length() >= var2.length());
                }else{
                         //ERROR DE TIPOS DE DATOS PERMITIDOS PARA LA OPERACION
                        ErrorS error = new ErrorS("Error semantico, Error en tipos de datos permitidos para una expresion logica >= ",this.linea,this.columna,"SEMANTICO");
                        ErrorS.tablaErrores.add(error);
                    return null;
                }
            } 
        //MENOR
            else if(this.operador == Operador.MENOR_QUE){
                 //OPERACION DE ENTEROS
                if(c.getName().contains("Integer")&& c2.getName().contains("Integer"))
                     return (int)op1 < (int)op2;
                else if(c.getName().contains("Integer") && c2.getName().contains("Double"))     // ENTERO - DOUBLE
                    return (double) op1 < (double)op2;
                else if(c.getName().contains("Double") && c2.getName().contains("Integer")) // DOUBLE - ENTERO
                    return (double)op1 < (double)op2;
                 else if(c.getName().contains("Double") && c2.getName().contains("Double")) //FLOAT - FLOAT
                    return ((double)op1 < (double)(op2));
                 else if (c.getName().contains("String") && c2.getName().contains("String")){     // CONCATENACIÓN STRINGS
                    if (op1 == null)  op1 = "";
                    if (op2 == null ) op1 = "";
                    if (c.getName().contains("String")   && !c2.getName().contains("String")){ 
                        String var = (String)op1;
                         return ( var.length() < (int)op2);
                    }
                    else if (c2.getName().contains("String") && !c.getName().contains("String")){ 
                        String var2 = (String)op2;
                        return ((int)op1 < var2.length());
                    }
                    String var = (String)op1;
                    String var2 = (String)op2;
                    return (var.length() < var2.length());
                 }else{
                        //ERROR DE TIPOS DE DATOS PERMITIDOS PARA LA OPERACION
                        ErrorS error = new ErrorS("Error semantico, Error en tipos de datos permitidos para una expresion logica<",this.linea,this.columna,"SEMANTICO");
                        ErrorS.tablaErrores.add(error);
                        return null;
                    }
            }
        //MENOR_IGUAL
            else if(this.operador == Operador.MENOR_IGUA_QUE){
                //OPERACION DE ENTEROS
                if (c.getName().contains("Integer")&& c2.getName().contains("Integer"))
                    return (int)op1 <= (int)op2;
                else if(c.getName().contains("Integer") && c2.getName().contains("Double"))     // ENTERO - FLOAT
                    return ((double) op1 <= (double)op2);
                else if(c.getName().contains("Double") && c2.getName().contains("Integer")) // FLOAT - ENTERO
                    return ((double)op1 <= (double)op2);
                else if(c.getName().contains("Double") && c2.getName().contains("Double")) //FLOAT - FLOAT
                    return ((double)op1 <= (double)(op2));
                else if (c.getName().contains("String") && c2.getName().contains("String"))   {    // CONCATENACIÓN STRINGS
                    if (op1 == null)  op1 = "";
                    if (op2 == null ) op1 = "";
                    c=op1.getClass();
                    c2=op2.getClass();
                    
                    if (c.getName().contains("String") && !c2.getName().contains("String")){
                        String var = (String)op1;
                        return ( var.length() <= (int)op2);
                    }else if(c2.getName().contains("String") && !c.getName().contains("String")){ 
                        String var2 = (String)op2;
                        return ((int)op1 <=var2.length());
                    }
                    String var = (String)op1;
                    String var2 = (String)op2;
                    return (var.length() <= var2.length());
                }else{
                         //ERROR DE TIPOS DE DATOS PERMITIDOS PARA LA OPERACION
                        ErrorS error = new ErrorS("Error semantico, Error en tipos de datos permitidos para una expresion logica <= ",this.linea,this.columna,"SEMANTICO");
                        ErrorS.tablaErrores.add(error);
                    return null;
                }
            }    
        
        //   MENOS UNARIO - NOT
        }else {
            Object op1 = this.op_izquierda.getValorImplicito(entorno, arbol);
            Class c = op1.getClass();
            if (this.operador == Operador.MENOS_UNARIO) {
                if (c.getName().contains("Double")) {
                    return -1 * (double)op1;
                } else if (c.getName().contains("Integer")) {
                    return -1 * (double)op1;
                }else {
                    System.out.println("Error de tipos de datos no permitidos realizando una operación unaria");
                    return null;
                }
            }//NOT
             else if(this.operador == Operador.AND){
                Object valor1 = this.op_izquierda.getValorImplicito(entorno,arbol);
                if((int)valor1 == 0 || (double)valor1 == 0.0) valor1 = false;
                if((int)valor1 == 1 || (double)valor1 == 1.0) valor1 = true;  
               

                 Class v = valor1.getClass();
                if( v.getName().contains("Boolean"))
                    return (! (boolean)valor1);
                else{
                 //ERROR DE TIPOS DE DATOS PERMITIDOS PARA LA OPERACION
                    ErrorS error = new ErrorS("Error semantico, Error en tipos de datos permitidos para una expresion logica NOT ",this.linea,this.columna,"SEMANTICO");
                    ErrorS.tablaErrores.add(error);
                return null;
                }
             }//NULL
            else if(this.operador == Operador.NULO){
                 Object valor1 = this.op_izquierda.getValorImplicito(entorno,arbol);
                Class v = valor1.getClass();
                if(valor1==null)
                    return (! (boolean)true);
                else{
                    return false;
                }
            }
        }
        return null;
    }
    
    public Object AND(Entorno entorno, AST arbol){
          
       

        return null;
    }
}

