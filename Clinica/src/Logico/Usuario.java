package Logico;

public class Usuario {
	private String codigoUsuario;
	private String login;
	
	private String password;
	private String nombre;
	private String telefono;
	
	public Usuario(String codigoUsuario, String login, String password, String nombre,
			String telefono) {
		super();
		this.codigoUsuario = codigoUsuario;
		this.login = login;
		
		this.password = password;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}
	

}
