package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JComboBox;

import Logico.Clinica;
import Logico.Consulta;
import java.awt.Toolkit;

public class RegisConsulta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtconsulta;
	private JTextField textdiagnostico;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegisConsulta dialog = new RegisConsulta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegisConsulta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Nicole Diaz\\git\\PFP1\\PFP1\\Clinica\\src\\Imgenes\\logitoventana.png"));
		setBounds(100, 100, 941, 386);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion de Consulta", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 694, 250);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("New label");
				lblNewLabel.setBounds(10, 22, 122, 170);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblcodconsulta = new JLabel("Codigo");
				lblcodconsulta.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblcodconsulta.setBounds(193, 36, 173, 25);
				panel.add(lblcodconsulta);
			}
			{
				JLabel lblenfermedad = new JLabel("Enfermedad:");
				lblenfermedad.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblenfermedad.setBounds(193, 117, 173, 25);
				panel.add(lblenfermedad);
			}
			{
				JLabel lbldiagnostico = new JLabel("Diagnostico");
				lbldiagnostico.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lbldiagnostico.setBounds(193, 155, 173, 25);
				panel.add(lbldiagnostico);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Fecha de Consulta");
				lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblNewLabel_4.setBounds(193, 199, 173, 25);
				panel.add(lblNewLabel_4);
			}
			{
				txtconsulta = new JTextField();
				txtconsulta.setBounds(376, 36, 245, 25);
				panel.add(txtconsulta);
				txtconsulta.setColumns(10);
			}
			{
				textdiagnostico = new JTextField();
				textdiagnostico.setBounds(376, 158, 245, 25);
				panel.add(textdiagnostico);
				textdiagnostico.setColumns(10);
			}
			{
				JComboBox cbxenfermedad = new JComboBox();
				cbxenfermedad.setBounds(376, 120, 245, 25);
				panel.add(cbxenfermedad);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Sintomas");
				lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblNewLabel_1.setBounds(193, 72, 173, 25);
				panel.add(lblNewLabel_1);
			}
			{
				textField = new JTextField();
				textField.setBounds(376, 75, 245, 25);
				panel.add(textField);
				textField.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
