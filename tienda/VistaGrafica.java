package tienda;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList; 
import javax.swing.DefaultListModel;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ListCellRenderer;



import java.util.ArrayList;

public class VistaGrafica extends Vista{
    private JList<Traje> listaTrajes;
    private DefaultListModel<Traje> modelo; 
    public JPanel panelBprincipales;
    public JPanel panelBotones;

    public JPanel Panel_crearTraje;
    public JPanel panel_lista_Traje;

    // Atributos para los elementos gráficos
    private JTextField txtNombre;
    private JTextField txtTipo;

    private JFrame frame;

    //CrearMesas manejoM = new CrearMesas();

    JButton boton_crearGato = new JButton();
    JButton botonVend = new JButton();
    JButton usuarios  = new JButton();
    JButton boton_crearPerro = new JButton();

    // Atributo para el controlador
    private Controlador controlador;



    public VistaGrafica(){  //Creamos el constructor y dentro de este creamos el JFrame
        frame = new JFrame(); // Crear el objeto JFrame
        
        
        // Inicializar los demás componentes gráficos del frame
        frame.setTitle("tienda trajes");
        frame.setSize(700, 450);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);  


        frame.setVisible(true); //Hacemos visible la ventana
        iniciarComponentes();

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        // Crear una instancia del controlador y pasarle el modelo y la vista
        controlador = new Controlador(new tienda(), this);

        // Llamar al método del controlador para inicializar la vista
        controlador.iniciarVista();
    }    

//============================================================================
    private void iniciarComponentes(){
        listaTrajes = new JList<>(new DefaultListModel<>());
        modelo = (DefaultListModel<Traje>) listaTrajes.getModel(); // Asigna el modelo al atributo de la clase
        iniciarPaneles();
        iniciarBotones();
        //crearPanelPerro();
        Panel_crearTraje();
        crearPanelLista();
    }
//============================================================================
    // Método para iniciar los paneles
    private void iniciarPaneles(){
        panelBprincipales = new JPanel();
        panelBprincipales.setLayout(null);//desactivamos el layout por defecto que esta centrado
        panelBprincipales.setBackground(Color.WHITE);
        // establecemos el color del panel
        panelBprincipales.setSize(300, 600);
        frame.getContentPane().add(panelBprincipales);//agregamos el panel al frame

        //panel donde se agregan los botones principales
        panelBotones = new JPanel();
        panelBotones.setLayout(null);
        panelBotones.setSize(150, 600);
        panelBotones.setBackground(new Color(30, 136, 229));

        panelBprincipales.add(panelBotones);
    
    }

    // Método para iniciar los botones
    private void iniciarBotones(){
        boton_crearPerro.setText("Crear Trajes");
        boton_crearPerro.setBounds(20, 20, 100, 30);
        boton_crearPerro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            //llamamos el metodo que creamos para el panel
                mostrar_crear_Trajes();
            }
        });
        panelBotones.add(boton_crearPerro);

    
        
        botonVend.setText("Lista Trajees");
        botonVend.setBounds(20, 100, 100, 30);
        botonVend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MostrarLista();
            }
        });
        panelBotones.add(botonVend);

        
        
        usuarios .setText("Proximamente 2");
        usuarios .setBounds(20, 140, 100, 30);
        //panelBotones.add(usuarios);

        
    //creamos el boton cerrar y configuramos su funcionamiento
        JButton botonCe = new JButton();
        botonCe.setText("Cerrar");
        botonCe.setBounds(20, 180, 100, 30);

    
        botonCe.addActionListener(new ActionListener() {  //agregamos el addAcionlistener al boton para que al precionarlo funcione

            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(frame, "desea salir de la APP", "SALIR", JOptionPane.YES_NO_OPTION); // Usar el frame como componente padre
                if(respuesta == JOptionPane.YES_OPTION){ //creamos el bucle que se encarga de evaluar la desicion de usiario
                    System.exit(0);
                }
                
            }
            
        });

        panelBotones.add(botonCe);

    }


//============================================================================


    public void Panel_crearTraje() {
        // Crear un panel
        Panel_crearTraje = new JPanel();

        // Crear los componentes del panel
        JLabel titulo = new JLabel("Agregar Traje");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel nombreLabel = new JLabel("Nombre:");
        JTextField nombreField = new JTextField(10);
        JLabel paisLabel = new JLabel("pais:");
        JTextField paisField = new JTextField(10);
        JLabel materialLabel = new JLabel("material:");
        JTextField materialField = new JTextField(10);
        JLabel precioLabel = new JLabel("precio:");
        JTextField precioField = new JTextField(10);

        // Agregar un ActionListener al botón para mostrar el valor seleccionado

        // Agregar los componentes al JFrame
        JButton crearButton = new JButton("Crear");

        // Agregar un listener al botón crear
        crearButton.addActionListener(e -> {
            // Obtener los datos del panel
            String nombre = nombreField.getText();
            String pais =  paisField.getText();
            String material =  materialField.getText();
            
            try {
                int precio =  Integer.parseInt(precioField.getText());
                controlador.agregarTraje(nombre,pais,material,precio);
            } catch (NumberFormatException error) {
                mostrarMensaje("Error ingrese un numero valido");
            }
            
            
            
            // Llamar al método del controlador para agregar un gato al modelo y a la vista
            //controlador.agregarTraje(nombre,pais,material,precio);

            // Limpiar los campos del panel
            nombreField.setText("");
            paisField.setText("");
            materialField.setText("");
            precioField.setText("");
        });

        // Agregar los componentes al panel
        Panel_crearTraje.add(titulo);
        Panel_crearTraje.add(new JLabel(""));
        Panel_crearTraje.add(nombreLabel);
        Panel_crearTraje.add(nombreField);
        Panel_crearTraje.add(paisLabel);
        Panel_crearTraje.add(paisField);
        Panel_crearTraje.add(materialLabel);
        Panel_crearTraje.add(materialField);
        Panel_crearTraje.add(precioLabel);
        Panel_crearTraje.add(precioField);

        Panel_crearTraje.add(new JLabel(""));
        Panel_crearTraje.add(crearButton);

        // Establecer el tamaño y el layout del panel
        Panel_crearTraje.setLayout(new GridLayout(7, 1));
        Panel_crearTraje.setBackground(Color.WHITE);
        Panel_crearTraje.setSize(300, 300);
        Panel_crearTraje.setVisible(true);
        Panel_crearTraje.setBounds(200, 0, 300, 300);

        panelBprincipales.add(Panel_crearTraje);

    }

    public void crearPanelLista() {
        // Inicializar el JList con un modelo de lista que contenga los Trajees
        //listaTrajes = new JList<>(new DefaultListModel<>());
        // Agregar un renderizador personalizado al JList para que muestre el nombre y el tipo de Traje
        listaTrajes.setCellRenderer(new TrajeRenderer());

        // Crear un botón de modificar
        JButton botonModificar = new JButton("Modificar");

        // Agregar un escuchador de eventos al botón para que se ejecute una acción cuando se haga clic en él
        botonModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el objeto seleccionado en el JList y verificar que no sea nulo
                Traje Traje = listaTrajes.getSelectedValue();
                if (Traje != null) {
                    // Crear una ventana emergente con campos de texto para ingresar los nuevos datos del objeto
                    JTextField nombreField = new JTextField(Traje.getNombre());
                    // Crear el array con las opciones
                    JTextField paisField = new JTextField(Traje.getPaisFabricacion());
                    JTextField materialField = new JTextField(Traje.getMaterial());
                    JTextField precioField = new JTextField(Integer.toString(Traje.getPrecio()));
                    Object[] campos = {
                            "Nombre:", nombreField,
                            "Pais:", paisField,
                            "Material:",materialField,
                            "Precio:",precioField
                    };
                    int opcion = JOptionPane.showConfirmDialog(null, campos, "Modificar Traje", JOptionPane.OK_CANCEL_OPTION);
                    // Si se presiona el botón OK, asignar los nuevos datos al objeto y actualizar el modelo de la lista
                    if (opcion == JOptionPane.OK_OPTION) {
                        try {
                        int precio =  Integer.parseInt(precioField.getText());
                        controlador.actualizarTraje(Traje.getNombre(),nombreField.getText(),paisField.getText(),materialField.getText(),precio);
                    } catch (NumberFormatException error) {
                        mostrarMensaje("Error ingrese un numero valido");
                    }
                        
                    }
                
                }
            }
        });

        // Crear un botón con un texto que indique la acción de eliminar
        JButton botonEliminar = new JButton("Eliminar");

        // Agregar un escuchador de eventos al botón para que se ejecute una acción cuando se haga clic en él
        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el objeto seleccionado en el JList y verificar que no sea nulo
                Traje Traje = listaTrajes.getSelectedValue();
                if (Traje != null) {
                    // Llamar al método del controlador para eliminar el Traje del modelo y de la vista
                    if(controlador.eliminarTraje(Traje.getNombre())){
                        mostrarMensaje("elemento eliminado correctamente");
                    }else{
                        mostrarMensaje("no se pudo borrar");
                    }
                }
            }
        });

        // Crear una caja de texto con un texto vacío
        JTextField campoBuscar = new JTextField();
        campoBuscar.setSize(100, 300);
        campoBuscar.setPreferredSize(new Dimension(80, 50));
        // Crear un botón con un texto que indique la acción de buscar
        JButton botonBuscar = new JButton("Buscar");
        botonBuscar.setPreferredSize(new Dimension(80, 50));
        // Agregar un escuchador de eventos al botón para que se ejecute una acción cuando se haga clic en él
        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el texto de la caja de texto y verificar que no sea vacío
                String nombre = campoBuscar.getText();
                if (!nombre.isEmpty()) {
                    // Llamar al método del controlador para buscar el Traje por su nombre y seleccionarlo en la lista
                    controlador.buscarTraje(nombre);
                }
            }
        });
        
        
        // Agregar la caja de texto y el botón al panel
        // Crear un GridLayout con dos filas y una columna




        // Crear un panel principal y agregar el JList al panel
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new FlowLayout());
        panelPrincipal.setSize(100, 100);
        panelPrincipal.setVisible(true);
        
        panelPrincipal.add(campoBuscar);
        panelPrincipal.add(botonBuscar);

        JPanel panel_eliminar_modificar = new JPanel();
        panel_eliminar_modificar.setLayout(new BorderLayout());
        // Agregar el panel al GridLayout
        // Agregar el panel secundario y la lista al panel principal
        
        panel_eliminar_modificar.add(botonEliminar,BorderLayout.WEST);
        panel_eliminar_modificar.add(botonModificar,BorderLayout.EAST);

        
        panel_lista_Traje = new JPanel(); // Asignarle un objeto JPanel a la variable
        panel_lista_Traje.setLayout(new BorderLayout());

        // Configurar el tamaño y la ubicación del panel
        panel_lista_Traje.setSize(450, 400);
        //panel_lista_Traje.setPreferredSize(new Dimension(500, 500));
        panel_lista_Traje.setBounds(200, 0, 450, 400);
        panel_lista_Traje.setVisible(false);
        // Agregar el panel al JFrame y hacerlo visible
        
        panel_lista_Traje.add(panelPrincipal,BorderLayout.NORTH);
        panel_lista_Traje.add(listaTrajes,BorderLayout.CENTER);
        panel_lista_Traje.add(panel_eliminar_modificar,BorderLayout.SOUTH);

        panelBprincipales.add(panel_lista_Traje);  
    }

    private class TrajeRenderer implements ListCellRenderer<Traje> {

        @Override
        public Component getListCellRendererComponent(JList<? extends Traje> list, Traje value, int index,boolean isSelected, boolean cellHasFocus) {
            // Crear un JLabel con el nombre y el tipo de Traje
            JLabel label = new JLabel(value.getNombre() + " (" + value.getClass().getSimpleName() + ")");
            label.setOpaque(true);

            // Cambiar el color del fondo y del texto según si el elemento está seleccionado o no
            if (isSelected) {
                label.setBackground(list.getSelectionBackground());
                label.setForeground(list.getSelectionForeground());
            } else {
                label.setBackground(list.getBackground());
                label.setForeground(list.getForeground());
            }

            return label;
        }
    }

    // Método para asignar el controlador a la vista
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    // Método para mostrar un mensaje en una ventana emergente
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(frame, mensaje); // Usar el frame como componente padre
    }


    // Método para mostrar los datos de un Traje en los campos de texto
    public void mostrarTraje(Traje Traje) {
        if (Traje != null) { // Si el Traje existe
            Object[] campos = {
                    "Nombre:", Traje.getNombre(),
                    "Material:", Traje.getMaterial(),
                    "pais:", Traje.getPaisFabricacion(),
                    "precio:", Traje.getPrecio()
            };
            int opcion = JOptionPane.showConfirmDialog(null, campos, "Modificar Traje", JOptionPane.OK_CANCEL_OPTION);
            // Si se presiona el botón OK, asignar los nuevos datos al objeto y actualizar el modelo de la lista
        } else { // Si el Traje no existe
            mostrarMensaje("No se encontró el Traje");
        }
    }

    // Método para limpiar los campos de texto
    public void limpiarCampos() {
        txtNombre.setText("");
        txtTipo.setText("");
    }


    public void actualizarLista(ArrayList<Traje> lista) {
        modelo.clear(); // Limpiar el modelo de la lista
        for (Traje Traje : lista) { // Recorrer la lista de Trajees del modelo
            modelo.addElement(Traje); // Agregar cada Traje al modelo de la lista
        }
        listaTrajes.repaint(); // Repintar la lista para mostrar los cambios
    }
     private void apagarTodo(){
        Panel_crearTraje.setVisible(false);

        panel_lista_Traje.setVisible(false);
    }

    // Método para mostrar el panel para crear Trajes
    private void mostrar_crear_Trajes(){
        apagarTodo();
        Panel_crearTraje.setVisible(true);
        frame.revalidate(); // Usar el frame para revalidar
        frame.repaint(); // Usar el frame para repintar
    }

    // Método para mostrar el panel con la lista de Trajes
    private void MostrarLista(){
        apagarTodo();
        panel_lista_Traje.setVisible(true);
        frame.revalidate(); // Usar el frame para revalidar
        frame.repaint(); // Usar el frame para repintar
    }
    
    // Método para hacer visible la ventana
    @Override
    public void setVisible(boolean visible) {
        frame.setVisible(visible); // Llamar al método setVisible del frame
    }
}

