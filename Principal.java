import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import tienda.Controlador;
import tienda.VistaConsola;
import tienda.VistaGrafica;
import tienda.tienda;

public class Principal extends JFrame implements ActionListener {

    // Creamos dos botones
    JButton botonGrafica = new JButton("Grafica");
    JButton botonConsola = new JButton("Consola");
    // Constructor de la ventana
    public Principal() {
        // Establecemos el título, el tamaño y el layout de la ventana
        setTitle("Ventana con botones");
        setSize(300, 100);
        setLayout(new FlowLayout());

        // Añadimos los botones a la ventana
        add(botonGrafica);
        add(botonConsola);

        // Añadimos el evento de acción a los botones
        botonGrafica.addActionListener(this);
        botonConsola.addActionListener(this);

        // Hacemos visible la ventana
        setVisible(true);
    }

    // Método que se ejecuta cuando se presiona un botón
    public void actionPerformed(ActionEvent e) {
        // Obtenemos el botón que se presionó
        JButton boton = (JButton) e.getSource();
        // Cerramos la ventana
        dispose();
        // Comparamos el texto del botón para saber qué función usar
        if (boton.getText().equals("Grafica")) {
            // Llamamos a la función sumar con dos números de ejemplo
            VistaGrafica vista_Grafica = new VistaGrafica();
        } else if (boton.getText().equals("Consola")) {
            // Llamamos a la función restar con dos números de ejemplo
            VistaConsola vistaConsola = new VistaConsola();
        }

    }

    // Método principal que crea una instancia de la ventana
    public static void main(String[] args) {
        Principal ventana = new Principal();
    }
}
