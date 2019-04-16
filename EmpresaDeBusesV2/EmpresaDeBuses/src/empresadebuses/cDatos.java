package empresadebuses;

import java.io.*;
import java.util.Scanner;

public class cDatos {
    private static cTiquete tiquetes[][][] = new cTiquete[7][12][60];
    private static Scanner teclado = new Scanner(System.in);
    private static int dia;
    private static int horario;
    private static int asiento;
    private static int ventaTotal=0;
    
    public static void Inicializar() {
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 12; y++) { 
                for (int z = 0; z < 60; z++) {
                    tiquetes[x][y][z] = new cTiquete();
                }
            }
            
        }
        //LeerDeDisco();
    }

    public static void Vender() {
        String nombre;
        String cedula;
        String formaPago;
        String fechaCompra;
        
        System.out.print("\033[32mSeleccione el día:          ");
        dia = teclado.nextInt();
        System.out.print("\033[32mSeleccione el horario:      ");
        horario = teclado.nextInt();
        System.out.print("\033[32mSeleccione el asiento:      ");
        asiento = teclado.nextInt();
        System.out.print("\033[32mIngrese el nombre:          ");
        nombre = teclado.next();
        System.out.print("\033[32mIngrese la cédula:          ");
        cedula = teclado.next();
        System.out.print("\033[32mIngrese la forma de pago:   ");
        formaPago = teclado.next();
        System.out.print("\033[32mIngrese la fecha de compra: ");
        fechaCompra = teclado.next();
        if (tiquetes[dia-1][horario-8][asiento-1].Estado == 0) {
            tiquetes[dia-1][horario-8][asiento-1].Nombre = nombre;
            tiquetes[dia-1][horario-8][asiento-1].Cedula = cedula;
            tiquetes[dia-1][horario-8][asiento-1].FormaPago = formaPago;
            tiquetes[dia-1][horario-8][asiento-1].FechaCompra = fechaCompra;
            tiquetes[dia-1][horario-8][asiento-1].Estado = 1;
            System.out.println("\033[32mVendido !");
            ventaTotal = ventaTotal + 3000;
            //GuardarADisco();
        } else if (tiquetes[dia-1][horario-8][asiento-1].Estado == 1) {
            System.out.println("\033[31mEl asiento no se encuentra disponible");
        } else {
            System.out.println("\033[31mEl asiento está apartado");
        }
    }

    public static void Apartar() {
        String nombre;
        String cedula;
        String formaPago;
        String fechaCompra;
        
        System.out.print("\033[32mSeleccione el día:          ");
        dia = teclado.nextInt();
        System.out.print("\033[32mSeleccione el horario:      ");
        horario = teclado.nextInt();
        System.out.print("\033[32mSeleccione el asiento:      ");
        asiento = teclado.nextInt();
        System.out.print("\033[32mIngrese el nombre:          ");
        nombre = teclado.next();
        System.out.print("\033[32mIngrese la cédula:          ");
        cedula = teclado.next();
        System.out.print("\033[32mIngrese la forma de pago:   ");
        formaPago = teclado.next();
        System.out.print("\033[32mIngrese la fecha de compra: ");
        fechaCompra = teclado.next();
        if (tiquetes[dia-1][horario-8][asiento-1].Estado == 0) {
            tiquetes[dia-1][horario-8][asiento-1].Nombre = nombre;
            tiquetes[dia-1][horario-8][asiento-1].Cedula = cedula;
            tiquetes[dia-1][horario-8][asiento-1].FormaPago = formaPago;
            tiquetes[dia-1][horario-8][asiento-1].FechaCompra = fechaCompra;
            tiquetes[dia-1][horario-8][asiento-1].Estado = 2;
            System.out.println("\033[32mApartado !");
            //GuardarADisco();
        } else if (tiquetes[dia-1][horario-8][asiento-1].Estado == 1) {
            System.out.println("\033[31mEl asiento no se encuentra disponible");
        } else {
            System.out.println("\033[31mEl asiento está apartado");
        }
    }

    public static void Retirar() {
        System.out.print("\033[32mSeleccione el día:          ");
        dia = teclado.nextInt();
        System.out.print("\033[32mSeleccione el horario:      ");
        horario = teclado.nextInt();
        System.out.print("\033[32mSeleccione el asiento:      ");
        asiento = teclado.nextInt();
        if (tiquetes[dia-1][horario-8][asiento-1].Estado == 2) {
            tiquetes[dia-1][horario-8][asiento-1].Estado = 1;
            System.out.println("\033[32mSe pasó a estado vendido !");
            ventaTotal = ventaTotal + 3000;
            //GuardarADisco();
        } else if (tiquetes[dia-1][horario-8][asiento-1].Estado == 1) {
            System.out.println("\033[31mEl asiento ya estaba vendido");
        } else {
            System.out.println("\033[31mEl asiento no ha sido apartado");
        }
    }
    
    public static void Porcentajes() {
        int cantidad;
        for (int x = 0; x < 7; x ++) {
            for (int y = 0; y < 12; y++) {
                cantidad = 0;
                for (int z = 0; z < 60; z ++) {
                    if (tiquetes[x][y][z].Estado > 0) {
                        cantidad++;
                    }
                }
                cantidad = cantidad * 100 / 60;
                System.out.println("Día " + (x + 1) + ", horario " + (y + 8) + ", porcentaje : " + cantidad );
            }
        }
        
    }    
    
    public static void Devolver() {
        System.out.print("\033[32mSeleccione el día:     ");
        dia = teclado.nextInt();
        System.out.print("\033[32mSeleccione el horario: ");
        horario = teclado.nextInt();
        System.out.print("\033[32mSeleccione el asiento: ");
        asiento = teclado.nextInt();
        if (tiquetes[dia-1][horario-8][asiento-1].Estado == 0) {
            System.out.println("\033[31mNo se puede devolver ese tiquete porque no ha sido vendido");
        } else if (tiquetes[dia-1][horario-8][asiento-1].Estado == 1) {
            tiquetes[dia-1][horario-8][asiento-1].Estado = 0;
            System.out.println("\033[31mEl asiento se encuentra nuevamente disponible");
            ventaTotal = ventaTotal - 3000;
            //GuardarADisco();
        } else {
            tiquetes[dia-1][horario-8][asiento-1].Estado = 0;
            System.out.println("\033[31mEl asiento se encuentra nuevamente disponible");
            //GuardarADisco();            
        }
    }
    
    public static void Reporte() {
        System.out.print("\033[32mSeleccione el día:     ");
        dia = teclado.nextInt();
        System.out.print("\033[32mSeleccione el horario: ");
        horario = teclado.nextInt();
        for (int i = 0; i<60; i++) {
            if (tiquetes[dia-1][horario-8][i].Estado == 0) {
                System.out.println("Asiento " + (i+1) + " disponible");
            } else {
                System.out.println("Asiento " + (i+1) + " vendido");
            }
        }
    }
    
    public static void CierreCaja() {
        System.out.println("El total vendido es: " + ventaTotal);
    }
}
