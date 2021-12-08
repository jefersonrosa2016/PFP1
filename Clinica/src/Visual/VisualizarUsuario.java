package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logico.Administrador;
import Logico.Clinica;
import Logico.Medico;

import Logico.Usuario;

public class VisualizarUsuario extends JDialog {

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
	private JLabel imagenesacambiar;
	private JPanel panel_1;
	private JLabel lblApellidos;
	private JTextField txtapellidos;
	private JTextField txtPuesto;
	private JLabel puesto;
	private JRadioButton btnSecretaria;
	public static Usuario seleccionado=null;
	private JButton btnGuardar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VisualizarUsuario dialog = new VisualizarUsuario(null);
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
	public VisualizarUsuario(Usuario selected) {
		seleccionado=selected;
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarUsuario.class.getResource("/Imgenes/logitoventana.png")));
		setBounds(100, 100, 696, 510);

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
			panel.setBounds(12, 289, 655, 53);
			contentPanel.add(panel);
			{
				btnAdmins = new JRadioButton("Administrador");
				btnAdmins.setEnabled(false);
				btnAdmins.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(btnAdmins.isSelected()) {
							lblMed.setVisible(false);	
							txtEspecialidad.setVisible(false);
							btnMedico.setSelected(false);
							txtPuesto.setVisible(true);
							puesto.setVisible(true);
							btnSecretaria.setSelected(false);
							
							
							}
					}
				});
				btnAdmins.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				btnAdmins.setBounds(261, 23, 166, 23);
				panel.add(btnAdmins);
			}
			{
				btnMedico = new JRadioButton("M\u00E9dico");
				btnMedico.setEnabled(false);
				btnMedico.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(btnMedico.isSelected()) {
						lblMed.setVisible(true);	
						txtEspecialidad.setVisible(true);
						btnAdmins.setSelected(false);
						txtPuesto.setVisible(false);
						puesto.setVisible(false);
						btnSecretaria.setSelected(false);
				
						
						}
					}
					
				});
				btnMedico.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				btnMedico.setBounds(63, 23, 109, 23);
				panel.add(btnMedico);
			}
			
			btnSecretaria = new JRadioButton("Secretaria");
			btnSecretaria.setEnabled(false);
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
			btnSecretaria.setBounds(470, 23, 166, 23);
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
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion de Usuario", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(17, 13, 650, 265);
			contentPanel.add(panel);
			{
				lblCodUsuario = new JLabel("C\u00F3digo:");
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
				txtnombre.setEnabled(false);
				txtnombre.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						int key = e.getKeyChar();

					    boolean mayusculas = key >= 65 && key <= 90;
					    boolean minusculas = key >= 97 && key <= 122;
					    boolean espacio = key == 32;
					            
					     if (!(minusculas || mayusculas || espacio))
					    {
					        e.consume();
					    }
					 
					}
				});
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
				txtusername.setEnabled(false);
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
				txtpassword.setEnabled(false);
				txtpassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtpassword.setColumns(10);
				txtpassword.setBounds(389, 185, 244, 30);
				panel.add(txtpassword);
			}
			{
				lblTelef = new JLabel("Tel\u00E9fono:");
				lblTelef.setFont(new Font("Comic Sans MS", Font.BOLD, 18));

				lblTelef.setBounds(257, 226, 122, 26);
				panel.add(lblTelef);
			}
			{
				txttelef = new JTextField();
				txttelef.setEnabled(false);
				txttelef.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
	                    if((!(Character.isDigit(c))&&(c!='-'))||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)) {
	                        e.consume();
	                    }
					}
				});
				txttelef.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txttelef.setColumns(10);
				txttelef.setBounds(389, 224, 244, 30);
				panel.add(txttelef);
			}
			{
				imagenesacambiar = new JLabel("");
				imagenesacambiar.setBounds(21, 21, 211, 231);
				panel.add(imagenesacambiar);
			}
			{
				
				{
				}		
			}
			{
				lblApellidos = new JLabel("Apellidos:");
				lblApellidos.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblApellidos.setBounds(257, 105, 89, 26);
				panel.add(lblApellidos);
			}
			{
				txtapellidos = new JTextField();
				txtapellidos.setEnabled(false);
				txtapellidos.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						int key = e.getKeyChar();

					    boolean mayusculas = key >= 65 && key <= 90;
					    boolean minusculas = key >= 97 && key <= 122;
					    boolean espacio = key == 32;
					            
					     if (!(minusculas || mayusculas || espacio))
					    {
					        e.consume();
					    }

						
					}
				});
				txtapellidos.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtapellidos.setColumns(10);
				txtapellidos.setBounds(389, 105, 244, 30);
				panel.add(txtapellidos);
			}
		}
		{
			panel_1 = new JPanel();

			panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(12, 353, 655, 67);
			contentPanel.add(panel_1);
			panel_1.setLayout(null);
			{
{

					txtPuesto = new JTextField();
					txtPuesto.setEnabled(false);
					txtPuesto.addKeyListener(new KeyAdapter() {
						@Override
						public void keyTyped(KeyEvent e) {
							int key = e.getKeyChar();

						    boolean mayusculas = key >= 65 && key <= 90;
						    boolean minusculas = key >= 97 && key <= 122;
						    boolean espacio = key == 32;
						            
						     if (!(minusculas || mayusculas || espacio))
						    {
						        e.consume();
						    }
						}
					});
					txtPuesto.setVisible(false);
					txtPuesto.setBounds(266, 19, 244, 30);
					panel_1.add(txtPuesto);
					txtPuesto.setFont(new Font("Tahoma", Font.PLAIN, 18));
					txtPuesto.setColumns(10);
					{
						txtEspecialidad = new JTextField();
						txtEspecialidad.setEnabled(false);
						txtEspecialidad.addKeyListener(new KeyAdapter() {
							@Override
							public void keyTyped(KeyEvent e) {
								int key = e.getKeyChar();

							    boolean mayusculas = key >= 65 && key <= 90;
							    boolean minusculas = key >= 97 && key <= 122;
							    boolean espacio = key == 32;
							            
							     if (!(minusculas || mayusculas || espacio))
							    {
							        e.consume();
							    }
							}
						});
						txtEspecialidad.setVisible(false);
						txtEspecialidad.setBounds(266, 19, 244, 30);
						panel_1.add(txtEspecialidad);
						txtEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
						txtEspecialidad.setColumns(10);
					}
				}
			}
			
			puesto = new JLabel("Puesto:");
			puesto.setVisible(false);
			puesto.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			puesto.setBounds(177, 21, 114, 26);
			panel_1.add(puesto);
			
					{
			
									lblMed = new JLabel("Especialidad:");
									lblMed.setVisible(false);
									lblMed.setBounds(142, 21, 114, 26);
									panel_1.add(lblMed);
									lblMed.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
								}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Modificar");
				okButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					btnGuardar.setEnabled(true);
					activaredicion();
					okButton.setVisible(false);
					}
					
				});
				
				btnGuardar = new JButton("Guardar");
				btnGuardar.addActionListener(new ActionListener() {
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
						int indiceUsuario= Clinica.getInstance().IndiceDelUsuarioByCodigo(txtCodigo.getText());
						if (indiceUsuario!=-1) {
							Clinica.getInstance().getMisUsuarios().remove(indiceUsuario);
							
							Clinica.getInstance().getMisUsuarios().add(u);
							JOptionPane.showMessageDialog(null, "Usuario Modificado CORRECTAMENTE");
							dispose();
						}
						
					}
				});
				btnGuardar.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				btnGuardar.setEnabled(false);
				buttonPane.add(btnGuardar);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				cancelButton.addActionListener(new ActionListener() {
			
					public void actionPerformed(ActionEvent e) {
						dispose();
						// TODO Auto-generated method stub
						
					}
				});
				
				
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		limpiarCampos();
	}
	
	public void limpiarCampos() {
		txtapellidos.setText((String) seleccionado.getApellidos());
		txtCodigo.setText(seleccionado.getCodigoUsuario());
		if(seleccionado instanceof Medico) {
			Medico aux= (Medico) seleccionado;
			txtEspecialidad.setText(aux.getEspecialidad());
			txtEspecialidad.setVisible(true);
			lblMed.setVisible(true);
			btnMedico.setSelected(true);
			ImageIcon medico =new ImageIcon(getClass().getResource("/Imgenes/doctor.png"));
			Icon medi= new ImageIcon(medico.getImage().getScaledInstance(211, 231,Image.SCALE_DEFAULT));
			imagenesacambiar.setIcon(medi);
			
		}
		if(seleccionado instanceof Administrador) {
			Administrador aux= (Administrador) seleccionado;
			if (aux.getPuestoLaboral().equalsIgnoreCase("Secretaria")) {
				btnSecretaria.setSelected(true);
				ImageIcon secretaria = new ImageIcon(getClass().getResource("/Imgenes/secretario.png"));
				Icon secre = new ImageIcon(secretaria.getImage().getScaledInstance(211, 231, Image.SCALE_DEFAULT));
				imagenesacambiar.setIcon(secre);
			}else {
				txtPuesto.setText(aux.getPuestoLaboral());
				btnAdmins.setSelected(true);
				txtPuesto.setVisible(true);
				puesto.setVisible(true);
				ImageIcon admins =new ImageIcon(getClass().getResource("/Imgenes/administrador.png"));
				Icon adminst= new ImageIcon(admins.getImage().getScaledInstance(211, 231,Image.SCALE_DEFAULT));
				imagenesacambiar.setIcon(adminst);
			}
			
			
		}
		
		txtnombre.setText(seleccionado.getNombre());
		txtpassword.setText(seleccionado.getPassword());
		txttelef.setText(seleccionado.getTelefono());
		txtusername.setText(seleccionado.getLogin());	
	}
	public void activaredicion() {
		txtnombre.setEnabled(true);
		txtpassword.setEnabled(true);
		txttelef.setEnabled(true);
		txtusername.setEnabled(true);
		txtapellidos.setEnabled(true);

		txtPuesto.setEnabled(true);
		txtEspecialidad.setEnabled(true);
	}
}
