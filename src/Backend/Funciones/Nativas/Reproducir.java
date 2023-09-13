/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Funciones.Nativas;

import Backend.Compilador.AST;
import Backend.Compilador.Entorno;
import Backend.Interfaces.Expresion;
import Backend.Interfaces.Instruccion;
import Backend.Reproductor.Nota.notas;

/**
 *
 * @author astridmc
 */
public class Reproducir implements Instruccion{

    @Override
    public Object ejecutar(Entorno entorno, AST arbol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    String nota;
    Expresion octava;
    Expresion miliSegundos;
    Expresion canal;

    public Reproducir(String nota, Expresion octava, Expresion miliSegundos, Expresion canal) {
        this.nota = nota;
        this.octava = octava;
        this.miliSegundos = miliSegundos;
        this.canal = canal;
    }
    
    @Override
    public String tipoIns() {
        return "reproducir";
    }
    
}
