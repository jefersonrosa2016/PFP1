package Logico;

public class Enfermedad {
	private String codigoEnfermedad;
	private String nombreEnfermedad;
	private String tipoEnfermedad;
	private String descipcionEnfermedad;
	public Enfermedad(String codigoEnfermedad, String nombreEnfermedad, String tipoEnfermedad,
			String descipcionEnfermedad) {
		super();
		this.codigoEnfermedad = codigoEnfermedad;
		this.nombreEnfermedad = nombreEnfermedad;
		this.tipoEnfermedad = tipoEnfermedad;
		this.descipcionEnfermedad = descipcionEnfermedad;
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
	public String getDescipcionEnfermedad() {
		return descipcionEnfermedad;
	}
	public void setDescipcionEnfermedad(String descipcionEnfermedad) {
		this.descipcionEnfermedad = descipcionEnfermedad;
	}
}
