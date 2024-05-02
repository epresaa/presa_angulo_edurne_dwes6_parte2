package birt.dwes.api.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name="Cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellidos")
	private String apellidos; 
	
	@Column(name="email")
	private String email;
	
	@Column(name="dni")
	private String dni;
	
	@Column(name="representante_ventas")
	private String representante_ventas;
	
	// Constructores
	public Cliente() {};
	
	public Cliente(int id, String nombre, String apellidos, String email, String dni, String repre) {
		this.id= id;
		this.nombre = nombre;
		this.apellidos= apellidos;
		this.email = email;
		this.dni = dni;
		this.representante_ventas = repre;
	};
	
	// Getters y Setters
	// Atributo id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	// Atributo nombre
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	// Atributo apellidos
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	// Atributo email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	// Atributo dni
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	// Atributo representante_ventas
	public String getRepre() {
		return representante_ventas;
	}
	public void setRepre(String repre) {
		this.representante_ventas = repre;
	}
		
}
