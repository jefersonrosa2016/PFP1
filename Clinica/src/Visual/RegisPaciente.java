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
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class RegisPaciente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigoCliente;
	private JTextField txtnombrePaciente;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JDateChooser fechamedico;

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
			
			textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
			textField.setColumns(10);
			textField.setBounds(635, 69, 244, 30);
			panel_1.add(textField);
			
			JLabel lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblApellidos.setBounds(549, 71, 85, 26);
			panel_1.add(lblApellidos);
			
			textField_1 = new JTextField();
			textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			textField_1.setColumns(10);
			textField_1.setBounds(635, 26, 244, 30);
			panel_1.add(textField_1);
			
			JLabel lblCedula = new JLabel("Cedula:");
			lblCedula.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblCedula.setBounds(549, 28, 76, 26);
			panel_1.add(lblCedula);
			
			textField_2 = new JTextField();
			textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
			textField_2.setColumns(10);
			textField_2.setBounds(635, 112, 244, 30);
			panel_1.add(textField_2);
			
			JLabel lblTelefono = new JLabel("Telefono:");
			lblTelefono.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblTelefono.setBounds(549, 114, 85, 26);
			panel_1.add(lblTelefono);
			
			JLabel lblGenero = new JLabel("Genero:");
			lblGenero.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblGenero.setBounds(206, 114, 76, 26);
			panel_1.add(lblGenero);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Hombre", "Mujer", "Otros"}));
			comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
			comboBox.setBounds(292, 112, 244, 30);
			panel_1.add(comboBox);
			
			JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
			lblFechaDeNacimiento.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblFechaDeNacimiento.setBounds(206, 153, 200, 26);
			panel_1.add(lblFechaDeNacimiento);
			
			JLabel lblDireccion = new JLabel("Direccion:");
			lblDireccion.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblDireccion.setBounds(206, 199, 95, 26);
			panel_1.add(lblDireccion);
			
			textField_4 = new JTextField();
			textField_4.setToolTipText("");
			textField_4.setHorizontalAlignment(SwingConstants.LEFT);
			textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
			textField_4.setColumns(10);
			textField_4.setBounds(292, 198, 588, 30);
			panel_1.add(textField_4);
			
			fechamedico = new JDateChooser();
			fechamedico.setBounds(406, 155, 474, 30);
			
			
			panel_1.add(fechamedico);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
