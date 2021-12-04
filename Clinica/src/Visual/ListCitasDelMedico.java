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
	private CitaMedica selected=null; 
	private JTable table;
	private JButton btnVisualizar;
	
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
		System.out.println(VistaMedico.elmedico.getCodigoUsuario());
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
		
		JPanel PanelCanceladas = new JPanel();
		tabbedPane.addTab("Citas Canceladas", null, PanelCanceladas, null);
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
}
