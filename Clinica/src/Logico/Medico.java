package Logico;

public class Medico extends Usuario {


	private String especialidad;
	public Medico(String codigoUsuario, String login, String password, String nombre,
			String apellidos, String telefono,String especialidad ) {
		
	super(codigoUsuario, login, password, nombre, telefono, apellidos);
		
		this.especialidad=especialidad;
		// TODO Auto-generated constructor stub
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	

}
