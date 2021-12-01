package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dimension;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/Imgenes/logitoventana.png")));
		setTitle("Gestion de Clinica");
		dimension= getToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize((int)dimension.getWidth(),(int)dimension.getHeight()-40);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuUsuarios = new JMenu("Usuarios");
		ImageIcon imagen =new ImageIcon(getClass().getResource("/Imgenes/UsuarioJoven.png"));
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance((int)70,(int)70,Image.SCALE_DEFAULT));
		menuUsuarios.setIcon(icono);
		menuUsuarios.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		menuBar.add(menuUsuarios);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Regsitrar");
		ImageIcon regi =new ImageIcon(getClass().getResource("/Imgenes/RegistrarUsuarioIcono.png"));
		Icon regii= new ImageIcon(regi.getImage().getScaledInstance((int)50,(int)50,Image.SCALE_DEFAULT));
		mntmNewMenuItem.setIcon(regii);
		mntmNewMenuItem.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		menuUsuarios.add(mntmNewMenuItem);
		
		JSeparator separator = new JSeparator();
		menuUsuarios.add(separator);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listado");
		ImageIcon lsit =new ImageIcon(getClass().getResource("/Imgenes/ListadoIcono.png"));
		Icon liti= new ImageIcon(lsit.getImage().getScaledInstance((int)50,(int)50,Image.SCALE_DEFAULT));
		mntmNewMenuItem_1.setIcon(liti);
		mntmNewMenuItem_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		menuUsuarios.add(mntmNewMenuItem_1);
		
		JMenu menuPacientes = new JMenu("Pacientes");
		ImageIcon pacienteee =new ImageIcon(getClass().getResource("/Imgenes/PacienteIcono.png"));
		Icon pacien= new ImageIcon(pacienteee.getImage().getScaledInstance((int)70,(int)70,Image.SCALE_DEFAULT));
		menuPacientes.setIcon(pacien);
		menuPacientes.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		menuBar.add(menuPacientes);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Registrar");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisPaciente paci= new RegisPaciente();
				paci.setVisible(true);
			}
		});
		mntmNewMenuItem_2.setIcon(regii);
		mntmNewMenuItem_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		menuPacientes.add(mntmNewMenuItem_2);
		
		JSeparator separator_1 = new JSeparator();
		menuPacientes.add(separator_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Listado");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListPacientes lispaci = new ListPacientes();
				lispaci.setVisible(true);
			}
		});
		mntmNewMenuItem_3.setIcon(liti);
		mntmNewMenuItem_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		menuPacientes.add(mntmNewMenuItem_3);
		
		JSeparator separator_6 = new JSeparator();
		menuPacientes.add(separator_6);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Agregar Vacunas");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarVacunaPaciente agregi= new AgregarVacunaPaciente();
				agregi.setVisible(true);
			}
		});
		ImageIcon vacc =new ImageIcon(getClass().getResource("/Imgenes/vacunaColocar.png"));
		Icon vaco= new ImageIcon(vacc.getImage().getScaledInstance((int)50,(int)50,Image.SCALE_DEFAULT));
		mntmNewMenuItem_11.setIcon(vaco);
		mntmNewMenuItem_11.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		menuPacientes.add(mntmNewMenuItem_11);
		
		JSeparator separator_2 = new JSeparator();
		menuPacientes.add(separator_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Historial Clinico");
		ImageIcon his =new ImageIcon(getClass().getResource("/Imgenes/IconoHistorial.png"));
		Icon histo= new ImageIcon(his.getImage().getScaledInstance((int)50,(int)50,Image.SCALE_DEFAULT));
		mntmNewMenuItem_4.setIcon(histo);
		mntmNewMenuItem_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		menuPacientes.add(mntmNewMenuItem_4);
		
		JMenu menuCitas = new JMenu("Citas");
		ImageIcon Cita =new ImageIcon(getClass().getResource("/Imgenes/IconoCita.png"));
		Icon citita= new ImageIcon(Cita.getImage().getScaledInstance((int)70,(int)70,Image.SCALE_DEFAULT));
		menuCitas.setIcon(citita);
		menuCitas.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		menuBar.add(menuCitas);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Crear");
		mntmNewMenuItem_5.setIcon(regii);
		mntmNewMenuItem_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		menuCitas.add(mntmNewMenuItem_5);
		
		JSeparator separator_3 = new JSeparator();
		menuCitas.add(separator_3);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Listado");
		mntmNewMenuItem_6.setIcon(liti);
		mntmNewMenuItem_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		menuCitas.add(mntmNewMenuItem_6);
		
		JMenu menuConsulta = new JMenu("Consulta");
		ImageIcon consul =new ImageIcon(getClass().getResource("/Imgenes/IconoConsulta.png"));
		Icon consultita= new ImageIcon(consul.getImage().getScaledInstance((int)70,(int)70,Image.SCALE_DEFAULT));
		menuConsulta.setIcon(consultita);
		menuConsulta.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		menuBar.add(menuConsulta);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Registrar");
		mntmNewMenuItem_7.setIcon(regii);
		mntmNewMenuItem_7.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		menuConsulta.add(mntmNewMenuItem_7);
		
		JSeparator separator_4 = new JSeparator();
		menuConsulta.add(separator_4);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Listado\r\n");
		mntmNewMenuItem_8.setIcon(liti);
		mntmNewMenuItem_8.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		menuConsulta.add(mntmNewMenuItem_8);
		
		JMenu menuVacuna = new JMenu("Vacunas");
		ImageIcon vacu =new ImageIcon(getClass().getResource("/Imgenes/IconoVacuna.png"));
		Icon vacunii= new ImageIcon(vacu.getImage().getScaledInstance((int)70,(int)70,Image.SCALE_DEFAULT));
		menuVacuna.setIcon(vacunii);
		menuVacuna.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		menuBar.add(menuVacuna);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Registrar");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisVacuna vacu = new RegisVacuna();
				vacu.setVisible(true);
			}
		});
		mntmNewMenuItem_9.setIcon(regii);
		mntmNewMenuItem_9.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		menuVacuna.add(mntmNewMenuItem_9);
		
		JSeparator separator_5 = new JSeparator();
		menuVacuna.add(separator_5);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Listado");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListVacunas lisvacu = new ListVacunas();
				lisvacu.setVisible(true);
			}
		});
		mntmNewMenuItem_10.setIcon(liti);
		mntmNewMenuItem_10.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		menuVacuna.add(mntmNewMenuItem_10);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
