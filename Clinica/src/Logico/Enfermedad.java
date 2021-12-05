package Logico;

import java.io.Serializable;

public class Enfermedad implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4095889974237260508L;
	private String codigoEnfermedad;
	private String nombreEnfermedad;
	private String tipoEnfermedad;
	private String descripcionEnfermedad;
	public Enfermedad(String codigoEnfermedad, String nombreEnfermedad,String tipoEnfermedad, String descripcionEnfermedad) {
		super();
		this.codigoEnfermedad = codigoEnfermedad;
		this.nombreEnfermedad = nombreEnfermedad;
		this.tipoEnfermedad = tipoEnfermedad;
		this.descripcionEnfermedad = descripcionEnfermedad;
	}

	public String getCodigoEnfermedad() {
		return codigoEnfermedad;
	}
	public void setCodigoEnfermedad(String codigoEnfermedad) {
		this.codigoEnfermedad = codigoEnfermedad;
	}
	public String getNombreEnfermedad() {
		return nombreEnfermedad;
	}
	public void setNombreEnfermedad(String nombreEnfermedad) {
		this.nombreEnfermedad = nombreEnfermedad;
	}
	public String getTipoEnfermedad() {
		return tipoEnfermedad;
	}
	public void setTipoEnfermedad(String tipoEnfermedad) {
		this.tipoEnfermedad = tipoEnfermedad;
	}
	public String getDescripcionEnfermedad() {
		return descripcionEnfermedad;
	}
	public void setDescipcionEnfermedad(String descipcionEnfermedad) {
		this.descripcionEnfermedad = descipcionEnfermedad;
	}
}
