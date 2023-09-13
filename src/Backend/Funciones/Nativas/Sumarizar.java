/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Funciones.Nativas;

import Backend.Compilador.AST;
import Backend.Compilador.Entorno;
import Backend.Interfaces.Expresion;
import Backend.Interfaces.Instruccion;
import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class Sumarizar implements Instruccion{

    Expresion idArreglo;
    ArrayList<Expresion> arreglo;

    public Sumarizar(Expresion idArreglo) {
        this.idArreglo = idArreglo;
    }

    public Sumarizar(ArrayList<Expresion> arreglo) {
        this.arreglo = arreglo;
    }
    
    @Override
    public Object ejecutar(Entorno entorno, AST arbol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Expresion getIdArreglo() {
        return idArreglo;
    }

    public void setIdArreglo(Expresion idArreglo) {
        this.idArreglo = idArreglo;
    }

    public ArrayList<Expresion> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<Expresion> arreglo) {
        this.arreglo = arreglo;
    }
    
    @Override
    public String tipoIns() {
        return "sumarizar";
    }
    
}
