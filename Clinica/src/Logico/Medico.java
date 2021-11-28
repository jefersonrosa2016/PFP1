package Logico;

public class Medico extends Usuario {

	private String codigoMedico;
	private String especialidad;
	public Medico(String codigoUsuario, String login, String idUsuario, String password, String nombre,
			String telefono,String codigoMedico,String especialidad ) {
		super(codigoUsuario, login, idUsuario, password, nombre, telefono);
		this.codigoMedico=codigoMedico;
		this.especialidad=especialidad;
		// TODO Auto-generated constructor stub
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public String getCodigoMedico() {
		return codigoMedico;
	}
	

}
