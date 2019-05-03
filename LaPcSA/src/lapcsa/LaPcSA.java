/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapcsa;

import java.util.*;

/**
 *
 * @author pauls
 */
public class LaPcSA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opcion = 1;
        Scanner scan = new Scanner(System.in);
        
        //Inicializar clase
        cDatos.Inicializar();
        
        System.out.println("Bienvenido al taller de reparacion de computadoras La PC SA");
        System.out.println("Por favor digite el numero de una de las siguientes opciones: ");
        
        //Menu
        while(opcion != 0) {
            System.out.println("1. Ingresar una computadora");
            System.out.println("2. Retirar una computadora");
            System.out.println("3. Ver estado de la computadora");
            System.out.println("4. Mostrar computadoras pendientes de reparacion");
            System.out.println("0. Salir");
            opcion = scan.nextInt();
            
            if (opcion == 1){
                //cDatos.Ingresar();
            }
            
        }
    }
    
}
