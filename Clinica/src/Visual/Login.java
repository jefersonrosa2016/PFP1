package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import Logico.Administrador;
import Logico.Clinica;
import Logico.Medico;
import Logico.Usuario;

import java.awt.Toolkit;
import java.awt.Window.Type;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField contraseña;
	public static Administrador lasecre=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream clinica;
				FileOutputStream clinica2;
				ObjectInputStream clinicaRead;
				ObjectOutputStream clinicaWrite;
				try {
					clinica = new FileInputStream ("src/Ficheros/LaInfoClinica.dat");
					clinicaRead = new ObjectInputStream(clinica);
					Clinica temp = (Clinica)clinicaRead.readObject();
					Clinica.setInstanciaGlobal(temp);
					clinica.close();
					clinicaRead.close();
				} catch (FileNotFoundException e) {
					try {
						clinica2 = new  FileOutputStream("src/Ficheros/LaInfoClinica.dat");
						clinicaWrite = new ObjectOutputStream(clinica2);
						Administrador admin= new Administrador("USR"+Clinica.getInstance().getCodigodeusuario(),"admin", "admin", "Jerferson", "Rosa Tejada","809-838-8171", "Admnistrador");
						Clinica.getInstance().ingresarUsuario(admin);
						clinicaWrite.writeObject(Clinica.getInstance());
						clinica2.close();
						clinicaWrite.close();
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
			
				
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream clinica2;
				ObjectOutputStream clinicaWrite;
				try {
					clinica2 = new  FileOutputStream("src/Ficheros/LaInfoClinica.dat");
					clinicaWrite = new ObjectOutputStream(clinica2);
					clinicaWrite.writeObject(Clinica.getInstance());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		
		
		setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		setTitle("Inicio de seccion ");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imgenes/logitoventana.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 344);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel lblUsername = new JLabel("Codigo de usuario");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblUsername.setBounds(350, 33, 160, 34);

		contentPane.add(lblUsername);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(285, 80, 299, 34);
		contentPane.add(txtUsuario);
		
		JLabel label_1 = new JLabel("Contrase\u00F1a");
		label_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		label_1.setBounds(381, 127, 107, 26);
		contentPane.add(label_1);
		
		contraseña = new JPasswordField();
		contraseña.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contraseña.setBounds(285, 166, 299, 34);
		contentPane.add(contraseña);
		
		JButton button = new JButton("Conectar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String contra= new String (contraseña.getPassword());
				verificaciondecuenta(txtUsuario.getText(),contra);
			}

			
		});
		button.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		button.setBounds(372, 222, 124, 25);
		contentPane.add(button);
		
		JLabel logo = new JLabel("");
		ImageIcon imagen =new ImageIcon(getClass().getResource("/Imgenes/LogoLogin.png"));
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance((int)220,(int)189,Image.SCALE_DEFAULT));
		logo.setIcon(icono);
		logo.setBounds(36, 49, 237, 187);
		contentPane.add(logo);
	}
	public void verificaciondecuenta(String user, String pass) {
		for (int i = 0; i<Clinica.getInstance().getMisUsuarios().size(); i++) {
			if(user.equals(Clinica.getInstance().getMisUsuarios().get(i).getLogin()) && pass.equals(Clinica.getInstance().getMisUsuarios().get(i).getPassword())) {
				if(Clinica.getInstance().getMisUsuarios().get(i) instanceof Administrador) {
					
					Administrador admin= (Administrador) Clinica.getInstance().getMisUsuarios().get(i);
					lasecre=admin;
					if(admin.getPuestoLaboral().equalsIgnoreCase("Secretaria")) {
						VistaSecretaria lasecre= new VistaSecretaria(admin);
						dispose();
						lasecre.setVisible(true);
					}else {
						Principal adminviu = new Principal((Administrador) Clinica.getInstance().getMisUsuarios().get(i));
						dispose();
						adminviu.setVisible(true);
					}
					
				}
				if(Clinica.getInstance().getMisUsuarios().get(i) instanceof Medico) {
					VistaMedico medicoviu= new VistaMedico(Clinica.getInstance().getMisUsuarios().get(i));
					dispose();
					medicoviu.setVisible(true);
				}
				
				
			}
			
		}
		
	}
}
