package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Medico;
import Logico.Usuario;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.SwingConstants;

public class VistaMedico extends JFrame {

	private JPanel contentPane;
	private Dimension dimension;
	public static Medico elmedico = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaMedico frame = new VistaMedico(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param usuario 
	 */
	public VistaMedico(Usuario usuario) {
		elmedico=(Medico) usuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dimension= getToolkit().getScreenSize();
		setSize((int)dimension.getWidth(),(int)dimension.getHeight()-40);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Citas");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListCitasDelMedico miscitas= new ListCitasDelMedico();
				miscitas.setVisible(true);
			}
		});
		ImageIcon Cita =new ImageIcon(getClass().getResource("/Imgenes/IconoCita.png"));
		Icon citita= new ImageIcon(Cita.getImage().getScaledInstance((int)70,(int)70,Image.SCALE_DEFAULT));
		mnNewMenu.setIcon(citita);
		mnNewMenu.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		menuBar.add(mnNewMenu);
		
		JMenu menuPacientes = new JMenu("Pacientes");
		menuPacientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListadepacientesMedico lispaci = new ListadepacientesMedico();
				lispaci.setVisible(true);
			}
		});
		ImageIcon pacienteee =new ImageIcon(getClass().getResource("/Imgenes/PacienteIcono.png"));
		Icon pacien= new ImageIcon(pacienteee.getImage().getScaledInstance((int)70,(int)70,Image.SCALE_DEFAULT));
		menuPacientes.setIcon(pacien);
		menuPacientes.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		menuBar.add(menuPacientes);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion Cuenta", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(1579, 13, 311, 164);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel nombre = new JLabel("");
		nombre.setHorizontalAlignment(SwingConstants.CENTER);
		nombre.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		nombre.setBounds(12, 26, 287, 32);
		nombre.setText(usuario.getNombre()+" "+usuario.getApellidos());
		panel.add(nombre);
		
		JLabel TipodeCuenta = new JLabel("");
		TipodeCuenta.setHorizontalAlignment(SwingConstants.CENTER);
		TipodeCuenta.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		TipodeCuenta.setBounds(12, 69, 287, 32);
		TipodeCuenta.setText("Medico");
		panel.add(TipodeCuenta);
		
		JButton btnNewButton = new JButton("Cerrar seccion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login salir = new Login();
				dispose();
				salir.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton.setBounds(78, 114, 159, 25);
		panel.add(btnNewButton);
	}
}
