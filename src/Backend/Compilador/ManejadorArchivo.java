/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Compilador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author astridmc
 */
public class ManejadorArchivo {

    public static String LeerArchivo(String path) {
        String texto = "";
         String texto2 = "";
        try (FileReader entrada = new FileReader(path)) {
            
        BufferedReader bf = new BufferedReader(entrada);
            while ((texto2 = bf.readLine())  != null) {
               texto=texto+texto2+"\n";
            }
            System.out.println(texto);
            return texto;
        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo \\n");
            return "";
        }
    }

    public static void GuardarArchivo(String ruta, String contenido) {
        try {
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
