package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import Logico.CitaMedica;
import Logico.Clinica;
import Logico.Medico;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CrearCitas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodCita;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtEspecialidad;
	private JTable tblmedicos;
	private static DefaultTableModel modeloTabla;
	private static Object[] row;//Arreglo de objeto.
	private Medico seleccionado= null;
	private JButton btnDisponibles;
	private JDateChooser dateCita;
	private JRadioButton btn8;
	private JRadioButton btn9;
	private JRadioButton btn10;
	private JRadioButton btn11;
	private JRadioButton btn14;
	private JRadioButton btn16;
	private JRadioButton btn15;
	private JRadioButton btn17;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearCitas dialog = new CrearCitas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearCitas() {
		setBounds(100, 100, 951, 563);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion Cita", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(12, 13, 395, 455);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel label = new JLabel("Codigo:");
				label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				label.setBounds(12, 30, 76, 26);
				panel.add(label);
			}
			{
				txtCodCita = new JTextField();
				txtCodCita.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtCodCita.setEditable(false);
				txtCodCita.setColumns(10);
				txtCodCita.setBounds(98, 28, 244, 30);
				panel.add(txtCodCita);
			}
			{
				JLabel label = new JLabel("Nombre:");
				label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				label.setBounds(12, 71, 76, 26);
				panel.add(label);
			}
			{
				txtNombre = new JTextField();
				txtNombre.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						int key = e.getKeyChar();

					    boolean mayusculas = key >= 65 && key <= 90;
					    boolean minusculas = key >= 97 && key <= 122;
					    boolean espacio = key == 32;
					            
					     if (!(minusculas || mayusculas || espacio))
					    {
					        e.consume();
					    }
					}
				});
				txtNombre.setText("");
				txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtNombre.setColumns(10);
				txtNombre.setBounds(98, 69, 244, 30);
				panel.add(txtNombre);
			}
			{
				JLabel label = new JLabel("Telefono:");
				label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				label.setBounds(12, 112, 85, 26);
				panel.add(label);
			}
			{
				txtTelefono = new JTextField();
				txtTelefono.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
	                    if((!(Character.isDigit(c))&&(c!='-'))||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)) {
	                        e.consume();
	                    }
					}
				});
				txtTelefono.setText("");
				txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtTelefono.setColumns(10);
				txtTelefono.setBounds(98, 110, 244, 30);
				panel.add(txtTelefono);
			}
			
			JLabel lblFechaDeCita = new JLabel("Fecha de Cita:");
			lblFechaDeCita.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblFechaDeCita.setBounds(12, 153, 129, 26);
			panel.add(lblFechaDeCita);
			
			dateCita = new JDateChooser();
			dateCita.setFont(new Font("Tahoma", Font.PLAIN, 18));
			dateCita.setBounds(145, 149, 197, 30);
			panel.add(dateCita);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(12, 209, 363, 233);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblHorarios = new JLabel("Horarios:");
					lblHorarios.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
					lblHorarios.setBounds(36, 13, 91, 26);
					panel_1.add(lblHorarios);
				}
				{
					btnDisponibles = new JButton("Ver Disponibles");
					btnDisponibles.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							mostrarHorarioDisponible(seleccionado,dateCita.getDate());
						}

						
					});
					btnDisponibles.setEnabled(false);
					btnDisponibles.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
					btnDisponibles.setBounds(174, 14, 154, 25);
					panel_1.add(btnDisponibles);
				}
				{
					btn8 = new JRadioButton("8:00-9:00");
					btn8.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							btn9.setSelected(false);
							btn10.setSelected(false);
							btn11.setSelected(false);
							btn14.setSelected(false);
							btn15.setSelected(false);
							btn16.setSelected(false);
							btn17.setSelected(false);
						}
					});
					btn8.setEnabled(false);
					btn8.setBounds(26, 63, 127, 25);
					panel_1.add(btn8);
					btn8.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
				}
				{
					btn9 = new JRadioButton("9:00-10:00");
					btn9.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							btn8.setSelected(false);
							btn10.setSelected(false);
							btn11.setSelected(false);
							btn14.setSelected(false);
							btn15.setSelected(false);
							btn16.setSelected(false);
							btn17.setSelected(false);
						}
					});
					btn9.setEnabled(false);
					btn9.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
					btn9.setBounds(26, 104, 127, 25);
					panel_1.add(btn9);
				}
				{
					btn10 = new JRadioButton("10:00-11:00");
					btn10.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							btn8.setSelected(false);
							btn9.setSelected(false);
						
							btn11.setSelected(false);
							btn14.setSelected(false);
							btn15.setSelected(false);
							btn16.setSelected(false);
							btn17.setSelected(false);
						}
					});
					btn10.setEnabled(false);
					btn10.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
					btn10.setBounds(26, 141, 138, 25);
					panel_1.add(btn10);
				}
				{
					btn11 = new JRadioButton("11:00-12:00");
					btn11.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							btn8.setSelected(false);
							btn9.setSelected(false);
							btn10.setSelected(false);
					
							btn14.setSelected(false);
							btn15.setSelected(false);
							btn16.setSelected(false);
							btn17.setSelected(false);
						}
					});
					btn11.setEnabled(false);
					btn11.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
					btn11.setBounds(26, 180, 138, 25);
					panel_1.add(btn11);
				}
				{
					btn14 = new JRadioButton("14:00-15:00");
					btn14.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							btn8.setSelected(false);
							btn9.setSelected(false);
							btn10.setSelected(false);
							btn11.setSelected(false);
						
							btn15.setSelected(false);
							btn16.setSelected(false);
							btn17.setSelected(false);
						}
					});
					btn14.setEnabled(false);
					btn14.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
					btn14.setBounds(194, 63, 144, 25);
					panel_1.add(btn14);
				}
				{
					btn16 = new JRadioButton("16:00-17:00");
					btn16.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							btn8.setSelected(false);
							btn9.setSelected(false);
							btn10.setSelected(false);
							btn11.setSelected(false);
							btn14.setSelected(false);
							btn15.setSelected(false);
							
							btn17.setSelected(false);
						}
					});
					btn16.setEnabled(false);
					btn16.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
					btn16.setBounds(194, 141, 138, 25);
					panel_1.add(btn16);
				}
				{
					btn15 = new JRadioButton("15:00-16:00");
					btn15.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							btn8.setSelected(false);
							btn9.setSelected(false);
							btn10.setSelected(false);
							btn11.setSelected(false);
							btn14.setSelected(false);
							
							btn16.setSelected(false);
							btn17.setSelected(false);
						}
					});
					btn15.setEnabled(false);
					btn15.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
					btn15.setBounds(194, 106, 138, 25);
					panel_1.add(btn15);
				}
				{
					btn17 = new JRadioButton("17:00-18:00");
					btn17.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							btn8.setSelected(false);
							btn9.setSelected(false);
							btn10.setSelected(false);
							btn11.setSelected(false);
							btn14.setSelected(false);
							btn15.setSelected(false);
							btn16.setSelected(false);
			
						}
					});
					btn17.setEnabled(false);
					btn17.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
					btn17.setBounds(194, 182, 138, 25);
					panel_1.add(btn17);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Listado de Medicos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(419, 13, 510, 455);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblEspecialidad = new JLabel("Especialidad:");
				lblEspecialidad.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblEspecialidad.setBounds(23, 38, 123, 26);
				panel.add(lblEspecialidad);
			}
			{
				txtEspecialidad = new JTextField();
				txtEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtEspecialidad.setColumns(10);
				txtEspecialidad.setBounds(158, 36, 184, 30);
				panel.add(txtEspecialidad);
			}
			{
				JButton btnBuscarMedico = new JButton("Buscar");
				btnBuscarMedico.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						loadTable(txtEspecialidad.getText(), 2);
					}
				});
				btnBuscarMedico.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				btnBuscarMedico.setBounds(362, 39, 116, 25);
				panel.add(btnBuscarMedico);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(12, 79, 486, 363);
				panel.add(panel_1);
				panel_1.setLayout(new BorderLayout(0, 0));
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel_1.add(scrollPane, BorderLayout.CENTER);
				
				tblmedicos = new JTable();
				tblmedicos.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						btnDisponibles.setEnabled(true);
						int select = tblmedicos.getSelectedRow();
						
						if(select !=-1 ) {
							seleccionado=(Medico) Clinica.getInstance().BuscarUsuarioPorCodigo((String) tblmedicos.getValueAt(select,0));
						}
						
						
					}
				});
				modeloTabla =  new DefaultTableModel();
				String[] columnas = {"Codigo", "Nombre","Apellidos","Especialidad"};
				modeloTabla.setColumnIdentifiers(columnas);
				tblmedicos.setModel(modeloTabla);
				scrollPane.setViewportView(tblmedicos);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCrear = new JButton("Crear");
				btnCrear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (btn8.isSelected()) {
							CitaMedica c = new CitaMedica(txtCodCita.getText(),dateCita.getDate(), txtNombre.getText(), txtTelefono.getText(),seleccionado, btn8.getText(),"Pendiente");
							Clinica.getInstance().ingresarCitaMedica(c);
						}
						if (btn9.isSelected()) {
							CitaMedica c = new CitaMedica(txtCodCita.getText(), dateCita.getDate(), txtNombre.getText(), txtTelefono.getText(),seleccionado, btn9.getText(),"Pendiente");
							Clinica.getInstance().ingresarCitaMedica(c);
						}
						if (btn10.isSelected()) {
							CitaMedica c = new CitaMedica(txtCodCita.getText(), dateCita.getDate(), txtNombre.getText(), txtTelefono.getText(),seleccionado, btn10.getText(),"Pendiente");
							Clinica.getInstance().ingresarCitaMedica(c);
						}
						if (btn11.isSelected()) {
							CitaMedica c = new CitaMedica(txtCodCita.getText(), dateCita.getDate(), txtNombre.getText(), txtTelefono.getText(),seleccionado, btn11.getText(),"Pendiente");
							Clinica.getInstance().ingresarCitaMedica(c);
						}
						if (btn14.isSelected()) {
							CitaMedica c = new CitaMedica(txtCodCita.getText(), dateCita.getDate(), txtNombre.getText(), txtTelefono.getText(),seleccionado, btn14.getText(),"Pendiente");
							Clinica.getInstance().ingresarCitaMedica(c);
						}
						if (btn15.isSelected()) {
							CitaMedica c = new CitaMedica(txtCodCita.getText(), dateCita.getDate(), txtNombre.getText(), txtTelefono.getText(),seleccionado, btn15.getText(),"Pendiente");
							Clinica.getInstance().ingresarCitaMedica(c);
						}
						if (btn16.isSelected()) {
							CitaMedica c = new CitaMedica(txtCodCita.getText(), dateCita.getDate(), txtNombre.getText(), txtTelefono.getText(),seleccionado, btn16.getText(),"Pendiente");
							Clinica.getInstance().ingresarCitaMedica(c);
						}
						if (btn17.isSelected()) {
							CitaMedica c = new CitaMedica(txtCodCita.getText(), dateCita.getDate(), txtNombre.getText(), txtTelefono.getText(),seleccionado, btn17.getText(),"Pendiente");
							Clinica.getInstance().ingresarCitaMedica(c);
						}
						JOptionPane.showMessageDialog(null, "Cita  Creada CORRECTAMENTE");
						limpiarCampos();
						
					
					}


				});
				btnCrear.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				btnCrear.setActionCommand("OK");
				buttonPane.add(btnCrear);
				getRootPane().setDefaultButton(btnCrear);
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
		}
		loadTable("", 1);
		limpiarCampos();
	}

	public void loadTable(String busqueda, int opcion) {
		modeloTabla.setRowCount(0);
		row = new Object[modeloTabla.getColumnCount()];
		if(opcion == 1) {
			for (int i = 0; i<Clinica.getInstance().getMisUsuarios().size(); i++) {
				if(Clinica.getInstance().getMisUsuarios().get(i) instanceof Medico) {
					Medico temp=(Medico) Clinica.getInstance().getMisUsuarios().get(i);
					row[0] = temp.getCodigoUsuario();
					row[1] = temp.getNombre();
					row[2] = temp.getApellidos();
					row[3] =temp.getEspecialidad();
				modeloTabla.addRow(row);
				}
				
			}
		}else if (opcion == 2) {
			
			for (int i = 0; i<Clinica.getInstance().getMisUsuarios().size(); i++) {
				
				if(Clinica.getInstance().getMisUsuarios().get(i) instanceof Medico) {
					Medico temp=(Medico) Clinica.getInstance().getMisUsuarios().get(i);
					
					String codigo = temp.getEspecialidad();
					
					if( codigo .equalsIgnoreCase(busqueda)) {
						row[0] = temp.getCodigoUsuario();
						row[1] = temp.getNombre();
						row[2] = temp.getApellidos();
						row[3] =temp.getEspecialidad();
					modeloTabla.addRow(row);
					}
					
					if(busqueda .equalsIgnoreCase("")) {
						row[0] = temp.getCodigoUsuario();
						row[1] = temp.getNombre();
						row[2] = temp.getApellidos();
						row[3] =temp.getEspecialidad();
					modeloTabla.addRow(row);
					}
					
				}
				
				
				
			}
			
		}
		
	}
	public void mostrarHorarioDisponible(Medico seleccionado, Date fecha) {
		boolean OchoaNueve=true;
		boolean NueveaDiez=true;
		boolean DiezaOnce=true;
		boolean OnceaDoce=true;
		boolean CatorceaQuince=true;
		boolean QuinceaDiesiceis=true;
		boolean DiesiceisaDiesisiete=true;
		boolean DiesisieteaDiesiocho=true;
		
		for (int i = 0; i<Clinica.getInstance().getCitasMedicas().size(); i++) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			
		

			if(seleccionado==Clinica.getInstance().getCitasMedicas().get(i).getMedico() && sdf.format(fecha).equals(sdf.format(Clinica.getInstance().getCitasMedicas().get(i).getFechaCita())) &&Clinica.getInstance().getCitasMedicas().get(i).getEstado().equalsIgnoreCase("Pendiente") ) {
				
				
				if(Clinica.getInstance().getCitasMedicas().get(i).getHorario().equalsIgnoreCase(btn8.getText())) {
					OchoaNueve=false;
				}
				if(Clinica.getInstance().getCitasMedicas().get(i).getHorario().equalsIgnoreCase(btn9.getText())) {
					NueveaDiez=false;
				}
				if(Clinica.getInstance().getCitasMedicas().get(i).getHorario().equalsIgnoreCase(btn10.getText())) {
					DiezaOnce=false;
				}
				if(Clinica.getInstance().getCitasMedicas().get(i).getHorario().equalsIgnoreCase(btn11.getText())) {
					OnceaDoce=false;
				}
				if(Clinica.getInstance().getCitasMedicas().get(i).getHorario().equalsIgnoreCase(btn14.getText())) {
					CatorceaQuince=false;
				}
				if(Clinica.getInstance().getCitasMedicas().get(i).getHorario().equalsIgnoreCase(btn15.getText())) {
					QuinceaDiesiceis=false;
				}
				if(Clinica.getInstance().getCitasMedicas().get(i).getHorario().equalsIgnoreCase(btn16.getText())) {
					DiesiceisaDiesisiete=false;
				}
				
				
				if(Clinica.getInstance().getCitasMedicas().get(i).getHorario().equalsIgnoreCase(btn17.getText())) {
					DiesisieteaDiesiocho=false;
				}
				
				
			}
			
		}
		if (OchoaNueve== true) {
			btn8.setEnabled(true);
		}
		if (NueveaDiez== true) {
			btn9.setEnabled(true);
		}
		if (DiezaOnce== true) {
			btn10.setEnabled(true);
		}
		if (OnceaDoce== true) {
			btn11.setEnabled(true);
		}
		if (CatorceaQuince== true) {
			btn14.setEnabled(true);
		}
		if (QuinceaDiesiceis== true) {
			btn15.setEnabled(true);
		}
		if (DiesiceisaDiesisiete== true) {
			btn16.setEnabled(true);
		}
		if (DiesisieteaDiesiocho== true) {
			btn17.setEnabled(true);
		}

		
	}
	public void limpiarCampos() {
		btn8.setEnabled(false);
		btn9.setEnabled(false);
		btn10.setEnabled(false);
		btn11.setEnabled(false);
		btn14.setEnabled(false);
		btn15.setEnabled(false);
		btn16.setEnabled(false);
		btn17.setEnabled(false);
		btn8.setSelected(false);
		btn9.setSelected(false);
		btn10.setSelected(false);
		btn11.setSelected(false);
		btn14.setSelected(false);
		btn15.setSelected(false);
		btn16.setSelected(false);
		btn17.setSelected(false);
		txtCodCita.setText("CIT"+Clinica.getInstance().getCodigocita());
		txtEspecialidad.setText("");
		txtNombre.setText("");
		txtTelefono.setText("");
		dateCita.setDate(null);
		btnDisponibles.setEnabled(false);
		loadTable("", 1);
		
		
	}
}
