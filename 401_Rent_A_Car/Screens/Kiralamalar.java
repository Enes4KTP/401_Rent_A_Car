import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Kiralamalar extends JFrame {
	JTable table = new JTable();
	private JPanel contentPane;
	DefaultTableModel designModel;
	ArrayList<SozlesmeIslemleri> sozlesmeList= new ArrayList<>();
	SozlesmeIslemleri sozlesme;
	String tarih,tarih1;
	/**
	 * Launch the application.
	 */
	public ArrayList<SozlesmeIslemleri> sozlesmeListesi()
	{

		try{
			SozlesmeIslemleri tools= new SozlesmeIslemleri();
		tools.acDataBaseOpen();
		String query="SELECT * FROM Sozlesmeler";
		Statement st= tools.connection.createStatement();
		ResultSet rs= st.executeQuery(query);
		while(rs.next())
		{
		sozlesme=new SozlesmeIslemleri(rs.getInt("ID"),rs.getString("KiralamaTarih"),
					rs.getString("TeslimTarihi"),rs.getString("arabaID"));
		
			sozlesmeList.add(sozlesme);
		}
		}
		catch(Exception e )
		{
			JOptionPane.showMessageDialog(null, e);
		}
		return sozlesmeList;
	}
	Object[] row = new Object[4];
	
	public String aracID,kullaniciID;

	public void listele()
	{
		ArrayList<SozlesmeIslemleri> list= sozlesmeListesi();
		designModel=(DefaultTableModel) table.getModel();
		String header[]= new String[] {"musteriID", "TarihBaslangic", "TarihSon"};
		designModel.setColumnIdentifiers(header);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		    	DefaultTableModel model= (DefaultTableModel) table.getModel();
				int selectedRowIndex=table.getSelectedRow();
				kullaniciID= model.getValueAt(selectedRowIndex, 0).toString();
				
				tarih=model.getValueAt(selectedRowIndex, 1).toString();
				tarih1=model.getValueAt(selectedRowIndex, 2).toString();
				aracID=sozlesme.getAracID().toString();
				
				int yýl1,yýl2,ay1,ay2,gun1,gun2,hesap;
		
		
				
				    yýl1=Integer.parseInt(tarih.substring(0,4));
				    ay1=Integer.parseInt(tarih.substring(5,7));
				    gun1=Integer.parseInt(tarih.substring(8,10));
				    
				
	
			    yýl2=Integer.parseInt(tarih1.substring(0,4));
			    ay2=Integer.parseInt(tarih1.substring(5,7));
			    gun2=Integer.parseInt(tarih1.substring(8,10));
			    
			    hesap=(yýl2-yýl1)*365+(ay2-ay1)*30+(gun2-gun1);
			    if(hesap<0)
			    {
			    	
			    	JOptionPane.showMessageDialog(null,
							"HATALI DURUM !",
							"Uyari mesaji",
							JOptionPane.WARNING_MESSAGE);
			    }
			    else if (hesap==0)
			    {
			    	JOptionPane.showMessageDialog(null,
							"Seçilen sözleþmenin kontrat süresi bitmiþtir, silebilirsiniz",
							"Uyari mesaji",
							JOptionPane.WARNING_MESSAGE);	
			    	
			    }
			    else
			    {
			    	JOptionPane.showMessageDialog(null,
							"Sözleþmenin bitimine '"+hesap+"' gün kalmýþtýr.",
							"Uyari mesaji",
							JOptionPane.WARNING_MESSAGE);
			  
			    }
			}
			
		});
		table.setModel(designModel);
		//BÝLGÝLERÝ GETÝR
	for(int i=0;i<list.size();i++)
	{
		row[0]=list.get(i).getKullaniciID();
		row[1]=list.get(i).getIlktarih();
		row[2]=list.get(i).getSontarih();
	
		
		designModel.addRow(row);
	}
		
	}
	public void ClearTable()
	{
		
		DefaultTableModel clearModel = (DefaultTableModel) table.getModel();
		
		clearModel.setRowCount(0); //her þeyi sýfýrlýyorum
		 ArrayList<SozlesmeIslemleri> products = new ArrayList<SozlesmeIslemleri>();
	        products = new Kiralamalar().sozlesmeListesi();
	        
	        String[] data = new String[4];
	       
	        for(int i=0;i<sozlesmeList.size();i++)
			{
				System.out.println(sozlesmeList.get(i));
			}
	        for (int i = 0; i < products.size()-sozlesmeList.size(); i++) {
	            data[0] = String.valueOf(products.get(i).getKullaniciID());
	            data[1] = products.get(i).getIlktarih();
	            data[2] = products.get(i).getSontarih();
	            
	    
	            designModel.addRow(data);          
	        }

	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kiralamalar frame = new Kiralamalar();
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
	
	
	
	

	public Kiralamalar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 663);

		setLocationRelativeTo(null); // Ortala

		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane p = new JScrollPane(table);
		p.setBounds(10, 46, 759, 508);
		contentPane.add(p);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"musteriID", "TarihBaslangic", "TarihSon"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.setBounds(49, 46, 678, 516);
		listele();
		
		JButton btnSzleme = new JButton("S\u00D6ZLE\u015EME FES\u0130H");
		btnSzleme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tarih!="")
				{
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(btnSzleme, "SÖZLEÞME FESÝH", "Kayýtla birlikte, sözleþme fesh edilip araç boþa çýkacaktýr kabul ediyor musunuz ?", dialogButton);
				if(dialogResult == 0) {
				  System.out.println("Yes option");
		  SozlesmeIslemleri sonislem=new SozlesmeIslemleri(Integer.parseInt(kullaniciID),aracID);
		  try {
			sonislem.Delete(sonislem);
			ClearTable();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				} else {
				  System.out.println("No Option");
				} 
				}
				else
				{
					JOptionPane.showMessageDialog(null,
							"Lütfen seçim yapýnýz.",
							"Uyari mesaji",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnSzleme.setForeground(Color.LIGHT_GRAY);
		btnSzleme.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		btnSzleme.setBackground(Color.DARK_GRAY);
		btnSzleme.setBounds(831, 46, 178, 75);
		contentPane.add(btnSzleme);
		
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
	}
}
