package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import java.awt.Font;

public class ListUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListUsuario dialog = new ListUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListUsuario() {
		setBounds(100, 100, 553, 393);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Listado de Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setToolTipText("");
			panel.setBounds(10, 11, 517, 258);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Codigo de usuario");
				lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblNewLabel.setBounds(178, 29, 160, 23);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Username");
				lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblNewLabel_1.setBounds(178, 103, 160, 23);
				panel.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Password");
				lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblNewLabel_2.setBounds(178, 124, 160, 23);
				panel.add(lblNewLabel_2);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Tipo de Usuario");
				lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblNewLabel_3.setBounds(178, 149, 160, 23);
				panel.add(lblNewLabel_3);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Nombre");
				lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblNewLabel_4.setBounds(178, 54, 160, 23);
				panel.add(lblNewLabel_4);
			}
			{
				JLabel lblNewLabel_5 = new JLabel("Telef");
				lblNewLabel_5.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblNewLabel_5.setBounds(178, 78, 160, 23);
				panel.add(lblNewLabel_5);
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
