/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Instrucciones;

import Backend.Compilador.AST;
import Backend.Compilador.Entorno;
import Backend.Compilador.Simbolo.Tipo;
import Backend.Interfaces.Expresion;
import Backend.Interfaces.Instruccion;

/**
 *
 * @author astridmc
 */
public class DeclaracionFor implements Instruccion{
    Tipo tipoDato;
    String idenfiticador;
    Expresion expresion;

    public DeclaracionFor(Tipo tipoDato, String idenfiticador, Expresion expresion) {
        this.tipoDato = tipoDato;
        this.idenfiticador = idenfiticador;
        this.expresion = expresion;
    }

    @Override
    public Object ejecutar(Entorno entorno, AST arbol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String tipoIns() {
        return "declaracionFor";
    }
    
}
