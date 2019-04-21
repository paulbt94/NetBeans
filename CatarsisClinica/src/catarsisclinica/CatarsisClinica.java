/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catarsisclinica;
import java.util.Scanner;

/**
 *
 * @author pauls
 */
public class CatarsisClinica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
            System.out.println("1. Citas");
            System.out.println("2. Expedientes");
            System.out.println("3. Reportes");
            System.out.println("0. Salir");
            opcion = scan.nextInt();
            if (opcion == 1) {
                cDatos.Asignar();
            }else if (opcion == 3){
                cDatos.Reporte();
            }
        }
        
    }
    
    
}
