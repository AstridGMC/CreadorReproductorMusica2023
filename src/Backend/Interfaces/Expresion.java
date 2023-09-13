/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Interfaces;

import Backend.Compilador.AST;
import Backend.Compilador.Entorno;
import Backend.Compilador.Simbolo.Tipo;

/**
 *
 * @author astridmc
 */
public interface Expresion {

    Tipo getTipo(Entorno entorno, AST arbol);
    Object getValorImplicito(Entorno entorno, AST arbol);
    Object setValorImplicito();
}
