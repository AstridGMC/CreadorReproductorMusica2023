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
public class Asignacion implements Instruccion{

    public ArrayList<String> identificadores;
      public String identificador;
    Declaracion declaracion;
    public Expresion valor;
    public int linea;
    public int columna;
    
    Instruccion ins;

    public Asignacion(ArrayList<String> identificadores, Expresion valor, int linea, int columna) {
        this.identificadores = identificadores;
        this.valor = valor;
        this.linea = linea;
        this.columna = columna;
    }
    public Asignacion(String identificador, Expresion valor, int linea, int columna) {
        this.identificador = identificador;
        this.valor = valor;
        this.linea = linea;
        this.columna = columna;
    }
    public Asignacion(String identificador, Expresion valor) {
        this.identificador = identificador;
        this.valor = valor;
    }

    public Asignacion(Declaracion declaracion, Expresion valor) {
        this.declaracion = declaracion;
        this.valor = valor;
    }
    
     public Asignacion(String identificador, Instruccion funcion) {
         this.identificador = identificador;
         this.ins=funcion;
    }
 public Asignacion(ArrayList<String> identificadores,  Instruccion funcion) {
         this.identificador = identificador;
         this.ins=funcion;
    }
    @Override
    public Object ejecutar(Entorno entorno, AST arbol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String tipoIns() {
        return "asignacion";
    }
    
}
