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
public class DecIncremento implements Instruccion{
    Expresion expresion;
    public TipoDecIncremento tipo;

    public DecIncremento(Expresion expresion, TipoDecIncremento tipo) {
        this.expresion = expresion;
        this.tipo = tipo;
    }
    
    

    @Override
    public Object ejecutar(Entorno entorno, AST arbol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public enum TipoDecIncremento{
        masmas,
        menosmenos
    }
    
    @Override
    public String tipoIns() {
        return "decIncremento";
    }
}
