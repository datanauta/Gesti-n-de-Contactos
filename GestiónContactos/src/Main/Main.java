package Main;

import Controlador.ControladorContactos;
import Modelo.ContactoDAO;
import Vista.VistaContactos;

public class Main {
	
	public static void main(String[] args) {
		VistaContactos vista = new VistaContactos();
		ContactoDAO modelo = new ContactoDAO();
		ControladorContactos controlador = new ControladorContactos(vista,modelo);
		
		vista.setVisible(true);
	}
}
