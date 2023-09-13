/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Funciones;

import Backend.Compilador.Simbolo.Tipo;
import Backend.Interfaces.Expresion;

/**
 *
 * @author astridmc
 */
public class Parametro {
    Tipo tipo;
    String nombreParam;

    public Parametro(Tipo tipo, String nombreParam) {
        this.tipo = tipo;
        this.nombreParam = nombreParam;
    }
    
    
           
}
