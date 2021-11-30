package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Clinica;
import javax.swing.UIManager;
import java.awt.Color;

public class ListPacientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tblListadoVacunas;
	
	private static DefaultTableModel modeloTabla;
	private static Object[] row;//Arreglo de objeto.
	private JTextField TxtcodBusqueda;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListPacientes dialog = new ListPacientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListPacientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListVacunas.class.getResource("/Imgenes/logitoventana.png")));
		setResizable(false);
		setModal(true);
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
		lblNewLabel.setBounds(23, 36, 164, 26);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(15, 97, 535, 245);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		tblListadoVacunas = new JTable();
		tblListadoVacunas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modeloTabla =  new DefaultTableModel();
		String[] columnas = {"Codigo", "Nombre"};
		modeloTabla.setColumnIdentifiers(columnas);
		tblListadoVacunas.setModel(modeloTabla);
		
		scrollPane.setViewportView(tblListadoVacunas);
		
		TxtcodBusqueda = new JTextField();
		TxtcodBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 18));
		TxtcodBusqueda.setBounds(199, 39, 189, 25);
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
		btnNewButton.setBounds(410, 39, 116, 25);
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
				ImageIcon j =new ImageIcon(getClass().getResource("/Imgenes/IconoSalir.png"));
				Icon sal= new ImageIcon(j.getImage().getScaledInstance((int)25,(int)25,Image.SCALE_DEFAULT));
				cancelButton.setIcon(sal);
				cancelButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadTable("", 1);
	}
	
	public void loadTable(String busqueda, int opcion) {
		modeloTabla.setRowCount(0);
		row = new Object[modeloTabla.getColumnCount()];
		if(opcion == 1) {
			for (int i = 0; i<Clinica.getInstance().getMisVacunas().size(); i++) {
				row[0] = Clinica.getInstance().getMisVacunas().get(i).getCodigoVacunacion();
				row[1] = Clinica.getInstance().getMisVacunas().get(i).getNombreVacuna();
			modeloTabla.addRow(row);
			}
		}else if (opcion == 2) {
			
			for (int i = 0; i<Clinica.getInstance().getMisVacunas().size(); i++) {
				String codigo = Clinica.getInstance().getMisVacunas().get(i).getCodigoVacunacion();
				if( codigo .equalsIgnoreCase(busqueda)) {
					row[0] = Clinica.getInstance().getMisVacunas().get(i).getCodigoVacunacion();
					row[1] = Clinica.getInstance().getMisVacunas().get(i).getNombreVacuna();
					modeloTabla.addRow(row);
				}else if(busqueda .equalsIgnoreCase("")) {
					row[0] = Clinica.getInstance().getMisVacunas().get(i).getCodigoVacunacion();
					row[1] = Clinica.getInstance().getMisVacunas().get(i).getNombreVacuna();
				modeloTabla.addRow(row);
				}
			}
			
		}
		
	}

}
