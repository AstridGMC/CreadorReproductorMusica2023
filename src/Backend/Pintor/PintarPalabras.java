/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Pintor;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author luis
 */
public class PintarPalabras {

    public JTextPane caja2;
    private StyleContext sc;
    private DefaultStyledDocument doc;

    public PintarPalabras() {
        this.caja2 = new JTextPane();
        this.sc = new StyleContext();
        this.doc = new DefaultStyledDocument(sc);
    }

    public void darEstilo(String textoApintar) {

        caja2.setDocument(doc);
        try {
            doc.insertString(0, textoApintar, null);
        } catch (Exception ex) {
            System.out.println("ERROR: no se pudo establecer estilo de documento");
        }

    }

    //COMENTARIO
    public void pintaGris(int posini, int posfin) {
        Style rojo = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(rojo, Color.LIGHT_GRAY);
        doc.setCharacterAttributes(posini, posfin, rojo, false);

    }

    //IDENTIFICADORES
    public void pintaVerde(int posini, int posfin) {
        Style verde = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(verde, Color.decode("#088A29"));
        doc.setCharacterAttributes(posini, posfin, verde, false);
    }


    //PALABRAS RESERVADAS
    public void pintaAzul(int posini, int posfin) {
        Style azul = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(azul, Color.blue);
        doc.setCharacterAttributes(posini, posfin, azul, false);

    }


    //NUMEROS
    public void pintaMora(int posini, int posfin) {
        Style mora = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(mora, Color.decode("#9400D3"));
        doc.setCharacterAttributes(posini, posfin, mora, false);
    }

    //CADENAS, CARACTERES
    public void pintaNara(int posini, int posfin) {
        Style nara = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(nara, Color.decode("#FF8000"));
        doc.setCharacterAttributes(posini, posfin, nara, false);
    }
}
