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
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import Logico.CitaMedica;
import Logico.Clinica;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerCita extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txthorario;
	private JTextField txtNombreMedico;
	private JTextField txtApellidoMedico;
	private JTextField txtEspecialidad;
	private JDateChooser dateFechaCita;
	private JRadioButton btnpendiente;
	private JRadioButton btnrealizada;
	private JRadioButton btncancelada;
	private JButton okButton;
	private JButton btnSave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VerCita dialog = new VerCita(null);
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
	public VerCita(CitaMedica selected) {
		setBounds(100, 100, 474, 677);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion Cita", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(12, 13, 417, 249);
			contentPanel.add(panel);
			{
				JLabel label = new JLabel("Codigo:");
				label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				label.setBounds(41, 29, 76, 26);
				panel.add(label);
			}
			{
				txtCodigo = new JTextField();
				txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtCodigo.setEditable(false);
				txtCodigo.setColumns(10);
				txtCodigo.setBounds(127, 27, 244, 30);
				panel.add(txtCodigo);
			}
			{
				JLabel label = new JLabel("Nombre:");
				label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				label.setBounds(41, 70, 76, 26);
				panel.add(label);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setEditable(false);
				txtNombre.setText("");
				txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtNombre.setColumns(10);
				txtNombre.setBounds(127, 68, 244, 30);
				panel.add(txtNombre);
			}
			{
				JLabel label = new JLabel("Telefono:");
				label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				label.setBounds(41, 111, 85, 26);
				panel.add(label);
			}
			{
				txtTelefono = new JTextField();
				txtTelefono.setEditable(false);
				txtTelefono.setText("");
				txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtTelefono.setColumns(10);
				txtTelefono.setBounds(127, 109, 244, 30);
				panel.add(txtTelefono);
			}
			{
				JLabel label = new JLabel("Fecha de Cita:");
				label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				label.setBounds(41, 152, 129, 26);
				panel.add(label);
			}
			{
				dateFechaCita = new JDateChooser();
				dateFechaCita.setEnabled(false);
				dateFechaCita.setFont(new Font("Tahoma", Font.PLAIN, 18));
				dateFechaCita.setBounds(174, 148, 197, 30);
				panel.add(dateFechaCita);
			}
			{
				JLabel lblHorario = new JLabel("Horario:");
				lblHorario.setBounds(41, 191, 91, 26);
				panel.add(lblHorario);
				lblHorario.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			}
			{
				txthorario = new JTextField();
				txthorario.setEditable(false);
				txthorario.setText("");
				txthorario.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txthorario.setColumns(10);
				txthorario.setBounds(127, 195, 244, 30);
				panel.add(txthorario);
			}
		}
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(12, 281, 417, 170);
			contentPanel.add(panel_1);
			panel_1.setBorder(new TitledBorder(null, "Infomacion del Medico", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setLayout(null);
			{
				txtNombreMedico = new JTextField();
				txtNombreMedico.setText("");
				txtNombreMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtNombreMedico.setEditable(false);
				txtNombreMedico.setColumns(10);
				txtNombreMedico.setBounds(126, 35, 244, 30);
				panel_1.add(txtNombreMedico);
			}
			{
				JLabel label = new JLabel("Nombre:");
				label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				label.setBounds(40, 37, 76, 26);
				panel_1.add(label);
			}
			{
				JLabel lblApellido = new JLabel("Apellido:");
				lblApellido.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblApellido.setBounds(40, 83, 76, 26);
				panel_1.add(lblApellido);
			}
			{
				txtApellidoMedico = new JTextField();
				txtApellidoMedico.setText("");
				txtApellidoMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtApellidoMedico.setEditable(false);
				txtApellidoMedico.setColumns(10);
				txtApellidoMedico.setBounds(126, 78, 244, 30);
				panel_1.add(txtApellidoMedico);
			}
			{
				JLabel lblEspecialidad = new JLabel("Especialidad:");
				lblEspecialidad.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblEspecialidad.setBounds(40, 125, 122, 26);
				panel_1.add(lblEspecialidad);
			}
			{
				txtEspecialidad = new JTextField();
				txtEspecialidad.setText("");
				txtEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtEspecialidad.setEditable(false);
				txtEspecialidad.setColumns(10);
				txtEspecialidad.setBounds(154, 121, 216, 30);
				panel_1.add(txtEspecialidad);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Estado Cita", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(12, 464, 417, 118);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				btnpendiente = new JRadioButton("Pendiente");
				btnpendiente.setEnabled(false);
				btnpendiente.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				btnpendiente.setBounds(8, 40, 127, 25);
				panel.add(btnpendiente);
			}
			{
				btnrealizada = new JRadioButton("Realizada");
				btnrealizada.setEnabled(false);
				btnrealizada.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				btnrealizada.setBounds(152, 40, 127, 25);
				panel.add(btnrealizada);
			}
			{
				btncancelada = new JRadioButton("Cancelada");
				btncancelada.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnSave.setVisible(true);
						btnpendiente.setSelected(false);
					}
				});
				btncancelada.setEnabled(false);
				btncancelada.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				btncancelada.setBounds(283, 40, 113, 25);
				panel.add(btncancelada);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnSave = new JButton("Guardar");
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int indicedeCita=Clinica.getInstance().indicedecitaBycod(selected.getCodigoCita());
						if (indicedeCita!=-1) {
							Clinica.getInstance().getCitasMedicas().get(indicedeCita).setEstado(btncancelada.getText());
							JOptionPane.showMessageDialog(null, "Cita  Cancelada con Exito");
							dispose();
							
						}
					}
				});
				btnSave.setVisible(false);
				btnSave.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
				btnSave.setActionCommand("OK");
				buttonPane.add(btnSave);
			}
			{
				okButton = new JButton("Modificar Estado");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btncancelada.setEnabled(true);
						okButton.setVisible(false);
						
					}
				});
				okButton.setVisible(false);
				okButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
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
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			cargardatos(selected);
		}
	}

	public void cargardatos(CitaMedica selected) {
		txtApellidoMedico.setText((String) selected.getMedico().getApellidos());
		txtCodigo.setText(selected.getCodigoCita());
		txtEspecialidad.setText(selected.getMedico().getEspecialidad());
		txthorario.setText(selected.getHorario());
		txtNombre.setText(selected.getNombrePersona());
		txtNombreMedico.setText(selected.getMedico().getNombre());
		txtTelefono.setText(selected.getTelefonoPersona());
		dateFechaCita.setDate(selected.getFechaCita());
		if (selected.getEstado().equalsIgnoreCase("Pendiente")) {
			btnpendiente.setSelected(true);
			btncancelada.setSelected(false);
			btnrealizada.setSelected(false);
			if(Login.lasecre.getPuestoLaboral().equalsIgnoreCase("Secretaria")) {
				okButton.setVisible(true);
			}
			
			
		}
		if (selected.getEstado().equalsIgnoreCase("Realizada")) {
			btnpendiente.setSelected(false);
			btncancelada.setSelected(false);
			btnrealizada.setSelected(true);
		}
		if (selected.getEstado().equalsIgnoreCase("Cancelada")) {
			btnpendiente.setSelected(false);
			btncancelada.setSelected(true);
			btnrealizada.setSelected(false);
			
		}
		
	}
	

}
