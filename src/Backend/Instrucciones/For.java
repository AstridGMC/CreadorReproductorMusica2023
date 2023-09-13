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
import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class For implements Instruccion{
    DeclaracionFor decFor;
    Expresion expresion;
    Instruccion decIn;
    ArrayList<Instruccion> instrucciones;

    public For(DeclaracionFor decFor, Expresion expresion, Instruccion decIn, ArrayList<Instruccion> instrucciones) {
        this.decFor = decFor;
        this.expresion = expresion;
        this.decIn = decIn;
        this.instrucciones = instrucciones;
    }
     
    
    
    @Override
    public Object ejecutar(Entorno entorno, AST arbol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
    
    @Override
    public String tipoIns() {
        return "for";
    }
}

