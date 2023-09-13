/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Instrucciones.IfElse;

import Backend.Compilador.AST;
import Backend.Compilador.Entorno;
import Backend.Interfaces.Expresion;
import Backend.Interfaces.Instruccion;
import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class SentenciaIf implements Instruccion{
    Expresion expresion;
    ArrayList<Instruccion> instrucciones;
    SentenciaElse sentenciaElse;
    SentenciaIfElse sentenciaifElse;

    public SentenciaIf(Expresion expresion, ArrayList<Instruccion> instrucciones, SentenciaElse sentenciaElse, SentenciaIfElse sentenciaifElse) {
        this.expresion = expresion;
        this.instrucciones = instrucciones;
        this.sentenciaElse = sentenciaElse;
        this.sentenciaifElse = sentenciaifElse;
    }

    
    
    @Override
    public Object ejecutar(Entorno entorno, AST arbol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String tipoIns() {
        return "sentenciaIf";
    }
}
