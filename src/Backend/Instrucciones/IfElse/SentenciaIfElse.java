/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Instrucciones.IfElse;

import Backend.Compilador.AST;
import Backend.Compilador.Entorno;
import Backend.Interfaces.Instruccion;

/**
 *
 * @author astridmc
 */
public class SentenciaIfElse implements Instruccion{
    SentenciaIf senIf;

    public SentenciaIfElse(SentenciaIf senIf) {
        this.senIf = senIf;
    }

    @Override
    public Object ejecutar(Entorno entorno, AST arbol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String tipoIns() {
        return "sentenciaIfElse";
    }
}
