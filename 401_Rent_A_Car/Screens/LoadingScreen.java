import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class LoadingScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
	
			public void run() {
				try {
					LoadingScreen frame = new LoadingScreen();
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
	public LoadingScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null); // Ekrana Ortalýyorum
		setVisible(true); // Güzel Bir Görünüþ Saðlýyor.
		setContentPane(contentPane);
		JLabel ProgressLabel = new JLabel("New label");
		ProgressLabel.setForeground(Color.RED);
		ProgressLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		ProgressLabel.setBounds(307, 412, 240, 38);
		getContentPane().add(ProgressLabel);

		// BAR//

		JProgressBar progressBar = new JProgressBar();
		progressBar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		progressBar.setForeground(Color.RED);
		progressBar.setBackground(Color.WHITE);
		progressBar.setBounds(177, 460, 467, 38);
		getContentPane().add(progressBar);

		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 101; i++) {
					try {

						progressBar.setValue(i);
						TimeUnit.MILLISECONDS.sleep(70);

					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					if (i > 0 && i < 70) {
						ProgressLabel.setText("Veri Tabanýna Eriþiliyor..");
					} else if (i > 70 && i < 90) {
						ProgressLabel.setText("Program Baþlatýlýyor..");
					} else if (i == 100) {
						setVisible(false);
						Manager_Screen s1 = new Manager_Screen();
						s1.setVisible(true);
					}
				}
			}
		};
		t1.start();

		JLabel Label1 = new JLabel("");
		Label1.setBounds(-14, -57, 873, 588);
		getContentPane().add(Label1);

		// ArkaPlan Ýþlemleri//

		Image img = new ImageIcon(this.getClass().getResource("carBG.jpg")).getImage();
		Label1.setIcon(new ImageIcon(img));
	}

}
