package Logico;

import java.util.ArrayList;

public class Clinica {
	
	private ArrayList <Paciente> misPacientes;
	private ArrayList <Usuario> misUsuarios;
	private ArrayList <CitaMedica> citasMedicas;
	private ArrayList <Enfermedad> misEnfermedades;
	private ArrayList <Vacuna> misVacunas;
	public static Clinica instanciaGlobal = null;
	private int codigocita;
	private int codigomedico;
	private int codigoconsulta;
	private int codigoenfermedad;
	private int codigoHistorialclinico;
	private int codigodeusuario;
	private int codigodevacunacion;
	
	
	public static Clinica getInstance() {
		if(instanciaGlobal == null) {
			instanciaGlobal = new Clinica();
		}
		return instanciaGlobal;
	}


	private Clinica() {
		super();
		this.citasMedicas= new ArrayList <CitaMedica>();
		this.misPacientes= new ArrayList <Paciente>();
		this.misEnfermedades= new ArrayList <Enfermedad>();
		this.misUsuarios= new ArrayList <Usuario>();
		this.misVacunas= new ArrayList <Vacuna>();
		this.codigocita=1;
		this.codigomedico=1;
		this.codigoconsulta=1;
		this.codigoenfermedad=1;
		this.codigoHistorialclinico=1;
		this.codigodeusuario=1;
		this.codigodevacunacion=1;
	}


	public ArrayList<Paciente> getMisPacientes() {
		return misPacientes;
	}


	public void setMisPacientes(ArrayList<Paciente> misPacientes) {
		this.misPacientes = misPacientes;
	}


	public ArrayList<Usuario> getMisUsuarios() {
		return misUsuarios;
	}


	public void setMisUsuarios(ArrayList<Usuario> misUsuarios) {
		this.misUsuarios = misUsuarios;
	}


	public ArrayList<CitaMedica> getCitasMedicas() {
		return citasMedicas;
	}


	public void setCitasMedicas(ArrayList<CitaMedica> citasMedicas) {
		this.citasMedicas = citasMedicas;
	}


	public ArrayList<Enfermedad> getMisEnfermedades() {
		return misEnfermedades;
	}


	public void setMisEnfermedades(ArrayList<Enfermedad> misEnfermedades) {
		this.misEnfermedades = misEnfermedades;
	}


	public ArrayList<Vacuna> getMisVacunas() {
		return misVacunas;
	}


	public void setMisVacunas(ArrayList<Vacuna> misVacunas) {
		this.misVacunas = misVacunas;
	}


	public int getCodigocita() {
		return codigocita;
	}



	public int getCodigomedico() {
		return codigomedico;
	}


	public int getCodigoconsulta() {
		return codigoconsulta;
	}


	public int getCodigoenfermedad() {
		return codigoenfermedad;
	}



	public int getCodigoHistorialclinico() {
		return codigoHistorialclinico;
	}


	public int getCodigodeusuario() {
		return codigodeusuario;
	}



	public int getCodigodevacunacion() {
		return codigodevacunacion;
	}

	
	
}
