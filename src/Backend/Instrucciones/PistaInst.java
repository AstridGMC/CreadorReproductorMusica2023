/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Instrucciones;

import Backend.Compilador.AST;
import Backend.Compilador.Entorno;
import Backend.Interfaces.Instruccion;
import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class PistaInst implements Instruccion{
    String nombre;
    ArrayList<Instruccion> instrucciones;
    ArrayList<String> Imports;

    public PistaInst(String nombre, ArrayList<Instruccion> instrucciones, ArrayList<String> Imports) {
        this.nombre = nombre;
        this.instrucciones = instrucciones;
        this.Imports = Imports;
    }

    @Override
    public Object ejecutar(Entorno entorno, AST arbol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Instruccion> getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(ArrayList<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }

    public ArrayList<String> getImports() {
        return Imports;
    }

    public void setImports(ArrayList<String> Imports) {
        this.Imports = Imports;
    }

    @Override
    public String tipoIns() {
        return "pistaIns";
    }
    
}
