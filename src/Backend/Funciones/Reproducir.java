/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Funciones;

import Backend.Compilador.AST;
import Backend.Compilador.Entorno;
import Backend.Interfaces.Expresion;
import Backend.Interfaces.Instruccion;

/**
 *
 * @author astridmc
 */
public class Reproducir implements Instruccion{
    String nota;
    Expresion octava;
    Expresion milisegundos;
    Expresion Canal;

    public Reproducir(String nota, Expresion octava, Expresion milisegundos, Expresion Canal) {
        this.nota = nota;
        this.octava = octava;
        this.milisegundos = milisegundos;
        this.Canal = Canal;
    }

    @Override
    public Object ejecutar(Entorno entorno, AST arbol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String tipoIns() {
        return "reproducir";
    }
    
    
}
