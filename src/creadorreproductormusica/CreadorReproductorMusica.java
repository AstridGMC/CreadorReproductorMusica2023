/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creadorreproductormusica;
import CupYFlex.parser;
import CupYFlex.AnalizadorLexico;
import Frontend.Principal;
import java.io.StringReader;

/**
 *
 * @author astridmc
 */
public class CreadorReproductorMusica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*String entrada = "pista jo \n  \tvar cadena unn=\"d#nd\" \n\tvar entero unn\n ";
            AnalizadorLexico lexico = new AnalizadorLexico(new StringReader(entrada));
            parser parser1 = new parser(lexico);
        try {
            parser1.parse();
        } catch (Exception ex) {
            System.out.println("Error fatal en compilación de entrada.");
            System.out.println("Causa: "+ex);
        } */
        Principal principal = new Principal();
        principal.setVisible(true);
        /*Object obj = 3.3;
        Class c = obj.getClass();
        System.out.println("Clase del Objeto obj es : "
                + c.getName());
        if(c.getName().contains("Boolean")){
            System.out.println("siii");
        }else{
            System.out.println("nooo");
        }*/
    }
}
