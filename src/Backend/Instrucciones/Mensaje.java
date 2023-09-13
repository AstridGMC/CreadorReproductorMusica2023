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
import Frontend.Principal;

/**
 *
 * @author astridmc
 */
public class Mensaje implements Instruccion{
    Expresion expresion;

    public Mensaje(Expresion expresion) {
        this.expresion = expresion;
    }
    
    @Override
    public Object ejecutar(Entorno entorno, AST arbol) {
        Principal.consola.setText(Principal.consola.getText()+"\n"+expresion.getValorImplicito(entorno, arbol));
        return true;
    }

    public String tipoIns() {
        return "mensaje";
    }
    
}
