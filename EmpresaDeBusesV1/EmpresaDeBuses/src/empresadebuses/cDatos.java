package empresadebuses;

import java.io.*;
import java.util.Scanner;

public class cDatos {
    private static int tiquetes[][][] = new int[7][12][60];
    private static Scanner teclado = new Scanner(System.in);
    private static int dia;
    private static int horario;
    private static int asiento;
    private static int ventaTotal=0;
    
    public static void Inicializar() {
        LeerDeDisco();
    }

    public static void Vender() {
        System.out.print("\033[32mSeleccione el día:     ");
        dia = teclado.nextInt();
        System.out.print("\033[32mSeleccione el horario: ");
        horario = teclado.nextInt();
        System.out.print("\033[32mSeleccione el asiento: ");
        asiento = teclado.nextInt();
        if (tiquetes[dia-1][horario-8][asiento-1] == 1) {
            System.out.println("\033[31mEl asiento no se encuentra disponible");
        } else {
            tiquetes[dia-1][horario-8][asiento-1] = 1;
            System.out.println("\033[32mVendido !");
            ventaTotal = ventaTotal + 3000;
            GuardarADisco();
        }
    }
    
    public static void Devolver() {
        System.out.print("\033[32mSeleccione el día:     ");
        dia = teclado.nextInt();
        System.out.print("\033[32mSeleccione el horario: ");
        horario = teclado.nextInt();
        System.out.print("\033[32mSeleccione el asiento: ");
        asiento = teclado.nextInt();
        if (tiquetes[dia-1][horario-8][asiento-1] == 1) {
            tiquetes[dia-1][horario-8][asiento-1] = 0;
            System.out.println("\033[31mEl asiento se encuentra nuevamente disponible");
            ventaTotal = ventaTotal - 3000;
            GuardarADisco();
        }
    }
    
    public static void Reporte() {
        System.out.print("\033[32mSeleccione el día:     ");
        dia = teclado.nextInt();
        System.out.print("\033[32mSeleccione el horario: ");
        horario = teclado.nextInt();
        for (int i = 0; i<60; i++) {
            if (tiquetes[dia-1][horario-8][i] == 0) {
                System.out.println("Asiento " + (i+1) + " disponible");
            } else {
                System.out.println("Asiento " + (i+1) + " vendido");
            }
        }
    }
    
    public static void CierreCaja() {
        System.out.println("El total vendido es: " + ventaTotal);
    }
    
    private static void GuardarADisco() {
        try {
            FileWriter escritor = new FileWriter(new File("datos.txt"));
            BufferedWriter buffer = new BufferedWriter(escritor);
            PrintWriter impresor = new PrintWriter(buffer);
            
            for (int x = 0; x < 7; x++) {
                for (int y = 0; y < 12; y++) {
                    for (int z = 0; z < 60; z++) {
                        impresor.write("" + tiquetes[x][y][z]);
                        impresor.println();
                    }
                }
            }
            impresor.close();
            buffer.close();
            
        } catch (IOException e) {
            
        }
    }
    
    private static void LeerDeDisco() {
        try {
            FileInputStream archivo = new FileInputStream("datos.txt");
            DataInputStream entrada = new DataInputStream(archivo);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            String strLinea;
            int x = 0;
            int y = 0;
            int z = 0;
            while ((strLinea = buffer.readLine()) != null) {
                if (strLinea.equals("1")) {
                    System.out.println(x);
                    System.out.println(y);
                    System.out.println(z);
                }
                tiquetes[x][y][z] = Integer.parseInt(strLinea);
                x++;
                if (x == 8) {
                    x = 0;
                    y++;
                }
                if (y == 13) {
                    y = 0;
                    z++;
                }
            }
            entrada.close();
        } catch(Exception e) {
            System.err.println("Se presentó un error: " + e.getMessage());
        }
    }
}
