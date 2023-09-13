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
public class AsignacionArreglo implements Instruccion{
        public ArrayList<ArrayList<Expresion>> elementos ;
        public String identificador;
        public Expresion valor;
        public int linea;
        public int columna;

    public AsignacionArreglo(ArrayList<ArrayList<Expresion>> elementos, String identificador, Expresion valor, int linea, int columna) {
        this.elementos = elementos;
        this.identificador = identificador;
        this.valor = valor;
        this.linea = linea;
        this.columna = columna;
    }
        
    
    @Override
    public String tipoIns() {
        return "asignacion arreglo";
    }

    @Override
    public Object ejecutar(Entorno entorno, AST arbol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
