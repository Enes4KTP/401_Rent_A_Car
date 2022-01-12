
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Manager_Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager_Login frame = new Manager_Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 */

	public Manager_Login() {
		setBackground(Color.BLACK);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 433);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(144,104,42));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setBackground(new Color(144,104,42));
		textField.setBounds(121, 140, 273, 31);
		textField.setBorder(null);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.BOLD, 15));
		passwordField.setForeground(Color.WHITE);
		passwordField.setHorizontalAlignment(JTextField.CENTER);
		passwordField.setBackground(new Color(144,104,42));
		passwordField.setBounds(121, 222, 273, 33);
		passwordField.setBorder(null);
		
		contentPane.add(passwordField);
		yoneticiGiris girisIslem= new yoneticiGiris();
		JButton btnNewButton = new JButton("GIRIS YAP");
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName= textField.getText();
				String password= String.valueOf(passwordField.getPassword());
				girisIslem.girisDogrulama(userName, password);
				if(yoneticiGiris.sayac==1) //girisIslem.sayac==1
				{
					JOptionPane.showMessageDialog(contentPane,
                		    "\"Hoþgeldiniz, '"+userName+"' Sisteme Aktarýlýyorsunuz");
					LoadingScreen jump = new LoadingScreen();
					setVisible(false);
					jump.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane,
                		    "Yanlýþ Giriþ Yaptýnýz Tekrardan Deneyiniz !!");
		}
			}
		});
		btnNewButton.setForeground(new  Color(222,203,173));
		btnNewButton.setFont(new Font("Hindenburg", Font.PLAIN, 22));
		btnNewButton.setBounds(189, 303, 120, 38);
		contentPane.add(btnNewButton);
		setLocationRelativeTo(null); // Ortala
		btnNewButton.setBackground(new Color(79,79,79));
		
		JLabel imageLabel = new JLabel("New label");
		imageLabel.setBackground(new Color(210, 180, 140));
		imageLabel.setBounds(0, -40, 532, 475);
Image img = new ImageIcon(this.getClass().getResource("designBackground.png")).getImage();
		
		imageLabel.setIcon(new ImageIcon(img));
		contentPane.add(imageLabel);
		
		JLabel lblNewLabel = new JLabel("GIRIS YAP");
		lblNewLabel.setBounds(207, 325, 61, 13);
		contentPane.add(lblNewLabel);
		

	}
}
