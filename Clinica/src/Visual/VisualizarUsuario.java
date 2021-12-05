package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class VisualizarUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VisualizarUsuario dialog = new VisualizarUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VisualizarUsuario() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			
			JPanel panel = new JPanel();
			panel.setForeground(Color.GRAY);
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion de Usuario", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(55, 11, 650, 265);
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

				lblTelef.setBounds(257, 226, 122, 26);
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
