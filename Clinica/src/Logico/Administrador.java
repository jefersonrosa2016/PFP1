package Logico;

public class Administrador extends Usuario {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8320940550113460975L;
	private String puestoLaboral;
	public Administrador(String codigoUsuario, String login, String password, String nombre,
			String apellidos, String telefono,String puestoLaboral) {
		super(codigoUsuario, login, password, nombre, telefono, apellidos);
		this.puestoLaboral=puestoLaboral;
	}
	public String getPuestoLaboral() {
		return puestoLaboral;
	}
	public void setPuestoLaboral(String puestoLaboral) {
		this.puestoLaboral = puestoLaboral;
	}

}
