import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;


public class Sozlesme extends JFrame {
	JTable aracTable= new JTable();
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_10;
	private JTextField textField_9;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_23;
	private JTextArea textArea1;
	private JComboBox comboBox_1;
	private JTextArea textArea1_1;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;
	JFormattedTextField cepFormatted_1_1;
	JFormattedTextField tcKimlikFormatted_1;
	private String date;
    String date2;
   public  double sonfiyattutucu;
   public String yasKontrol,durumKontrol;
   JFormattedTextField dogumTarihiFormatted ;
   
   
   
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
		
		DefaultTableModel clearModel = (DefaultTableModel) aracTable.getModel();
		
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

	DefaultTableModel designModel;
	ArrayList<AracIslemleri> carsList= new ArrayList<>();
	AracIslemleri cars; //Coasters
	Object[] row = new Object[12];
	ArrayList<AracIslemleri> list;
	public void listele()
	{
	  
		list= carList();
	 designModel = (DefaultTableModel) aracTable.getModel();
	String header[] = new String[] { "ID", "MARKA", "MODEL", "YIL", "PLAKA", "RENK", "YAKIT T\u0130P\u0130", "V\u0130TES", "YAS SINIRI", "F\u0130YAT" ,"KiralanmaDurumu"};
	designModel.setColumnIdentifiers(header);
	aracTable.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		DefaultTableModel model= (DefaultTableModel) aracTable.getModel();
			int selectedRowIndex=aracTable.getSelectedRow();
			textField_13.setText(model.getValueAt(selectedRowIndex, 0).toString());
			textField_14.setText(model.getValueAt(selectedRowIndex, 1).toString());
			textField_15.setText(model.getValueAt(selectedRowIndex, 2).toString());
			textField_16.setText(model.getValueAt(selectedRowIndex, 10).toString());
			sonfiyattutucu=Double.parseDouble(model.getValueAt(selectedRowIndex, 9).toString());
			yasKontrol=model.getValueAt(selectedRowIndex,8).toString();
			durumKontrol=model.getValueAt(selectedRowIndex, 10).toString();
			
		}
		
	});


	aracTable.setModel(designModel);
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
					Sozlesme frame = new Sozlesme();
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
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	
	public Sozlesme() {
		setTitle("S\u00F6zle\u015Fmeler");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 663);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TC Kimlik NO:");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 62, 110, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblSoyad = new JLabel("Ad:");
		lblSoyad.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSoyad.setForeground(Color.LIGHT_GRAY);
		lblSoyad.setBackground(Color.LIGHT_GRAY);
		lblSoyad.setBounds(10, 10, 40, 15);
		contentPane.add(lblSoyad);


	
		JLabel lblSoyad_1 = new JLabel("Soyad:");
		lblSoyad_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSoyad_1.setForeground(Color.LIGHT_GRAY);
		lblSoyad_1.setBackground(Color.LIGHT_GRAY);;
		lblSoyad_1.setBounds(10, 36, 76, 15);
		contentPane.add(lblSoyad_1);
		
		JLabel lblCinsiyet = new JLabel("Cinsiyet:");
		lblCinsiyet.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCinsiyet.setForeground(Color.LIGHT_GRAY);
		lblCinsiyet.setBackground(Color.LIGHT_GRAY);
		lblCinsiyet.setBounds(10, 143, 86, 15);
		contentPane.add(lblCinsiyet);
		
		JLabel lblDogumTarihi = new JLabel("Do\u011Fum Tarihi:");
		lblDogumTarihi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDogumTarihi.setForeground(Color.LIGHT_GRAY);
		lblDogumTarihi.setBackground(Color.LIGHT_GRAY);
		lblDogumTarihi.setBounds(10, 89, 86, 15);
		contentPane.add(lblDogumTarihi);
		
		JLabel lblDogumYeri = new JLabel("Do\u011Fum Yeri:");
		lblDogumYeri.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDogumYeri.setForeground(Color.LIGHT_GRAY);
		lblDogumYeri.setBackground(Color.LIGHT_GRAY);
		lblDogumYeri.setBounds(10, 115, 76, 15);
		contentPane.add(lblDogumYeri);
		
		JLabel lblCepTelefonu = new JLabel("Cep Telefonu:");
		lblCepTelefonu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCepTelefonu.setForeground(Color.LIGHT_GRAY);
		lblCepTelefonu.setBackground(Color.LIGHT_GRAY);
		lblCepTelefonu.setBounds(10, 169, 85, 15);
		contentPane.add(lblCepTelefonu);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblEmail.setForeground(Color.LIGHT_GRAY);
		lblEmail.setBackground(Color.LIGHT_GRAY);
		lblEmail.setBounds(10, 196, 50, 14);
		contentPane.add(lblEmail);
		
		JLabel lblAdres = new JLabel("Adres:");
		lblAdres.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblAdres.setForeground(Color.LIGHT_GRAY);
		lblAdres.setBackground(Color.LIGHT_GRAY);
		lblAdres.setBounds(10, 223, 40, 14);
		contentPane.add(lblAdres);
		
		JLabel lblEhliyetTarihi = new JLabel("Ehliyet Tarihi:");
		lblEhliyetTarihi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblEhliyetTarihi.setForeground(Color.LIGHT_GRAY);
		lblEhliyetTarihi.setBackground(Color.LIGHT_GRAY);
		lblEhliyetTarihi.setBounds(22, 289, 85, 14);
		contentPane.add(lblEhliyetTarihi);
		
		JLabel lblEhliyetTipi = new JLabel("Ehliyet Tipi:");
		lblEhliyetTipi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblEhliyetTipi.setForeground(Color.LIGHT_GRAY);
		lblEhliyetTipi.setBackground(Color.LIGHT_GRAY);
		lblEhliyetTipi.setBounds(22, 324, 110, 14);
		contentPane.add(lblEhliyetTipi);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(105, 10, 85, 16);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(105, 36, 85, 16);
		contentPane.add(textField_2);
		
		textField_5 = new JTextField();
		
		textField_5.setColumns(10);
		textField_5.setBounds(105, 115, 85, 16);
		contentPane.add(textField_5);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(105, 196, 185, 16);
		contentPane.add(textField_7);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(117, 322, 85, 16);
		contentPane.add(textField_10);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Erkek", "Kad\u0131n"}));
		comboBox.setBounds(105, 143, 85, 16);
		contentPane.add(comboBox);
		lblEhliyetTipi.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblKefilAd = new JLabel("Kefil Ad:");
		lblKefilAd.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblKefilAd.setForeground(Color.LIGHT_GRAY);
		lblKefilAd.setBackground(Color.LIGHT_GRAY);
		lblKefilAd.setBounds(357, 35, 85, 15);
		contentPane.add(lblKefilAd);
		
		JLabel lblKefilSoyad = new JLabel("Kefil Soyad:");
		lblKefilSoyad.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblKefilSoyad.setForeground(Color.LIGHT_GRAY);
		lblKefilSoyad.setBackground(Color.LIGHT_GRAY);
		lblKefilSoyad.setBounds(357, 60, 85, 15);
		contentPane.add(lblKefilSoyad);
		
		JLabel lblKefilAdresi = new JLabel("Kefil Adres:");
		lblKefilAdresi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblKefilAdresi.setForeground(Color.LIGHT_GRAY);
		lblKefilAdresi.setBackground(Color.LIGHT_GRAY);
		lblKefilAdresi.setBounds(357, 85, 85, 15);
		contentPane.add(lblKefilAdresi);
		
		JLabel lblKefilTelefon = new JLabel("Kefil Telefon:");
		lblKefilTelefon.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblKefilTelefon.setForeground(Color.LIGHT_GRAY);
		lblKefilTelefon.setBackground(Color.LIGHT_GRAY);
		lblKefilTelefon.setBounds(357, 160, 85, 15);
		contentPane.add(lblKefilTelefon);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(452, 33, 85, 16);
		contentPane.add(textField_9);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(452, 58, 85, 16);
		contentPane.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(452, 158, 138, 16);
		contentPane.add(textField_12);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblGnlk = new JLabel("Kiralanma G\u00FCn\u00FC :");
		lblGnlk.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGnlk.setBounds(357, 210, 151, 15);
		lblGnlk.setForeground(Color.LIGHT_GRAY);
		lblGnlk.setBackground(Color.LIGHT_GRAY);
		contentPane.add(lblGnlk);
		
		JLabel lblTutar = new JLabel("Tutar:");
		lblTutar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTutar.setForeground(Color.LIGHT_GRAY);
		lblTutar.setBackground(Color.LIGHT_GRAY);
		lblTutar.setBounds(390, 283, 85, 15);
		contentPane.add(lblTutar);
		
		textField_23 = new JTextField();
		textField_23.setEditable(false);
		textField_23.setColumns(10);
		textField_23.setBounds(476, 283, 85, 16);
		contentPane.add(textField_23);
		
		JButton btnAraResimEkle = new JButton("K\u0130RALA");
		btnAraResimEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_1.getText()==null||textField_2.getText()==null||tcKimlikFormatted_1.getText()==null||dogumTarihiFormatted.getText()==null||textField_5.getText()==null||comboBox.getSelectedItem().toString()==null||cepFormatted_1_1.getText()==null||textField_7.getText()==null||
						textArea1.getText()==null||comboBox_1.getSelectedItem().toString()==""||textField_10.getText()==""||textField_9.getText()==""||textField_11.getText()==""||textArea1_1.getText()==""||
						textField_12.getText()==null||dateChooser.getDate().toString()==null||dateChooser_1.getDate().toString()==null||textField_23.getText()==null||textField_13.getText()==null)
				{
					JOptionPane.showMessageDialog(null,
							"Lütfen her şeyi doldurunuz !!",
							"Uyari mesaji",
							JOptionPane.WARNING_MESSAGE);
					
				}
				else
				{
					
					
					if(textField_16.getText().equals("Kiralanmadı"))
					{
						
					int yas=2022-Integer.parseInt(dogumTarihiFormatted.getText());
					if(yasKontrol.equals("30 Yaş Ve Üstü")&& yas<30)
					{
						JOptionPane.showMessageDialog(null,
								"Seçtiğiniz araba 30 yaş altına verilmemektedir !!",
								"Uyari mesaji",
								JOptionPane.WARNING_MESSAGE);
						
					}
					else if(yasKontrol.equals("25 Yaş Ve Üstü")&& yas<25)
					{	JOptionPane.showMessageDialog(null,
							"Seçtiğiniz araba 25 yaş altına verilmemektedir !!",
							"Uyari mesaji",
							JOptionPane.WARNING_MESSAGE);
						
					}
					else if(yasKontrol.equals("20 Yaş Ve Üstü")&& yas<20)
					{	JOptionPane.showMessageDialog(null,
							"Seçtiğiniz araba 20 yaş altına verilmemektedir !!",
							"Uyari mesaji",
							JOptionPane.WARNING_MESSAGE);
						
					}
					else
					{
						
					
					SozlesmeIslemleri ekle= new SozlesmeIslemleri(textField_1.getText(),textField_2.getText(),tcKimlikFormatted_1.getText(),dogumTarihiFormatted.getText(),textField_5.getText()
							,comboBox.getSelectedItem().toString(),cepFormatted_1_1.getText(),textField_7.getText(),textArea1.getText(),comboBox_1.getSelectedItem().toString(),
							textField_10.getText(),textField_9.getText(),textField_11.getText(),textArea1_1.getText(),textField_12.getText(),date,date2,Double.parseDouble(textField_23.getText()),
							textField_13.getText());
			
					try {
						ekle.Insert(ekle);
						ekle.Update(ekle);
						ClearTable();
						JOptionPane.showMessageDialog(null,
							    "Hayırlı olsun süre bitimine kadar araç sizindir.",
							    "İŞLEM BAŞARILI BİR ŞEKİLDE TAMLANDI",
							    JOptionPane.PLAIN_MESSAGE);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						}
					}
					else {
						JOptionPane.showMessageDialog(null,
								"Seçtiğiniz araba kiralanmıştır. !!",
								"Uyari mesaji",
								JOptionPane.WARNING_MESSAGE);
					}
				
					}
			}
				}
			);
		btnAraResimEkle.setForeground(Color.LIGHT_GRAY);
		btnAraResimEkle.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		btnAraResimEkle.setBackground(Color.DARK_GRAY);
		btnAraResimEkle.setBounds(894, 24, 126, 42);
		contentPane.add(btnAraResimEkle);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setForeground(Color.LIGHT_GRAY);
		comboBox_1.setBackground(Color.DARK_GRAY);
		comboBox_1.setBounds(117, 291, 103, 23);
		comboBox_1.addItem("");
		
		for(int i=1950;i<=2022;i++)
		{
			comboBox_1.addItem(i);
		}
		contentPane.add(comboBox_1);
		
		JScrollPane p = new JScrollPane(aracTable);
		p.setBounds(22, 365, 1021, 226);
		contentPane.add(p);
		
	
		
		//ŞARTLANDIRMA
		aracTable.setModel(new DefaultTableModel(
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
				false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
			
			});
		
		JLabel lblGnlk_1 = new JLabel("ID :");
		lblGnlk_1.setForeground(Color.LIGHT_GRAY);
		lblGnlk_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGnlk_1.setBackground(Color.LIGHT_GRAY);
		lblGnlk_1.setBounds(744, 35, 40, 15);
		contentPane.add(lblGnlk_1);
		
		textField_13 = new JTextField();
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBounds(781, 35, 85, 16);
		contentPane.add(textField_13);
		
		JLabel lblGnlk_1_1 = new JLabel("-SE\u00C7\u0130LEN ARABA-");
		lblGnlk_1_1.setForeground(Color.LIGHT_GRAY);
		lblGnlk_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGnlk_1_1.setBackground(Color.LIGHT_GRAY);
		lblGnlk_1_1.setBounds(700, 10, 151, 15);
		contentPane.add(lblGnlk_1_1);
		
		JLabel lblGnlk_1_2 = new JLabel("MARKA :");
		lblGnlk_1_2.setForeground(Color.LIGHT_GRAY);
		lblGnlk_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGnlk_1_2.setBackground(Color.LIGHT_GRAY);
		lblGnlk_1_2.setBounds(710, 71, 76, 15);
		contentPane.add(lblGnlk_1_2);
		
		textField_14 = new JTextField();
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		textField_14.setBounds(781, 71, 85, 16);
		contentPane.add(textField_14);
		
		JLabel lblGnlk_1_3 = new JLabel("MODEL :");
		lblGnlk_1_3.setForeground(Color.LIGHT_GRAY);
		lblGnlk_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGnlk_1_3.setBackground(Color.LIGHT_GRAY);
		lblGnlk_1_3.setBounds(710, 97, 61, 15);
		contentPane.add(lblGnlk_1_3);
		
		textField_15 = new JTextField();
		textField_15.setEditable(false);
		textField_15.setColumns(10);
		textField_15.setBounds(781, 97, 85, 16);
		contentPane.add(textField_15);
		
		JLabel lblGnlk_1_3_1 = new JLabel("DURUM :");
		lblGnlk_1_3_1.setForeground(Color.LIGHT_GRAY);
		lblGnlk_1_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGnlk_1_3_1.setBackground(Color.LIGHT_GRAY);
		lblGnlk_1_3_1.setBounds(710, 123, 61, 15);
		contentPane.add(lblGnlk_1_3_1);
		
		textField_16 = new JTextField();
		textField_16.setEditable(false);
		textField_16.setColumns(10);
		textField_16.setBounds(781, 123, 85, 16);
		contentPane.add(textField_16);
		
		 textArea1 = new JTextArea();
		textArea1.setLineWrap(true);
		textArea1.setBounds(105, 221, 203, 57);
		contentPane.add(textArea1);
		
		JButton btnHesapla = new JButton("Hesapla");
		btnHesapla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int yıl1,yıl2,ay1,ay2,gun1,gun2;
				if(dateChooser.getDate()==null||dateChooser_1.getDate()==null)
				{
					JOptionPane.showMessageDialog(null,
							"Lütfen tarih bilgileri tam giriniz.",
							"Uyari mesaji",
							JOptionPane.WARNING_MESSAGE);
				}
				else
				{

				 SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
				    date = dcn.format(dateChooser.getDate());
				    
				    yıl1=Integer.parseInt(date.substring(0,4));
				    ay1=Integer.parseInt(date.substring(5,7));
				    gun1=Integer.parseInt(date.substring(8,10));
				    
				     date2= dcn.format(dateChooser_1.getDate());
				    yıl2=Integer.parseInt(date2.substring(0,4));
				    ay2=Integer.parseInt(date2.substring(5,7));
				    gun2=Integer.parseInt(date2.substring(8,10));
				    double  tutar=0;
				    if(yıl2==yıl1 && ay2<ay1)
			
				    {
				    		JOptionPane.showMessageDialog(null,
									"Son tarih, ilk tarihten geride olamaz. Lütfen Düzeltiniz.",
									"Uyari mesaji",
									JOptionPane.WARNING_MESSAGE);	
				    }
				    else if(yıl1>yıl2)
				    {
				    	JOptionPane.showMessageDialog(null,
								"Son tarih, ilk tarihten geride olamaz. Lütfen Düzeltiniz.",
								"Uyari mesaji",
								JOptionPane.WARNING_MESSAGE);
				    }
				    else
				    {
				    	tutar=((yıl2-yıl1)*sonfiyattutucu*365)+((ay2-ay1)*sonfiyattutucu*30)+((gun2-gun1)*sonfiyattutucu);
				    	
				    }
				    if(yıl2==yıl1&& ay2==ay1&& gun2<gun1)
				    {JOptionPane.showMessageDialog(null,
							"Son tarih, ilk tarihten geride olamaz. Lütfen Düzeltiniz.",
							"Uyari mesaji",
							JOptionPane.WARNING_MESSAGE);
				    	
				    }
				    else if (gun1==gun2)
				    {
				    	JOptionPane.showMessageDialog(null,
				    	"Aynı gün seçim yapılmaz !!",
						"Uyari mesaji",
						JOptionPane.WARNING_MESSAGE);
				    }
				    else
				    {
				    	tutar=((yıl2-yıl1)*sonfiyattutucu*365)+((ay2-ay1)*sonfiyattutucu*30)+((gun2-gun1)*sonfiyattutucu);
				    	
				    }
				    if(tutar>0) //Kontrol Aşaması
				    {
				    	
				    	textField_23.setText(Double.toString(tutar));
				    }
				    
				   
				    
				  
				    
				
				    
				    
				}
			}
		});
		btnHesapla.setForeground(Color.LIGHT_GRAY);
		btnHesapla.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		btnHesapla.setBackground(Color.DARK_GRAY);
		btnHesapla.setBounds(621, 209, 91, 23);
		contentPane.add(btnHesapla);
		
		textArea1_1 = new JTextArea();
		textArea1_1.setLineWrap(true);
		textArea1_1.setBounds(452, 81, 203, 57);
		contentPane.add(textArea1_1);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(467, 210, 126, 20);
		contentPane.add(dateChooser);
		
		JLabel lblGnlk_2 = new JLabel("Teslim G\u00FCn\u00FC :");
		lblGnlk_2.setForeground(Color.LIGHT_GRAY);
		lblGnlk_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGnlk_2.setBackground(Color.LIGHT_GRAY);
		lblGnlk_2.setBounds(377, 246, 110, 15);
		contentPane.add(lblGnlk_2);
		
		 dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(467, 241, 126, 20);
		contentPane.add(dateChooser_1);
		
		NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(0);
	    formatter.setMaximum(Integer.MAX_VALUE);
	    formatter.setAllowsInvalid(false);
	    // If you want the value to be committed on each keystroke instead of focus lost
	    formatter.setCommitsOnValidEdit(true);
	    format.setGroupingUsed(false);
		 dogumTarihiFormatted = new JFormattedTextField(formatter);
		dogumTarihiFormatted.setBounds(106, 87, 86, 20);
		contentPane.add(dogumTarihiFormatted);
		
		tcKimlikFormatted_1 = new JFormattedTextField(formatter);
		tcKimlikFormatted_1.setBounds(105, 61, 86, 15);
		contentPane.add(tcKimlikFormatted_1);
		
		JFormattedTextField cepFormatted_1_1 = new JFormattedTextField(formatter);
		cepFormatted_1_1.setBounds(107, 168, 86, 16);
		contentPane.add(cepFormatted_1_1);
		//Listelenen Verilerin TextField'lere Aktarılması//
		
		listele();
		
		
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

	}
}

