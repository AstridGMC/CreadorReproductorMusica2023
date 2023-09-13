/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Instrucciones;

import Backend.Compilador.AST;
import Backend.Compilador.Entorno;
import Backend.Compilador.Simbolo.Tipo;
import Backend.Interfaces.Instruccion;
import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class Declaracion implements Instruccion{
    ArrayList<String> ids;
    Tipo tipo ;
    boolean isKeep;

    public Declaracion(ArrayList<String> ids, Tipo tipo, boolean isKeep) {
        this.ids = ids;
        this.tipo = tipo;
        this.isKeep = isKeep;
    }
    
    
    @Override
    public Object ejecutar(Entorno entorno, AST arbol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String tipoIns() {
        return "declaracion";
    }

    public ArrayList<String> getIds() {
        return ids;
    }

    public void setIds(ArrayList<String> ids) {
        this.ids = ids;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public boolean isIsKeep() {
        return isKeep;
    }

    public void setIsKeep(boolean isKeep) {
        this.isKeep = isKeep;
    }
    
    
}
