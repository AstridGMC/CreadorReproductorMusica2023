/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Interfaces;

import Backend.Compilador.AST;
import Backend.Compilador.Entorno;

/**
 *
 * @author astridmc
 */
public interface Instruccion {
    String tipoIns();
    Object ejecutar(Entorno entorno, AST arbol);
    
}
