/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catarsisclinica;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author pauls
 */
public class CatarsisClinica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int opcion = 1;
        Scanner scan = new Scanner(System.in);
        
        //Inicializar clase
        cDatos.Inicializar();
        
        //Saludo de bienvenida
        System.out.println("Bienvenido al Sistema de gestion de expedientes electronicos de la Clinica Catarsis.");
        System.out.println("Por favor digite el numero de una de las siguientes opciones:");
        
        //Menu principal de usuario
        while(opcion != 0) {
            System.out.println("1. Asignar citas");
            System.out.println("2. Crear expedientes");
            System.out.println("3. Buscar expediente");
            System.out.println("4. Reporte de disponibilidad");
            System.out.println("0. Salir");
            opcion = scan.nextInt();
            if (opcion == 1) {
                cDatos.Asignar();
            }else if (opcion == 2){
                cDatos.Expediente();
            }else if (opcion == 3){
                cDatos.Buscar();
            }else if (opcion == 4){
                cDatos.Reporte();
            }
        }
    }
 
}
