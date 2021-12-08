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
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logico.Clinica;
import Logico.Paciente;
import Logico.Vacuna;



public class AgregarVacunaPaciente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnAgregar;
	private JButton cancelButton;
	private JTextField txtcedula;
	private JLabel lblNombreCliente;
	private JTextField txtTelefono;
	private JLabel lblDireccion;
	private JTextField txtDireccion;
	private JPanel panelInfo;
	private JButton btnBuscarCedula;
	private JPanel panelVacunas;
	private JPanel panel_1;
	private JPanel panel_2;
	
	private DefaultListModel<String> disponibleModel;
	private DefaultListModel<String> colocadasModel;
	private ArrayList<String> Derecha;
	private ArrayList<String> Izquierda;
	private String selected = "";

	private Paciente paciente = null;
	private JList listDisponibles;
	private JList ListaPuestas;
	private JButton HACIADERECHA;
	private JTextField txtnombre;
	private JTextField txtapellido;
	private JTextField txtGenerro;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarVacunaPaciente dialog = new AgregarVacunaPaciente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Create the dialog.
	 */
	public AgregarVacunaPaciente() {
		setResizable(false);
		setModal(true);
		
		Izquierda = new ArrayList<>();
		Derecha = new ArrayList<>();
		
		setTitle("Agregar/Remover Vacunas Paciente");
		setBounds(100, 100, 814, 649);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Paciente", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(15, 16, 774, 262);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00E9dula:");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNewLabel.setBounds(195, 34, 64, 20);
		panel.add(lblNewLabel);
		
		txtcedula = new JTextField();
		txtcedula.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtcedula.setBounds(271, 31, 244, 30);
		panel.add(txtcedula);
		txtcedula.setColumns(10);
		
		btnBuscarCedula = new JButton("Buscar");
		btnBuscarCedula.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		ImageIcon imagen =new ImageIcon(getClass().getResource("/Imgenes/BuscaIcono.png"));
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance((int)25,(int)25,Image.SCALE_DEFAULT));
		btnBuscarCedula.setIcon(icono);
		btnBuscarCedula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paciente = Clinica.getInstance().buscarPacienteByCedula(txtcedula.getText());

				if(paciente != null) {
					txtTelefono.setText(paciente.getTelefono());
					txtDireccion.setText(paciente.getDireccion());
					txtapellido.setText(paciente.getApellidos());
					txtGenerro.setText(paciente.getGenero());
					txtnombre.setText(paciente.getNombre());
					txtcedula.setEditable(false);
					JOptionPane.showMessageDialog(null, "Paciente Encontrado");
					
					Izquierda = loadDisponibles(paciente);
					
					loadIzquierdaDisponible(Izquierda);
					
					
				}
				
				if(paciente == null) {
					JOptionPane.showMessageDialog(null, "No se encontro el Paciente, proceda a ingresarlo", "Error", JOptionPane.OK_OPTION);
				}

			}
		});
		btnBuscarCedula.setBounds(527, 32, 115, 29);
		panel.add(btnBuscarCedula);
		
		panelInfo = new JPanel();
		panelInfo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelInfo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Info - Paciente", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelInfo.setBounds(25, 71, 721, 178);
		panel.add(panelInfo);
		panelInfo.setLayout(null);
		
		lblNombreCliente = new JLabel("Tel\u00E9fono:");
		lblNombreCliente.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNombreCliente.setBounds(12, 82, 96, 20);
		panelInfo.add(lblNombreCliente);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(98, 79, 244, 30);
		panelInfo.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblDireccion.setBounds(12, 124, 96, 20);
		panelInfo.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDireccion.setEditable(false);
		txtDireccion.setBounds(98, 121, 595, 30);
		panelInfo.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel label = new JLabel("Nombre:");
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		label.setBounds(12, 40, 76, 26);
		panelInfo.add(label);
		
		txtnombre = new JTextField();
		txtnombre.setEditable(false);
		txtnombre.setText("");
		txtnombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtnombre.setColumns(10);
		txtnombre.setBounds(98, 38, 244, 30);
		panelInfo.add(txtnombre);
		
		JLabel label_1 = new JLabel("Apellidos:");
		label_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		label_1.setBounds(363, 42, 85, 26);
		panelInfo.add(label_1);
		
		txtapellido = new JTextField();
		txtapellido.setEditable(false);
		txtapellido.setText("");
		txtapellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtapellido.setColumns(10);
		txtapellido.setBounds(449, 40, 244, 30);
		panelInfo.add(txtapellido);
		
		JLabel lblGnero = new JLabel("G\u00E9nero:");
		lblGnero.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblGnero.setBounds(363, 79, 76, 26);
		panelInfo.add(lblGnero);
		
		txtGenerro = new JTextField();
		txtGenerro.setEditable(false);
		txtGenerro.setText("");
		txtGenerro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtGenerro.setColumns(10);
		txtGenerro.setBounds(449, 83, 244, 30);
		panelInfo.add(txtGenerro);
		
		panelVacunas = new JPanel();
		panelVacunas.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Vacunas", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelVacunas.setBounds(15, 291, 774, 240);
		contentPanel.add(panelVacunas);
		panelVacunas.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(35, 59, 265, 165);
		panelVacunas.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		listDisponibles = new JList();
		listDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 18));
		listDisponibles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index= listDisponibles.getSelectedIndex();
				if (index !=-1) {
					selected = disponibleModel.getElementAt(index);
					HACIADERECHA.setEnabled(true);
				}
				
			}
		});
		listDisponibles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		disponibleModel = new DefaultListModel<>();
		listDisponibles.setModel(disponibleModel);
		
		scrollPane.setViewportView(listDisponibles);

		
		panel_2 = new JPanel();
		panel_2.setBounds(480, 59, 265, 165);
		panelVacunas.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1, BorderLayout.CENTER);
		
		ListaPuestas = new JList();
		ListaPuestas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ListaPuestas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		colocadasModel= new DefaultListModel<>();
		ListaPuestas.setModel(colocadasModel);
		scrollPane_1.setViewportView(ListaPuestas);
			
		JLabel lblNewLabel_1 = new JLabel("Vacunas Disponibles");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNewLabel_1.setBounds(75, 31, 184, 20);
		panelVacunas.add(lblNewLabel_1);
		
		JLabel lblPrestamos = new JLabel("Vacunas Puestas");
		lblPrestamos.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblPrestamos.setBounds(537, 31, 148, 20);
		panelVacunas.add(lblPrestamos);
		
		HACIADERECHA = new JButton(">>");
		HACIADERECHA.setEnabled(false);
		HACIADERECHA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Derecha.add(selected);
				Izquierda.remove(selected);
				disponibleModel.removeAllElements();
				for (int i = 0; i < Izquierda.size(); i++) {
					disponibleModel.addElement(Izquierda.get(i));
				}
				loadcolocadas(Derecha);
				HACIADERECHA.setEnabled(false);
				btnAgregar.setEnabled(true);
				
			}

		
		});
		HACIADERECHA.setBounds(356, 113, 64, 37);
		panelVacunas.add(HACIADERECHA);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnAgregar = new JButton("Agregar");
				btnAgregar.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				btnAgregar.setEnabled(false);
				btnAgregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if( !(txtcedula.getText().equalsIgnoreCase("")) || !(txtTelefono.getText().equalsIgnoreCase("")) 
								|| !(txtDireccion.getText().equalsIgnoreCase("")) ) {
							
							int posicionDelpaciente= Clinica.getInstance().IndiceDelPacienteByCodigo(paciente.getCodigopaciente());
							for (int i = 0; i <Derecha.size(); i++) {
								String[] splits = Derecha.get(i).split(":");
							
								Vacuna vacuna = Clinica.getInstance().buscarVacunaPorCodigo(splits[0]);
								Clinica.getInstance().getMisPacientes().get(posicionDelpaciente).getHistorial().getMisVacunas().add(vacuna);
								
							}
							
							
							
							JOptionPane.showMessageDialog(null, "Vacunas Ingresadas Correctamente");
							limpiarCampos();
						}else {
							JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
							limpiarCampos();
						}
						
					}
				});
				btnAgregar.setActionCommand("OK");
				buttonPane.add(btnAgregar);
				getRootPane().setDefaultButton(btnAgregar);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int option = JOptionPane.showConfirmDialog(null,"Realmente Desea Salir?", "Confirmar", JOptionPane.WARNING_MESSAGE);
						
						if (JOptionPane.OK_OPTION==option) {
							dispose();
						}
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		
	}
	
	


	public void limpiarCampos() {

		txtcedula.setText("");		
		txtcedula.setEditable(true);
		txtapellido.setText("");
		txtGenerro.setText("");
		txtnombre.setText("");
		txtTelefono.setText("");
		txtTelefono.setEditable(false);
		txtDireccion.setText("");
		txtDireccion.setEditable(false);
		btnBuscarCedula.setVisible(true);
		btnAgregar.setEnabled(false);
		colocadasModel.removeAllElements();
		Derecha.clear();
		disponibleModel.removeAllElements();
		Izquierda.clear();
		loadcolocadas(Derecha);
	}
		
	
	private void loadIzquierdaDisponible(ArrayList<String> izquierda) {
		disponibleModel.removeAllElements();
		for (int i = 0; i <izquierda.size(); i++) {
			disponibleModel.addElement(izquierda.get(i));
		}
		
	}
	private ArrayList<String> loadDisponibles(Paciente paciente) {
		ArrayList<String> temp = new ArrayList<>();
		disponibleModel.removeAllElements();
		if(paciente !=null) {
			if(paciente.getHistorial().getMisVacunas().size()==0) {
				for (int i = 0; i < Clinica.getInstance().getMisVacunas().size(); i++) {
					String aux = new String(Clinica.getInstance().getMisVacunas().get(i).getCodigoVacunacion()+":"+Clinica.getInstance().getMisVacunas().get(i).getNombreVacuna());
					disponibleModel.addElement(aux);
					temp.add(aux);
				}
				
			}else {
				boolean vac=true;
				for (int i = 0; i < Clinica.getInstance().getMisVacunas().size(); i++) {
					 vac=true;
						for(Vacuna v: paciente.getHistorial().getMisVacunas()) {
							if( v==Clinica.getInstance().getMisVacunas().get(i)) {
								vac=false;
								
							}
						}
						if(vac==true) {
							String aux = new String(Clinica.getInstance().getMisVacunas().get(i).getCodigoVacunacion()+":"+Clinica.getInstance().getMisVacunas().get(i).getNombreVacuna());
							disponibleModel.addElement(aux);
							temp.add(aux);
						}

									
				}
				
			}
			
		}
		
		
		return temp;
	}
	private void loadcolocadas (ArrayList<String> derecha) {
		colocadasModel.removeAllElements();
		
		for (int i = 0; i <derecha.size(); i++) {
			colocadasModel.addElement(derecha.get(i));
		}
		
	}

}
