/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Instrucciones.IfElse;

import Backend.Compilador.AST;
import Backend.Compilador.Entorno;
import Backend.Interfaces.Instruccion;
import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class SentenciaElse implements Instruccion{
    ArrayList<Instruccion> instrucciones;

    public SentenciaElse(ArrayList<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }
    
    

    @Override
    public Object ejecutar(Entorno entorno, AST arbol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String tipoIns() {
        return "sentenciaElse";
    }
}
