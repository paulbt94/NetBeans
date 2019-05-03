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
public class cDatos {
    private static Scanner scan = new Scanner(System.in);
    private static cCompu compu[] = new cCompu[20];
    private static int pc;
    
    
    
    //Inicializar
    public static void Inicializar() {
        for (int x = 0; x < 20; x++){
            compu[x] = new cCompu();
        }
    }
    
    
    //Ingresar compu
    public static void Ingresar(){
        int serie;
        String descripcion;
        String propietario;
        String telefono;
        String detalle;
        
        while (pc <= 20) {
            System.out.println("Digite la prioridad en la que desea que se repare su pc del 1 al 20: ");
        pc = scan.nextInt();
        } if (pc > 20) {
            System.out.println("El valor debe ser entre 1 y 20");
        }
        
        
        
        System.out.println("Digite el numero de serie de su computadora: ");
        serie = scan.nextInt();
        
        System.out.println("Descripcion de la computadora: ");
        descripcion = scan.next();
        
        System.out.println("Digite su nombre: ");
        propietario = scan.next();
        
        System.out.println("Digite su numero de telefono: ");
        telefono = scan.next();
        
        System.out.println("Describa la falla de la computadora: ");
        detalle = scan.next();
        
        if(compu[pc-1].Estado == 0) {
            compu[pc-1].Serie = serie;
            compu[pc-1].Descripcion = descripcion;
            compu[pc-1].Propietario = propietario;
            compu[pc-1].Telefono = telefono;
            compu[pc-1].Detalle = detalle;
            compu[pc-1].Estado = 1;
            
            System.out.println("Su computadora ha sido agregada al sistema!");
        } else if (compu[pc-1].Estado == 1) {
            System.out.println("No hay espacios disponibles");
        }
        
    }

    
}
