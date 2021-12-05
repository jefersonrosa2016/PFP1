package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Administrador;
import Logico.Clinica;
import Logico.Usuario;

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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

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
					Principal frame = new Principal(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal(Administrador usuario) {
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
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Registrar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			RegistrarUsuario a= new RegistrarUsuario();
			a.setVisible(true);
			}
		});
		ImageIcon regi =new ImageIcon(getClass().getResource("/Imgenes/RegistrarUsuarioIcono.png"));
		Icon regii= new ImageIcon(regi.getImage().getScaledInstance((int)50,(int)50,Image.SCALE_DEFAULT));
		mntmNewMenuItem.setIcon(regii);
		mntmNewMenuItem.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		menuUsuarios.add(mntmNewMenuItem);
		
		JSeparator separator = new JSeparator();
		menuUsuarios.add(separator);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listado");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListUsuario b= new ListUsuario ();
				b.setVisible(true);
			}
		});
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
		ImageIcon vacc =new ImageIcon(getClass().getResource("/Imgenes/vacunaColocar.png"));
		Icon vaco= new ImageIcon(vacc.getImage().getScaledInstance((int)50,(int)50,Image.SCALE_DEFAULT));
		ImageIcon his =new ImageIcon(getClass().getResource("/Imgenes/IconoHistorial.png"));
		Icon histo= new ImageIcon(his.getImage().getScaledInstance((int)50,(int)50,Image.SCALE_DEFAULT));
		
		JMenu menuCitas = new JMenu("Citas");
		ImageIcon Cita =new ImageIcon(getClass().getResource("/Imgenes/IconoCita.png"));
		Icon citita= new ImageIcon(Cita.getImage().getScaledInstance((int)70,(int)70,Image.SCALE_DEFAULT));
		menuCitas.setIcon(citita);
		menuCitas.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		menuBar.add(menuCitas);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Listado");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListCitas siiiiiuuuu = new ListCitas();
				siiiiiuuuu.setVisible(true);
			}
		});
		mntmNewMenuItem_6.setIcon(liti);
		mntmNewMenuItem_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		menuCitas.add(mntmNewMenuItem_6);
		ImageIcon consul =new ImageIcon(getClass().getResource("/Imgenes/IconoConsulta.png"));
		Icon consultita= new ImageIcon(consul.getImage().getScaledInstance((int)70,(int)70,Image.SCALE_DEFAULT));
		
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
		
		JMenu menuEnfer = new JMenu("Enfermedades");
		ImageIcon Enfer = new ImageIcon(getClass().getResource("/Imgenes/iconoEnfermedad.png"));
		Icon enferme = new ImageIcon(Enfer.getImage().getScaledInstance((int)70,(int)70, Image.SCALE_DEFAULT));
		menuEnfer.setHorizontalAlignment(SwingConstants.RIGHT);
		menuEnfer.setIcon(enferme);
		menuEnfer.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		
		menuBar.add(menuEnfer);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Registrar ");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegisEnfermedad enferme = new RegisEnfermedad();
				enferme.setVisible(true);
			}
		});
		mntmNewMenuItem_2.setIcon(regii);
		mntmNewMenuItem_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		menuEnfer.add(mntmNewMenuItem_2);
		
		JSeparator separator_2 = new JSeparator();
		menuEnfer.add(separator_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Listado ");
		mntmNewMenuItem_4.setIcon(liti);
		mntmNewMenuItem_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		menuEnfer.add(mntmNewMenuItem_4);
		
		JSeparator separator_1 = new JSeparator();
		menuEnfer.add(separator_1);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion Cuenta", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 13, 311, 164);
		contentPane.add(panel);
		
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
		TipodeCuenta.setText(usuario.getPuestoLaboral());
		panel.add(TipodeCuenta);
		
		JButton button = new JButton("Cerrar seccion");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login salida = new Login();
				dispose();
				salida.setVisible(true);
			}
		});
		button.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		button.setBounds(78, 114, 159, 25);
		panel.add(button);
	}
}
