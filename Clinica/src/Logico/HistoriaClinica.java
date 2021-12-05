package Logico;

import java.io.Serializable;
import java.util.ArrayList;

public class HistoriaClinica implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1704440315587299163L;
	private String codigoHistorial;
	private ArrayList<Consulta> misConsultas;
	private ArrayList<Vacuna> misVacunas;
	public HistoriaClinica(String codigoHistorial) {
		super();
		this.codigoHistorial = codigoHistorial;
		this.misConsultas = new ArrayList<Consulta> ();
		this.misVacunas = new ArrayList<Vacuna> ();
	}
	public ArrayList<Consulta> getMisConsultas() {
		return misConsultas;
	}
	public void setMisConsultas(ArrayList<Consulta> misConsultas) {
		this.misConsultas = misConsultas;
	}
	public ArrayList<Vacuna> getMisVacunas() {
		return misVacunas;
	}
	public void setMisVacunas(ArrayList<Vacuna> misVacunas) {
		this.misVacunas = misVacunas;
	}
	public String getCodigoHistorial() {
		return codigoHistorial;
	}
	

}
