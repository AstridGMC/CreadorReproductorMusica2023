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
import Frontend.Principal;
import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class Asignacion implements Instruccion{

    public ArrayList<String> identificadores;
      public String identificador;
    Declaracion declaracion;
    public Expresion valor;
    public int linea;
    public int columna;
    
    Instruccion ins;

    public Asignacion(ArrayList<String> identificadores, Expresion valor, int linea, int columna) {
        this.identificadores = identificadores;
        this.valor = valor;
        this.linea = linea;
        this.columna = columna;
    }
    public Asignacion(String identificador, Expresion valor, int linea, int columna) {
        this.identificador = identificador;
        this.valor = valor;
        this.linea = linea;
        this.columna = columna;
    }
    public Asignacion(String identificador, Expresion valor) {
        this.identificador = identificador;
        this.valor = valor;
    }

    public Asignacion(Declaracion declaracion, Expresion valor) {
        this.declaracion = declaracion;
        this.valor = valor;
    }
    
     public Asignacion(String identificador, Instruccion funcion) {
         this.identificador = identificador;
         this.ins=funcion;
    }
 public Asignacion(ArrayList<String> identificadores,  Instruccion funcion) {
         this.identificadores = identificadores;
         this.ins=funcion;
    }
    @Override
    public Object ejecutar(Entorno entorno, AST arbol) {
       
         Object valor_simbolo = valor.getValorImplicito(entorno, arbol);
         Tipo tipoResultado = valor.getTipo(entorno, arbol);
          if(identificadores!=null){
              for (int i = 0; i < identificadores.size(); i++) {
                       if (entorno.Existe(identificadores.get(i)))
                      {
                          Simbolo simbolo = entorno.getSimbolo(identificadores.get(i));
                          if (simbolo.tipo == tipoResultado)
                          {
                              simbolo.valor = valor_simbolo;
                              entorno.Reemplazar(identificadores.get(i), simbolo);
                          }
                          else
                          {
                              Principal.consola.setText(Principal.consola.getText()+"Error semantico en Asignacion, no se permiten asignar valores de diferentes tipos en linea " + linea + " y columna " + columna + "\n");
                              return false;
                          }
                      }
                      else
                      {
                          Principal.consola.setText(Principal.consola.getText()+"Error semantico no existe el  id " + identificadores.get(i) + " " + linea + " y columna " + columna + "\n");
                          return null;
                      }
              }
          }else{
              if (entorno.Existe(identificador))
            {
                Simbolo simbolo = entorno.getSimbolo(identificador);
                if (simbolo.tipo == tipoResultado)
                {
                    simbolo.valor = valor_simbolo;
                    entorno.Reemplazar(identificador, simbolo);
                }
                else
                {
                    Principal.consola.setText(Principal.consola.getText()+"Error semantico en Asignacion, no se permiten asignar valores de diferentes tipos en linea " + linea + " y columna " + columna + "\n");
                    return false;
                }
            }
            else
            {
                Principal.consola.setText(Principal.consola.getText()+"Error semantico no existe el  id " + identificador + " " + linea + " y columna " + columna + "\n");
                return null;
            }
          }
            return null;
        }

    @Override
    public String tipoIns() {
        return "Asignacion";
    }

  
}
