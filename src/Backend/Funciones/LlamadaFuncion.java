/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Funciones;

import Backend.Interfaces.Expresion;
import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class LlamadaFuncion {
    String idFuncion;
    ArrayList<Expresion> listaExp;

    public LlamadaFuncion(String idFuncion, ArrayList<Expresion> listaExp) {
        this.idFuncion = idFuncion;
        this.listaExp = listaExp;
    }
    
    
}
