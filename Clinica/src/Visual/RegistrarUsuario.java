package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCodUsua;
	private JTextField textUsern;
	private JTextField textPassw;
	private JTextField textNombre;
	private JTextField textTelef;
	private JTextField txtEspecialidad;
	private JLabel lblMed;
	private JLabel lblPuesto;
	private JTextField txtPuesto;
	private JRadioButton btnAdmins;
	private JRadioButton btnMedico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarUsuario dialog = new RegistrarUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarUsuario() {
		setBounds(100, 100, 579, 427);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setForeground(Color.LIGHT_GRAY);
			panel.setLayout(null);
			panel.setToolTipText("");
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo de Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(16, 217, 497, 135);
			contentPanel.add(panel);
			{
				btnAdmins = new JRadioButton("Administrador");
				btnAdmins.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(btnAdmins.isSelected()) {
							lblMed.setVisible(false);	
							txtEspecialidad.setVisible(false);
							lblPuesto.setVisible(true);
							txtPuesto.setVisible(true);
							btnMedico.setSelected(false);
							}
					}
				});
				btnAdmins.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				btnAdmins.setBounds(6, 23, 147, 23);
				panel.add(btnAdmins);
			}
			{
				btnMedico = new JRadioButton("Medico");
				btnMedico.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(btnMedico.isSelected()) {
						lblMed.setVisible(true);	
						txtEspecialidad.setVisible(true);
						lblPuesto.setVisible(false);
						txtPuesto.setVisible(false);
						btnAdmins.setSelected(false);
						}
					}
				});
				btnMedico.setSelected(true);
				btnMedico.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				btnMedico.setBounds(228, 23, 109, 23);
				panel.add(btnMedico);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setForeground(Color.GRAY);
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion de Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 543, 201);
			contentPanel.add(panel);
			{
				JLabel lblCodigoDeUsuario = new JLabel("Cod. Usuario");
				lblCodigoDeUsuario.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblCodigoDeUsuario.setBounds(20, 24, 111, 26);
				panel.add(lblCodigoDeUsuario);
			}
			{
				textCodUsua = new JTextField();
				textCodUsua.setColumns(10);
				textCodUsua.setBounds(141, 27, 165, 23);
				panel.add(textCodUsua);
			}
			{
				JLabel labelUserna = new JLabel("Username");
				labelUserna.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				labelUserna.setBounds(20, 89, 111, 26);
				panel.add(labelUserna);
			}
			{
				textUsern = new JTextField();
				textUsern.setColumns(10);
				textUsern.setBounds(141, 92, 165, 23);
				panel.add(textUsern);
			}
			{
				JLabel labelPass = new JLabel("Password");
				labelPass.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				labelPass.setBounds(20, 127, 86, 23);
				panel.add(labelPass);
			}
			{
				textPassw = new JTextField();
				textPassw.setColumns(10);
				textPassw.setBounds(142, 127, 165, 23);
				panel.add(textPassw);
			}
			{
				textNombre = new JTextField();
				textNombre.setColumns(10);
				textNombre.setBounds(141, 62, 165, 23);
				panel.add(textNombre);
			}
			{
				JLabel lblNombre = new JLabel("Nombre");
				lblNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblNombre.setBounds(20, 68, 84, 17);
				panel.add(lblNombre);
			}
			{
				JLabel lblTelef = new JLabel("Telef.");
				lblTelef.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblTelef.setBounds(20, 158, 75, 23);
				panel.add(lblTelef);
			}
			{
				textTelef = new JTextField();
				textTelef.setBounds(141, 161, 165, 23);
				panel.add(textTelef);
				textTelef.setColumns(10);
			}
			
			lblMed = new JLabel("Especialidad");
			lblMed.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblMed.setBounds(326, 89, 111, 26);
			panel.add(lblMed);
			
			txtEspecialidad = new JTextField();
			txtEspecialidad.setBounds(439, 95, 94, 20);
			panel.add(txtEspecialidad);
			txtEspecialidad.setColumns(10);
			{
				lblPuesto = new JLabel("Puesto");
				lblPuesto.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblPuesto.setBounds(316, 24, 86, 26);
				lblPuesto.setVisible(false);
				panel.add(lblPuesto);
			}
			{
				txtPuesto = new JTextField();
				txtPuesto.setColumns(10);
				txtPuesto.setBounds(397, 30, 94, 20);
				txtPuesto.setVisible(false);
				panel.add(txtPuesto);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
