package movietime.core.main;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import movietime.gui.panel.HomepagePanel;

public class MovieTimeUI extends JPanel {

	private Image img;
	public JFrame frame;
	public HomepagePanel homepagePanel;

	
	public MovieTimeUI(String img) {
		this(new ImageIcon(img).getImage());
	}

	public MovieTimeUI(Image img) {
		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
	}

	public MovieTimeUI() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("Arial", Font.PLAIN, 16));
		frame.setTitle("MovieTime VideoRental");
		frame.setMaximumSize(new Dimension(800, 600));
		frame.setMinimumSize(new Dimension(800, 600));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		try {
			homepagePanel = new HomepagePanel(frame, "star2.jpg");
			frame.getContentPane().add(homepagePanel);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
