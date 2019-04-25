/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catarsisclinica;
import java.util.Arrays;
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
    private static cCrearArchivo archivo = new cCrearArchivo();
    
    public static void Inicializar() {
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 9; y++) {
                for (int z = 0; z < 3; z++) {
                    cita[x][y][z] = new cCita();
                }
                
            }
        }
    }
    
    //Crear citas
    public static void Asignar() {
        String nombre = "";
        String telefono = "";
        String cedula = "";
        String correo = "";
        String texto = "";
        
        System.out.println("1. Lunes"+"\t"+"2. Martes"+"\t"+"3. Miercoles"+"\t"+"4. Jueves"+"\t"+"5. Viernes"+"\t"+"6. Sabado"+"\t"+"7. Domingo" );
        System.out.println("Seleccione el dia del 1 al 7: ");
        dia = scan.nextInt();
        System.out.println("1. 8-9AM"+"\t"+"2. 9-10AM"+"\t"+"3. 10-11AM"+"\t"+"4. 11-12PM"+"\t"+"5. 12-1PM"+"\t"+"6. 1-2PM"+"\t"+"7. 2-3PM"+"\t"+"8. 3-4PM"+"\t"+"9. 4-5PM" );
        System.out.println("Seleccione la hora del 1 al 9: ");
        hora = scan.nextInt();
        System.out.println("1. Elliot Castro"+"\t"+"2. Juan Perez"+"\t"+"3. Daniela Jimenez");
        System.out.println("Seleccione el Psicologo del 1 al 3: ");
        psicologo = scan.nextInt();
        
        //Datos con validaciones
        while (nombre.equals("")){
            System.out.println("Digite su nombre: ");
            nombre = scan.next();
            if (!nombre.matches("^[A-Za-z ]*$")){
            System.out.println("Solo puede digitar Letras y espacios");
            nombre = "";
            }
        } 
        
        while (telefono.equals("")){
            System.out.println("Digite su numero de telefono: ");
            telefono = scan.next();
            if (!telefono.matches("[0-9]*")){
            System.out.println("Solo puede digitar numeros");
            telefono = "";
            }
        } 
        
        while (cedula.equals("")){
            System.out.println("Digite su numero de cedula utlizando solo numeros:  ");
            cedula = scan.next();
            if (!cedula.matches("[0-9]*")){
            System.out.println("Solo puede digitar numeros");
            cedula = "";
            }
        } 
        
        while (correo.equals("")){
            System.out.println("Digite su correo electronico:  ");
            correo = scan.next();
            if (!correo.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" +
      "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$")){
            System.out.println("El formato debe ser xxxxxx@xxxxx.xxx");
            correo = "";
            }
        } 
        
             //asignar info de usaurio al arreglo   
        if (cita[dia-1][hora-1][psicologo-1].Estado==0) {
            cita[dia-1][hora-1][psicologo-1].Nombre = nombre;
            cita[dia-1][hora-1][psicologo-1].Telefono = telefono;
            cita[dia-1][hora-1][psicologo-1].Cedula = cedula;
            cita[dia-1][hora-1][psicologo-1].Correo = correo;
            cita[dia-1][hora-1][psicologo-1].Estado = 1;
            System.out.println("Su cita ha sido asignada!");
            //Guardar en archivo
            texto += dia;
            texto += "\t";
            texto += hora;
            texto += "\t";
            texto += psicologo;
            texto += "\t";
            texto += cedula;
            texto += "\t";
            texto += nombre;
            texto += "\t";
            texto += telefono;
            texto += "\t";
            texto += correo;
            texto += "\t";
            texto += "Asignada"; 
            texto += "\n";
            //Crear archivo con los datos
            archivo.crearArchivo(texto);
            
            //Cita no disponible
        } else if (cita[dia-1][hora-1][psicologo-1].Estado == 1){
            System.out.println("La cita solicitada no se encuentra disponible!");
        }
    }
    
    public static void Reporte(){
        System.out.println("Seleccione es dia que desea visualizar: ");
        dia = scan.nextInt();
        System.out.println("Seleccione la hora: ");
        hora = scan.nextInt();
        for (int i = 0; i<3; i++) {
            if (cita[dia-1][hora-1][i].Estado == 0){
                System.out.println("Cita " + (i+1) + " disponible");
            } else {
                System.out.println("Cita " + (i+1) + " no disponible");
            }
        }
    }
    
    public static void Expediente(){
        String padecimiento;
        String recomendaciones;
        String texto = "";
        
        System.out.println("1. Lunes"+"\t"+"2. Martes"+"\t"+"3. Miercoles"+"\t"+"4. Jueves"+"\t"+"5. Viernes"+"\t"+"6. Sabado"+"\t"+"7. Domingo" );
        System.out.println("Seleccione el dia del 1 al 7: ");
        dia = scan.nextInt();
        System.out.println("1. 8-9AM"+"\t"+"2. 9-10AM"+"\t"+"3. 10-11AM"+"\t"+"4. 11-12PM"+"\t"+"5. 12-1PM"+"\t"+"6. 1-2PM"+"\t"+"7. 2-3PM"+"\t"+"8. 3-4PM"+"\t"+"9. 4-5PM" );
        System.out.println("Seleccione la hora del 1 al 9: ");
        hora = scan.nextInt();
        System.out.println("1. Elliot Castro"+"\t"+"2. Juan Perez"+"\t"+"3. Daniela Jimenez");
        System.out.println("Seleccione el Psicologo del 1 al 3: ");
        psicologo = scan.nextInt();
        if (cita[dia-1][hora-1][psicologo-1].Estado == 1){
            System.out.println("Por favor indique el padecimiento encontrado: ");
            padecimiento = scan.next();
            System.out.println("Por favor indique las recomendaciones para el paciente: ");
            recomendaciones = scan.next();
            
            System.out.println("Se ha creado un nuevo expediente");
            cita[dia-1][hora-1][psicologo-1].Padecimiento = padecimiento;
            cita[dia-1][hora-1][psicologo-1].Recomendaciones = recomendaciones;
            
        } else if (cita[dia-1][hora-1][psicologo-1].Estado == 0){
            System.out.println("No cuenta con una cita, por favor asignar una cita desde el menu principal");
        }

    }
    
    public static void Buscar(){
        String Ced;
        
        System.out.println("Por favor digite el numero de cedula del expediente que desea visulizar: ");
        Ced = scan.next();
        
        System.out.println(Arrays.asList(cita));
        
        /*if (cita[dia-1][hora-1][psicologo-1].Estado == 1){
            System.out.println(Arrays.toString(cita));
        }else if (cita[dia-1][hora-1][psicologo-1].Estado == 0){
            System.out.println("No existe el expediente");
            
        }*/
    }
}
