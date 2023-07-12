package tienda;
import java.util.ArrayList;
public abstract class Vista {

    // Atributo para el controlador
    protected Controlador controlador;

    // Método para asignar el controlador a la vista
    public void setControlador(Controlador controlador) {
        this.controlador = controlador; // Asignar el controlador a la vista
    }

    // Método abstracto para hacer visible la ventana
    public abstract void setVisible(boolean visible);


    // Método abstracto para actualizar la lista de Trajes con los datos del modelo
    public abstract void actualizarLista(ArrayList<Traje> listaTrajes);

    // Método abstracto para mostrar los datos de un Traje en los campos de texto
    public abstract void mostrarTraje(Traje Traje);

    // Método abstracto para mostrar un mensaje en la consola o en la ventana
    public abstract void mostrarMensaje(String mensaje);
}
