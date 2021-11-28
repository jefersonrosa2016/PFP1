package Logico;

import java.util.ArrayList;

public class Paciente {

	private String cedula;
	private String nombre;
	private String genero;
	private String diaNacimiento;
	private String direccion;
	private String telefono;
	private HistoriaClinica historial;
	private ArrayList<Consulta> misConsultas;
	
	public Paciente(String cedula, String nombre, String genero, String diaNacimiento, String direccion,
			String telefono,String codigoHistorial) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.genero = genero;
		this.diaNacimiento = diaNacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.historial = new HistoriaClinica(codigoHistorial);
		this.misConsultas = new ArrayList<Consulta> ();
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

	public String getDiaNacimiento() {
		return diaNacimiento;
	}

	public void setDiaNacimiento(String diaNacimiento) {
		this.diaNacimiento = diaNacimiento;
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
	
	
	
	
	
}
