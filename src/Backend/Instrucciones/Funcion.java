/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Instrucciones;

import Backend.Compilador.AST;
import Backend.Compilador.Entorno;
import Backend.Compilador.Simbolo.Tipo;
import Backend.Funciones.Parametro;
import Backend.Interfaces.Instruccion;
import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class Funcion implements Instruccion {
    String identificador;
    ArrayList<Parametro> parametros;
    ArrayList<Instruccion> instrucciones;
    Tipo tipo;
    boolean isKeep;

    public Funcion(String identificador, ArrayList<Parametro> parametros, ArrayList<Instruccion> instrucciones, Tipo tipo) {
        this.identificador = identificador;
        this.parametros = parametros;
        this.instrucciones = instrucciones;
        this.tipo = tipo;
        this.isKeep=false;
    }

    @Override
    public Object ejecutar(Entorno entorno, AST arbol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isIsKeep() {
        return isKeep;
    }

    public void setIsKeep(boolean isKeep) {
        this.isKeep = isKeep;
    }
    
    @Override
    public String tipoIns() {
        return "funcion";
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public ArrayList<Parametro> getParametros() {
        return parametros;
    }

    public void setParametros(ArrayList<Parametro> parametros) {
        this.parametros = parametros;
    }

    public ArrayList<Instruccion> getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(ArrayList<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    
    
}
