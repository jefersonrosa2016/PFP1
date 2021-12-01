package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.JTextComponent;

import com.toedter.calendar.JDateChooser;

import Logico.Clinica;
import Logico.Consulta;

public class RegiConsulta extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegiConsulta dialog = new RegiConsulta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param txtCodigoConsulta 
	 */
	public RegiConsulta(JTextComponent txtCodigoConsulta) {
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
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion De Consulta", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
			
			JLabel lblCodDeConsulta = new JLabel("Codigo:");
			lblCodDeConsulta.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblCodDeConsulta.setBounds(206, 30, 76, 26);
			panel_1.add(lblCodDeConsulta);
			
			txtCodigoConsulta = new JTextField();
			txtCodigoConsulta.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtCodigoConsulta.setEditable(false);
			txtCodigoConsulta.setColumns(10);
			txtCodigoConsulta.setBounds(292, 28, 244, 30);
			panel_1.add(txtCodigoConsulta);
			
			txtsintomas = new JTextField();
			txtsintomas.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtsintomas.setColumns(10);
			txtsintomas.setBounds(292, 69, 244, 30);
			panel_1.add(txtsintomas);
			
			JLabel lblSintomas = new JLabel("Sintomas:");
			lblSintomas.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblSintomas.setBounds(206, 71, 91, 26);
			panel_1.add(lblSintomas);
			
			txtdiagnostico = new JTextField();
			txtdiagnostico.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtdiagnostico.setColumns(10);
			txtdiagnostico.setBounds(635, 69, 244, 30);
			panel_1.add(txtdiagnostico);
			
			JLabel lbldiagnostico = new JLabel("Diagnostico:");
			lbldiagnostico.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lbldiagnostico.setBounds(549, 71, 114, 26);
			panel_1.add(lbldiagnostico);
			
			txtenfermedad = new JTextField();
			txtenfermedad.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtenfermedad.setColumns(10);
			txtenfermedad.setBounds(635, 26, 244, 30);
			panel_1.add(txtenfermedad);
			
			JLabel lblenfermedad = new JLabel("Enfermedad:");
			lblenfermedad.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblenfermedad.setBounds(549, 28, 134, 26);
			panel_1.add(lblenfermedad);
			
			cbxenfermedad = new JComboBox();
			cbxenfermedad.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccione>>", "Agudas", "Cronicas", "Infecciosas", "Mentales", "Metabolicas", "Geneticas", "Traumaticas"}));
			cbxenfermedad.setFont(new Font("Tahoma", Font.PLAIN, 18));
			cbxenfermedad.setBounds(292, 112, 244, 30);
			panel_1.add(cbxenfermedad);
			
			JLabel lblFechaDeConsulta = new JLabel("Fecha de Consulta:");
			lblFechaDeConsulta.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblFechaDeConsulta.setBounds(206, 153, 200, 26);
			panel_1.add(lblFechaDeConsulta);
			

			fechadeconsulta = new JDateChooser();
			fechadeconsulta.setFont(new Font("Tahoma", Font.PLAIN, 18));
			fechadeconsulta.setBounds(406, 155, 474, 30);
			
			panel_1.add(fechadeconsulta);
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
						Consulta aux= new Consulta(txtCodigoConsulta.getText(), txtsintomas.getText(),(String) cbxenfermedad.getSelectedItem(), txtdiagnostico.getText(),""+ Clinica.getInstance().getCodigoHistorialclinico(), txtCodigoCliente.getText(), txtApellido.getText(),fechaConsulta.getDate());
						Clinica.getInstance().ingresarconsulta(aux);
						JOptionPane.showMessageDialog(null, "Consulta Ingresada CORRECTAMENTE");
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
		txtCodigoConsulta.setText("CONSULTA"+ Clinica.getInstance().getCodigoconsulta());
		txtsintomas.setText("");
		txtdiagnostico.setText("");
		txtenfermedad.setText("");
		fechaConsulta.setDate(null);
	}
}

