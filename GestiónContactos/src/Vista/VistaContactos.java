package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Modelo.Contacto;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class VistaContactos extends JFrame {
	
	private JTable tablaContactos;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnLimpiar;
	private DefaultTableModel modeloTabla;
	
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	
	public VistaContactos() {
		setTitle("Gestión de Contactos");
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Teléfono");
		modeloTabla.addColumn("Email");
		
		tablaContactos = new JTable(modeloTabla);
		JScrollPane scrollPane = new JScrollPane(tablaContactos);
		
		
		
		JPanel panelEntrada = new JPanel(new GridLayout(2,3));
		txtNombre = new JTextField();
		txtTelefono = new JTextField();
		txtEmail = new JTextField();
		
		txtNombre.setBackground(Color.WHITE);
		txtTelefono.setBackground(Color.WHITE);
		txtEmail.setBackground(Color.WHITE);
		
		panelEntrada.setBackground(Color.ORANGE);
		
		panelEntrada.add(new JLabel("Nombre:"));
		panelEntrada.add(new JLabel("Teléfono:"));
		panelEntrada.add(new JLabel("Email:"));
		
		panelEntrada.add(txtNombre);
		panelEntrada.add(txtTelefono);
		panelEntrada.add(txtEmail);
		
		JPanel panelBotones = new JPanel();
		btnAgregar = new JButton("Agregar");
		btnEliminar = new JButton("Eliminar");
		btnLimpiar = new JButton("Limpiar");
		panelBotones.add(btnAgregar);
		panelBotones.add(btnEliminar);
		panelBotones.add(btnLimpiar);
		
		btnAgregar.setBackground(Color.green);
		btnEliminar.setBackground(Color.red);
		btnLimpiar.setBackground(Color.cyan);
		
		add(panelEntrada,BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(panelBotones,BorderLayout.SOUTH);
	}
	
	public String getNombre() {
		return txtNombre.getText();
	}
	
	public String getTelefono() {
		return txtTelefono.getText();
	}
	
	public String getEmail(){
		return txtEmail.getText();
	}
	
	public void mostrarContactos(List<Contacto>contactos) {
		modeloTabla.setRowCount(0);
		for(Contacto contacto: contactos) {
			modeloTabla.addRow(new Object[] {
					contacto.getNombre(),
					contacto.getTelefono(),
					contacto.getEmail()
			});
		}
	}
	
	public void agregarListener(ActionListener listener) {
		btnAgregar.addActionListener(listener);
	}
	
	public void eliminarListener(ActionListener listener) {
		btnEliminar.addActionListener(listener);
	}
	
	public void limpiarListener(ActionListener listener) {
		btnLimpiar.addActionListener(listener);
	}
	
	public String obtenerNombreContactoSeleccionado() {
		int filaSeleccionada = tablaContactos.getSelectedRow();
		if(filaSeleccionada != -1) {
			return (String) modeloTabla.getValueAt(filaSeleccionada,0);
		}
		return null;
	}
	
	public void limpiarCampos() {
		txtNombre.setText("");
		txtTelefono.setText("");
		txtEmail.setText("");
	}
}