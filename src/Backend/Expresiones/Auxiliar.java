/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Expresiones;

import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class Auxiliar {
    String identificador;
    String Tipo;
    ArrayList<Object> arreglo;
    int tam;

    public Auxiliar(String identificador, String Tipo, int tam) {
        this.identificador = identificador;
        this.Tipo = Tipo;
        this.tam = tam;
    }

    public Auxiliar(String identificador, String Tipo) {
        this.identificador = identificador;
        this.Tipo = Tipo;
    }

    public Auxiliar(ArrayList<Object> arreglo) {
        this.arreglo = arreglo;
    }
    
    
}
