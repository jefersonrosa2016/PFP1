package Socket;



import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import Logico.Administrador;
import Logico.Clinica;

public class Servidor {

	public static void main(String args[]) {
		ServerSocket sfd = null;
		try {
			sfd = new ServerSocket(7000);
		} catch (IOException ioe) {
			System.out.println("Comunicación rechazada." + ioe);
			System.exit(1);
		}

		while (true) {
			try {
				Socket nsfd = sfd.accept();
				System.out.println("Conexion aceptada de: " + nsfd.getInetAddress());
				ObjectInputStream lectura = new ObjectInputStream(nsfd.getInputStream());
				
				
				FileOutputStream Respaldo;
				ObjectOutputStream RespaldoWrite;
				
				
				
				Respaldo = new  FileOutputStream("Respaldo/LaInfoClinicaRespaldo.dat");
				RespaldoWrite = new ObjectOutputStream(Respaldo);
				
				RespaldoWrite.writeObject(lectura.readObject());
				Respaldo.close();
				RespaldoWrite.close();
				
				
				
			} catch (IOException ioe) {
				System.out.println("Error: " + ioe);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
