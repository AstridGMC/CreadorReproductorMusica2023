/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Instrucciones;

import Backend.Compilador.AST;
import Backend.Compilador.Entorno;
import Backend.Compilador.Simbolo;
import Backend.Compilador.Simbolo.Tipo;
import Backend.Interfaces.Expresion;
import Backend.Interfaces.Instruccion;

import Backend.Funciones.Funcion;
import Frontend.Principal;
import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class Declaracion implements Instruccion{
    ArrayList<Simbolo> variables;
    Tipo tipo ;
    boolean isKeep;
    Expresion valor;

    public Declaracion(ArrayList<Simbolo> ids, Tipo tipo, boolean isKeep) {
        this.variables = ids;
        this.tipo = tipo;
        this.isKeep = isKeep;
    }
    
    
    @Override
    public Object ejecutar(Entorno entorno, AST arbol) {
        Object valor_simbolo = null;
         Simbolo.Tipo tipoResultado;
         if (valor != null)
            {
                valor_simbolo = valor.getValorImplicito(entorno, arbol);
               
                    tipoResultado = getTipo(valor_simbolo);
            }
            else
            {
                tipoResultado = tipo;
                if (tipo == Simbolo.Tipo.BOOL)
                    valor_simbolo = false;
                else if (tipo == Simbolo.Tipo.DOUBLE)
                    valor_simbolo = 0.0;
                else if (tipo == Simbolo.Tipo.INT)
                    valor_simbolo = 0;
                else if (tipo == Simbolo.Tipo.STRING)
                    valor_simbolo = "";
               else if (tipo == Simbolo.Tipo.CHAR)
                    valor_simbolo = '.';
            }

            for (Simbolo variable : variables) {
            
          
                if (!entorno.ExisteEnActual(variable.identificador))
                {
                    if (tipo == tipoResultado)
                    {
                        variable.valor = valor_simbolo;
                        entorno.Agregar(variable.identificador, variable);
                    }
                    else
                    {
                         Principal.consola.setText(Principal.consola.getText()+"Error semantico en Declaracion, no se permiten asignar valores de diferentes tipos en linea " + variable.linea + " y columna " + variable.columna + "\n");
                        return false;
                    }
                }
                else
                {
                    Principal.consola.setText(Principal.consola.getText()+"Error semantico en Declaracion, no se permiten declarar dos id... con el mismo nombre en linea " + variable.linea + " y columna " + variable.columna + "\n");
                    return false;
                }
            }
            return null;
        
    
    }
    
    /**
     *
     * @param ids
     */
    public void setIds(ArrayList<Simbolo> ids) {
        this.variables = ids;
    }

    public Tipo getTipo(Object valor) {
        
            if (boolean.class == valor)
            {
                return Simbolo.Tipo.BOOL;
            }
            else if (valor == String.class )
            {
                return Simbolo.Tipo.STRING;
            }
            else if (valor == int.class)
            {
                return Simbolo.Tipo.INT;
            }
            else if (valor == double.class)
            {
                return Simbolo.Tipo.DOUBLE;
            }
            else if (valor == double.class)
            {
                return Simbolo.Tipo.DOUBLE;
            }
            else
                return Simbolo.Tipo.STRING;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public boolean isIsKeep() {
        return isKeep;
    }

    public void setIsKeep(boolean isKeep) {
        this.isKeep = isKeep;
    }

    @Override
    public String tipoIns() {
        return "Declaracion";
    }
    
    
}
