package empresadebuses;

import java.util.Scanner;

public class EmpresaDeBuses {

    public static void main(String[] args) {
        int opcion = 1;
        Scanner teclado = new Scanner(System.in);
        
        cDatos.Inicializar();
        
        while (opcion != 0) {
            System.out.println("\033[34m1. Vender");
            System.out.println("\033[34m2. Devolver");
            System.out.println("\033[34m3. Reporte");
            System.out.println("\033[34m4. Cierre de Caja");
            System.out.println("\033[34m0. Salir");
            opcion = teclado.nextInt();
            if (opcion == 1) {
                cDatos.Vender();
            } else if (opcion == 2) {
                cDatos.Devolver();
            } else if (opcion == 3) {
                cDatos.Reporte();
            } else if (opcion == 4) {
                cDatos.CierreCaja();
            } else if (opcion == 0) {
                System.out.println("\033[31mSaliendo del programa...");
            } else {
                System.out.println("\033[31mLa opción seleccionada no existe");
            }
        }
    }
    
}
