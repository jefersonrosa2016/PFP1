package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Logico.Clinica;
import Logico.Consulta;
import Logico.Medico;
import Logico.Paciente;
import Logico.Vacuna;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.awt.Toolkit;

public class VistadelPacienteMedico extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigoCliente;
	private JTextField txtnombrePaciente;
	private JTextField txtApellido;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JDateChooser fechamedico;
	private JTextField txtgenero;
	
	private static DefaultTableModel modeloTablaVacunas;
	private static Object[] rowVacunas;//Arreglo de objeto.
	private JTable tblListadoVacunas;
	private JTextField TxtcodBusqueda;
	private JTextField txtBusquedacodvacunafaltante;
	private JTable tblListaDeVacunasPendiente;
	
	private static DefaultTableModel modeloTablaVacunaspendientes;
	private static Object[] rowVacunaspendientes;//Arreglo de objeto.
	private JTextField txtTipoSangre;
	private Vacuna Vdeseada=null;
	private JButton btnColocar;
	private JTextField txtcodconsulta;
	
	private static DefaultTableModel modeloTablaCONSULTAS;
	private static Object[] rowCONSULTAS;//Arreglo de objeto.
	
	private static DefaultTableModel modeloTablaHistorialClinico;
	private static Object[] rowHistorialClinico;//Arreglo de objeto.
	
	
	
	private JTable TabladeConsultas;
	private JTextField txtSintomasMiConsulta;
	private JTextField txtdiagnosticoMiConsulta;
	private JTextField txtCodhistorialdeConsultas;
	private JTable TablaHistorialClinico;
	private JButton btnBuscarhistorialConsulta;
	private JTextField txtSintomasHistorial;
	private JTextField txtDiagnosticoHistorial;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VistadelPacienteMedico dialog = new VistadelPacienteMedico(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param selected 
	 */
	public VistadelPacienteMedico(Paciente selected) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistadelPacienteMedico.class.getResource("/Imgenes/logitoventana.png")));
		setBounds(100, 100, 960, 512);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		ImageIcon pacien =new ImageIcon(getClass().getResource("/Imgenes/ImagenPacienteGrande.png"));
		Icon paci= new ImageIcon(pacien.getImage().getScaledInstance((int)158,(int)202,Image.SCALE_DEFAULT));
		{
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(12, 13, 918, 399);
			
			contentPanel.add(tabbedPane);
			{
				JPanel panelPaciente = new JPanel();
				tabbedPane.addTab("Paciente", null, panelPaciente, null);
				panelPaciente.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panelPaciente.setLayout(null);
				
				JLabel Contenedorimagen = new JLabel("");
				Contenedorimagen.setBounds(23, 81, 158, 202);
				Contenedorimagen.setIcon(paci);
				panelPaciente.add(Contenedorimagen);
				
				JLabel lblCodDePaciente = new JLabel("Codigo:");
				lblCodDePaciente.setBounds(206, 85, 76, 26);
				lblCodDePaciente.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				panelPaciente.add(lblCodDePaciente);
				
				txtCodigoCliente = new JTextField();
				txtCodigoCliente.setBounds(292, 83, 244, 30);
				txtCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtCodigoCliente.setEditable(false);
				txtCodigoCliente.setColumns(10);
				panelPaciente.add(txtCodigoCliente);
				
				txtnombrePaciente = new JTextField();
				txtnombrePaciente.setBounds(292, 124, 244, 30);
				txtnombrePaciente.setEditable(false);
				txtnombrePaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtnombrePaciente.setColumns(10);
				panelPaciente.add(txtnombrePaciente);
				
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setBounds(206, 126, 76, 26);
				lblNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				panelPaciente.add(lblNombre);
				
				txtApellido = new JTextField();
				txtApellido.setBounds(635, 124, 244, 30);
				txtApellido.setEditable(false);
				txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtApellido.setColumns(10);
				panelPaciente.add(txtApellido);
				
				JLabel lblApellidos = new JLabel("Apellidos:");
				lblApellidos.setBounds(549, 126, 85, 26);
				lblApellidos.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				panelPaciente.add(lblApellidos);
				
				txtCedula = new JTextField();
				txtCedula.setBounds(635, 81, 244, 30);
				txtCedula.setEditable(false);
				txtCedula.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtCedula.setColumns(10);
				panelPaciente.add(txtCedula);
				
				JLabel lblCedula = new JLabel("Cedula:");
				lblCedula.setBounds(549, 83, 76, 26);
				lblCedula.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				panelPaciente.add(lblCedula);
				
				txtTelefono = new JTextField();
				txtTelefono.setBounds(635, 167, 244, 30);
				txtTelefono.setEditable(false);
				txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtTelefono.setColumns(10);
				panelPaciente.add(txtTelefono);
				
				JLabel lblTelefono = new JLabel("Telefono:");
				lblTelefono.setBounds(549, 169, 85, 26);
				lblTelefono.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				panelPaciente.add(lblTelefono);
				
				JLabel lblGenero = new JLabel("Genero:");
				lblGenero.setBounds(206, 169, 76, 26);
				lblGenero.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				panelPaciente.add(lblGenero);
				
				JLabel lblFechaDeNacimiento = new JLabel("F. de Nacimiento:");
				lblFechaDeNacimiento.setBounds(549, 210, 158, 26);
				lblFechaDeNacimiento.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				panelPaciente.add(lblFechaDeNacimiento);
				
				JLabel lblDireccion = new JLabel("Direccion:");
				lblDireccion.setBounds(206, 254, 95, 26);
				lblDireccion.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				panelPaciente.add(lblDireccion);
				
				txtDireccion = new JTextField();
				txtDireccion.setBounds(292, 253, 588, 30);
				txtDireccion.setEditable(false);
				txtDireccion.setToolTipText("");
				txtDireccion.setHorizontalAlignment(SwingConstants.LEFT);
				txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtDireccion.setColumns(10);
				panelPaciente.add(txtDireccion);
				
				fechamedico = new JDateChooser();
				fechamedico.setBounds(707, 210, 173, 30);
				fechamedico.setEnabled(false);
				fechamedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
				
				
				panelPaciente.add(fechamedico);
				
				JLabel lblTipoDeSangre = new JLabel("Tipo de Sangre:");
				lblTipoDeSangre.setBounds(206, 217, 148, 26);
				lblTipoDeSangre.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				panelPaciente.add(lblTipoDeSangre);
				
				txtgenero = new JTextField();
				txtgenero.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtgenero.setEditable(false);
				txtgenero.setColumns(10);
				txtgenero.setBounds(292, 173, 244, 30);
				panelPaciente.add(txtgenero);
				
				txtTipoSangre = new JTextField();
				txtTipoSangre.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtTipoSangre.setEditable(false);
				txtTipoSangre.setColumns(10);
				txtTipoSangre.setBounds(355, 215, 181, 30);
				panelPaciente.add(txtTipoSangre);
				
				JPanel panel = new JPanel();
				panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel.setBounds(12, 68, 182, 233);
				panelPaciente.add(panel);
				
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(193, 68, 708, 233);
				panelPaciente.add(panel_1);
								
				infodelpaciente(selected);
				
			}
			{
				JPanel panelConsultas = new JPanel();
				tabbedPane.addTab("Consultas", null, panelConsultas, null);
				panelConsultas.setLayout(null);
				
				JPanel panel = new JPanel();
				panel.setLayout(null);
				panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Listado Consultas Realizadas", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel.setBounds(0, 0, 484, 371);
				panelConsultas.add(panel);
				
				JLabel lblCodigoDeConsulta = new JLabel("Codigo de Consulta:");
				lblCodigoDeConsulta.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
				lblCodigoDeConsulta.setBounds(15, 36, 164, 26);
				panel.add(lblCodigoDeConsulta);
				
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(15, 75, 457, 270);
				panel.add(panel_1);
				panel_1.setLayout(new BorderLayout(0, 0));
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel_1.add(scrollPane, BorderLayout.CENTER);
				
				TabladeConsultas = new JTable();
				TabladeConsultas.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int select = TabladeConsultas.getSelectedRow();
						
						if(select !=-1 ) {
							Consulta laConsulta = Clinica.getInstance().buscarconsulta((String) TabladeConsultas.getValueAt(select,0));
							cargardatosMisConsultas(laConsulta);
							
						}
					}

				});
				modeloTablaCONSULTAS =  new DefaultTableModel();
				String[] colum = {"Codigo", "Fecha","Enfermedad"};
				modeloTablaCONSULTAS.setColumnIdentifiers(colum);
				TabladeConsultas.setModel(modeloTablaCONSULTAS);
				
				TabladeConsultas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				scrollPane.setViewportView(TabladeConsultas);
				
				txtcodconsulta = new JTextField();
				txtcodconsulta.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtcodconsulta.setColumns(10);
				txtcodconsulta.setBounds(171, 34, 178, 30);
				panel.add(txtcodconsulta);
				
				JButton btnBuscarC = new JButton("Buscar");
				btnBuscarC.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						loadtableMisConsultas(selected,txtcodconsulta.getText(),2);
					}

				
				});
				btnBuscarC.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				btnBuscarC.setBounds(361, 37, 111, 25);
				panel.add(btnBuscarC);
				
				JPanel panel_2 = new JPanel();
				panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_2.setBounds(490, 13, 411, 343);
				panelConsultas.add(panel_2);
				panel_2.setLayout(null);
				
				JPanel panel_3 = new JPanel();
				panel_3.setBorder(new TitledBorder(null, "Sintomas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_3.setBounds(12, 13, 387, 125);
				panel_2.add(panel_3);
				panel_3.setLayout(new BorderLayout(0, 0));
				
				JScrollPane scrollPane_1 = new JScrollPane();
				panel_3.add(scrollPane_1, BorderLayout.CENTER);
				
				txtSintomasMiConsulta = new JTextField();
				txtSintomasMiConsulta.setEditable(false);
				scrollPane_1.setViewportView(txtSintomasMiConsulta);
				txtSintomasMiConsulta.setColumns(10);
				
				JPanel panel_4 = new JPanel();
				panel_4.setBorder(new TitledBorder(null, "Diagn\u00F3stico", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_4.setBounds(12, 151, 387, 179);
				panel_2.add(panel_4);
				panel_4.setLayout(new BorderLayout(0, 0));
				
				JScrollPane scrollPane_2 = new JScrollPane();
				panel_4.add(scrollPane_2, BorderLayout.CENTER);
				
				txtdiagnosticoMiConsulta = new JTextField();
				txtdiagnosticoMiConsulta.setEditable(false);
				scrollPane_2.setViewportView(txtdiagnosticoMiConsulta);
				txtdiagnosticoMiConsulta.setColumns(10);
			}
			{
				JPanel panelVacunas = new JPanel();
				tabbedPane.addTab("Vacunas", null, panelVacunas, null);
				panelVacunas.setLayout(null);
				
				JPanel panel = new JPanel();
				panel.setLayout(null);
				panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Listado Vacunas Realizadas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel.setBounds(12, 0, 443, 358);
				panelVacunas.add(panel);
				
				JLabel label = new JLabel("Codigo de Vacuna:");
				label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
				label.setBounds(15, 36, 164, 26);
				panel.add(label);
				
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(15, 75, 414, 245);
				panel.add(panel_1);
				panel_1.setLayout(new BorderLayout(0, 0));
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel_1.add(scrollPane, BorderLayout.CENTER);
				
				tblListadoVacunas = new JTable();
				tblListadoVacunas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				modeloTablaVacunas =  new DefaultTableModel();
				String[] columnas = {"Codigo", "Nombre"};
				modeloTablaVacunas.setColumnIdentifiers(columnas);
				tblListadoVacunas.setModel(modeloTablaVacunas);
				scrollPane.setViewportView(tblListadoVacunas);
				
				TxtcodBusqueda = new JTextField();
				TxtcodBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 18));
				TxtcodBusqueda.setColumns(10);
				TxtcodBusqueda.setBounds(161, 34, 140, 30);
				panel.add(TxtcodBusqueda);
				
				JButton btnNewButton = new JButton("Buscar");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						loadTableVacuna(selected, 2,TxtcodBusqueda.getText());
					}


				});
				btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				btnNewButton.setBounds(313, 37, 116, 25);
				panel.add(btnNewButton);
				
				JPanel panel_2 = new JPanel();
				panel_2.setLayout(null);
				panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Listado Vacunas Disponibles", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_2.setBounds(467, 0, 443, 358);
				panelVacunas.add(panel_2);
				
				JLabel label_1 = new JLabel("Codigo de Vacuna:");
				label_1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
				label_1.setBounds(15, 36, 164, 26);
				panel_2.add(label_1);
				
				JPanel panel_3 = new JPanel();
				panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_3.setBounds(15, 75, 414, 245);
				panel_2.add(panel_3);
				panel_3.setLayout(new BorderLayout(0, 0));
				
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel_3.add(scrollPane_1, BorderLayout.CENTER);
				
				tblListaDeVacunasPendiente = new JTable();
				tblListaDeVacunasPendiente.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						btnColocar.setEnabled(true);
						int select= tblListaDeVacunasPendiente.getSelectedRow();
						if(select !=-1 ) {
							Vdeseada=Clinica.getInstance().buscarVacunaPorCodigo((String) tblListaDeVacunasPendiente.getValueAt(select,0));
									
									
						}
						
					}
				});
				tblListaDeVacunasPendiente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				modeloTablaVacunaspendientes =  new DefaultTableModel();
				String[] colum = {"Codigo", "Nombre"};
				modeloTablaVacunaspendientes.setColumnIdentifiers(colum);
				tblListaDeVacunasPendiente.setModel(modeloTablaVacunaspendientes);
				scrollPane_1.setViewportView(tblListaDeVacunasPendiente);
				
				txtBusquedacodvacunafaltante = new JTextField();
				txtBusquedacodvacunafaltante.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtBusquedacodvacunafaltante.setColumns(10);
				txtBusquedacodvacunafaltante.setBounds(161, 34, 140, 30);
				panel_2.add(txtBusquedacodvacunafaltante);
				
				JButton button = new JButton("Buscar");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						loadTableVacunasPendientes(selected,2,txtBusquedacodvacunafaltante.getText());
						
					}

					
				});
				button.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				button.setBounds(313, 37, 116, 25);
				panel_2.add(button);
				
				btnColocar = new JButton("Colocar");
				btnColocar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int posicionDelpaciente= Clinica.getInstance().IndiceDelPacienteByCodigo(selected.getCodigopaciente());
						Clinica.getInstance().getMisPacientes().get(posicionDelpaciente).getHistorial().getMisVacunas().add(Vdeseada);
						loadTableVacunasPendientes(selected,1,"");
						loadTableVacuna(selected, 1, "");
						JOptionPane.showMessageDialog(null, "Vacuna Ingresadas Correctamente");
						btnColocar.setEnabled(false);
					}
				});
				btnColocar.setEnabled(false);
				btnColocar.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				btnColocar.setBounds(313, 320, 116, 25);
				panel_2.add(btnColocar);
				
				
				
				
				
				
				
				
				
				//poner loadtablevacuna
				loadTableVacunasPendientes(selected,1,"");
				loadTableVacuna(selected, 1, "");
				loadtableMisConsultas(selected,"",1);
			}
			{
				JPanel panelHistorialClinico = new JPanel();
				tabbedPane.addTab("Historial Clinico", null, panelHistorialClinico, null);
				panelHistorialClinico.setLayout(null);
				
				JPanel panel = new JPanel();
				panel.setLayout(null);
				panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Historial de Consultas", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel.setBounds(0, 0, 484, 371);
				panelHistorialClinico.add(panel);
				
				JLabel label = new JLabel("Codigo de Consulta:");
				label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
				label.setBounds(15, 36, 164, 26);
				panel.add(label);
				
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(15, 75, 457, 270);
				panel.add(panel_1);
				panel_1.setLayout(new BorderLayout(0, 0));
				
				JScrollPane scrollPane = new JScrollPane();
				panel_1.add(scrollPane, BorderLayout.CENTER);
				
				TablaHistorialClinico = new JTable();
				TablaHistorialClinico.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int select = TablaHistorialClinico.getSelectedRow();
						
						if(select !=-1 ) {
							Consulta laConsulta = Clinica.getInstance().buscarconsulta((String) TablaHistorialClinico.getValueAt(select,0));
							CargardatosHistorialConsultas(laConsulta);
						}
						
					}

					
				});
				modeloTablaHistorialClinico =  new DefaultTableModel();
				String[] colummm = {"Codigo", "Fecha","Enfermedad","Medico"};
				modeloTablaHistorialClinico.setColumnIdentifiers(colummm);
				TablaHistorialClinico.setModel(modeloTablaHistorialClinico);
				
				
				scrollPane.setViewportView(TablaHistorialClinico);
				
				txtCodhistorialdeConsultas = new JTextField();
				txtCodhistorialdeConsultas.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtCodhistorialdeConsultas.setColumns(10);
				txtCodhistorialdeConsultas.setBounds(171, 34, 178, 30);
				panel.add(txtCodhistorialdeConsultas);
				
				btnBuscarhistorialConsulta = new JButton("Buscar");
				btnBuscarhistorialConsulta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						loadtableHistorialConsultas(selected,txtCodhistorialdeConsultas.getText(),2);
					}

					
				});
				btnBuscarhistorialConsulta.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				btnBuscarhistorialConsulta.setBounds(361, 37, 111, 25);
				panel.add(btnBuscarhistorialConsulta);
				
				JPanel panel_2 = new JPanel();
				panel_2.setLayout(null);
				panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_2.setBounds(490, 13, 411, 343);
				panelHistorialClinico.add(panel_2);
				
				JPanel panel_3 = new JPanel();
				panel_3.setBorder(new TitledBorder(null, "Sintomas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_3.setBounds(12, 13, 387, 125);
				panel_2.add(panel_3);
				panel_3.setLayout(new BorderLayout(0, 0));
				
				JScrollPane scrollPane_1 = new JScrollPane();
				panel_3.add(scrollPane_1, BorderLayout.CENTER);
				
				txtSintomasHistorial = new JTextField();
				txtSintomasHistorial.setEditable(false);
				scrollPane_1.setViewportView(txtSintomasHistorial);
				txtSintomasHistorial.setColumns(10);
				
				JPanel panel_4 = new JPanel();
				panel_4.setBorder(new TitledBorder(null, "Diagn\u00F3stico", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_4.setBounds(12, 151, 387, 179);
				panel_2.add(panel_4);
				panel_4.setLayout(new BorderLayout(0, 0));
				
				JScrollPane scrollPane_2 = new JScrollPane();
				panel_4.add(scrollPane_2, BorderLayout.CENTER);
				
				txtDiagnosticoHistorial = new JTextField();
				txtDiagnosticoHistorial.setEditable(false);
				scrollPane_2.setViewportView(txtDiagnosticoHistorial);
				txtDiagnosticoHistorial.setColumns(10);
			}
			
			JPanel Paneldiagnostico = new JPanel();
			Paneldiagnostico.setToolTipText("");
			tabbedPane.addTab("Diagnosticar", null, Paneldiagnostico, null);
			
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadtableHistorialConsultas(selected,"",1);
		
	}

	public void infodelpaciente(Paciente selected) {
		if(selected!=null) {
			txtApellido.setText(selected.getApellidos());
			txtCedula.setText(selected.getCedula());
			txtCodigoCliente.setText(selected.getCodigopaciente());
			txtDireccion.setText(selected.getDireccion());
			txtgenero.setText(selected.getGenero());
			txtnombrePaciente.setText(selected.getNombre());
			txtTelefono.setText(selected.getTelefono());
			fechamedico.setDate(selected.getFechadenacimiento());
			txtTipoSangre.setText(selected.getTipoSangre());
		}
		
	}
	public void loadTableVacuna(Paciente selected, int opcion, String busqueda) {
		modeloTablaVacunas.setRowCount(0);
		rowVacunas = new Object[modeloTablaVacunas.getColumnCount()];
		if(opcion == 1) {
			for (int i = 0; i<selected.getHistorial().getMisVacunas().size(); i++) {
				rowVacunas[0] = selected.getHistorial().getMisVacunas().get(i).getCodigoVacunacion();
				rowVacunas[1] = selected.getHistorial().getMisVacunas().get(i).getNombreVacuna();
			modeloTablaVacunas.addRow(rowVacunas);
			}
		}else if (opcion == 2) {
			
			for (int i = 0; i<selected.getHistorial().getMisVacunas().size(); i++) {
				String codigo = selected.getHistorial().getMisVacunas().get(i).getCodigoVacunacion();;
				if( codigo .equalsIgnoreCase(busqueda)) {
					rowVacunas[0] = selected.getHistorial().getMisVacunas().get(i).getCodigoVacunacion();
					rowVacunas[1] = selected.getHistorial().getMisVacunas().get(i).getNombreVacuna();
					modeloTablaVacunas.addRow(rowVacunas);
				}else if(busqueda .equalsIgnoreCase("")) {
					rowVacunas[0] = selected.getHistorial().getMisVacunas().get(i).getCodigoVacunacion();
					rowVacunas[1] = selected.getHistorial().getMisVacunas().get(i).getNombreVacuna();
				modeloTablaVacunas.addRow(rowVacunas);
				}
			}
			
		}
		
	}
	public void loadTableVacunasPendientes(Paciente selected,int opcion, String busqueda) {
		modeloTablaVacunaspendientes.setRowCount(0);
		rowVacunaspendientes = new Object[modeloTablaVacunaspendientes.getColumnCount()];
		if(opcion == 1) {
			boolean vac=true;
			for (int i = 0; i < Clinica.getInstance().getMisVacunas().size(); i++) {
				 vac=true;
					for(Vacuna v: selected.getHistorial().getMisVacunas()) {
						if( v==Clinica.getInstance().getMisVacunas().get(i)) {
							vac=false;
							
						}
					}
					if(vac==true) {
						rowVacunaspendientes[0] = Clinica.getInstance().getMisVacunas().get(i).getCodigoVacunacion();
						rowVacunaspendientes[1] = Clinica.getInstance().getMisVacunas().get(i).getNombreVacuna();
						modeloTablaVacunaspendientes.addRow(rowVacunaspendientes);
					}

								
			}
			
			
		}else if (opcion == 2) {
			boolean vac=true;
			for (int i = 0; i < Clinica.getInstance().getMisVacunas().size(); i++) {
				 vac=true;
					for(Vacuna v: selected.getHistorial().getMisVacunas()) {
						if( v==Clinica.getInstance().getMisVacunas().get(i)) {
							vac=false;
							
						}
					}
					if(vac==true) {
						String codigo = Clinica.getInstance().getMisVacunas().get(i).getCodigoVacunacion();
						if( codigo .equalsIgnoreCase(busqueda)) {
							rowVacunaspendientes[0] = Clinica.getInstance().getMisVacunas().get(i).getCodigoVacunacion();
							rowVacunaspendientes[1] = Clinica.getInstance().getMisVacunas().get(i).getNombreVacuna();
							modeloTablaVacunaspendientes.addRow(rowVacunaspendientes);
						}else if(busqueda .equalsIgnoreCase("")) {
							rowVacunaspendientes[0] = Clinica.getInstance().getMisVacunas().get(i).getCodigoVacunacion();
							rowVacunaspendientes[1] = Clinica.getInstance().getMisVacunas().get(i).getNombreVacuna();
							modeloTablaVacunaspendientes.addRow(rowVacunaspendientes);
						}
						
					}

								
			}

			
		}
		
	}
	public void loadtableMisConsultas(Paciente selected, String busqueda, int opcion) {
		modeloTablaCONSULTAS.setRowCount(0);
		rowCONSULTAS = new Object[modeloTablaCONSULTAS.getColumnCount()];
		if(opcion == 1) {
			for (int i = 0; i<selected.getMisConsultas().size(); i++) {
				
				if(selected.getMisConsultas().get(i).getMedico().getCodigoUsuario().equalsIgnoreCase(VistaMedico.elmedico.getCodigoUsuario())) {
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						String fecha =sdf.format(selected.getMisConsultas().get(i).getFechaConsulta());
						rowCONSULTAS[0] = selected.getMisConsultas().get(i).getCodigoConsulta();
						rowCONSULTAS[1] = fecha;
						rowCONSULTAS[2] = selected.getMisConsultas().get(i).getEnfermedad().getNombreEnfermedad();
						modeloTablaCONSULTAS.addRow(rowCONSULTAS);
				}
			
			}
		}else if (opcion == 2) {
			
			for (int i = 0; i<selected.getMisConsultas().size(); i++) {
				
				if(selected.getMisConsultas().get(i).getMedico().getCodigoUsuario().equalsIgnoreCase(VistaMedico.elmedico.getCodigoUsuario())) {
					String codigo = selected.getMisConsultas().get(i).getCodigoConsulta();
					if( codigo .equalsIgnoreCase(busqueda)) {
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						String fecha =sdf.format(selected.getMisConsultas().get(i).getFechaConsulta());
						rowCONSULTAS[0] = selected.getMisConsultas().get(i).getCodigoConsulta();
						rowCONSULTAS[1] = fecha;
						rowCONSULTAS[2] = selected.getMisConsultas().get(i).getEnfermedad().getNombreEnfermedad();
						modeloTablaCONSULTAS.addRow(rowCONSULTAS);
					}else if(busqueda .equalsIgnoreCase("")) {
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						String fecha =sdf.format(selected.getMisConsultas().get(i).getFechaConsulta());
						rowCONSULTAS[0] = selected.getMisConsultas().get(i).getCodigoConsulta();
						rowCONSULTAS[1] = fecha;
						rowCONSULTAS[2] = selected.getMisConsultas().get(i).getEnfermedad().getNombreEnfermedad();
						modeloTablaCONSULTAS.addRow(rowCONSULTAS);
					}
					
				}
						
				
			}
			
		}
		
	}

	public void cargardatosMisConsultas(Consulta laConsulta) {
		txtdiagnosticoMiConsulta.setText(laConsulta.getDiagnostico());
		txtSintomasMiConsulta.setText(laConsulta.getSintomas());
	}
	public void loadtableHistorialConsultas(Paciente selected, String busqueda, int opcion) {
		modeloTablaHistorialClinico.setRowCount(0);
		rowHistorialClinico = new Object[modeloTablaHistorialClinico.getColumnCount()];
		if(opcion == 1) {
			for (int i = 0; i<selected.getHistorial().getMisConsultas().size(); i++) {
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						String fecha =sdf.format(selected.getHistorial().getMisConsultas().get(i).getFechaConsulta());
						rowHistorialClinico[0] = selected.getHistorial().getMisConsultas().get(i).getCodigoConsulta();
						rowHistorialClinico[1] = fecha;
						rowHistorialClinico[2] = selected.getHistorial().getMisConsultas().get(i).getEnfermedad().getNombreEnfermedad();
						rowHistorialClinico[3] = selected.getHistorial().getMisConsultas().get(i).getMedico().getNombre();
						modeloTablaHistorialClinico.addRow(rowHistorialClinico);
				
			
			}
		}else if (opcion == 2) {
			
			for (int i = 0; i<selected.getHistorial().getMisConsultas().size(); i++) {
					String codigo = selected.getMisConsultas().get(i).getCodigoConsulta();
					if( codigo .equalsIgnoreCase(busqueda)) {
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						String fecha =sdf.format(selected.getHistorial().getMisConsultas().get(i).getFechaConsulta());
						rowHistorialClinico[0] = selected.getHistorial().getMisConsultas().get(i).getCodigoConsulta();
						rowHistorialClinico[1] = fecha;
						rowHistorialClinico[2] = selected.getHistorial().getMisConsultas().get(i).getEnfermedad().getNombreEnfermedad();
						rowHistorialClinico[3] = selected.getHistorial().getMisConsultas().get(i).getMedico().getNombre();
						modeloTablaHistorialClinico.addRow(rowHistorialClinico);
					}else if(busqueda .equalsIgnoreCase("")) {
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						String fecha =sdf.format(selected.getHistorial().getMisConsultas().get(i).getFechaConsulta());
						rowHistorialClinico[0] = selected.getHistorial().getMisConsultas().get(i).getCodigoConsulta();
						rowHistorialClinico[1] = fecha;
						rowHistorialClinico[2] = selected.getHistorial().getMisConsultas().get(i).getEnfermedad().getNombreEnfermedad();
						rowHistorialClinico[3] = selected.getHistorial().getMisConsultas().get(i).getMedico().getNombre();
						modeloTablaHistorialClinico.addRow(rowHistorialClinico);
					}
					
				
						
				
			}
			
		}
		
	}
	public void CargardatosHistorialConsultas(Consulta laConsulta) {
		txtSintomasHistorial.setText(laConsulta.getSintomas());
		txtDiagnosticoHistorial.setText(laConsulta.getDiagnostico());
		
	}
	
	
	
}
