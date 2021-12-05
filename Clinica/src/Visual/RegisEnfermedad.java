package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;

import Logico.Clinica;
import Logico.Enfermedad;

import javax.swing.UIManager;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;

public class RegisEnfermedad extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JComboBox cbxtipos;
	private JEditorPane txtDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegisEnfermedad dialog = new RegisEnfermedad();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegisEnfermedad() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegisEnfermedad.class.getResource("/Imgenes/logitoventana.png")));
		setBounds(100, 100, 640, 443);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion Enfermedad", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 581, 156);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblCod = new JLabel("Codigo");
			lblCod.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblCod.setBounds(179, 29, 69, 24);
			panel.add(lblCod);
			
			JLabel lblNombre = new JLabel("Nombre ");
			lblNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblNombre.setBounds(179, 64, 84, 24);
			panel.add(lblNombre);
			
			JLabel lblTipos = new JLabel("Tipos ");
			lblTipos.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblTipos.setBounds(179, 99, 59, 24);
			panel.add(lblTipos);
			
			txtCodigo = new JTextField();
			txtCodigo.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			txtCodigo.setEditable(false);
			txtCodigo.setBounds(256, 28, 244, 30);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(256, 63, 244, 30);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			cbxtipos = new JComboBox();
			cbxtipos.setFont(new Font("Tahoma", Font.PLAIN, 15));
			cbxtipos.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccione>>", "Al\u00E9rgicas", "Autoinmunes", "Carenciales o nutricionales", "Cardiovasculares", "C\u00E1ncer", "Cong\u00E9nitas", "Degenerativas", "Endocrinas", "Gen\u00E9ticas", "Intoxicaciones ", "Infecciones", "Parasitarias"}));
			cbxtipos.setBounds(256, 98, 244, 30);
			panel.add(cbxtipos);
			
			JLabel lblNewLabel_2 = new JLabel("New label");
			ImageIcon medico =new ImageIcon(getClass().getResource("/Imgenes/Enfermedad.png"));
			Icon medi= new ImageIcon(medico.getImage().getScaledInstance((int)130,(int)109,Image.SCALE_DEFAULT));
			lblNewLabel_2.setIcon(medi);
			lblNewLabel_2.setBounds(23, 25, 130, 109);
			panel.add(lblNewLabel_2);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Descripci\u00F3n", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(10, 178, 581, 155);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		txtDescripcion = new JEditorPane();
		scrollPane.setViewportView(txtDescripcion);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				ImageIcon i =new ImageIcon(getClass().getResource("/Imgenes/iconoGuardar.png"));
				Icon guarda= new ImageIcon(i.getImage().getScaledInstance((int)25,(int)25,Image.SCALE_DEFAULT));
				okButton.setIcon(guarda);
				okButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {

						Enfermedad aux = new Enfermedad(txtCodigo.getText(), txtNombre.getText(),(String) cbxtipos.getSelectedItem(), txtDescripcion.getText());
						Clinica.getInstance().ingresarEnfermedad(aux);
						JOptionPane.showMessageDialog(null, "Enfermedad Ingresada CORRECTAMENTE");
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
					public void actionPerformed(ActionEvent arg0) {
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
			limpiarCampos ();
			
		}
	}
	
	public void limpiarCampos () {
		txtCodigo.setText("EF" + Clinica.getInstance().getCodigoenfermedad());
		txtNombre.setText ("");
		cbxtipos.setSelectedIndex(0);
		txtDescripcion.setText("");
		
		
	
	}	
}
