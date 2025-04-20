package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContactoDAO {
	
	private Connection connection;
	

	public ContactoDAO() {
		try {
			this.connection = DriverManager.getConnection("jdbc:sqlite:contactos.db");
			crearTablaSiNoExiste();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void crearTablaSiNoExiste() throws SQLException{
		String sql = """
			CREATE TABLE IF NOT EXISTS contactos(
			id INTEGER PRIMARY KEY AUTOINCREMENT,
			nombre TEXT NOT NULL,
			telefono TEXT NOT NULL,
			email TEXT
			);	
			""";
		
		Statement stmt = connection.createStatement();
		stmt.execute(sql);
		stmt.close();
	}
	
	public void agregarContactos(Contacto contacto) {
		String sql = "INSERT INTO contactos (nombre,telefono,email) VALUES (?,?,?)";
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, contacto.getNombre());
			stmt.setString(2, contacto.getTelefono());
			stmt.setString(3,  contacto.getEmail());
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Contacto> obtenerContactos(){
		List<Contacto> contactos = new ArrayList<>();
		String sql = "SELECT * FROM contactos";
		try(Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql)) {
			while(rs.next()) {
				String nombre = rs.getString("nombre");
				String telefono = rs.getString("telefono");
				String email = rs.getString("email");
				contactos.add(new Contacto(nombre,telefono,email));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return contactos;
	}
	
	public void eliminarContactos(String nombre) {
		String sql = "DELETE FROM contactos WHERE nombre = ?";
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, nombre);
			stmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
