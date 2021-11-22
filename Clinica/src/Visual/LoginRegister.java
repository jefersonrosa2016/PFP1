package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LoginRegister extends JFrame {

	private JPanel contentPane;
	private Dimension dimension; 
	private JTextField txtCodigoUsuario;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginRegister frame = new LoginRegister();
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
	public LoginRegister() {
		dimension= getToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize((int)dimension.getWidth(),(int)dimension.getHeight()-40);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ImageIcon imagen =new ImageIcon(getClass().getResource("/Imgenes/pngwing.com (1).png"));
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance((int)1920-45,(int)1040-45,Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(icono);
		lblNewLabel.setBounds(0, 0, 56, 16);
		lblNewLabel.setSize((int)dimension.getWidth(),(int)dimension.getHeight()-40);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(766, 129, 358, 276);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo de Usuario");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNewLabel_1.setBounds(92, 27, 160, 34);
		panel.add(lblNewLabel_1);
		
		txtCodigoUsuario = new JTextField();
		txtCodigoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCodigoUsuario.setBounds(29, 73, 299, 34);
		panel.add(txtCodigoUsuario);
		txtCodigoUsuario.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNewLabel_2.setBounds(122, 120, 153, 26);
		panel.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(29, 159, 299, 34);
		panel.add(passwordField);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnConectar.setBounds(112, 218, 124, 25);
		panel.add(btnConectar);
	}
}
