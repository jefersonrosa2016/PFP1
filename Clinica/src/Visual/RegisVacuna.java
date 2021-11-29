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

import Logico.Clinica;
import Logico.Vacuna;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

public class RegisVacuna extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigoVacuna;
	private JTextField txtNombreVacuna;
	private JButton btnRegistrar;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegisVacuna dialog = new RegisVacuna();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegisVacuna() {
		
		setBounds(100, 100, 666, 308);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon imagen =new ImageIcon(getClass().getResource("/Imgenes/regisvacunii.png"));
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance((int)273,(int)206,Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(icono);
		lblNewLabel.setBounds(12, 13, 283, 206);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo de Vacuna:");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNewLabel_1.setBounds(370, 45, 177, 26);
		contentPanel.add(lblNewLabel_1);
		
		txtCodigoVacuna = new JTextField();
		txtCodigoVacuna.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCodigoVacuna.setEditable(false);
		txtCodigoVacuna.setBounds(307, 74, 299, 30);
		contentPanel.add(txtCodigoVacuna);
		txtCodigoVacuna.setColumns(10);
		
		
		txtNombreVacuna = new JTextField();
		txtNombreVacuna.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNombreVacuna.setColumns(10);
		txtNombreVacuna.setBounds(307, 147, 299, 30);
		contentPanel.add(txtNombreVacuna);
		limpiarCampos();
		
		JLabel lblNombreDeVacuna = new JLabel("Nombre de Vacuna:");
		lblNombreDeVacuna.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNombreDeVacuna.setBounds(370, 117, 177, 26);
		contentPanel.add(lblNombreDeVacuna);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistrar = new JButton("Registrar");
				btnRegistrar.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				ImageIcon i =new ImageIcon(getClass().getResource("/Imgenes/iconoGuardar.png"));
				Icon guarda= new ImageIcon(i.getImage().getScaledInstance((int)25,(int)25,Image.SCALE_DEFAULT));
				btnRegistrar.setIcon(guarda);
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Vacuna aux =  new Vacuna(txtCodigoVacuna.getText(),txtNombreVacuna.getText());
						Clinica.getInstance().ingresarVacuna(aux);
						JOptionPane.showMessageDialog(null, "VACUNA INGRESADA CORRECTAMENTE");
						limpiarCampos();
					}

				
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				btnSalir = new JButton("Salir");
				ImageIcon j =new ImageIcon(getClass().getResource("/Imgenes/IconoSalir.png"));
				Icon sal= new ImageIcon(j.getImage().getScaledInstance((int)25,(int)25,Image.SCALE_DEFAULT));
				btnSalir.setIcon(sal);
				btnSalir.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
		}
	}
	private void limpiarCampos() {
		txtCodigoVacuna.setText("VAC"+ Clinica.getInstance().getCodigodevacunacion());
		txtNombreVacuna.setText("");
		
	}
}
