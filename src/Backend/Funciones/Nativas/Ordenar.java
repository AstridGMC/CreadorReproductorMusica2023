/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Funciones.Nativas;

import Backend.Compilador.AST;
import Backend.Compilador.Entorno;
import Backend.Interfaces.Expresion;
import Backend.Interfaces.Instruccion;
import Frontend.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author astridmc
 */
public class Ordenar implements Instruccion{

    @Override
    public Object ejecutar(Entorno entorno, AST arbol) {
        Object arr = this.arreglo.getValorImplicito(entorno, arbol);
        switch(""){
            case "cadena":
                
                break;
            case "char":
                
                break;
            case "entero":
                
                break;
            case "decimal":
                
                break;    
        }
    
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    Expresion  arreglo;
    String tipoOrden;

    public Ordenar(Expresion arreglo,String tipoOrden) {
        this.arreglo = arreglo;
        this.tipoOrden = tipoOrden;
    }
    
    public ArrayList OrdenarString(ArrayList<Expresion> arreglo, Entorno entorno, AST arbol){
        switch(tipoOrden){
            case "ascendente":
                Collections.sort(arreglo, new Comparator<Expresion>() {
                    public int compare(Expresion obj1, Expresion obj2) {
                        
                        return ((String)obj1.getValorImplicito(entorno, arbol)).compareTo((String)obj2.getValorImplicito(entorno, arbol));
                    }
                });
                return arreglo;
            case "descendente":
                Collections.sort(arreglo,Collections.reverseOrder( new Comparator<Expresion>() {
                    public int compare(Expresion obj1, Expresion obj2) {
                        
                        return ((String)obj1.getValorImplicito(entorno, arbol)).compareTo((String)obj2.getValorImplicito(entorno, arbol));
                    }
                }));
                return arreglo;
            case "pares":
                Principal.consola.setText(Principal.consola.getText()+"\n No se puede ordenar por PARES un arreglo de Cadenas\n");
                break;
            case "impares":
                Principal.consola.setText(Principal.consola.getText()+"\n No se puede ordenar por IMPARES un arreglo de Cadenas\n");
                break;  
            case "primos":
                Principal.consola.setText(Principal.consola.getText()+"\n No se puede ordenar por PRIMOS un arreglo de Cadenas\n");
                break;    
        }
        return null;
    }
    
    public ArrayList OrdenarInt(ArrayList<Expresion> arreglo,String orden, Entorno entorno, AST arbol){
         switch(tipoOrden){
            case "ascendente":
                Collections.sort(arreglo, new Comparator<Expresion>() {
                    public int compare(Expresion obj1, Expresion obj2) {
                        
                        return ((Integer)obj1.getValorImplicito(entorno, arbol)).compareTo((Integer)obj2.getValorImplicito(entorno, arbol));
                    }
                });
                return arreglo;
            case "descendente":
                Collections.sort(arreglo,Collections.reverseOrder( new Comparator<Expresion>() {
                    public int compare(Expresion obj1, Expresion obj2) {
                        
                        return ((Integer)obj1.getValorImplicito(entorno, arbol)).compareTo((Integer)obj2.getValorImplicito(entorno, arbol));
                    }
                }));
                return arreglo;
            case "pares":
                break;
            case "impares":
                break;  
            case "primos":
                break;
        }
        return null;
    }
    
    public ArrayList OrdenarChar(ArrayList<Expresion> arreglo,String orden, Entorno entorno, AST arbol){
        switch(tipoOrden){
            case "ascendente":
                Collections.sort(arreglo, new Comparator<Expresion>() {
                    public int compare(Expresion obj1, Expresion obj2) {
                        
                        return ((Character)obj1.getValorImplicito(entorno, arbol)).compareTo((Character)obj2.getValorImplicito(entorno, arbol));
                    }
                });
                return arreglo;
            case "descendente":
                Collections.sort(arreglo,Collections.reverseOrder( new Comparator<Expresion>() {
                    public int compare(Expresion obj1, Expresion obj2) {
                        
                        return ((Character)obj1.getValorImplicito(entorno, arbol)).compareTo((Character)obj2.getValorImplicito(entorno, arbol));
                    }
                }));
                return arreglo;
            case "pares":
                Principal.consola.setText(Principal.consola.getText()+"\n No se puede ordenar por PARES un arreglo de Caracteres\n");
                break;
            case "impares":
                Principal.consola.setText(Principal.consola.getText()+"\n No se puede ordenar por IMPARES un arreglo de Caracteres\n");
                break;  
            case "primos":
                Principal.consola.setText(Principal.consola.getText()+"\n No se puede ordenar por PRIMOS un arreglo de Caracteres\n");
                break;
        }
        return null;
    }
    
    public ArrayList OrdenarDouble(ArrayList<Expresion> arreglo,String orden, Entorno entorno, AST arbol){
        switch(tipoOrden){
            case "ascendente":
                Collections.sort(arreglo, new Comparator<Expresion>() {
                    public int compare(Expresion obj1, Expresion obj2) {
                        
                        return ((Double)obj1.getValorImplicito(entorno, arbol)).compareTo((Double)obj2.getValorImplicito(entorno, arbol));
                    }
                });
                return arreglo;
            case "descendente":
                Collections.sort(arreglo,Collections.reverseOrder( new Comparator<Expresion>() {
                    public int compare(Expresion obj1, Expresion obj2) {
                        
                        return ((Double)obj1.getValorImplicito(entorno, arbol)).compareTo((Double)obj2.getValorImplicito(entorno, arbol));
                    }
                }));
                return arreglo;
            case "pares":
                break;
            case "impares":
                break;  
            case "primos":
                break;
        }
        return null;
    }
    
    @Override
    public String tipoIns() {
        return "ordenar";
    }
}
