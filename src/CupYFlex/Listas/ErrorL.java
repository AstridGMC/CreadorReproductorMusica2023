/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CupYFlex.Listas;

import CupYFlex.*;
import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class ErrorL {
    
    private String Lexema;
    private int columna;
    private int fila;
    private String tipo;
    static public ArrayList<ErrorL> tablaErrores=new ArrayList();

    public ErrorL(String Lexema,int fila,int columna, String tipo) {
        this.Lexema = Lexema;
        this.columna = columna;
        this.fila = fila;
        this.tipo = tipo;
    }

    public String getLexema() {
        return Lexema;
    }

    public void setLexema(String Lexema) {
        this.Lexema = Lexema;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String mensaje) {
        this.tipo = mensaje;
        
    }
    
}
