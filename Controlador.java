package dulceria_gui;

// Clase Controlador
public class Controlador {

    // Atributos para el modelo y la vista
    private tienda modelo;
    private Vista vista;

    // Constructor
    public Controlador(tienda modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setControlador(this); // Asignar el controlador a la vista
    }



    // Método para inicializar la vista
    public void iniciarVista() {
        vista.setVisible(true); // Hacer visible la ventana
        vista.actualizarLista(modelo.get_listaTrajes()); // Actualizar la lista de Trajes con los datos del modelo
    }

    // Método para agregar un Traje al modelo y a la vista
    public void agregarTraje(String nombre,String pais,String material,int precio) {
        modelo.agregarTraje(new Traje(nombre,pais,material,precio)); // Llamar al método del modelo para agregar el Traje a la lista
        vista.actualizarLista(modelo.get_listaTrajes()); // Llamar al método de la vista para actualizar la lista de Trajes con los datos del modelo
        vista.mostrarMensaje("Traje agregado con éxito."); // Mostrar un mensaje de confirmación en la vista
    }

    // Método para buscar un Traje por su nombre en el modelo y mostrarlo en la vista
    public void buscarTraje(String nombre) {
        Traje Traje = modelo.buscarTraje(nombre); // Llamar al método del modelo para buscar el Traje por su nombre
        if (Traje != null) { // Si se encontró el Traje
            vista.mostrarTraje(Traje); // Llamar al método de la vista para mostrar los datos del Traje en los campos de texto
            vista.mostrarMensaje("Traje encontrado."); // Mostrar un mensaje de confirmación en la vista

        } else { // Si no se encontró el Traje
            vista.mostrarMensaje("No se encontró ningún Traje con ese nombre."); // Mostrar un mensaje de error en la vista
        }
    }

    // Método para actualizar un Traje del modelo y de la vista
    public void actualizarTraje(String nombre_viejo,String nombre, String pais,String material,int precio) {
        //Traje Traje = modelo.buscarTraje(nombre_viejo); // Llamar al método del modelo para buscar el Traje por su nombre
        //if (Traje != null) { // Si se encontró el Traje
        //Traje Traje_en_la_lista = (Traje) Traje; // Hacer un casting a Traje
        Traje trajeNuevo = new Traje(nombre, pais, material, precio);
        //Traje_en_la_lista.setNombre(nombre); // Actualizar el nombre del Traje
        //Traje_en_la_lista.setPaisFabricacion(pais); // Actualizar la categoria
        //Traje_en_la_lista.setMaterial(material);// Actualizar la categoria
        //Traje_en_la_lista.setPrecio(precio); // Actualizar la categoria
        modelo.actualizarTraje(nombre_viejo, trajeNuevo);
        vista.actualizarLista(modelo.get_listaTrajes()); // Llamar al método de la vista para actualizar la lista de Trajes con los datos del modelo
        vista.mostrarMensaje("Traje actualizado con éxito."); // Mostrar un mensaje de confirmación en la vista
        //} else { // Si no se encontró el Traje
        //    vista.mostrarMensaje("No se encontró ningún Traje con ese nombre."); // Mostrar un mensaje de error en la vista
        //}
    }
    // Método para actualizar un Traje del modelo y de la vista
    
    // Método para mostrar los datos de un Traje en la vista
    public void mostrarTraje(String nombre) {
        Traje Traje = modelo.buscarTraje(nombre); // Llamar al método del modelo para buscar el Traje por su nombre
        vista.mostrarTraje(Traje); // Llamar al método de la vista para mostrar los datos del Traje en los campos de texto
    }
    // Método para eliminar un Traje de la lista
    public boolean eliminarTraje(String nombre) {
        boolean resultado =  modelo.eliminarTraje(nombre); // Buscar el Traje por su nombre
        vista.actualizarLista(modelo.get_listaTrajes());
        return resultado;
    }
}
