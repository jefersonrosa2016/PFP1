package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Logico.Clinica;
import Logico.Paciente;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class Verpaciente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigoCliente;
	private JTextField txtnombrePaciente;
	private JTextField txtApellido;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JDateChooser fechamedico;
	private JTextField txtGenero;
	private JTextField txtTipoSangre;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Verpaciente dialog = new Verpaciente(null);
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
	public Verpaciente(Paciente selected) {
		setAlwaysOnTop(true);
		setTitle("Vizualizacion del Paciente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegisPaciente.class.getResource("/Imgenes/logitoventana.png")));
		setBounds(100, 100, 941, 391);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		ImageIcon pacien =new ImageIcon(getClass().getResource("/Imgenes/ImagenPacienteGrande.png"));
		Icon paci= new ImageIcon(pacien.getImage().getScaledInstance((int)158,(int)202,Image.SCALE_DEFAULT));
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion Del Paciente", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(12, 13, 892, 274);
			contentPanel.add(panel_1);
			panel_1.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBounds(12, 28, 182, 228);
			panel_1.add(panel);
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setLayout(null);
			
			JLabel Contenedorimagen = new JLabel("");
			Contenedorimagen.setBounds(12, 13, 158, 202);
			Contenedorimagen.setIcon(paci);
			panel.add(Contenedorimagen);
			
			JLabel lblCodDePaciente = new JLabel("Codigo:");
			lblCodDePaciente.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblCodDePaciente.setBounds(206, 30, 76, 26);
			panel_1.add(lblCodDePaciente);
			
			txtCodigoCliente = new JTextField();
			txtCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtCodigoCliente.setEditable(false);
			txtCodigoCliente.setColumns(10);
			txtCodigoCliente.setBounds(292, 28, 244, 30);
			panel_1.add(txtCodigoCliente);
			
			txtnombrePaciente = new JTextField();
			txtnombrePaciente.setEditable(false);
			txtnombrePaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtnombrePaciente.setColumns(10);
			txtnombrePaciente.setBounds(292, 69, 244, 30);
			panel_1.add(txtnombrePaciente);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblNombre.setBounds(206, 71, 76, 26);
			panel_1.add(lblNombre);
			
			txtApellido = new JTextField();
			txtApellido.setEditable(false);
			txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtApellido.setColumns(10);
			txtApellido.setBounds(635, 69, 244, 30);
			panel_1.add(txtApellido);
			
			JLabel lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblApellidos.setBounds(549, 71, 85, 26);
			panel_1.add(lblApellidos);
			
			txtCedula = new JTextField();
			txtCedula.setEditable(false);
			txtCedula.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtCedula.setColumns(10);
			txtCedula.setBounds(635, 26, 244, 30);
			panel_1.add(txtCedula);
			
			JLabel lblCedula = new JLabel("Cedula:");
			lblCedula.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblCedula.setBounds(549, 28, 76, 26);
			panel_1.add(lblCedula);
			
			txtTelefono = new JTextField();
			txtTelefono.setEditable(false);
			txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(635, 112, 244, 30);
			panel_1.add(txtTelefono);
			
			JLabel lblTelefono = new JLabel("Telefono:");
			lblTelefono.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblTelefono.setBounds(549, 114, 85, 26);
			panel_1.add(lblTelefono);
			
			JLabel lblGenero = new JLabel("Genero:");
			lblGenero.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblGenero.setBounds(206, 114, 76, 26);
			panel_1.add(lblGenero);
			
			JLabel lblFechaDeNacimiento = new JLabel("F. de Nacimiento:");
			lblFechaDeNacimiento.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblFechaDeNacimiento.setBounds(549, 155, 200, 26);
			panel_1.add(lblFechaDeNacimiento);
			
			JLabel lblDireccion = new JLabel("Direccion:");
			lblDireccion.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblDireccion.setBounds(206, 199, 95, 26);
			panel_1.add(lblDireccion);
			
			txtDireccion = new JTextField();
			txtDireccion.setEditable(false);
			txtDireccion.setToolTipText("");
			txtDireccion.setHorizontalAlignment(SwingConstants.LEFT);
			txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(292, 198, 588, 30);
			panel_1.add(txtDireccion);
			
			fechamedico = new JDateChooser();
			fechamedico.setEnabled(false);
			fechamedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
			fechamedico.setBounds(718, 155, 162, 30);
			
			
			panel_1.add(fechamedico);
			
			txtGenero = new JTextField();
			txtGenero.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtGenero.setEditable(false);
			txtGenero.setColumns(10);
			txtGenero.setBounds(292, 112, 244, 30);
			panel_1.add(txtGenero);
			
			JLabel label = new JLabel("Tipo de Sangre:");
			label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			label.setBounds(206, 156, 148, 26);
			panel_1.add(label);
			
			txtTipoSangre = new JTextField();
			txtTipoSangre.setText((String) null);
			txtTipoSangre.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtTipoSangre.setEditable(false);
			txtTipoSangre.setColumns(10);
			txtTipoSangre.setBounds(355, 153, 181, 30);
			panel_1.add(txtTipoSangre);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				ImageIcon i =new ImageIcon(getClass().getResource("/Imgenes/modificacion.png"));
				Icon modifica= new ImageIcon(i.getImage().getScaledInstance((int)25,(int)25,Image.SCALE_DEFAULT));
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				ImageIcon j =new ImageIcon(getClass().getResource("/Imgenes/IconoSalir.png"));
				Icon sal= new ImageIcon(j.getImage().getScaledInstance((int)25,(int)25,Image.SCALE_DEFAULT));
				cancelButton.setIcon(sal);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		cargardatospaciente(selected);
	}

	public void cargardatospaciente(Paciente selected) {
		txtApellido.setText(selected.getApellidos());
		txtCedula.setText(selected.getCedula());
		txtCodigoCliente.setText(selected.getCodigopaciente());
		txtDireccion.setText(selected.getDireccion());
		txtGenero.setText(selected.getGenero());
		txtnombrePaciente.setText(selected.getNombre());
		txtTelefono.setText(selected.getTelefono());
		txtTipoSangre.setText(selected.getTipoSangre());
		
	}
}
