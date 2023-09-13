/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Expresiones;

import Backend.Compilador.AST;
import Backend.Compilador.Entorno;
import Backend.Compilador.Simbolo;
import Backend.Interfaces.Expresion;
import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class LlamadaArreglo implements Expresion{
    String identificador;
    String Tipo;
    ArrayList<Expresion> indices;
    int tam;

    public LlamadaArreglo(String identificador, String Tipo, ArrayList<Expresion> indices) {
        this.identificador = identificador;
        this.Tipo = Tipo;
        this.indices = indices;
    }
    
    @Override
    public Simbolo.Tipo getTipo(Entorno entorno, AST arbol) {
        return Simbolo.Tipo.ARRAY;
    }

    @Override
    public Object getValorImplicito(Entorno entorno, AST arbol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object setValorImplicito() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
