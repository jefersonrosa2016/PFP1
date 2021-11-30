package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class RegistrarUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JRadioButton btnAdmins;
	private JRadioButton btnMedico;
	private JLabel lblCodUsuario;
	private JTextField textField;
	private JLabel label_1;
	private JTextField textField_1;
	private JLabel lblUsername;
	private JTextField textField_2;
	private JLabel lblPassword;
	private JTextField textField_3;
	private JLabel lblTelef;
	private JTextField textField_4;
	private JLabel lblPuesto;
	private JLabel lblMed;
	private JTextField txtPuesto;
	private JTextField txtEspecialidad;
	private JLabel imagendemedico;
	private JLabel imagendeadmin;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarUsuario.class.getResource("/Imgenes/logitoventana.png")));
		setBounds(100, 100, 794, 437);
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
			panel.setBounds(10, 226, 758, 128);
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
				btnAdmins.setBounds(16, 23, 147, 23);
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
				btnMedico.setBounds(368, 23, 109, 23);
				panel.add(btnMedico);
			}
			{
				{
					{
						lblPuesto = new JLabel("Puesto");
						lblPuesto.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
						lblPuesto.setBounds(16, 55, 55, 26);
						panel.add(lblPuesto);
					}
					{
						txtPuesto = new JTextField();
						txtPuesto.setFont(new Font("Tahoma", Font.PLAIN, 18));
						txtPuesto.setColumns(10);
						txtPuesto.setBounds(81, 53, 244, 30);
						panel.add(txtPuesto);
					}
					{
						lblMed = new JLabel("Especialidad");
						lblMed.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
						lblMed.setBounds(368, 55, 114, 26);
						panel.add(lblMed);
					}
					{
						txtEspecialidad = new JTextField();
						txtEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
						txtEspecialidad.setColumns(10);
						txtEspecialidad.setBounds(487, 53, 244, 30);
						panel.add(txtEspecialidad);
					}
				}
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setForeground(Color.GRAY);
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion de Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 758, 212);
			contentPanel.add(panel);
			{
				lblCodUsuario = new JLabel("Codigo:");
				lblCodUsuario.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblCodUsuario.setBounds(350, 21, 76, 26);
				panel.add(lblCodUsuario);
			}
			{
				textField = new JTextField();
				textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
				textField.setColumns(10);
				textField.setBounds(482, 21, 244, 30);
				panel.add(textField);
			}
			{
				label_1 = new JLabel("Nombre:");
				label_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				label_1.setBounds(350, 60, 76, 26);
				panel.add(label_1);
			}
			{
				textField_1 = new JTextField();
				textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
				textField_1.setColumns(10);
				textField_1.setBounds(482, 60, 244, 30);
				panel.add(textField_1);
			}
			{
				lblUsername = new JLabel("Username:");
				lblUsername.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblUsername.setBounds(350, 99, 122, 26);
				panel.add(lblUsername);
			}
			{
				textField_2 = new JTextField();
				textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
				textField_2.setColumns(10);
				textField_2.setBounds(482, 99, 244, 30);
				panel.add(textField_2);
			}
			{
				lblPassword = new JLabel("Password:");
				lblPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblPassword.setBounds(350, 138, 122, 26);
				panel.add(lblPassword);
			}
			{
				textField_3 = new JTextField();
				textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
				textField_3.setColumns(10);
				textField_3.setBounds(482, 138, 244, 30);
				panel.add(textField_3);
			}
			{
				lblTelef = new JLabel("Telef.:");
				lblTelef.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblTelef.setBounds(350, 177, 76, 26);
				panel.add(lblTelef);
			}
			{
				textField_4 = new JTextField();
				textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
				textField_4.setColumns(10);
				textField_4.setBounds(482, 177, 244, 30);
				panel.add(textField_4);
			}
			{
				imagendemedico = new JLabel("");
				imagendemedico.setBounds(84, 21, 181, 174);
				ImageIcon medico =new ImageIcon(getClass().getResource("/Imgenes/iconoMedico.png"));
				Icon medi= new ImageIcon(medico.getImage().getScaledInstance((int)181,(int)174,Image.SCALE_DEFAULT));
				imagendemedico.setIcon(medi);
				panel.add(imagendemedico);
			}
			{
				imagendeadmin = new JLabel("");
				imagendeadmin.setBounds(84, 21, 181, 174);
				panel.add(imagendeadmin);
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
