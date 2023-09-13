/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Compilador;
/**
 *
 * @author astridmc
 */
public class Simbolo {
    public String idUnico;
    public String identificador;
    public Object valor;
    public Tipo tipo;
    public int linea;
    public int columna;
    
    public  enum Tipo {
       STRING,
       INT,
       DOUBLE,
       BOOL,
       VOID,
       STRUCT,
       NULL,
       ATRIBUTO,
       CHAR,
       ARRAY,
       IDENTIFICADOR,
       METODO
   }
 

    public Simbolo(String identificador, Tipo tipo, int linea, int columna) {
        this.identificador = identificador;
        this.tipo = tipo;
        this.linea = linea;
        this.columna = columna;
    }
    
     public Simbolo(String identificador, Tipo tipo) {
        this.identificador = identificador;
        this.tipo = tipo;
    }
    
   
    
}
