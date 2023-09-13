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

/**
 *
 * @author astridmc
 */
public class Primitivo implements Expresion{
    int linea;
    int columna;
    Object valor;
    Tipo tipo;
    

    public Primitivo(Tipo tipo,Object valor, int linea, int columna) {
        this.tipo=tipo;
        this.linea = linea;
        this.columna = columna;
        this.valor = valor;
    }
    
    @Override
    public Tipo getTipo(Entorno entorno, AST arbol){
        Object value = this.getValorImplicito(entorno, arbol);
        if(value != null){
            Class c = value.getClass();
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
        }else if(value == null){
            System.out.println("nulo");
            return Tipo.NULL;
        }
        return Tipo.VOID;
    }
    
    @Override
    public Object getValorImplicito(Entorno entorno, AST arbol){
        return this.valor;
    }
    
    private boolean esEntero(double num){
        boolean esEntero = true;
        try{
            int entero = (int) num;
        }catch(Exception e){
            esEntero = false;
        }
        return esEntero;
    }

    @Override
    public Object setValorImplicito() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    
    
}
