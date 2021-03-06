package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Clinica;
import Logico.Medico;
import Logico.Paciente;

public class ListadepacientesMedico extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	
	private static DefaultTableModel modeloTabla;
	private static Object[] row;//Arreglo de objeto.
	private JTextField TxtcodBusqueda;
	private Paciente selected=null; 
	private JButton btnVisualizar_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadepacientesMedico dialog = new ListadepacientesMedico();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadepacientesMedico() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListVacunas.class.getResource("/Imgenes/logitoventana.png")));
		setTitle("Listado de Pacientes");
		setBounds(100, 100, 601, 469);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Listado Pacientes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(15, 16, 565, 358);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNewLabel.setBounds(35, 37, 86, 26);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(15, 97, 535, 245);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnVisualizar_1.setEnabled(true);
				int select = table.getSelectedRow();
				
				if(select !=-1 ) {
					selected=Clinica.getInstance().Buscarpaciente((String) table.getValueAt(select,0));
					
				}
			}
		});
		modeloTabla =  new DefaultTableModel();
		String[] columnas = {"Codigo", "Nombre","Apellidos","Cedula","Telefono"};
		modeloTabla.setColumnIdentifiers(columnas);
		table.setModel(modeloTabla);
		
		scrollPane.setViewportView(table);
		
		TxtcodBusqueda = new JTextField();
		TxtcodBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 18));
		TxtcodBusqueda.setBounds(133, 35, 244, 30);
		panel.add(TxtcodBusqueda);
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
		btnNewButton.setBounds(404, 38, 116, 25);
		panel.add(btnNewButton);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				loadTable("", 1);
				ImageIcon j =new ImageIcon(getClass().getResource("/Imgenes/IconoSalir.png"));
				Icon sal= new ImageIcon(j.getImage().getScaledInstance((int)25,(int)25,Image.SCALE_DEFAULT));
				ImageIcon i =new ImageIcon(getClass().getResource("/Imgenes/visualizarIcono.png"));
				Icon ver= new ImageIcon(i.getImage().getScaledInstance((int)25,(int)25,Image.SCALE_DEFAULT));
				btnVisualizar_1 = new JButton("Visualizar");
				btnVisualizar_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						VistadelPacienteMedico vi = new VistadelPacienteMedico(selected);
						System.out.println(selected.getCodigopaciente());
						dispose();
						vi.setVisible(true);
						
						
					}
				});
				
				JButton btnNewButton_1 = new JButton("A\u00F1adir");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegisPaciente paci= new RegisPaciente();
						dispose();
						paci.setVisible(true);
					}
				});
				btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				buttonPane.add(btnNewButton_1);
				btnVisualizar_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				btnVisualizar_1.setIcon(ver);
				btnVisualizar_1.setEnabled(false);
				buttonPane.add(btnVisualizar_1);
				cancelButton.setIcon(sal);
				cancelButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}
	
	public void loadTable(String busqueda, int opcion) {
		modeloTabla.setRowCount(0);
		row = new Object[modeloTabla.getColumnCount()];
		if(opcion == 1) {
			for (int i = 0; i<Clinica.getInstance().getMisPacientes().size(); i++) {
				row[0] = Clinica.getInstance().getMisPacientes().get(i).getCodigopaciente();
				row[1] = Clinica.getInstance().getMisPacientes().get(i).getNombre();
				row[2] = Clinica.getInstance().getMisPacientes().get(i).getApellidos();
				row[3] = Clinica.getInstance().getMisPacientes().get(i).getCedula();
				row[4] = Clinica.getInstance().getMisPacientes().get(i).getTelefono();
			modeloTabla.addRow(row);
			}
		}else if (opcion == 2) {
			
			for (int i = 0; i<Clinica.getInstance().getMisPacientes().size(); i++) {
				String codigo = Clinica.getInstance().getMisPacientes().get(i).getNombre();
				if( codigo .equalsIgnoreCase(busqueda)) {
					row[0] = Clinica.getInstance().getMisPacientes().get(i).getCodigopaciente();
					row[1] = Clinica.getInstance().getMisPacientes().get(i).getNombre();
					row[2] = Clinica.getInstance().getMisPacientes().get(i).getApellidos();
					row[3] = Clinica.getInstance().getMisPacientes().get(i).getCedula();
					row[4] = Clinica.getInstance().getMisPacientes().get(i).getTelefono();
					modeloTabla.addRow(row);
				}else if(busqueda .equalsIgnoreCase("")) {
					row[0] = Clinica.getInstance().getMisPacientes().get(i).getCodigopaciente();
					row[1] = Clinica.getInstance().getMisPacientes().get(i).getNombre();
					row[2] = Clinica.getInstance().getMisPacientes().get(i).getApellidos();
					row[3] = Clinica.getInstance().getMisPacientes().get(i).getCedula();
					row[4] = Clinica.getInstance().getMisPacientes().get(i).getTelefono();
				modeloTabla.addRow(row);
				}
			}
			
		}
		
	}
}
