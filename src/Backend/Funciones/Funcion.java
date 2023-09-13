/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Funciones;

import Backend.Compilador.AST;
import Backend.Compilador.Entorno;
import Backend.Compilador.Simbolo.Tipo;
import Backend.Interfaces.Instruccion;
import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class Funcion implements Instruccion{
    private boolean esPrincipal;
    private String Nombre;
    private Tipo tipo;
    private ArrayList<Instruccion> sentencias;
    private boolean isNativa;
    private boolean isKeep;
    private ArrayList<Parametro> parametros;
    

    public Funcion(String Nombre, Tipo tipo, ArrayList<Instruccion> sentencias, boolean isNativa, boolean isKeep, boolean esPrincipal,ArrayList<Parametro> parametros) {
        this.Nombre = Nombre;
        this.tipo = tipo;
        this.sentencias = sentencias;
        this.isNativa = isNativa;
        this.isKeep = isKeep;
        this.esPrincipal=esPrincipal;
        this.parametros = parametros;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Instruccion> getSentencias() {
        return sentencias;
    }

    public void setSentencias(ArrayList<Instruccion> sentencias) {
        this.sentencias = sentencias;
    }

    public boolean isIsNativa() {
        return isNativa;
    }

    public void setIsNativa(boolean isNativa) {
        this.isNativa = isNativa;
    }

    public boolean isIsKeep() {
        return isKeep;
    }

    public void setIsKeep(boolean isKeep) {
        this.isKeep = isKeep;
    }

    public boolean isEsPrincipal() {
        return esPrincipal;
    }

    public ArrayList<Parametro> getParametros() {
        return parametros;
    }

    public void setParametros(ArrayList<Parametro> parametros) {
        this.parametros = parametros;
    }

    
    
    @Override
    public Object ejecutar(Entorno entorno, AST arbol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String tipoIns() {
        return "funcion";
    }
    
    
}
