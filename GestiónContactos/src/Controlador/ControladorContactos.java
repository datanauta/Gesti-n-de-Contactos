package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import Modelo.Contacto;
import Modelo.ContactoDAO;
import Vista.VistaContactos;

public class ControladorContactos {
    private VistaContactos vista;
    private ContactoDAO modelo;

    public ControladorContactos(VistaContactos vista, ContactoDAO modelo) {
        this.vista = vista;
        this.modelo = modelo;

        // Agregar los listeners
        vista.agregarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarContacto();
            }
        });

        vista.eliminarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarContacto();
            }
        });

        actualizarVista();
        
        vista.limpiarListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		vista.limpiarCampos();
        	}
        });
    }

    public void agregarContacto() {
        // Simulamos la creación de un nuevo contacto (puedes agregar un formulario de entrada)
        String nombre = vista.getNombre();
        String telefono = vista.getEmail();
        String email = vista.getEmail();
        if(!nombre.isEmpty() && !telefono.isEmpty() && !email.isEmpty()) {
        	Contacto contacto = new Contacto(nombre,telefono,email);
        	modelo.agregarContactos(contacto);
        	actualizarVista();
        } else {
        	JOptionPane.showMessageDialog(null,"Por favor, completa todos los campos");
        	JOptionPane.showMessageDialog(null, "");
        }
    }

    public void eliminarContacto() {
        String nombre = vista.obtenerNombreContactoSeleccionado();
        if (nombre != null) {
            modelo.eliminarContactos(nombre);
            actualizarVista();
            JOptionPane.showMessageDialog(null, "Contacto eliminado correctamente");
        }
    }

    public void actualizarVista() {
        List<Contacto> contactos = modelo.obtenerContactos();
        vista.mostrarContactos(contactos);
    }
}
 
	
