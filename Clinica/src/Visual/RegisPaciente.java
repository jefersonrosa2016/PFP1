package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import Logico.Clinica;
import Logico.Paciente;

import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class RegisPaciente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigoCliente;
	private JTextField txtnombrePaciente;
	private JTextField txtApellido;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JDateChooser fechamedico;
	private JComboBox cbxGenero;
	private JComboBox cbxTipoSangre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegisPaciente dialog = new RegisPaciente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegisPaciente() {
		
		setTitle("Registrar Paciente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegisPaciente.class.getResource("/Imgenes/logitoventana.png")));
		setBounds(100, 100, 941, 386);
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
			txtnombrePaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtnombrePaciente.setColumns(10);
			txtnombrePaciente.setBounds(292, 69, 244, 30);
			panel_1.add(txtnombrePaciente);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblNombre.setBounds(206, 71, 76, 26);
			panel_1.add(lblNombre);
			
			txtApellido = new JTextField();
			txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtApellido.setColumns(10);
			txtApellido.setBounds(635, 69, 244, 30);
			panel_1.add(txtApellido);
			
			JLabel lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblApellidos.setBounds(549, 71, 85, 26);
			panel_1.add(lblApellidos);
			
			txtCedula = new JTextField();
			txtCedula.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtCedula.setColumns(10);
			txtCedula.setBounds(635, 26, 244, 30);
			panel_1.add(txtCedula);
			
			JLabel lblCedula = new JLabel("Cedula:");
			lblCedula.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblCedula.setBounds(549, 28, 76, 26);
			panel_1.add(lblCedula);
			
			txtTelefono = new JTextField();
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
			
			cbxGenero = new JComboBox();
			cbxGenero.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccione>>", "Hombre", "Mujer"}));
			cbxGenero.setFont(new Font("Tahoma", Font.PLAIN, 18));
			cbxGenero.setBounds(292, 112, 244, 30);
			panel_1.add(cbxGenero);
			
			JLabel lblDireccion = new JLabel("Direccion:");
			lblDireccion.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblDireccion.setBounds(206, 199, 95, 26);
			panel_1.add(lblDireccion);
			
			txtDireccion = new JTextField();
			txtDireccion.setToolTipText("");
			txtDireccion.setHorizontalAlignment(SwingConstants.LEFT);
			txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(292, 198, 588, 30);
			panel_1.add(txtDireccion);
			
			fechamedico = new JDateChooser();
			fechamedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
			fechamedico.setBounds(719, 155, 161, 30);
			
			
			panel_1.add(fechamedico);
			
			cbxTipoSangre = new JComboBox();
			cbxTipoSangre.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccione>>", "A-", "A+", "B-", "B+", "AB-", "AB+", "O-", "O+"}));
			cbxTipoSangre.setFont(new Font("Tahoma", Font.PLAIN, 18));
			cbxTipoSangre.setBounds(355, 156, 181, 30);
			panel_1.add(cbxTipoSangre);
			
			JLabel label = new JLabel("Tipo de Sangre:");
			label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			label.setBounds(206, 159, 148, 26);
			panel_1.add(label);
			
			JLabel label_1 = new JLabel("F. de Nacimiento:");
			label_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			label_1.setBounds(549, 155, 158, 26);
			panel_1.add(label_1);
			limpiarCampos();
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				ImageIcon i =new ImageIcon(getClass().getResource("/Imgenes/iconoGuardar.png"));
				Icon guarda= new ImageIcon(i.getImage().getScaledInstance((int)25,(int)25,Image.SCALE_DEFAULT));
				okButton.setIcon(guarda);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Paciente aux= new Paciente(txtCedula.getText(), txtnombrePaciente.getText(),(String) cbxGenero.getSelectedItem(), txtDireccion.getText(), txtTelefono.getText(),""+ Clinica.getInstance().getCodigoHistorialclinico(), txtCodigoCliente.getText(), txtApellido.getText(),fechamedico.getDate(),(String) cbxTipoSangre.getSelectedItem());
						Clinica.getInstance().ingresarPaciente(aux);
						JOptionPane.showMessageDialog(null, "Paciente Ingresado CORRECTAMENTE");
						limpiarCampos();
					}
				});
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
				ImageIcon j =new ImageIcon(getClass().getResource("/Imgenes/IconoSalir.png"));
				Icon sal= new ImageIcon(j.getImage().getScaledInstance((int)25,(int)25,Image.SCALE_DEFAULT));
				cancelButton.setIcon(sal);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private void limpiarCampos() {
		txtCodigoCliente.setText("PAC"+ Clinica.getInstance().getCodigopaciente());
		txtnombrePaciente.setText("");
		txtApellido.setText("");
		txtCedula.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		fechamedico.setDate(null);
		cbxGenero.setSelectedIndex(0);
		cbxTipoSangre.setSelectedIndex(0);
	}
}
