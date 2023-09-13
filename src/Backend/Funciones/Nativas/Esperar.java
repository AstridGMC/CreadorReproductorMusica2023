/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Funciones.Nativas;

import Backend.Compilador.AST;
import Backend.Compilador.Entorno;
import Backend.Interfaces.Instruccion;

/**
 *
 * @author astridmc
 */
public class Esperar implements Instruccion{
    
    int miliSegundos;
    int canal;

    @Override
    public Object ejecutar(Entorno entorno, AST arbol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Esperar(int miliSegundos, int canal) {
        this.miliSegundos = miliSegundos;
        this.canal = canal;
    }
    
    public void esperarTiempo(Double tiempo){
        
    }

    @Override
    public String tipoIns() {
        return "esperar";
    }
}
