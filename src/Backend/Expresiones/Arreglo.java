/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Instrucciones;

import Backend.Compilador.AST;
import Backend.Compilador.Entorno;
import Backend.Compilador.Simbolo.Tipo;
import Backend.Interfaces.Expresion;
import Backend.Interfaces.Instruccion;
import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class Arreglo implements Instruccion{ 
    String identificador;
    int dimension;
    Tipo tipo;
    ArrayList<Expresion> dimensiones;
    ArrayList<ArrayList<Expresion>> valores;

    public Arreglo(Tipo tipo, String identificador, int dimension, ArrayList<Expresion> dimensiones, ArrayList<ArrayList<Expresion>> valores) {
        this.identificador = identificador;
        this.dimension = dimension;
        this.valores = valores;
        this.tipo=tipo;
    }

    public Arreglo(Tipo tipo, String identificador, int dimension, ArrayList<Expresion> dimensiones) {
        this.identificador = identificador;
        this.dimension = dimension;
        this.tipo=tipo;
    }

    public void setValores(ArrayList<ArrayList<Expresion> > valores) {
        this.valores = valores;
    }

    @Override
    public String tipoIns() {
       return "Arreglo";
    }

    @Override
    public Object ejecutar(Entorno entorno, AST arbol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
