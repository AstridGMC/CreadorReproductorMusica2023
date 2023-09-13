/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Reproductor;

/**
 *
 * @author astridmc
 */
public class Nota {
    notas nombre;
    int idNota;
    public enum notas{
        DO,
        RE,
        MI,
        FA,
        SOL,
        LA,
        SI
        
    }
    
    public static String ComprobarNota(String nota){
        if(notas.DO.toString().toLowerCase().equals(nota.toLowerCase())){
            return "C";
        }else if(notas.RE.toString().toLowerCase().equals(nota.toLowerCase())){
            return "D";
        }else if(notas.MI.toString().toLowerCase().equals(nota.toLowerCase())){
            return "E";
        }else if(notas.FA.toString().toLowerCase().equals(nota.toLowerCase())){
            return "F";
        }else if(notas.SOL.toString().toLowerCase().equals(nota.toLowerCase())){
            return "G";
        }else if(notas.LA.toString().toLowerCase().equals(nota.toLowerCase())){
            return "A";
        }else if(notas.SI.toString().toLowerCase().equals(nota.toLowerCase())){
            return "B";
        }else{
            return null;
        }
        
    }
}
