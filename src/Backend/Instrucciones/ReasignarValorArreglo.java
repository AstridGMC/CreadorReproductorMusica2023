/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Instrucciones;

import Backend.Compilador.AST;
import Backend.Compilador.Entorno;
import Backend.Interfaces.Expresion;
import Backend.Interfaces.Instruccion;
import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class ReasignarValorArreglo implements Instruccion{
    
        public String identificador;
        public Expresion valor;
        public ArrayList<Expresion> indices;
        public Expresion indice;

    public ReasignarValorArreglo(String identificador, Expresion valor, Expresion indice) {
        this.identificador = identificador;
        this.valor = valor;
        this.indice = indice;
    }

    public ReasignarValorArreglo(String identificador, Expresion valor,  ArrayList<Expresion> indices) {
        this.identificador = identificador;
        this.valor = valor;
        this.indices = indices;
    }   

    @Override
    public String tipoIns() {
       return "reasignarValorArreglo";
    }

    @Override
    public Object ejecutar(Entorno entorno, AST arbol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
