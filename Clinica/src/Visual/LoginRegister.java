package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class LoginRegister extends JFrame {

	private JPanel contentPane;
	private Dimension dimension; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginRegister frame = new LoginRegister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginRegister() {
		dimension= getToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize((int)dimension.getWidth(),(int)dimension.getHeight()-40);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon imagen =new ImageIcon(getClass().getResource("/Imgenes/pngwing.com (1).png"));
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance((int)1920-45,(int)1040-45,Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(icono);
		lblNewLabel.setBounds(0, 0, 56, 16);
		lblNewLabel.setSize((int)dimension.getWidth(),(int)dimension.getHeight()-40);
		contentPane.add(lblNewLabel);
	}
}
