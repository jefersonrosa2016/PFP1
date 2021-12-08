package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Clinica;
import Logico.Enfermedad;

public class ListEnferme extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JRadioButton btnCodigo;
	private JPanel panelNombre;
	private JPanel panelTipo;
	private JPanel panelCodigo;
	private JTextField txtCod;
	private JTextField txtNombre;
	private JButton btnBuscarNombre;
	private JButton btnBuscarCod;
	private JComboBox cbxTipo;
	private JRadioButton btnNombre;
	private JRadioButton btnTipo;
	private JTable tableEnfermedades;
	public static Enfermedad seleccionada=null;
	
	private static DefaultTableModel modeloTabla;
	private static Object[] row;//Arreglo de objeto.
	
	
	
	
	private JEditorPane txtDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListEnferme dialog = new ListEnferme();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListEnferme() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(SeleccionarEnfermedad.class.getResource("/Imgenes/logitoventana.png")));
		setBounds(100, 100, 830, 525);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Tipo de Filtro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(12, 13, 400, 60);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				btnCodigo = new JRadioButton("C\u00F3digo");
				btnCodigo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnNombre.setSelected(false);
						btnTipo.setSelected(false);
						panelCodigo.setVisible(true);
						panelNombre.setVisible(false);
						panelTipo.setVisible(false);
						loadTable("",1);
						limpiardatos();

					}
				});
				btnCodigo.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				btnCodigo.setBounds(43, 17, 77, 25);
				panel.add(btnCodigo);
			}
			{
				btnNombre = new JRadioButton("Nombre");
				btnNombre.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnCodigo.setSelected(false);
						btnTipo.setSelected(false);
						panelCodigo.setVisible(false);
						panelNombre.setVisible(true);
						panelTipo.setVisible(false);
						loadTable("",1);
						limpiardatos();

						
					}
				});
				btnNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				btnNombre.setBounds(163, 17, 87, 25);
				panel.add(btnNombre);
			}
			{
				btnTipo = new JRadioButton("Tipo");
				btnTipo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnNombre.setSelected(false);
						btnCodigo.setSelected(false);
						panelCodigo.setVisible(false);
						panelNombre.setVisible(false);
						panelTipo.setVisible(true);
						loadTable("",1);
						limpiardatos();

					}
				});
				btnTipo.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				btnTipo.setBounds(293, 17, 61, 25);
				panel.add(btnTipo);
			}
		}
		{
			panelCodigo = new JPanel();
			panelCodigo.setVisible(false);
			panelCodigo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelCodigo.setBounds(12, 86, 400, 60);
			contentPanel.add(panelCodigo);
			panelCodigo.setLayout(null);
			{
				txtCod = new JTextField();
				txtCod.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtCod.setColumns(10);
				txtCod.setBounds(12, 13, 244, 30);
				panelCodigo.add(txtCod);
			}
			{
				btnBuscarCod = new JButton("Buscar");
				btnBuscarCod.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						loadTable(txtCod.getText(),2);
						

					}
				});
				btnBuscarCod.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				btnBuscarCod.setBounds(276, 15, 97, 25);
				panelCodigo.add(btnBuscarCod);
			}
		}
		{
			panelTipo = new JPanel();
			panelTipo.setVisible(false);
			panelTipo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelTipo.setBounds(12, 86, 400, 60);
			contentPanel.add(panelTipo);
			panelTipo.setLayout(null);
			
			cbxTipo = new JComboBox();
			cbxTipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (cbxTipo.getSelectedIndex()!=0) {
						loadTable((String) cbxTipo.getSelectedItem(),3);
					}
				
				}
			});
			cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccione>>", "Al\u00E9rgicas", "Autoinmunes", "Carenciales o nutricionales", "Cardiovasculares", "C\u00E1ncer", "Cong\u00E9nitas", "Degenerativas", "Endocrinas", "Gen\u00E9ticas", "Intoxicaciones ", "Infecciones", "Parasitarias"}));
			cbxTipo.setSelectedIndex(0);
			cbxTipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
			cbxTipo.setBounds(78, 15, 244, 30);
			panelTipo.add(cbxTipo);
		}
		{
			panelNombre = new JPanel();
			panelNombre.setVisible(false);
			panelNombre.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelNombre.setBounds(12, 86, 400, 60);
			contentPanel.add(panelNombre);
			panelNombre.setLayout(null);
			{
				txtNombre = new JTextField();
				txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtNombre.setColumns(10);
				txtNombre.setBounds(12, 13, 244, 30);
				panelNombre.add(txtNombre);
			}
			{
				btnBuscarNombre = new JButton("Buscar");
				btnBuscarNombre.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						loadTable(txtNombre.getText(),4);
						limpiardatos();

					}
				});
				btnBuscarNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				btnBuscarNombre.setBounds(276, 15, 97, 25);
				panelNombre.add(btnBuscarNombre);
			}
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 86, 400, 60);
		contentPanel.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Lista Enfermedades", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 159, 400, 274);
		contentPanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		tableEnfermedades = new JTable();
		tableEnfermedades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int select= tableEnfermedades.getSelectedRow();
				if(select !=-1 ) {
					seleccionada= Clinica.getInstance().buscarEnfermedadPorCodigo((String) tableEnfermedades.getValueAt(select,0));
					cargardatos(seleccionada);

				}
				
			}

			
		});
		modeloTabla =  new DefaultTableModel();
		String[] columnas = {"Codigo", "Nombre","Tipo"};
		modeloTabla.setColumnIdentifiers(columnas);
		tableEnfermedades.setModel(modeloTabla);
		scrollPane.setViewportView(tableEnfermedades);
		
		
		scrollPane.setViewportView(tableEnfermedades);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Descripci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(424, 13, 370, 417);
		contentPanel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1, BorderLayout.CENTER);
		
		txtDescripcion = new JEditorPane();
		txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDescripcion.setForeground(new Color(0, 0, 0));
		txtDescripcion.setEnabled(false);
		scrollPane_1.setViewportView(txtDescripcion);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadTable("",1);
	}
	public void loadTable(String busqueda,int opcion) {
		modeloTabla.setRowCount(0);
		row = new Object[modeloTabla.getColumnCount()];
		if(opcion == 1) {
			for (int i = 0; i<Clinica.getInstance().getMisEnfermedades().size(); i++) {
				row[0] = Clinica.getInstance().getMisEnfermedades().get(i).getCodigoEnfermedad();
				row[1] = Clinica.getInstance().getMisEnfermedades().get(i).getNombreEnfermedad();
				row[2] = Clinica.getInstance().getMisEnfermedades().get(i).getTipoEnfermedad();
			modeloTabla.addRow(row);
			}
		}else if (opcion == 2) {
			
			for (int i = 0; i<Clinica.getInstance().getMisEnfermedades().size(); i++) {
				String codigo = Clinica.getInstance().getMisEnfermedades().get(i).getCodigoEnfermedad();
				if( codigo .equalsIgnoreCase(busqueda)) {
					row[0] = Clinica.getInstance().getMisEnfermedades().get(i).getCodigoEnfermedad();
					row[1] = Clinica.getInstance().getMisEnfermedades().get(i).getNombreEnfermedad();
					row[2] = Clinica.getInstance().getMisEnfermedades().get(i).getTipoEnfermedad();
				modeloTabla.addRow(row);
				}else if(busqueda .equalsIgnoreCase("")) {
					row[0] = Clinica.getInstance().getMisEnfermedades().get(i).getCodigoEnfermedad();
					row[1] = Clinica.getInstance().getMisEnfermedades().get(i).getNombreEnfermedad();
					row[2] = Clinica.getInstance().getMisEnfermedades().get(i).getTipoEnfermedad();
				modeloTabla.addRow(row);
				}
			}
			
		}else if (opcion == 3) {
			for (int i = 0; i<Clinica.getInstance().getMisEnfermedades().size(); i++) {
				String codigo = Clinica.getInstance().getMisEnfermedades().get(i).getTipoEnfermedad();
				if( codigo .equalsIgnoreCase(busqueda)) {
					row[0] = Clinica.getInstance().getMisEnfermedades().get(i).getCodigoEnfermedad();
					row[1] = Clinica.getInstance().getMisEnfermedades().get(i).getNombreEnfermedad();
					row[2] = Clinica.getInstance().getMisEnfermedades().get(i).getTipoEnfermedad();
				modeloTabla.addRow(row);
				}else if(busqueda .equalsIgnoreCase("")) {
					row[0] = Clinica.getInstance().getMisEnfermedades().get(i).getCodigoEnfermedad();
					row[1] = Clinica.getInstance().getMisEnfermedades().get(i).getNombreEnfermedad();
					row[2] = Clinica.getInstance().getMisEnfermedades().get(i).getTipoEnfermedad();
				modeloTabla.addRow(row);
				}
			}
			
			
		}else if (opcion == 4) {
			for (int i = 0; i<Clinica.getInstance().getMisEnfermedades().size(); i++) {
				String codigo = Clinica.getInstance().getMisEnfermedades().get(i).getNombreEnfermedad();
				if( codigo .equalsIgnoreCase(busqueda)) {
					row[0] = Clinica.getInstance().getMisEnfermedades().get(i).getCodigoEnfermedad();
					row[1] = Clinica.getInstance().getMisEnfermedades().get(i).getNombreEnfermedad();
					row[2] = Clinica.getInstance().getMisEnfermedades().get(i).getTipoEnfermedad();
				modeloTabla.addRow(row);
				}else if(busqueda .equalsIgnoreCase("")) {
					row[0] = Clinica.getInstance().getMisEnfermedades().get(i).getCodigoEnfermedad();
					row[1] = Clinica.getInstance().getMisEnfermedades().get(i).getNombreEnfermedad();
					row[2] = Clinica.getInstance().getMisEnfermedades().get(i).getTipoEnfermedad();
				modeloTabla.addRow(row);
				}
			}
			
			
		}
		
		
	}
	public void cargardatos(Enfermedad selec) {
		txtDescripcion.setText(selec.getDescripcionEnfermedad());
		
	}
	public void limpiardatos() {
		txtDescripcion.setText("");
		txtCod.setText("");
		txtNombre.setText("");
		cbxTipo.setSelectedIndex(0);
		
	}
}
