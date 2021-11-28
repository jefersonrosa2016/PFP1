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
import java.awt.Toolkit;

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
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imgenes/logitoventana.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 344);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Codigo de Usuario");
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		label.setBounds(350, 33, 160, 34);
		contentPane.add(label);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(285, 80, 299, 34);
		contentPane.add(txtUsuario);
		
		JLabel label_1 = new JLabel("Contrase\u00F1a");
		label_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		label_1.setBounds(379, 127, 153, 26);
		contentPane.add(label_1);
		
		contraseña = new JPasswordField();
		contraseña.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contraseña.setBounds(285, 166, 299, 34);
		contentPane.add(contraseña);
		
		JButton button = new JButton("Conectar");
		button.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		button.setBounds(369, 222, 124, 25);
		contentPane.add(button);
		
		JLabel logo = new JLabel("");
		ImageIcon imagen =new ImageIcon(getClass().getResource("/Imgenes/LogoLogin.png"));
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance((int)220,(int)189,Image.SCALE_DEFAULT));
		logo.setIcon(icono);
		logo.setBounds(36, 49, 237, 187);
		contentPane.add(logo);
	}
}
