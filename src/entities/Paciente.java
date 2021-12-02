package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //entidad de la BD
public class Paciente {
	private int idpaciente;
	private String nombre;
	private String apellidopaterno;
	private String apellidomaterno;
	private int habitacion;
	private String estatus;
	
	public Paciente() {
		super();
	}

	//Constructor
	public Paciente(int idpaciente, String nombre, String apellidopaterno, String apellidomaterno, int habitacion,
			String estatus) {
		super();
		this.idpaciente = idpaciente;
		this.nombre = nombre;
		this.apellidopaterno = apellidopaterno;
		this.apellidomaterno = apellidomaterno;
		this.habitacion = habitacion;
		this.estatus = estatus;
	}
	
	//encapsulamiento de las variables
	@Id  //Clave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Valor generado por la BD
	public int getIdpaciente() {
		return idpaciente;
	}
	public void setIdpaciente(int idpaciente) {
		this.idpaciente = idpaciente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidopaterno() {
		return apellidopaterno;
	}
	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}
	public String getApellidomaterno() {
		return apellidomaterno;
	}
	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}
	public int getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(int habitacion) {
		this.habitacion = habitacion;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
}
