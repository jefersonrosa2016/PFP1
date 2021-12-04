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

import Logico.Administrador;
import Logico.Clinica;
import Logico.Medico;
import Logico.Paciente;
import Logico.Usuario;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class RegistrarUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JRadioButton btnAdmins;
	private JRadioButton btnMedico;
	private JLabel lblCodUsuario;
	private JTextField txtCodigo;
	private JLabel lblnombre;
	private JTextField txtnombre;
	private JLabel lblUsername;
	private JTextField txtusername;
	private JLabel lblPassword;
	private JTextField txtpassword;
	private JLabel lblTelef;
	private JTextField txttelef;
	private JLabel lblMed;
	private JTextField txtEspecialidad;
	private JLabel imagendemedico;
	private JLabel imagendeadmin;
	private JPanel panel_1;
	private JLabel lblApellidos;
	private JTextField txtapellidos;
	private JTextField txtPuesto;
	private JLabel puesto;
	private JRadioButton btnSecretaria;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public RegistrarUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarUsuario.class.getResource("/Imgenes/logitoventana.png")));


	setBounds(100, 100, 879, 515);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setForeground(Color.LIGHT_GRAY);
			panel.setLayout(null);
			panel.setToolTipText("");
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo de Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(12, 287, 648, 53);
			contentPanel.add(panel);
			{
				btnAdmins = new JRadioButton("Administrador");
				btnAdmins.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(btnAdmins.isSelected()) {
							lblMed.setVisible(false);	
							txtEspecialidad.setVisible(false);
							btnMedico.setSelected(false);
							txtPuesto.setVisible(true);
							puesto.setVisible(true);
							ImageIcon admins =new ImageIcon(getClass().getResource("/Imgenes/iconoAdmin.png"));
							Icon adminst= new ImageIcon(admins.getImage().getScaledInstance((int)211,(int)215,Image.SCALE_DEFAULT));
							imagendemedico.setIcon(adminst);
							}
					}
				});
				btnAdmins.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				btnAdmins.setBounds(343, 23, 166, 23);
				panel.add(btnAdmins);
			}
			{
				btnMedico = new JRadioButton("Medico");
				btnMedico.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(btnMedico.isSelected()) {
						lblMed.setVisible(true);	
						txtEspecialidad.setVisible(true);
						btnAdmins.setSelected(false);
						txtPuesto.setVisible(false);
						puesto.setVisible(false);
						ImageIcon medico =new ImageIcon(getClass().getResource("/Imgenes/iconoMedico.png"));
						Icon medi= new ImageIcon(medico.getImage().getScaledInstance((int)211,(int)215,Image.SCALE_DEFAULT));
						imagendemedico.setIcon(medi);
						}
					}
					
				});
				btnMedico.setSelected(true);
				btnMedico.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				btnMedico.setBounds(63, 23, 109, 23);
				panel.add(btnMedico);
			}
			
			btnSecretaria = new JRadioButton("Secretaria");
			btnSecretaria.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtPuesto.setVisible(false);
					puesto.setVisible(false);
					lblMed.setVisible(false);	
					txtEspecialidad.setVisible(false);
					btnAdmins.setSelected(false);
					btnMedico.setSelected(false);
					
				}
			});
			btnSecretaria.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			btnSecretaria.setBounds(643, 24, 166, 23);
			panel.add(btnSecretaria);
			{
				{
				}
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setForeground(Color.GRAY);
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion de Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 650, 265);
			contentPanel.add(panel);
			{
				lblCodUsuario = new JLabel("Codigo:");
				lblCodUsuario.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblCodUsuario.setBounds(257, 21, 76, 26);
				panel.add(lblCodUsuario);
			}
			{
				txtCodigo = new JTextField();
				txtCodigo.setEditable(false);
				txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtCodigo.setColumns(10);
				txtCodigo.setBounds(389, 21, 244, 30);
				panel.add(txtCodigo);
			}
			{
				lblnombre = new JLabel("Nombre:");
				lblnombre.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblnombre.setBounds(257, 60, 76, 26);
				panel.add(lblnombre);
			}
			{
				txtnombre = new JTextField();
				txtnombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtnombre.setColumns(10);
				txtnombre.setBounds(389, 60, 244, 30);
				panel.add(txtnombre);
			}
			{
				lblUsername = new JLabel("Username:");
				lblUsername.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblUsername.setBounds(257, 146, 122, 26);
				panel.add(lblUsername);
			}
			{
				txtusername = new JTextField();
				txtusername.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtusername.setColumns(10);
				txtusername.setBounds(389, 146, 244, 30);
				panel.add(txtusername);
			}
			{
				lblPassword = new JLabel("Password:");
				lblPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblPassword.setBounds(257, 185, 122, 26);
				panel.add(lblPassword);
			}
			{
				txtpassword = new JTextField();
				txtpassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtpassword.setColumns(10);
				txtpassword.setBounds(389, 185, 244, 30);
				panel.add(txtpassword);
			}
			{
				lblTelef = new JLabel("Telefono:");
				lblTelef.setFont(new Font("Comic Sans MS", Font.BOLD, 18));

				lblTelef.setBounds(350, 224, 89, 26);
				panel.add(lblTelef);
			}
			{
				txttelef = new JTextField();
				txttelef.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txttelef.setColumns(10);
				txttelef.setBounds(389, 224, 244, 30);
				panel.add(txttelef);
			}
			{
				imagendemedico = new JLabel("");
				imagendemedico.setBounds(21, 42, 181, 190);
				ImageIcon medico =new ImageIcon(getClass().getResource("/Imgenes/iconoMedico.png"));
				Icon medi= new ImageIcon(medico.getImage().getScaledInstance((int)211,(int)215,Image.SCALE_DEFAULT));
				imagendemedico.setIcon(medi);
				panel.add(imagendemedico);
			}
			{
				imagendeadmin = new JLabel("");
				imagendeadmin.setBounds(84, 21, 181, 174);
				panel.add(imagendeadmin);
			}
			{
				lblApellidos = new JLabel("Apellidos:");
				lblApellidos.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblApellidos.setBounds(257, 105, 89, 26);
				panel.add(lblApellidos);
			}
			{
				txtapellidos = new JTextField();
				txtapellidos.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtapellidos.setColumns(10);
				txtapellidos.setBounds(389, 105, 244, 30);
				panel.add(txtapellidos);
			}
		}
		{
			panel_1 = new JPanel();

			panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(12, 351, 817, 67);
			contentPanel.add(panel_1);
			panel_1.setLayout(null);
			{

				JLabel lblPuesto = new JLabel("Puesto");
				lblPuesto.setBounds(180, 21, 55, 26);
				panel_1.add(lblPuesto);
				lblPuesto.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
{

					txtPuesto = new JTextField();
					txtPuesto.setBounds(266, 19, 244, 30);
					panel_1.add(txtPuesto);
					txtPuesto.setFont(new Font("Tahoma", Font.PLAIN, 18));
					txtPuesto.setColumns(10);

					{

						lblMed = new JLabel("Especialidad:");
						lblMed.setBounds(60, 17, 114, 26);
						panel_1.add(lblMed);
						lblMed.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
					}
					{
						txtEspecialidad = new JTextField();
						txtEspecialidad.setBounds(186, 15, 244, 30);
						panel_1.add(txtEspecialidad);
						txtEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
						txtEspecialidad.setColumns(10);
					}
				}
			}
			
			puesto = new JLabel("Puesto:");
			puesto.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			puesto.setBounds(70, 17, 114, 26);
			panel_1.add(puesto);
			{
				txtPuesto = new JTextField();
				txtPuesto.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtPuesto.setColumns(10);
				txtPuesto.setBounds(186, 15, 244, 30);
				panel_1.add(txtPuesto);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("REGISTRAR");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Usuario u = null;
						if(btnMedico.isSelected()) {
							u = new Medico(txtCodigo.getText(), txtusername.getText(), txtpassword.getText(), txtnombre.getText(),txtapellidos.getText(), txttelef.getText(), txtEspecialidad.getText());
						}
						if(btnAdmins.isSelected()) {
							u = new Administrador(txtCodigo.getText(), txtusername.getText(), txtpassword.getText(), txtnombre.getText(), txtapellidos.getText(), txttelef.getText(), txtPuesto.getText());
						}
						if(btnSecretaria.isSelected()) {
							u = new Administrador(txtCodigo.getText(), txtusername.getText(), txtpassword.getText(), txtnombre.getText(), txtapellidos.getText(), txttelef.getText(), "Secretaria");
						}
						Clinica.getInstance().ingresarUsuario(u);
						JOptionPane.showMessageDialog(null, "Usuario Ingresado CORRECTAMENTE");
						limpiarCampos();
					
					}
					
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("SALIR");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		limpiarCampos();
	}
	
	public void limpiarCampos() {
		txtapellidos.setText("");
		txtCodigo.setText("USR"+Clinica.getInstance().getCodigodeusuario());
		txtEspecialidad.setText("");
		txtnombre.setText("");
		txtpassword.setText("");
		txtPuesto.setText("");
		txttelef.setText("");
		txtusername.setText("");
		btnAdmins.setSelected(false);
		btnMedico.setSelected(true);
		btnSecretaria.setSelected(false);
		
	}
}
