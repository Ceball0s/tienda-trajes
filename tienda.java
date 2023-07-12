package dulceria_gui;

import java.util.ArrayList; // Importar la clase ArrayList para manejar listas dinámicas
import java.util.Vector;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class tienda {

   // Atributo para almacenar los Trajees en una lista
   private ArrayList<Traje> listaTrajes;

   // Constructor
   public tienda() {
        listaTrajes = leerTrajes("trajes.bin");
       //listaTrajes = new ArrayList<>(); // Inicializar la lista vacía
   }

   // Método para agregar un Traje a la lista
   public boolean agregarTraje(Traje Traje) {
        Traje Traje_Traje_no_repetido = buscarTraje(Traje.getNombre()); // Buscar el Traje por su nombre
        if (Traje_Traje_no_repetido != null) { // Si se encontró el Traje
            return false;//no se agrego el Traje
        } else { // Si no se encontró el Traje
            listaTrajes.add(Traje); // Añadir el Traje al final de la lista
            guardarTrajes(listaTrajes, "trajes.bin");
            return true;
        }
        
       
   }
    
    // Método para buscar un Traje por su nombre en la lista
    public Traje buscarTraje(String nombre) {
        listaTrajes = leerTrajes("trajes.bin");
       for (Traje Traje : listaTrajes) { // Recorrer la lista usando un bucle for-each
           if (Traje.getNombre().equals(nombre)) { // Comparar el nombre del Traje con el buscado
               return Traje;
            }
        }
        return null; // Si no se encuentra el Traje, devolver null
    }

    // Método para actualizar un Traje de la lista
    public void actualizarTraje(String nombre, Traje Traje_nuevo) {
        /*
        Traje traje = buscarTraje(nombre); // Buscar el Traje por su nombre
        Traje TrajeViejo = (Traje) traje; // Hacer un casting a Perro
        TrajeViejo = Traje_nuevo;
        */
        eliminarTraje(nombre);
        agregarTraje(Traje_nuevo);
        guardarTrajes(listaTrajes, "trajes.bin");
    }

    // Método para eliminar un Traje de la lista
    public boolean eliminarTraje(String nombre) {
        Traje traje = buscarTraje(nombre); // Buscar el Traje por su nombre
        if (traje != null) { // Si se encontró el Traje
            listaTrajes.remove(traje); // Eliminar el Traje de la lista
            guardarTrajes(listaTrajes, "trajes.bin");
            return true;
        } else { // Si no se encontró el Traje
            return false;
        }
        
    }
 

    public ArrayList<Traje> get_listaTrajes(){
        listaTrajes = leerTrajes("trajes.bin");
        return listaTrajes;
    }

    public static void guardarTrajes(ArrayList<Traje> trajes, String archivo) {
        try {
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(trajes);
            oos.close();
            fos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<Traje> leerTrajes(String archivo) {
        ArrayList<Traje> trajes = null;

        try {
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            trajes = (ArrayList<Traje>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception ex) {
            //ex.printStackTrace();  
            System.out.println("error leyendo el archivo");
        }
        if(trajes == null){
            return new ArrayList<>();
        }
        return trajes;
    }
    
}
