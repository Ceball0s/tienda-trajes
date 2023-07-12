package dulceria_gui;
import java.util.Scanner; // Importar la clase Scanner para leer datos desde la consola
import java.util.ArrayList;


public class VistaConsola extends Vista{

    // Atributos para el controlador y el scanner
    private Controlador controlador;
    private Scanner scanner;

    // Constructor
    public VistaConsola() {
        scanner = new Scanner(System.in); // Crear el objeto scanner
        controlador = new Controlador(new tienda(), this);
        mostrarMenu();
    }

    // Método para hacer visible la ventana (en este caso, la consola)
    public void setVisible(boolean visible) {
        if (visible) { // Si se quiere hacer visible la consola
            mostrarMenu(); // Llamar al método para mostrar el menú de opciones
        } else { // Si se quiere ocultar la consola
            System.exit(0); // Terminar el programa
        }
    }

    // Método para mostrar el menú de opciones
    public void mostrarMenu() {
        System.out.println("Bienvenido a la Trajería");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Agregar un Traje");
        System.out.println("2. Buscar un Traje");
        System.out.println("3. Actualizar un Traje");
        System.out.println("4. Eliminar un Traje");
        System.out.println("5. Salir");
        int opcion = scanner.nextInt(); // Leer la opción elegida por el usuario
        scanner.nextLine(); // Limpiar el buffer del scanner
        ejecutarOpcion(opcion); // Llamar al método para ejecutar la opción elegida
    }

    // Método para ejecutar la opción elegida por el usuario
    public void ejecutarOpcion(int opcion) {
        switch (opcion) { // Según la opción elegida
            case 1: // Si es agregar un Traje
                agregarTraje(); // Llamar al método para agregar un Traje
                break;
            case 2: // Si es buscar un Traje
                buscarTraje(); // Llamar al método para buscar un Traje
                break;
            case 3: // Si es actualizar un Traje
                actualizarTraje(); // Llamar al método para actualizar un Traje
                break;
            case 4: // Si es eliminar un Traje
                eliminarTraje(); // Llamar al método para eliminar un Traje
                break;
            case 5: // Si es salir
                setVisible(false); // Hacer invisible la consola
                break;
            default: // Si es una opción inválida
                mostrarMensaje("Opción inválida. Intente de nuevo."); // Mostrar un mensaje de error
                mostrarMenu(); // Mostrar de nuevo el menú de opciones
                break;
        }
    }

    // Método para agregar un Traje
    public void agregarTraje() {
        System.out.println("Ingrese el nombre del Traje:");
        String nombre = scanner.nextLine(); // Leer el nombre del Traje desde la consola
        System.out.println("Ingrese el pais del Traje:");
        String pais = scanner.nextLine(); // Leer el tipo del Traje desde la consola
        System.out.println("Ingrese el material del Traje:");
        String material = scanner.nextLine(); // Leer el tipo del Traje desde la consola
        System.out.println("Ingrese el precio del Traje:");
        String preciostring = scanner.nextLine(); // Leer el tipo del Traje desde la consola
        try {
            int precio = Integer.parseInt(preciostring);
            controlador.agregarTraje(nombre, pais,material,precio); // Llamar al método del controlador para agregar el Traje al modelo y a la vista
        } catch (NumberFormatException error) {
            mostrarMensaje("Error ingrese un numero valido");
        }
        
        mostrarMenu(); // Mostrar de nuevo el menú de opciones
    }

    // Método para buscar un Traje
    public void buscarTraje() {
        System.out.println("Ingrese el nombre del Traje a buscar:");
        String nombre = scanner.nextLine(); // Leer el nombre del Traje a buscar desde la consola
        controlador.buscarTraje(nombre); // Llamar al método del controlador para buscar el Traje por su nombre en el modelo y mostrarlo en la vista
        mostrarMenu(); // Mostrar de nuevo el menú de opciones

    }

    // Método para actualizar un Traje

    public void actualizarTraje() {
        System.out.println("Ingrese el nombre del Traje a actualizar:"); 
        String nombre_viejo = scanner.nextLine(); // Leer el nombre del Traje a actualizar desde la consola 
        System.out.println("Ingrese el nuevo nombre del Traje:");
        String nombre = scanner.nextLine(); // Leer el nombre del Traje desde la consola
        System.out.println("Ingrese el nuevo pais del Traje:");
        String pais = scanner.nextLine(); // Leer el tipo del Traje desde la consola
        System.out.println("Ingrese el nuevo material del Traje:");
        String material = scanner.nextLine(); // Leer el tipo del Traje desde la consola
        System.out.println("Ingrese el nuevo precio del Traje:");
        String preciostring = scanner.nextLine(); // Leer el tipo del Traje desde la consola
        try {
            int precio = Integer.parseInt(preciostring);
            controlador.actualizarTraje(nombre_viejo,nombre, pais,material,precio); // Llamar al método del controlador para agregar el Traje al modelo y a la vista
        } catch (NumberFormatException error) {
            mostrarMensaje("Error ingrese un numero valido");
        }
        
        mostrarMenu(); // Mostrar de nuevo el menú de opciones 
    }

    // Método para eliminar un Traje 
    public void eliminarTraje() { 
        System.out.println("Ingrese el nombre del Traje a eliminar:"); 
        String nombre = scanner.nextLine(); // Leer el nombre del Traje a eliminar desde la consola 
        if (controlador.eliminarTraje(nombre) ) { // Si se eliminó el Traje 
            mostrarMensaje("Traje eliminado con éxito."); // Mostrar un mensaje de confirmación 
        } else { // Si no se eliminó el Traje 
            mostrarMensaje("No se encontró ningún Traje con ese nombre."); // Mostrar un mensaje de error 
        } mostrarMenu(); // Mostrar de nuevo el menú de opciones 
    }

    // Método para actualizar la lista de Trajes con los datos del modelo 
    public void actualizarLista(ArrayList<Traje> listaTrajes) { 
        System.out.println("Lista de Trajes:"); 
        for (Traje Traje : listaTrajes) { // Recorrer la lista de Trajes 
           mostrarTraje(Traje);
        } 
    }

    // Método para mostrar los datos de un Traje en los campos de texto 
    public void mostrarTraje(Traje Traje) { 
        System.out.println("Datos del Traje:"); 
        System.out.println("Nombre: " + Traje.getNombre()); // Mostrar el nombre del Traje 
        System.out.println("Pais: " + Traje.getPaisFabricacion()); // Mostrar el tipo del Traje
        System.out.println("material: " + Traje.getMaterial()); // Mostrar el tipo del Traje
        System.out.println("precio: " + Traje.getPrecio()); // Mostrar el tipo del Traje

    }

    // Método para mostrar un mensaje en la consola public 
    public void mostrarMensaje(String mensaje) { 
        System.out.println(mensaje); // Mostrar el mensaje en la consola 
    } 
}
