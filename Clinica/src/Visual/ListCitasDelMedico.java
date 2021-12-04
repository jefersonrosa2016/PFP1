package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Logico.CitaMedica;
import Logico.Clinica;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class ListCitasDelMedico extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txthorario;
	private JDateChooser dateFechaCita;
	private JRadioButton btnpendiente;
	private JRadioButton btnrealizada;
	private JRadioButton btncancelada;
	private JButton okButton;
	private JButton btnSave;
	
	private static DefaultTableModel modeloTabla;
	private static Object[] row;//Arreglo de objeto.
	private JTextField TxtcodBusqueda;
	
	private static DefaultTableModel modeloTablarealizada;
	private static Object[] rowrelizado;//Arreglo de objeto.
	
	private static DefaultTableModel modeloTablacancelada;
	private static Object[] rowcancelada;//Arreglo de objeto.
	
	private CitaMedica selected=null; 
	private JTable table;
	private JButton btnVisualizar;
	private JTextField txtCodCitaRealizada;
	private JTable table_1;
	private JButton btnBuscarealiza;
	private JTextField txtCodCancelada;
	private JTable table_2;
	private JButton btnBuscaCancelada;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListCitasDelMedico dialog = new ListCitasDelMedico();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListCitasDelMedico() {
		setBounds(100, 100, 920, 542);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion Cita", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(473, 45, 417, 249);
			contentPanel.add(panel);
			{
				JLabel label = new JLabel("Codigo:");
				label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				label.setBounds(41, 29, 76, 26);
				panel.add(label);
			}
			{
				txtCodigo = new JTextField();
				txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtCodigo.setEditable(false);
				txtCodigo.setColumns(10);
				txtCodigo.setBounds(127, 27, 244, 30);
				panel.add(txtCodigo);
			}
			{
				JLabel label = new JLabel("Nombre:");
				label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				label.setBounds(41, 70, 76, 26);
				panel.add(label);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setEditable(false);
				txtNombre.setText("");
				txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtNombre.setColumns(10);
				txtNombre.setBounds(127, 68, 244, 30);
				panel.add(txtNombre);
			}
			{
				JLabel label = new JLabel("Telefono:");
				label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				label.setBounds(41, 111, 85, 26);
				panel.add(label);
			}
			{
				txtTelefono = new JTextField();
				txtTelefono.setEditable(false);
				txtTelefono.setText("");
				txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtTelefono.setColumns(10);
				txtTelefono.setBounds(127, 109, 244, 30);
				panel.add(txtTelefono);
			}
			{
				JLabel label = new JLabel("Fecha de Cita:");
				label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				label.setBounds(41, 152, 129, 26);
				panel.add(label);
			}
			{
				dateFechaCita = new JDateChooser();
				dateFechaCita.setEnabled(false);
				dateFechaCita.setFont(new Font("Tahoma", Font.PLAIN, 18));
				dateFechaCita.setBounds(174, 148, 197, 30);
				panel.add(dateFechaCita);
			}
			{
				JLabel lblHorario = new JLabel("Horario:");
				lblHorario.setBounds(41, 191, 91, 26);
				panel.add(lblHorario);
				lblHorario.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			}
			{
				txthorario = new JTextField();
				txthorario.setEditable(false);
				txthorario.setText("");
				txthorario.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txthorario.setColumns(10);
				txthorario.setBounds(127, 195, 244, 30);
				panel.add(txthorario);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Estado Cita", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(473, 323, 417, 118);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				btnpendiente = new JRadioButton("Pendiente");
				btnpendiente.setEnabled(false);
				btnpendiente.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				btnpendiente.setBounds(8, 40, 127, 25);
				panel.add(btnpendiente);
			}
			{
				btnrealizada = new JRadioButton("Realizada");
				btnrealizada.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnSave.setVisible(true);
						btnSave.setEnabled(true);
						btnpendiente.setSelected(false);
					}
				});
				btnrealizada.setEnabled(false);
				btnrealizada.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				btnrealizada.setBounds(152, 40, 127, 25);
				panel.add(btnrealizada);
			}
			{
				btncancelada = new JRadioButton("Cancelada");
				btncancelada.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					
					}
				});
				btncancelada.setEnabled(false);
				btncancelada.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				btncancelada.setBounds(283, 40, 113, 25);
				panel.add(btncancelada);
			}
		}
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tabbedPane.getSelectedIndex()==2) {
					
					limpiardatos();
				}
				if(tabbedPane.getSelectedIndex()==1) {
					
					limpiardatos();
				}
				if(tabbedPane.getSelectedIndex()==0) {
					
					limpiardatos();
				}
			}

			
		});
		tabbedPane.setBounds(12, 20, 449, 430);
		contentPanel.add(tabbedPane);
		
		JPanel panelPendientes = new JPanel();
		tabbedPane.addTab("Citas Pendientes", null, panelPendientes, null);
		panelPendientes.setLayout(null);
		JPanel panelCitas = new JPanel();
		panelCitas.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Listado Citas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCitas.setBounds(0, 0, 444, 393);
		panelPendientes.add(panelCitas);
		panelCitas.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cod. Cita:");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNewLabel.setBounds(15, 37, 98, 26);
		panelCitas.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(15, 76, 402, 302);
		panelCitas.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnVisualizar.setEnabled(true);
				int select = table.getSelectedRow();
				
				if(select !=-1 ) {
					selected=Clinica.getInstance().buscarCitaPorCodigo((String) table.getValueAt(select,0));
				}
			}
		});
		modeloTabla =  new DefaultTableModel();
		String[] columnas = {"Codigo", "Nombre","Fecha","Horario"};
		modeloTabla.setColumnIdentifiers(columnas);
		table.setModel(modeloTabla);
		
		scrollPane.setViewportView(table);
		
		TxtcodBusqueda = new JTextField();
		TxtcodBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 18));
		TxtcodBusqueda.setBounds(110, 35, 180, 30);
		panelCitas.add(TxtcodBusqueda);
		TxtcodBusqueda.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable(TxtcodBusqueda.getText(), 2);
			}
		});
		ImageIcon imagen =new ImageIcon(getClass().getResource("/Imgenes/BuscaIcono.png"));
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance((int)25,(int)25,Image.SCALE_DEFAULT));
		btnNewButton.setIcon(icono);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton.setBounds(302, 38, 111, 25);
		panelCitas.add(btnNewButton);
		
		loadTable("",1);
		
		
		
		
		
		
		
		
		
		JPanel panelRealizadas = new JPanel();
		tabbedPane.addTab("Citas Realizadas", null, panelRealizadas, null);
		panelRealizadas.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Listado Citas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(0, 0, 444, 393);
		panelRealizadas.add(panel);
		
		JLabel label = new JLabel("Cod. Cita:");
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		label.setBounds(15, 37, 98, 26);
		panel.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(15, 76, 402, 302);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_2.add(scrollPane_1, BorderLayout.CENTER);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnVisualizar.setEnabled(true);
				int select = table_1.getSelectedRow();
				
				if(select !=-1 ) {
					selected=Clinica.getInstance().buscarCitaPorCodigo((String) table_1.getValueAt(select,0));
				}
				
			}
		});
		modeloTablarealizada =  new DefaultTableModel();
		String[] colum = {"Codigo", "Nombre","Fecha","Horario"};
		modeloTablarealizada.setColumnIdentifiers(colum);
		table_1.setModel(modeloTablarealizada);
		scrollPane_1.setViewportView(table_1);
		
		txtCodCitaRealizada = new JTextField();
		txtCodCitaRealizada.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCodCitaRealizada.setColumns(10);
		txtCodCitaRealizada.setBounds(110, 35, 180, 30);
		panel.add(txtCodCitaRealizada);
		
		btnBuscarealiza = new JButton("Buscar");
		btnBuscarealiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadtableRealizadas(txtCodCitaRealizada.getText(), 2);
			}

			
		});
		btnBuscarealiza.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnBuscarealiza.setIcon(icono);
		btnBuscarealiza.setBounds(302, 38, 111, 25);
		panel.add(btnBuscarealiza);
		
		JPanel PanelCanceladas = new JPanel();
		tabbedPane.addTab("Citas Canceladas", null, PanelCanceladas, null);
		PanelCanceladas.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Listado Citas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(0, 0, 444, 393);
		PanelCanceladas.add(panel_3);
		
		JLabel label_1 = new JLabel("Cod. Cita:");
		label_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		label_1.setBounds(15, 37, 98, 26);
		panel_3.add(label_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(15, 76, 402, 302);
		panel_3.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_4.add(scrollPane_2, BorderLayout.CENTER);
		
		table_2 = new JTable();
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnVisualizar.setEnabled(true);
				int select = table_2.getSelectedRow();
				
				if(select !=-1 ) {
					selected=Clinica.getInstance().buscarCitaPorCodigo((String) table_2.getValueAt(select,0));
				}
				
			}
		});
		modeloTablacancelada =  new DefaultTableModel();
		String[] co = {"Codigo", "Nombre","Fecha","Horario"};
		modeloTablacancelada.setColumnIdentifiers(co);
		table_2.setModel(modeloTablacancelada);
		
		
		
		scrollPane_2.setViewportView(table_2);
		
		txtCodCancelada = new JTextField();
		txtCodCancelada.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCodCancelada.setColumns(10);
		txtCodCancelada.setBounds(110, 35, 180, 30);
		panel_3.add(txtCodCancelada);
		
		btnBuscaCancelada = new JButton("Buscar");
		btnBuscaCancelada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadtablecancelada(txtCodCancelada.getText(), 2);
			}

			
		});
		btnBuscaCancelada.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnBuscaCancelada.setBounds(302, 38, 111, 25);
		btnBuscaCancelada.setIcon(icono);
		panel_3.add(btnBuscaCancelada);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnSave = new JButton("Guardar");
				btnSave.setEnabled(false);
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int indicedeCita=Clinica.getInstance().indicedecitaBycod(selected.getCodigoCita());
						if (indicedeCita!=-1) {
							Clinica.getInstance().getCitasMedicas().get(indicedeCita).setEstado(btnrealizada.getText());
							JOptionPane.showMessageDialog(null, "Cita  Realizada con Exito");
							dispose();
							
						}
					}
				});
				btnSave.setVisible(false);
				
				btnVisualizar = new JButton("Visualizar");
				btnVisualizar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cargardatos(selected);
						if(selected.getEstado().equalsIgnoreCase("Pendiente")) {
							okButton.setEnabled(true);
							
						}
						btnVisualizar.setEnabled(false);
					}
				});
				btnVisualizar.setEnabled(false);
				btnVisualizar.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				buttonPane.add(btnVisualizar);
				btnSave.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				btnSave.setActionCommand("OK");
				buttonPane.add(btnSave);
			}
			{
				okButton = new JButton("Modificar Estado");
				okButton.setEnabled(false);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnrealizada.setEnabled(true);
						btnVisualizar.setEnabled(false);
					}
				});
				okButton.setVisible(false);
				okButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		
			loadTable("",1);
			loadtableRealizadas("",1);
			loadtablecancelada("",1);
		}
	}

	public void cargardatos(CitaMedica selected) {
		txtCodigo.setText(selected.getCodigoCita());
		txthorario.setText(selected.getHorario());
		txtNombre.setText(selected.getNombrePersona());
		txtTelefono.setText(selected.getTelefonoPersona());
		dateFechaCita.setDate(selected.getFechaCita());
		if (selected.getEstado().equalsIgnoreCase("Pendiente")) {
			btnpendiente.setSelected(true);
			btncancelada.setSelected(false);
			btnrealizada.setSelected(false);
			okButton.setVisible(true);
			
		}
		if (selected.getEstado().equalsIgnoreCase("Realizada")) {
			btnpendiente.setSelected(false);
			btncancelada.setSelected(false);
			btnrealizada.setSelected(true);
		}
		if (selected.getEstado().equalsIgnoreCase("Cancelada")) {
			btnpendiente.setSelected(false);
			btncancelada.setSelected(true);
			btnrealizada.setSelected(false);
			
		}
		
	}
	public void loadTable(String busqueda, int opcion) {
		modeloTabla.setRowCount(0);
		row = new Object[modeloTabla.getColumnCount()];
		if(opcion == 1) {
			for (int i = 0; i<Clinica.getInstance().getCitasMedicas().size(); i++) {
				
				if(Clinica.getInstance().getCitasMedicas().get(i).getMedico().getCodigoUsuario().equalsIgnoreCase(VistaMedico.elmedico.getCodigoUsuario())) {
					if(Clinica.getInstance().getCitasMedicas().get(i).getEstado().equalsIgnoreCase("Pendiente")) {
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						sdf.format(Clinica.getInstance().getCitasMedicas().get(i).getFechaCita());
						String fecha =sdf.format(Clinica.getInstance().getCitasMedicas().get(i).getFechaCita());
						row[0] = Clinica.getInstance().getCitasMedicas().get(i).getCodigoCita();
						row[1] = Clinica.getInstance().getCitasMedicas().get(i).getNombrePersona();
						row[2] = fecha;
						row[3] = Clinica.getInstance().getCitasMedicas().get(i).getHorario();
					modeloTabla.addRow(row);
					}
				
				}
			
			}
		}else if (opcion == 2) {
			
			for (int i = 0; i<Clinica.getInstance().getCitasMedicas().size(); i++) {
				if(Clinica.getInstance().getCitasMedicas().get(i).getMedico().getCodigoUsuario().equalsIgnoreCase(VistaMedico.elmedico.getCodigoUsuario())) {
					if(Clinica.getInstance().getCitasMedicas().get(i).getEstado().equalsIgnoreCase("Pendiente")) {
						
						String codigo = Clinica.getInstance().getCitasMedicas().get(i).getCodigoCita();
						if( codigo .equalsIgnoreCase(busqueda)) {
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							String fecha =sdf.format(Clinica.getInstance().getCitasMedicas().get(i).getFechaCita());
							row[0] = Clinica.getInstance().getCitasMedicas().get(i).getCodigoCita();
							row[1] = Clinica.getInstance().getCitasMedicas().get(i).getNombrePersona();
							row[2] = fecha;
							row[3] = Clinica.getInstance().getCitasMedicas().get(i).getHorario();
						modeloTabla.addRow(row);
						}else if(busqueda .equalsIgnoreCase("")) {
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							sdf.format(Clinica.getInstance().getCitasMedicas().get(i).getFechaCita());
							String fecha =sdf.format(Clinica.getInstance().getCitasMedicas().get(i).getFechaCita());
							row[0] = Clinica.getInstance().getCitasMedicas().get(i).getCodigoCita();
							row[1] = Clinica.getInstance().getCitasMedicas().get(i).getNombrePersona();
							row[2] = fecha;
							row[3] = Clinica.getInstance().getCitasMedicas().get(i).getHorario();
						modeloTabla.addRow(row);
						}
					}	
				}
			}
			
		}
		
	}
	public void loadtableRealizadas(String busqueda, int opcion) {
		modeloTablarealizada.setRowCount(0);
		rowrelizado = new Object[modeloTablarealizada.getColumnCount()];
		if(opcion == 1) {
			for (int i = 0; i<Clinica.getInstance().getCitasMedicas().size(); i++) {
				
				if(Clinica.getInstance().getCitasMedicas().get(i).getMedico().getCodigoUsuario().equalsIgnoreCase(VistaMedico.elmedico.getCodigoUsuario())) {
					if(Clinica.getInstance().getCitasMedicas().get(i).getEstado().equalsIgnoreCase("Realizada")) {
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						sdf.format(Clinica.getInstance().getCitasMedicas().get(i).getFechaCita());
						String fecha =sdf.format(Clinica.getInstance().getCitasMedicas().get(i).getFechaCita());
						rowrelizado[0] = Clinica.getInstance().getCitasMedicas().get(i).getCodigoCita();
						rowrelizado[1] = Clinica.getInstance().getCitasMedicas().get(i).getNombrePersona();
						rowrelizado[2] = fecha;
						rowrelizado[3] = Clinica.getInstance().getCitasMedicas().get(i).getHorario();
						modeloTablarealizada.addRow(rowrelizado);
					}
				
				}
			
			}
		}else if (opcion == 2) {
			
			for (int i = 0; i<Clinica.getInstance().getCitasMedicas().size(); i++) {
				if(Clinica.getInstance().getCitasMedicas().get(i).getMedico().getCodigoUsuario().equalsIgnoreCase(VistaMedico.elmedico.getCodigoUsuario())) {
					if(Clinica.getInstance().getCitasMedicas().get(i).getEstado().equalsIgnoreCase("Realizada")) {
						
						String codigo = Clinica.getInstance().getCitasMedicas().get(i).getCodigoCita();
						if( codigo .equalsIgnoreCase(busqueda)) {
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							String fecha =sdf.format(Clinica.getInstance().getCitasMedicas().get(i).getFechaCita());
							rowrelizado[0] = Clinica.getInstance().getCitasMedicas().get(i).getCodigoCita();
							rowrelizado[1] = Clinica.getInstance().getCitasMedicas().get(i).getNombrePersona();
							rowrelizado[2] = fecha;
							rowrelizado[3] = Clinica.getInstance().getCitasMedicas().get(i).getHorario();
							modeloTablarealizada.addRow(rowrelizado);
						}else if(busqueda .equalsIgnoreCase("")) {
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							sdf.format(Clinica.getInstance().getCitasMedicas().get(i).getFechaCita());
							String fecha =sdf.format(Clinica.getInstance().getCitasMedicas().get(i).getFechaCita());
							rowrelizado[0] = Clinica.getInstance().getCitasMedicas().get(i).getCodigoCita();
							rowrelizado[1] = Clinica.getInstance().getCitasMedicas().get(i).getNombrePersona();
							rowrelizado[2] = fecha;
							rowrelizado[3] = Clinica.getInstance().getCitasMedicas().get(i).getHorario();
							modeloTablarealizada.addRow(rowrelizado);
						}
					}	
				}
			}
			
		}
		
	}
	public void limpiardatos() {
		txtCodigo.setText("");
		txthorario.setText("");
		txtNombre.setText("");
		txtTelefono.setText("");
		dateFechaCita.setDate(null);
		btnpendiente.setSelected(false);
		btncancelada.setSelected(false);
		btnrealizada.setSelected(false);
		okButton.setEnabled(false);
		okButton.setVisible(false);
		
		
	}
	public void loadtablecancelada(String busqueda, int opcion) {
		modeloTablacancelada.setRowCount(0);
		rowcancelada = new Object[modeloTablacancelada.getColumnCount()];
		if(opcion == 1) {
			for (int i = 0; i<Clinica.getInstance().getCitasMedicas().size(); i++) {
				
				if(Clinica.getInstance().getCitasMedicas().get(i).getMedico().getCodigoUsuario().equalsIgnoreCase(VistaMedico.elmedico.getCodigoUsuario())) {
					if(Clinica.getInstance().getCitasMedicas().get(i).getEstado().equalsIgnoreCase("Cancelada")) {
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						sdf.format(Clinica.getInstance().getCitasMedicas().get(i).getFechaCita());
						String fecha =sdf.format(Clinica.getInstance().getCitasMedicas().get(i).getFechaCita());
						rowcancelada[0] = Clinica.getInstance().getCitasMedicas().get(i).getCodigoCita();
						rowcancelada[1] = Clinica.getInstance().getCitasMedicas().get(i).getNombrePersona();
						rowcancelada[2] = fecha;
						rowcancelada[3] = Clinica.getInstance().getCitasMedicas().get(i).getHorario();
					modeloTablacancelada.addRow(rowcancelada);
					}
				
				}
			
			}
		}else if (opcion == 2) {
			
			for (int i = 0; i<Clinica.getInstance().getCitasMedicas().size(); i++) {
				if(Clinica.getInstance().getCitasMedicas().get(i).getMedico().getCodigoUsuario().equalsIgnoreCase(VistaMedico.elmedico.getCodigoUsuario())) {
					if(Clinica.getInstance().getCitasMedicas().get(i).getEstado().equalsIgnoreCase("Cancelada")) {
						
						String codigo = Clinica.getInstance().getCitasMedicas().get(i).getCodigoCita();
						if( codigo .equalsIgnoreCase(busqueda)) {
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							String fecha =sdf.format(Clinica.getInstance().getCitasMedicas().get(i).getFechaCita());
							rowcancelada[0] = Clinica.getInstance().getCitasMedicas().get(i).getCodigoCita();
							rowcancelada[1] = Clinica.getInstance().getCitasMedicas().get(i).getNombrePersona();
							rowcancelada[2] = fecha;
							rowcancelada[3] = Clinica.getInstance().getCitasMedicas().get(i).getHorario();
						modeloTablacancelada.addRow(rowcancelada);
						}else if(busqueda .equalsIgnoreCase("")) {
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							sdf.format(Clinica.getInstance().getCitasMedicas().get(i).getFechaCita());
							String fecha =sdf.format(Clinica.getInstance().getCitasMedicas().get(i).getFechaCita());
							rowcancelada[0] = Clinica.getInstance().getCitasMedicas().get(i).getCodigoCita();
							rowcancelada[1] = Clinica.getInstance().getCitasMedicas().get(i).getNombrePersona();
							rowcancelada[2] = fecha;
							rowcancelada[3] = Clinica.getInstance().getCitasMedicas().get(i).getHorario();
						modeloTablacancelada.addRow(rowcancelada);
						}
					}	
				}
			}
			
		}
		
	}
}
