import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class AracListele extends JFrame {
	

	

	private JPanel contentPane;
	JTable table= new JTable();
	
	/**
	 * Launch the application.
	 */
	DefaultTableModel designModel;
	ArrayList<AracIslemleri> carsList= new ArrayList<>();
	AracIslemleri cars; 
	ImageIcon carImage;

	public ArrayList<AracIslemleri> carList()
	{
	
	
	AracIslemleri cars;
	try{
		AracIslemleri tools= new AracIslemleri();
	tools.acDataBaseOpen();
	String query="SELECT * FROM AracBilgileri";
	 Connection  con = DriverManager.getConnection(lConnection.databaseURL);
	Statement st= con.createStatement();
	ResultSet rs= st.executeQuery(query);
	while(rs.next())
	{
		cars=new AracIslemleri(rs.getInt("ID"),rs.getString("Marka"),
				rs.getString("Model"),rs.getString("Yıl"),
				rs.getString("Plaka"),rs.getString("Renk"),rs.getString("Yakit_Tipi"),
				rs.getString("Vites"),rs.getString("Yas_Siniri"),rs.getInt("Fiyat")
				,rs.getString("AracResim"),rs.getString("KiralanmaDurumu"));
		carsList.add(cars);
		
	}
	}
	catch(Exception e )
	{
		JOptionPane.showMessageDialog(null, e);
	}
	return carsList;
	}
	
	
	public void ClearTable()
	{
		
		DefaultTableModel clearModel = (DefaultTableModel) table.getModel();
		
		clearModel.setRowCount(0); //her şeyi sıfırlıyorum
		 ArrayList<AracIslemleri> products = new ArrayList<AracIslemleri>();
	        products = new AracListele().carList();
	        
	        String[] data = new String[12];
	       
	        for(int i=0;i<carsList.size();i++)
			{
				System.out.println(carsList.get(i));
			}
	        for (int i = 0; i < products.size()-carsList.size(); i++) {
	            data[0] = String.valueOf(products.get(i).getId());
	            data[1] = products.get(i).getMarka();
	            data[2] = products.get(i).getModel();
	            data[3] = products.get(i).getYıl();
	            data[4] = products.get(i).getPlaka();
	            data[5] = products.get(i).getRenk();
	            data[6] = products.get(i).getYakıtTipi();
	            data[7] = products.get(i).getVites();
	            data[8] = products.get(i).getYasSiniri();
	            data[9] = String.valueOf(products.get(i).getFiyat());
	            data[10]= products.get(i).getAracDurum();
	    
	            designModel.addRow(data);          
	        }

	}
        	
	
	
	
	
	Object[] row = new Object[12];
	public void listele()
	{
	  
		ArrayList<AracIslemleri> list= carList();
	 designModel = (DefaultTableModel) table.getModel();
	String header[] = new String[] { "ID", "MARKA", "MODEL", "YIL", "PLAKA", "RENK", "YAKIT T\u0130P\u0130", "V\u0130TES", "YAS SINIRI", "F\u0130YAT","KiralanmaDurumu" };
	designModel.setColumnIdentifiers(header);
	table.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			AracIslemleri tools= new AracIslemleri();
		DefaultTableModel model= (DefaultTableModel) table.getModel();
			int selectedRowIndex=table.getSelectedRow();
	
			textField.setText(model.getValueAt(selectedRowIndex, 1).toString());
			textField_1.setText(model.getValueAt(selectedRowIndex, 2).toString());
			textField_2.setText(model.getValueAt(selectedRowIndex, 3).toString());
			textField_3.setText(model.getValueAt(selectedRowIndex, 4).toString());
			textField_4.setText(model.getValueAt(selectedRowIndex, 5).toString());
			textField_5.setText(model.getValueAt(selectedRowIndex, 9).toString());
			textField_6.setText(model.getValueAt(selectedRowIndex, 0).toString());
			
			switch((String) model.getValueAt(selectedRowIndex, 6))
			{
			case "Benzin":
				comboBox.setSelectedIndex(1);
				break;
			case "Benzin $ Lpg":
				comboBox.setSelectedIndex(2);
				break;
			case "Dizel":
				comboBox.setSelectedIndex(3);
				break;
			case "Elektrikli":
				comboBox.setSelectedIndex(4);
				break;
			case "Hibritli":
				comboBox.setSelectedIndex(5);
				break;
			}
			
			
			switch((String) model.getValueAt(selectedRowIndex, 7))
			{
			
			case "Yarı Otomatik":
				comboBox_1.setSelectedIndex(1);
				break;
			case "Otomatik":
				comboBox_1.setSelectedIndex(2);
				break;
			case "Manuel":
				comboBox_1.setSelectedIndex(3);
				break;
		
			}
			switch((String) model.getValueAt(selectedRowIndex, 8))
			{
			
			case "20 Yaş Ve Üstü":
				comboBox_2.setSelectedIndex(1);
				break;
			case "25 Yaş Ve Üstü":
				comboBox_2.setSelectedIndex(2);
				break;
			case "30 Yaş Ve Üstü":
				comboBox_2.setSelectedIndex(3);
				break;
		
			}
			 AracIslemleri resimDuzenleme = null;
			try {
				resimDuzenleme = tools.arama(Integer.parseInt(textField_6.getText()));
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ImageIcon img = new ImageIcon(resimDuzenleme.getResimURL());
			imageLabel.setIcon(img);
			
		}
		
	});

	
	table.setModel(designModel);
	//BİLGİLERİ GETİR
for(int i=0;i<list.size();i++)
{
	row[0]=list.get(i).getId();
	row[1]=list.get(i).getMarka();
	row[2]=list.get(i).getModel();
	row[3]=list.get(i).getYıl();
	row[4]=list.get(i).getPlaka();
	row[5]=list.get(i).getRenk();
	row[6]=list.get(i).getYakıtTipi();
	row[7]=list.get(i).getVites();
	row[8]=list.get(i).getYasSiniri();
	row[9]=list.get(i).getFiyat();
	row[10]=list.get(i).getAracDurum();
	designModel.addRow(row);
}	
	}
	


	public static void main(String[] args) {

	    
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AracListele frame = new AracListele();
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
	ImageIcon  carIcon, contratIcon, rentIcon, infoIcon;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel imageLabel;
	JComboBox comboBox = new JComboBox();
	JComboBox comboBox_1 = new JComboBox();
	JComboBox comboBox_2 = new JComboBox();
	private JTextField textField_6;
	
	
	
	public AracListele() {
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 663);
		setLocationRelativeTo(null); // Ortala
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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

		
		JMenu carMenu = new JMenu("Araç İşlemeleri");
		JMenu contratMenu = new JMenu("Sözleşme İşlemleri");
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
		JMenu infoMenu = new JMenu("Hakkında");
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

		
		

	
		
		//ŞARTLANDIRMA
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "MARKA", "MODEL", "YIL", "PLAKA", "RENK", "YAKIT T\u0130P\u0130", "V\u0130TES", "YAS SINIRI", "F\u0130YAT","KiralanmaDurumu"
				}
			) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false, false, false,false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		//Listelenen Verilerin TextField'lere Aktarılması//
		
		listele();
		
		JScrollPane p =  new JScrollPane(table); //Row İsim Gösterme
		p.setBounds(12, 269, 1040, 304);
		contentPane.add(p);

		JLabel lblKullaniciAdi = new JLabel("MARKA=");
		lblKullaniciAdi.setForeground(Color.LIGHT_GRAY);
		lblKullaniciAdi.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblKullaniciAdi.setBounds(10, 72, 95, 30);
		contentPane.add(lblKullaniciAdi);

		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setColumns(10);
		textField.setBackground(Color.DARK_GRAY);
		textField.setBounds(75, 75, 133, 25);
		contentPane.add(textField);

		JLabel lblKullaniciAdi_1 = new JLabel("MODEL=");
		lblKullaniciAdi_1.setForeground(Color.LIGHT_GRAY);
		lblKullaniciAdi_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblKullaniciAdi_1.setBounds(10, 134, 95, 30);
		contentPane.add(lblKullaniciAdi_1);

		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.DARK_GRAY);	
		textField_1.setBounds(75, 137, 133, 25);
		contentPane.add(textField_1);

		JLabel lblKullaniciAdi_2 = new JLabel("YIL=");
		lblKullaniciAdi_2.setForeground(Color.LIGHT_GRAY);
		lblKullaniciAdi_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblKullaniciAdi_2.setBounds(10, 195, 95, 30);
		contentPane.add(lblKullaniciAdi_2);

		textField_2 = new JTextField();
		textField_2.setForeground(Color.WHITE);
		textField_2.setColumns(10);
		textField_2.setBackground(Color.DARK_GRAY);
		textField_2.setBounds(75, 198, 133, 25);
		contentPane.add(textField_2);

		JLabel lblKullaniciAdi_3 = new JLabel("PLAKA=");
		lblKullaniciAdi_3.setForeground(Color.LIGHT_GRAY);
		lblKullaniciAdi_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblKullaniciAdi_3.setBounds(260, 72, 95, 30);
		contentPane.add(lblKullaniciAdi_3);

		textField_3 = new JTextField();
		textField_3.setForeground(Color.WHITE);
		textField_3.setColumns(10);
		textField_3.setBackground(Color.DARK_GRAY);
		textField_3.setBounds(347, 77, 133, 25);
		contentPane.add(textField_3);

		JLabel lblKullaniciAdi_4 = new JLabel("RENK=");
		lblKullaniciAdi_4.setForeground(Color.LIGHT_GRAY);
		lblKullaniciAdi_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblKullaniciAdi_4.setBounds(260, 134, 95, 30);
		contentPane.add(lblKullaniciAdi_4);

		textField_4 = new JTextField();
		textField_4.setForeground(Color.WHITE);
		textField_4.setColumns(10);
		textField_4.setBackground(Color.DARK_GRAY);
		textField_4.setBounds(347, 139, 133, 25);
		contentPane.add(textField_4);

	
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Benzin", "Benzin $ Lpg", "Dizel", "Elektrikli", "Hibritli"}));
		comboBox.setForeground(Color.LIGHT_GRAY);
		comboBox.setBackground(Color.DARK_GRAY);
		comboBox.setBounds(347, 200, 133, 25);
		contentPane.add(comboBox);

		JLabel lblKullaniciAdi_4_1 = new JLabel("YAKIT T\u0130P\u0130=");
		lblKullaniciAdi_4_1.setForeground(Color.LIGHT_GRAY);
		lblKullaniciAdi_4_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblKullaniciAdi_4_1.setBounds(260, 195, 95, 30);
		contentPane.add(lblKullaniciAdi_4_1);

		JLabel lblKullaniciAdi_4_1_1 = new JLabel("V\u0130TES=");
		lblKullaniciAdi_4_1_1.setForeground(Color.LIGHT_GRAY);
		lblKullaniciAdi_4_1_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblKullaniciAdi_4_1_1.setBounds(525, 72, 95, 30);
		contentPane.add(lblKullaniciAdi_4_1_1);

	
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "Yar\u0131 Otomatik", "Otomatik", "Manuel"}));
		comboBox_1.setForeground(Color.LIGHT_GRAY);
		comboBox_1.setBackground(Color.DARK_GRAY);
		comboBox_1.setBounds(641, 75, 133, 25);
		contentPane.add(comboBox_1);

		JLabel lblKullaniciAdi_4_1_2 = new JLabel("YA\u015E SINIRI=");
		lblKullaniciAdi_4_1_2.setForeground(Color.LIGHT_GRAY);
		lblKullaniciAdi_4_1_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblKullaniciAdi_4_1_2.setBounds(525, 134, 120, 30);
		contentPane.add(lblKullaniciAdi_4_1_2);
		
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"", "20 Ya\u015F Ve \u00DCst\u00FC", "25 Ya\u015F Ve \u00DCst\u00FC", "30 Ya\u015F Ve \u00DCst\u00FC"}));
		comboBox_2.setForeground(Color.LIGHT_GRAY);
		comboBox_2.setBackground(Color.DARK_GRAY);
		comboBox_2.setBounds(641, 137, 133, 25);
		contentPane.add(comboBox_2);

		JLabel lblKullaniciAdi_4_2 = new JLabel("F\u0130YAT=");
		lblKullaniciAdi_4_2.setForeground(Color.LIGHT_GRAY);
		lblKullaniciAdi_4_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblKullaniciAdi_4_2.setBounds(525, 195, 95, 30);
		contentPane.add(lblKullaniciAdi_4_2);

		textField_5 = new JTextField();
		textField_5.setForeground(Color.WHITE);
		textField_5.setColumns(10);
		textField_5.setBackground(Color.DARK_GRAY);
		textField_5.setBounds(641, 198, 133, 25);
		contentPane.add(textField_5);

	
		
		imageLabel = new JLabel("");
		imageLabel.setBounds(830, 26, 194, 143);
		contentPane.add(imageLabel);

		JButton btnAraResimEkle = new JButton("RES\u0130M G\u00DCNCELLE");
		btnAraResimEkle.addMouseListener(new MouseAdapter() {
			JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			@Override
			public void mousePressed(MouseEvent e) {
				
				fileChooser.setDialogTitle("BİR RESİM SEÇ");
				fileChooser.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG and GIF images", "png", "gif");
				fileChooser.addChoosableFileFilter(filter);

				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					//System.out.println(fileChooser.getSelectedFile().getPath());
					carImage = new ImageIcon(fileChooser.getSelectedFile().getPath());
					imageLabel.setIcon(carImage);
					
						
			
				}
			}
		});
		btnAraResimEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAraResimEkle.setForeground(Color.LIGHT_GRAY);
		btnAraResimEkle.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		btnAraResimEkle.setBackground(Color.DARK_GRAY);
		btnAraResimEkle.setBounds(819, 195, 210, 30);
		contentPane.add(btnAraResimEkle);
		
		JLabel lblKullaniciAdi_3_1 = new JLabel("ARA\u00C7LAR");
		lblKullaniciAdi_3_1.setForeground(Color.LIGHT_GRAY);
		lblKullaniciAdi_3_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblKullaniciAdi_3_1.setBounds(445, 11, 366, 30);
		contentPane.add(lblKullaniciAdi_3_1);
		
		JButton btnGncelle = new JButton("G\u00DCNCELLE");
		btnGncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGncelle.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.print(rootPaneCheckingEnabled);
				
				if(textField_6.getText()=="" || textField.getText()=="" ||textField_1.getText()=="" ||textField_2.getText()=="" ||textField_3.getText()=="" ||textField_4.getText()=="" ||comboBox.
						getSelectedItem().toString()=="" ||comboBox_1.getSelectedItem().toString()=="" ||comboBox_2.getSelectedItem().toString()=="" ||textField_5.getText()=="")
				{
					
					JOptionPane.showMessageDialog(null,
							"Lütfen Bilgileri Güncelleyiniz.",
							"Uyari mesaji",
							JOptionPane.WARNING_MESSAGE);

				}
				else
				{
					
					AracIslemleri guncelle= new AracIslemleri(Integer.parseInt(textField_6.getText()),textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText(),textField_4.getText(),comboBox.
							getSelectedItem().toString(),comboBox_1.getSelectedItem().toString(),comboBox_2.getSelectedItem().toString(),Integer.parseInt(textField_5.getText()),imageLabel.getIcon().toString());
					try {
						
						guncelle.Update(guncelle);
							
						ClearTable();
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
			}
		});
		btnGncelle.setForeground(Color.LIGHT_GRAY);
		btnGncelle.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		btnGncelle.setBackground(Color.DARK_GRAY);
		btnGncelle.setBounds(819, 232, 210, 30);
		contentPane.add(btnGncelle);
		
		JLabel lblId = new JLabel("ID=");
		lblId.setForeground(Color.LIGHT_GRAY);
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblId.setBounds(10, 26, 95, 30);
		contentPane.add(lblId);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setForeground(Color.WHITE);
		textField_6.setColumns(10);
		textField_6.setBackground(Color.DARK_GRAY);
		textField_6.setBounds(75, 29, 133, 25);
		contentPane.add(textField_6);
	}	
}
