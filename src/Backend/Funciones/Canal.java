/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Funciones;

import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class Canal {
    int idCanal;
    ArrayList <Reproducir> reproducciones;

    public Canal(int idCanal) {
        this.idCanal = idCanal;
    }
    
    public void insertarReproduccion(Reproducir rep){
        reproducciones.add(rep);
    }
    
    
}
