package Logico;

public class Vacuna {
	private  String codigoVacunacion;
	private String nombreVacuna;
	public Vacuna(String codigoVacunacion, String nombreVacuna) {
		super();
		this.codigoVacunacion = codigoVacunacion;
		this.nombreVacuna = nombreVacuna;
	}
	public String getNombreVacuna() {
		return nombreVacuna;
	}
	public void setNombreVacuna(String nombreVacuna) {
		this.nombreVacuna = nombreVacuna;
	}
	public String getCodigoVacunacion() {
		return codigoVacunacion;
	}
	
}
