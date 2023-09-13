/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Funciones.Nativas;

import Backend.Compilador.AST;
import Backend.Compilador.Entorno;
import Backend.Compilador.Simbolo;
import Backend.Compilador.Simbolo.Tipo;
import Backend.Interfaces.Expresion;
import Backend.Interfaces.Instruccion;
import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class Longitud implements Instruccion{
    Expresion expresion;
    
    @Override
    public Object ejecutar(Entorno entorno, AST arbol) {
        if(expresion.getTipo(entorno, arbol)==Tipo.ARRAY){
            return ((ArrayList)expresion.getValorImplicito(entorno, arbol)).size();
        }else if(expresion.getTipo(entorno, arbol)==Tipo.IDENTIFICADOR){
           // return ((String)expresion.getValorImplicito(entorno, arbol)).length();
        }else if(expresion.getTipo(entorno, arbol)==Tipo.STRING){
            return ((String)expresion.getValorImplicito(entorno, arbol)).length();
        }
        return null;
    }

    public Longitud(Expresion arreglo) {
        this.expresion = arreglo;
    }

    @Override
    public String tipoIns() {
        return "longitud";
    }

    
    
}
