package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logico.Administrador;
import Logico.Clinica;

public class VistaSecretaria extends JFrame {

	private JPanel contentPane;
	private Dimension dimension;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaSecretaria frame = new VistaSecretaria(null);
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
	public VistaSecretaria(Administrador usuario) {
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
		setTitle("Clinica");
		dimension= getToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize((int)dimension.getWidth(),(int)dimension.getHeight()-40);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		ImageIcon imagen =new ImageIcon(getClass().getResource("/Imgenes/UsuarioJoven.png"));
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance((int)70,(int)70,Image.SCALE_DEFAULT));
		ImageIcon regi =new ImageIcon(getClass().getResource("/Imgenes/RegistrarUsuarioIcono.png"));
		Icon regii= new ImageIcon(regi.getImage().getScaledInstance((int)50,(int)50,Image.SCALE_DEFAULT));
		ImageIcon lsit =new ImageIcon(getClass().getResource("/Imgenes/ListadoIcono.png"));
		Icon liti= new ImageIcon(lsit.getImage().getScaledInstance((int)50,(int)50,Image.SCALE_DEFAULT));
		ImageIcon pacienteee =new ImageIcon(getClass().getResource("/Imgenes/PacienteIcono.png"));
		Icon pacien= new ImageIcon(pacienteee.getImage().getScaledInstance((int)70,(int)70,Image.SCALE_DEFAULT));
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
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Crear");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCitas cita=  new CrearCitas();
				cita.setVisible(true);
			}
		});
		mntmNewMenuItem_5.setIcon(regii);
		mntmNewMenuItem_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		menuCitas.add(mntmNewMenuItem_5);
		
		JSeparator separator_3 = new JSeparator();
		menuCitas.add(separator_3);
		
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
		ImageIcon vacu =new ImageIcon(getClass().getResource("/Imgenes/IconoVacuna.png"));
		Icon vacunii= new ImageIcon(vacu.getImage().getScaledInstance((int)70,(int)70,Image.SCALE_DEFAULT));
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
