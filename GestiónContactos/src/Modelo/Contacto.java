package Modelo;

public class Contacto {
	
	private String nombre;
	private String telefono;
	private String email;
	
	public Contacto(String nombre, String telefono, String email) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}
	
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) { this.nombre = nombre;}
	public String getTelefono() {return telefono;}
	public void setTelefono() {this.telefono = telefono;}
	public String getEmail() {return email;}
	public void setEmail() {this.email = email;}
}
