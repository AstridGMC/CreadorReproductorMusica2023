/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Compilador;

import Backend.Instrucciones.Funcion;
import Backend.Interfaces.Instruccion;
import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class AST {
    public ArrayList<Instruccion> instrucciones;
    public ArrayList<Funcion> funciones;
    public AST(ArrayList<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }
    
}
