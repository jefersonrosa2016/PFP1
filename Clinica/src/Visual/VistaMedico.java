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

import Logico.Usuario;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaMedico extends JFrame {

	private JPanel contentPane;
	private Dimension dimension;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dimension= getToolkit().getScreenSize();
		setSize((int)dimension.getWidth(),(int)dimension.getHeight()-40);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Citas");
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
	}
}
