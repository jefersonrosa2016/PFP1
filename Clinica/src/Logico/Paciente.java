package Logico;

import java.util.ArrayList;
import java.util.Date;

public class Paciente {

	private String cedula;
	private String nombre;
	private String genero;
	private String apellidos;
	private Date fechadenacimiento;
	private String direccion;
	private String telefono;
	private HistoriaClinica historial;
	private ArrayList<Consulta> misConsultas;
	private String codigopaciente; 
	
	public Paciente(String cedula, String nombre, String genero, String direccion,
			String telefono,String codigoHistorial,String codigopaciente, String apellidos, Date fechadenacimiento) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.genero = genero;
		this.setFechadenacimiento(fechadenacimiento);
		this.direccion = direccion;
		this.telefono = telefono;
		this.historial = new HistoriaClinica(codigoHistorial);
		this.misConsultas = new ArrayList<Consulta> ();
		this.codigopaciente= codigopaciente;
		this.setApellidos(apellidos);
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public HistoriaClinica getHistorial() {
		return historial;
	}

	public void setHistorial(HistoriaClinica historial) {
		this.historial = historial;
	}

	public ArrayList<Consulta> getMisConsultas() {
		return misConsultas;
	}

	public void setMisConsultas(ArrayList<Consulta> misConsultas) {
		this.misConsultas = misConsultas;
	}

	public String getCodigopaciente() {
		return codigopaciente;
	}

	public void añadirConsulta(Consulta consulta) {
		misConsultas.add(consulta);
		
		// TODO Auto-generated method stub
		
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechadenacimiento() {
		return fechadenacimiento;
	}

	public void setFechadenacimiento(Date fechadenacimiento) {
		this.fechadenacimiento = fechadenacimiento;
	}
	
	
	
	
	
}
