package Logico;

import java.io.Serializable;
import java.util.Date;

public class CitaMedica implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6007903795094683916L;
	private String codigoCita;
	private Date fechaCita;
	private String nombrePersona;
	private String telefonoPersona;
	private String horario;
	private Medico medico;
	private String estado;
	public CitaMedica(String codigoCita, Date fechaCita, String nombrePersona, String telefonoPersona, Medico medico, String horario,String estado) {
		super();
		this.codigoCita = codigoCita;
		this.fechaCita = fechaCita;
		this.nombrePersona = nombrePersona;
		this.telefonoPersona = telefonoPersona;
		this.medico = medico;
		this.horario= horario;
		this.estado = estado;
	}
	public String getCodigoCita() {
		return codigoCita;
	}
	public void setCodigoCita(String codigoCita) {
		this.codigoCita = codigoCita;
	}
	public Date getFechaCita() {
		return fechaCita;
	}
	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}
	public String getNombrePersona() {
		return nombrePersona;
	}
	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}
	public String getTelefonoPersona() {
		return telefonoPersona;
	}
	public void setTelefonoPersona(String telefonoPersona) {
		this.telefonoPersona = telefonoPersona;
	}
	
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
