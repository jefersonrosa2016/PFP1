package Logico;

import java.io.Serializable;
import java.util.Date;

public class Consulta implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1424957659790402900L;
	private String codigoConsulta;
	private Date fechaConsulta;
	private String sintomas;
	private String diagnostico;
	private Enfermedad enfermedad;
	private Medico medico;
	public Consulta(String codigoConsulta, String sintomas, String diagnostico,
			Enfermedad enfermedad, Medico medico) {
		super();
		this.codigoConsulta = codigoConsulta;
		this.fechaConsulta = new Date();
		this.sintomas = sintomas;
		this.diagnostico = diagnostico;
		this.enfermedad = enfermedad;
		this.medico= medico;
	}
	public Date getFechaConsulta() {
		return fechaConsulta;
	}
	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}
	public String getSintomas() {
		return sintomas;
	}
	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public Enfermedad getEnfermedad() {
		return enfermedad;
	}
	public void setEnfermedad(Enfermedad enfermedad) {
		this.enfermedad = enfermedad;
	}
	public String getCodigoConsulta() {
		return codigoConsulta;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
}
