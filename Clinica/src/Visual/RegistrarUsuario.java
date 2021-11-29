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

public class RegistrarUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		setBounds(100, 100, 532, 435);
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
				JRadioButton radioButton = new JRadioButton("Administrador");
				radioButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				radioButton.setBounds(6, 23, 147, 23);
				panel.add(radioButton);
			}
			{
				JRadioButton radioButton = new JRadioButton("Medico");
				radioButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				radioButton.setBounds(228, 23, 109, 23);
				panel.add(radioButton);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setForeground(Color.GRAY);
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion de Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 503, 205);
			contentPanel.add(panel);
			{
				JLabel lblCodigoDeUsuario = new JLabel("Cod. Usuario");
				lblCodigoDeUsuario.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblCodigoDeUsuario.setBounds(203, 22, 111, 26);
				panel.add(lblCodigoDeUsuario);
			}
			{
				textField = new JTextField();
				textField.setColumns(10);
				textField.setBounds(324, 27, 165, 23);
				panel.add(textField);
			}
			{
				JLabel label = new JLabel("Username");
				label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				label.setBounds(203, 87, 111, 26);
				panel.add(label);
			}
			{
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(324, 92, 165, 23);
				panel.add(textField_1);
			}
			{
				JLabel label = new JLabel("Password");
				label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				label.setBounds(203, 130, 86, 23);
				panel.add(label);
			}
			{
				textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBounds(324, 133, 165, 23);
				panel.add(textField_2);
			}
			{
				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setBounds(324, 56, 165, 23);
				panel.add(textField_3);
			}
			{
				JLabel lblNewLabel = new JLabel("Nombre");
				lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblNewLabel.setBounds(203, 59, 84, 17);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Telef.");
				lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblNewLabel_1.setBounds(203, 167, 75, 23);
				panel.add(lblNewLabel_1);
			}
			{
				textField_4 = new JTextField();
				textField_4.setBounds(324, 170, 165, 23);
				panel.add(textField_4);
				textField_4.setColumns(10);
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
