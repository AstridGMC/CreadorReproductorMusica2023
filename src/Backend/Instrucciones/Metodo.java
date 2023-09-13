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
import Backend.Interfaces.Expresion;
import Backend.Interfaces.Instruccion;
import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class Metodo implements Instruccion{
    Tipo tipo = Tipo.METODO;
    String identificador;
    ArrayList<Parametro> parametros;
    ArrayList<Instruccion> instrucciones;
    boolean isPrincipal=false;
    boolean isKeep;

    public Metodo(String identificador, ArrayList<Parametro> parametros, ArrayList<Instruccion> instrucciones) {
        this.identificador = identificador;
        this.parametros = parametros;
        this.instrucciones = instrucciones;
        this.isPrincipal = false;
        this.isKeep=false;
    }

    public Metodo(String identificador, ArrayList<Parametro> parametros, ArrayList<Instruccion> instrucciones, boolean isPrincipal) {
        this.identificador = identificador;
        this.parametros = parametros;
        this.instrucciones = instrucciones;
        this.isPrincipal = isPrincipal;
    }

    public boolean isIsKeep() {
        return isKeep;
    }

    public void setIsKeep(boolean isKeep) {
        this.isKeep = isKeep;
    }
    
    
    
    @Override
    public Object ejecutar(Entorno entorno, AST arbol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public String tipoIns() {
        return "metodo";
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

    public boolean isIsPrincipal() {
        return isPrincipal;
    }

    public void setIsPrincipal(boolean isPrincipal) {
        this.isPrincipal = isPrincipal;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    
}
