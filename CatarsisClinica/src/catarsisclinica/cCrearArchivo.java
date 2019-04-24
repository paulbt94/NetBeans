/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catarsisclinica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;

/**
 *
 * @author pauls
 */
public class cCrearArchivo {
    String[] archivoLeido = new String[8];
    public static void crearArchivo(String texto){
        File file = new File("Catarsis.txt");

        try (Writer writer = new BufferedWriter(new FileWriter(file))) {
            String contents = texto;
            
            writer.write(contents);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void leerArchivo() throws FileNotFoundException, IOException{
        File file = new File("Catarsis.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while((st = br.readLine()) != null){
            System.out.println(st);
        }
    }
    
    
}
