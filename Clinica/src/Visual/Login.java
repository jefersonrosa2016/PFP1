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
import java.awt.event.ActionEvent;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField contraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
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
		if(Clinica.getInstance().getMisUsuarios().size()==0) {
			Administrador admin= new Administrador("USR"+Clinica.getInstance().getCodigodeusuario(),"admin", "admin", "Jerferson", "Rosa Tejada","809-838-8171", "Supremo");
			Clinica.getInstance().ingresarUsuario(admin);
		}
		
		
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
					Principal adminviu = new Principal((Administrador) Clinica.getInstance().getMisUsuarios().get(i));
					dispose();
					adminviu.setVisible(true);
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
