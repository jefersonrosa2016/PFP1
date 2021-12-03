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
import java.text.SimpleDateFormat;

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

import Logico.CitaMedica;
import Logico.Clinica;


public class ListCitas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	
	private static DefaultTableModel modeloTabla;
	private static Object[] row;//Arreglo de objeto.
	private JTextField TxtcodBusqueda;
	private CitaMedica selected=null; 
	private JButton btnVisualizar_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListCitas dialog = new ListCitas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListCitas() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListVacunas.class.getResource("/Imgenes/logitoventana.png")));
		setTitle("Listado de Citas");
		setBounds(100, 100, 601, 469);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Listado Citas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(15, 16, 565, 358);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cod. Cita:");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNewLabel.setBounds(33, 37, 98, 26);
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
					selected=Clinica.getInstance().buscarCitaPorCodigo((String) table.getValueAt(select,0));
				}
			}
		});
		modeloTabla =  new DefaultTableModel();
		String[] columnas = {"Codigo", "Nombre","Fecha","Horario","Estado","Medico"};
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
						VerCita elOella = new VerCita(selected);
						
						dispose();
						elOella.setVisible(true);
					}
				});
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
			for (int i = 0; i<Clinica.getInstance().getCitasMedicas().size(); i++) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				sdf.format(Clinica.getInstance().getCitasMedicas().get(i).getFechaCita());
				String fecha =sdf.format(Clinica.getInstance().getCitasMedicas().get(i).getFechaCita());
				row[0] = Clinica.getInstance().getCitasMedicas().get(i).getCodigoCita();
				row[1] = Clinica.getInstance().getCitasMedicas().get(i).getNombrePersona();
				row[2] = fecha;
				row[3] = Clinica.getInstance().getCitasMedicas().get(i).getHorario();
				row[4] = Clinica.getInstance().getCitasMedicas().get(i).getEstado();
				row[5] = Clinica.getInstance().getCitasMedicas().get(i).getMedico().getNombre();
			modeloTabla.addRow(row);
			}
		}else if (opcion == 2) {
			
			for (int i = 0; i<Clinica.getInstance().getCitasMedicas().size(); i++) {
				String codigo = Clinica.getInstance().getCitasMedicas().get(i).getCodigoCita();
				if( codigo .equalsIgnoreCase(busqueda)) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					String fecha =sdf.format(Clinica.getInstance().getCitasMedicas().get(i).getFechaCita());
					row[0] = Clinica.getInstance().getCitasMedicas().get(i).getCodigoCita();
					row[1] = Clinica.getInstance().getCitasMedicas().get(i).getNombrePersona();
					row[2] = fecha;
					row[3] = Clinica.getInstance().getCitasMedicas().get(i).getHorario();
					row[4] = Clinica.getInstance().getCitasMedicas().get(i).getEstado();
					row[5] = Clinica.getInstance().getCitasMedicas().get(i).getMedico().getNombre();
				modeloTabla.addRow(row);
				}else if(busqueda .equalsIgnoreCase("")) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					sdf.format(Clinica.getInstance().getCitasMedicas().get(i).getFechaCita());
					String fecha =sdf.format(Clinica.getInstance().getCitasMedicas().get(i).getFechaCita());
					row[0] = Clinica.getInstance().getCitasMedicas().get(i).getCodigoCita();
					row[1] = Clinica.getInstance().getCitasMedicas().get(i).getNombrePersona();
					row[2] = fecha;
					row[3] = Clinica.getInstance().getCitasMedicas().get(i).getHorario();
					row[4] = Clinica.getInstance().getCitasMedicas().get(i).getEstado();
					row[5] = Clinica.getInstance().getCitasMedicas().get(i).getMedico().getNombre();
				modeloTabla.addRow(row);
				}
			}
			
		}
		
	}
}