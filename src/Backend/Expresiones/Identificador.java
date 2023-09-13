/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Expresiones;

import Backend.Compilador.AST;
import Backend.Compilador.Entorno;
import Backend.Compilador.Simbolo;
import Backend.Interfaces.Expresion;

/**
 *
 * @author astridmc
 */
public class Identificador implements Expresion{
    public String identificador;
    int fila;
    int columna;

    public Identificador(String identificador, int fila, int columna) {
        this.identificador = identificador;
        this.fila = fila;
        this.columna = columna;
    }
    @Override
    public Object getValorImplicito(Entorno entorno, AST arbol){
        return this.identificador;
    }
    
    
    @Override
    public Simbolo.Tipo getTipo(Entorno entorno, AST arbol) {
     
        return Simbolo.Tipo.IDENTIFICADOR;
    }

    @Override
    public Object setValorImplicito() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
