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
public class cDatos {
    private static Scanner scan = new Scanner(System.in);
    private static cCita cita[][][] = new cCita[7][9][3];
    private static int dia;
    private static int hora;
    private static int psicologo;
    private static int asignarCita = 0;
    
    
    public static void Inicializar() {
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 9; y++) {
                for (int z = 0; z < 3; z++) {
                    cita[x][y][z] = new cCita();
                }
                
            }
        }
    }
    
    public static void Asignar() {
        String nombre;
        String telefono;
        String cedula;
        String correo;
        
        System.out.println("Seleccione el dia del 1 al 7: ");
        dia = scan.nextInt();
        System.out.println("Seleccione la hora del 1 al 9: ");
        hora = scan.nextInt();
        System.out.println("Seleccione el Psicologo del 1 al 3: ");
        psicologo = scan.nextInt();
        System.out.println("Digite su nombre: ");
        nombre = scan.next();
        System.out.println("Digite su numero de telefono: ");
        telefono = scan.next();
        System.out.println("Digite su numero de cedula: ");
        cedula = scan.next();
        System.out.println("Digite su correo electronico: ");
        correo = scan.next();
        if (cita[dia-1][hora-1][psicologo-1].Estado==0) {
            cita[dia-1][hora-1][psicologo-1].Nombre = nombre;
            cita[dia-1][hora-1][psicologo-1].Telefono = telefono;
            cita[dia-1][hora-1][psicologo-1].Cedula = cedula;
            cita[dia-1][hora-1][psicologo-1].Correo = correo;
            cita[dia-1][hora-1][psicologo-1].Estado = 1;
            System.out.println("Su cita ha sido asignada!");
            //Guardar en disco
        } else if (cita[dia-1][hora-1][psicologo-1].Estado == 1){
            System.out.println("La cita solicitada no se encuentra disponible!");
        }
        
        
    }
    
    
}
