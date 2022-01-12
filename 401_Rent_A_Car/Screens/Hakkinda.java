
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenu;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
public class Hakkinda extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hakkinda frame = new Hakkinda();
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
	String aciklama="401 Rent a Car olarak, d�nyada fark yaratan bir marka olma hedefiyle 2021 y�l�nda Evin Erkek ��renci Yurdu�nda 401 numaral� odada yola ��kt�k. Hayalimiz, ara� kiralamay� birka� �t�k� ile tamamlayacak bir platformu hayata kazand�rmak ve insanlar�n yol arkada�� olmakt�. Ara� kiralama trendinin y�kselmesiyle birlikte sekt�rde t�m payda�lar� bir araya getirecek bir platformun ihtiyac�n� hissettik. En b�y�k arzumuz bu ihtiyaca en h�zl�, uygun ve pratik ��z�mlerle cevap verebilmekti. Bu b�y�k arzu, teknolojimizin g�c� ve ekibimizin motivasyonuyla birle�erek hayat buldu. T�m misafirlerimize diledikleri ara�lar� en uygun fiyat garantisi ile sunarken, ara� kiralama sekt�r�nde de benzersiz bir platform olma yolunda emin ad�mlarla ilerledik.";
	public Hakkinda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 663);
		setBackground(new Color(51, 51, 51));
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

		
		JMenu carMenu = new JMenu("Ara� ��lemeleri");
		JMenu contratMenu = new JMenu("S�zle�me ��lemleri");
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
		JMenu infoMenu = new JMenu("Hakk�nda");
		infoMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Hakkinda jump = new Hakkinda();
				setVisible(false);
				jump.setVisible(true);
			}
		});

		
		

		JMenuItem s5 = new JMenuItem("Ara� Listele");
		s5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AracListele jump = null;
				jump = new AracListele();
				setVisible(false);
				jump.setVisible(true);
			}
		});
		JMenuItem s6 = new JMenuItem("Ara� Ekle");
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
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html><p>'"+aciklama+"'</p></html>");
		lblNewLabel.setForeground(new Color(255, 222, 173));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel.setBounds(52, 70, 966, 374);
		contentPane.add(lblNewLabel);
	}
}
