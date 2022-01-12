
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.text.NumberFormatter;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;


public class AracEkle extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AracEkle frame = new AracEkle();
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
	JMenu menu, menu2, menu3, menu4;
	JMenuItem menuItem;
	ImageIcon carIcon, contratIcon, rentIcon, infoIcon;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	JFormattedTextField formattedTextField;
	JFormattedTextField formattedTextField_1;
	ImageIcon carImage;

	public AracEkle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(new Color(51, 51, 51));
		setBounds(100, 100, 1080, 663);

		setLocationRelativeTo(null); // Ortala

		carIcon = new ImageIcon("Icons\\car.png");
		contratIcon = new ImageIcon("Icons\\contract.png");
		rentIcon = new ImageIcon("Icons\\lease.png");
		infoIcon = new ImageIcon("Icons\\information.png");

		JMenuBar menuBar = new JMenuBar();
		JLabel short_spaceLabel = new JLabel("         ");
		JLabel short_spaceLabel2 = new JLabel("        ");
		JLabel short_spaceLabel3 = new JLabel("        ");
		JLabel short_spaceLabel4 = new JLabel("        ");
		JLabel short_spaceLabel5 = new JLabel("                               ");
		JLabel short_spaceLabel6 = new JLabel("                               ");

		
		JMenu carMenu = new JMenu("Araç Ýþlemeleri");
		JMenu contratMenu = new JMenu("Sözleþme Ýþlemleri");
		contratMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Sozlesme jump = new Sozlesme();
				setVisible(false);
				jump.setVisible(true);
			}
		});
		JMenu rentMenu = new JMenu("Kiralamalar");
		rentMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Kiralamalar jump = new Kiralamalar();
				setVisible(false);
				jump.setVisible(true);
			}
		});
		JMenu infoMenu = new JMenu("Hakkýnda");
		infoMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Hakkinda jump = new Hakkinda();
				setVisible(false);
				jump.setVisible(true);
			}
		});

		
		

		JMenuItem s5 = new JMenuItem("Araç Listele");
		s5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AracListele jump = null;
				jump = new AracListele();
				setVisible(false);
				jump.setVisible(true);
			}
		});
		JMenuItem s6 = new JMenuItem("Araç Ekle");
		s6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AracEkle jump = new AracEkle();
				setVisible(false);
				jump.setVisible(true);
			}
		});

		menuBar.setBackground(new Color(128, 128, 128));
		

		
		carMenu.setIcon(carIcon);
		contratMenu.setIcon(contratIcon);
		rentMenu.setIcon(rentIcon);
		infoMenu.setIcon(infoIcon);
		menuBar.add(short_spaceLabel5);
		menuBar.add(short_spaceLabel6);
		menuBar.add(short_spaceLabel);
		menuBar.add(carMenu);
		menuBar.add(short_spaceLabel2);
		menuBar.add(contratMenu);
		menuBar.add(short_spaceLabel3);
		menuBar.add(rentMenu);
		menuBar.add(short_spaceLabel4);
		menuBar.add(infoMenu);


		carMenu.add(s5);
		carMenu.add(s6);

		setJMenuBar(menuBar);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblKullaniciAdi = new JLabel("MARKA=");
		lblKullaniciAdi.setForeground(Color.LIGHT_GRAY);
		lblKullaniciAdi.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblKullaniciAdi.setBounds(41, 63, 142, 34);
		contentPane.add(lblKullaniciAdi);

		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setColumns(10);
		textField.setBackground(Color.DARK_GRAY);
		textField.setBounds(162, 68, 172, 25);
		contentPane.add(textField);

		JLabel lblKullaniciAdi_1 = new JLabel("MODEL=");
		lblKullaniciAdi_1.setForeground(Color.LIGHT_GRAY);
		lblKullaniciAdi_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblKullaniciAdi_1.setBounds(41, 131, 142, 34);
		contentPane.add(lblKullaniciAdi_1);

		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.DARK_GRAY);
		textField_1.setBounds(162, 136, 172, 25);
		contentPane.add(textField_1);

		JLabel lblKullaniciAdi_2 = new JLabel("YIL=");
		lblKullaniciAdi_2.setForeground(Color.LIGHT_GRAY);
		lblKullaniciAdi_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblKullaniciAdi_2.setBounds(41, 202, 142, 34);
		contentPane.add(lblKullaniciAdi_2);

		JLabel lblKullaniciAdi_3 = new JLabel("PLAKA=");
		lblKullaniciAdi_3.setForeground(Color.LIGHT_GRAY);
		lblKullaniciAdi_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblKullaniciAdi_3.setBounds(41, 283, 142, 34);
		contentPane.add(lblKullaniciAdi_3);

		textField_3 = new JTextField();
		textField_3.setForeground(Color.WHITE);
		textField_3.setColumns(10);
		textField_3.setBackground(Color.DARK_GRAY);
		textField_3.setBounds(162, 288, 172, 25);
		contentPane.add(textField_3);

		JLabel lblKullaniciAdi_4 = new JLabel("RENK=");
		lblKullaniciAdi_4.setForeground(Color.LIGHT_GRAY);
		lblKullaniciAdi_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblKullaniciAdi_4.setBounds(41, 366, 142, 34);
		contentPane.add(lblKullaniciAdi_4);

		textField_4 = new JTextField();
		textField_4.setForeground(Color.WHITE);
		textField_4.setColumns(10);
		textField_4.setBackground(Color.DARK_GRAY);
		textField_4.setBounds(162, 371, 172, 25);
		contentPane.add(textField_4);

		JLabel lblKullaniciAdi_5 = new JLabel("YAKIT T\u0130P\u0130=");
		lblKullaniciAdi_5.setForeground(Color.LIGHT_GRAY);
		lblKullaniciAdi_5.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblKullaniciAdi_5.setBounds(41, 442, 142, 34);
		contentPane.add(lblKullaniciAdi_5);

		JLabel lblKullaniciAdi_6 = new JLabel("V\u0130TES=");
		lblKullaniciAdi_6.setForeground(Color.LIGHT_GRAY);
		lblKullaniciAdi_6.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblKullaniciAdi_6.setBounds(388, 63, 142, 34);
		
		contentPane.add(lblKullaniciAdi_6);

		JLabel lblKullaniciAdi_7 = new JLabel("YA\u015E SINIRI =");
		lblKullaniciAdi_7.setForeground(Color.LIGHT_GRAY);
		lblKullaniciAdi_7.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblKullaniciAdi_7.setBounds(388, 131, 142, 34);
		contentPane.add(lblKullaniciAdi_7);

		JLabel lblKullaniciAdi_8 = new JLabel("F\u0130YAT(günlük) =");
		lblKullaniciAdi_8.setForeground(Color.LIGHT_GRAY);
		lblKullaniciAdi_8.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblKullaniciAdi_8.setBounds(388, 202, 142, 34);
		contentPane.add(lblKullaniciAdi_8);

		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.LIGHT_GRAY);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "", "BENZ\u0130N", "BENZ\u0130N $ LPG", "D\u0130ZEL",
				"ELEKTR\u0130KL\u0130", "H\u0130BR\u0130TL\u0130" }));
		comboBox.setBackground(Color.DARK_GRAY);
		comboBox.setBounds(162, 448, 172, 22);
		contentPane.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(
				new DefaultComboBoxModel(new String[] {"", "Yar\u0131 Otomatik", "Otomatik", "Manuel"}));
		comboBox_1.setForeground(Color.LIGHT_GRAY);
		comboBox_1.setBackground(Color.DARK_GRAY);
		comboBox_1.setBounds(540, 63, 172, 22);
		contentPane.add(comboBox_1);

		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"", "20 Ya\u015F Ve \u00DCst\u00FC", "25 Ya\u015F Ve \u00DCst\u00FC", "30 Ya\u015F Ve \u00DCst\u00FC"}));
		comboBox_1_1.setForeground(Color.LIGHT_GRAY);
		comboBox_1_1.setBackground(Color.DARK_GRAY);
		comboBox_1_1.setBounds(540, 137, 172, 22);
		contentPane.add(comboBox_1_1);

		JLabel buttonLabel = new JLabel("");
		buttonLabel.setBounds(767, 63, 248, 173);
		contentPane.add(buttonLabel);
		buttonLabel.setIcon(carImage);

		JButton btnAraResimEkle = new JButton("ARA\u00C7 RES\u0130M EKLE");
		btnAraResimEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		btnAraResimEkle.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				fileChooser.setDialogTitle("Resim Seçiniz");
				fileChooser.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG and GIF images", "png", "gif");
				fileChooser.addChoosableFileFilter(filter);

				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					
					carImage = new ImageIcon(fileChooser.getSelectedFile().getPath());
System.out.print(carImage);
					buttonLabel.setIcon(carImage);
				}
			}
		});
		btnAraResimEkle.setForeground(Color.LIGHT_GRAY);
		btnAraResimEkle.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		btnAraResimEkle.setBackground(Color.DARK_GRAY);
		btnAraResimEkle.setBounds(767, 247, 248, 32);
		contentPane.add(btnAraResimEkle);

		JButton btnEkle = new JButton("EKLE");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText()==""||textField_1.getText()==""||formattedTextField.getText()==null||textField_3.getText()==""||textField_4.getText()==""||comboBox.
						getSelectedItem().toString()==null||comboBox_1.getSelectedItem().toString()==null||comboBox_1_1.getSelectedItem().toString()==null||formattedTextField_1.getText()==""||buttonLabel.getText().toString()=="")
				{
					JOptionPane.showMessageDialog(null,
							"Bilgileri tam giriniz.",
							"Uyari mesaji",
							JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					AracIslemleri ekle= new AracIslemleri(textField.getText(),textField_1.getText(),formattedTextField.getText(),textField_3.getText(),textField_4.getText(),comboBox.
							getSelectedItem().toString(),comboBox_1.getSelectedItem().toString(),comboBox_1_1.getSelectedItem().toString(),Integer.parseInt(formattedTextField_1.getText()),carImage.toString());
			try {
						ekle.acDataBaseOpen();
						ekle.Insert(ekle);
						ekle.acDataBaseClose();
						JOptionPane.showMessageDialog(null,
								"Araç baþarýyla eklenmiþtir.",
								"Uyari mesaji",
								JOptionPane.WARNING_MESSAGE);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		
			}
		});
		btnEkle.setForeground(new Color(0, 0, 0));
		btnEkle.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		btnEkle.setBackground(new Color(220, 20, 60));
		btnEkle.setBounds(514, 435, 186, 52);
		contentPane.add(btnEkle);
		
		
		NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(0);
	    formatter.setMaximum(Integer.MAX_VALUE);
	    formatter.setAllowsInvalid(false);
	    // If you want the value to be committed on each keystroke instead of focus lost
	    formatter.setCommitsOnValidEdit(true);
	    format.setGroupingUsed(false);
	     formattedTextField = new JFormattedTextField(formatter);
	    formattedTextField.setForeground(Color.WHITE);
	    formattedTextField.setBackground(Color.DARK_GRAY);
		formattedTextField.setBounds(162, 207, 172, 22);
		contentPane.add(formattedTextField);
		
		 formattedTextField_1 = new JFormattedTextField(formatter);
		formattedTextField_1.setForeground(Color.WHITE);
		formattedTextField_1.setBackground(Color.DARK_GRAY);
		formattedTextField_1.setBounds(542, 207, 172, 22);
		contentPane.add(formattedTextField_1);
	
	}
}
