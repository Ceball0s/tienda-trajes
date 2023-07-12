
//import dulceria_gui.Dulce;
//import dulceria_gui.Dulceria;
//import dulceria_gui.controlador;
import java.util.Scanner;


import tienda.Controlador;
import tienda.VistaConsola;
import tienda.VistaGrafica;
import tienda.tienda;
//miguel angel ceballos 2259619-3743
//Nicolás Gutiérrez Ramírez 2259515 
//Camilo Valencia Romero 2259497 

public class App {
    public static void main(String[] args) throws Exception {
        //ventana ventanaP = new ventana();
        //VistaConsola Vista_controlador = new VistaConsola();
        //Vista_controlador.setControlador(new Controlador(new Dulceria(), Vista_controlador));
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige una opción:"); 
        System.out.println("1. Vista Grafica"); 
        System.out.println("2. Vista Consola");
        System.out.println(":");
        int opcion = sc.nextInt();

        if (opcion == 1) { 
            VistaGrafica vista_Grafica = new VistaGrafica();
        } else if (opcion == 2) { 
            VistaConsola vistaConsola = new VistaConsola();

        } else { // Si el usuario elige una opción inválida, mostramos un mensaje de error 
            System.out.println("Opción inválida"); 
        }

        // Cerramos el objeto Scanner sc.close(); }
    }
}
