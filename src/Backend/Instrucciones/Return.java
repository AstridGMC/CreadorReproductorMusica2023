/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Instrucciones;

import Backend.Compilador.AST;
import Backend.Compilador.Entorno;
import Backend.Interfaces.Expresion;
import Backend.Interfaces.Instruccion;

/**
 *
 * @author astridmc
 */
public class Return implements Instruccion{
    Expresion expresion;

    public Return(Expresion expresion) {
        this.expresion = expresion;
    }
    
    

    @Override
    public Object ejecutar(Entorno entorno, AST arbol) {
        return expresion;
    }
    
    @Override
    public String tipoIns() {
        return "return";
    }
}
