/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Listas;

import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class Lista {
    String nombre;
    boolean random;
    boolean circular;
    ArrayList<String> pistasNombres;

    public Lista(String nombre, boolean random, boolean circular, ArrayList<String> pistasNombres) {
        this.nombre = nombre;
        this.random = random;
        this.circular = circular;
        this.pistasNombres = pistasNombres;
    }

    public Lista() {
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isRandom() {
        return random;
    }

    public void setRandom(boolean random) {
        this.random = random;
    }

    public boolean isCircular() {
        return circular;
    }

    public void setCircular(boolean circular) {
        this.circular = circular;
    }

    public ArrayList<String> getPistasNombres() {
        return pistasNombres;
    }

    public void setPistasNombres(ArrayList<String> pistasNombres) {
        this.pistasNombres = pistasNombres;
    }
    
    public void Asignar(AtributoLista at){
        try {
            switch(at.tipo){
                case "nombre":
                    this.nombre = at.cont.toString();
                    break;

               case "random":
                   this.random =(boolean) at.cont;
                    break;

               case "circular":
                     this.circular =(boolean) at.cont;
                    break;
               case "pistas":
                     this.pistasNombres =(ArrayList<String>) at.cont;
                    break;
            }
        } catch (Exception e) {
        }
        
    }
    
}
