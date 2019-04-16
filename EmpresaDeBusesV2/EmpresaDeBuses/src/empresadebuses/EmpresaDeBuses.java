package empresadebuses;

import java.util.Scanner;

public class EmpresaDeBuses {

    public static void main(String[] args) {
        int opcion = 1;
        Scanner teclado = new Scanner(System.in);
        
        cDatos.Inicializar();
        
        while (opcion != 0) {
            System.out.println("\033[34m1. Vender");
            System.out.println("\033[34m2. Apartar");
            System.out.println("\033[34m3. Retirar");
            System.out.println("\033[34m4. Devolver");
            System.out.println("\033[34m5. Reporte de disponibles");
            System.out.println("\033[34m6. Reporte porcentajes");
            System.out.println("\033[34m7. Cierre de Caja");
            System.out.println("\033[34m0. Salir");
            opcion = teclado.nextInt();
            if (opcion == 1) {
                cDatos.Vender();
            } else if (opcion == 2) {
                cDatos.Apartar();
            } else if (opcion == 3) {
                cDatos.Retirar();
            } else if (opcion == 4) {
                cDatos.Devolver();
            } else if (opcion == 5) {
                cDatos.Reporte();
            } else if (opcion == 6) {
                cDatos.Porcentajes();
            } else if (opcion == 7) {
                cDatos.CierreCaja();                
            }
        }
    }
    
}
