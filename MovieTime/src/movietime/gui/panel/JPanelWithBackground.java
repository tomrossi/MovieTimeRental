package movietime.gui.panel;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import movietime.core.database.DatabaseMovie;
import movietime.core.database.DatabaseUser;
import movietime.core.user.User;
import movietime.gui.component.ComponentGetter;

public abstract class JPanelWithBackground extends JPanel implements PanelInterface {

	private URL imageURL;// PERCORSO DELL'IMMAGINE
	private Image image;// IMMAGINE
	private User currentUser;// UTENTE
	private JPanel visiblePanel;// PANNELLO VISIBILE
	private JFrame frame;// FINESTRA PRINCIPALE
	private ComponentGetter myComponentGetter;// OGGETTO CHE RICHIAMA LISTA
												// PANNELLI
	private DatabaseUser dbUser;
	private DatabaseMovie dbMovie;

	public JPanelWithBackground(JFrame frame, String fileNameImage) {
		this.frame = frame;
		myComponentGetter = new ComponentGetter();
		setSize();
		setImage(fileNameImage);
		loadImage(image);
	}

	public void setImage(String fileNameImage) {
		setSize();
		URL url = JPanelWithBackground.class.getResource(fileNameImage);
		image = Toolkit.getDefaultToolkit().createImage(url);
		loadImage(image);
	}

	private void loadImage(Image img) {
		try {
			MediaTracker track = new MediaTracker(this);
			track.addImage(img, 0);
			track.waitForID(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void setSize() {
		Dimension size = new Dimension(800, 600);
		this.setPreferredSize(size);
		this.setMinimumSize(size);
		this.setMaximumSize(size);
		this.setSize(size);
		this.setLayout(null);
	}

	@Override
	public void paintComponents(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
		g.drawImage(image, 0, 0, null);
	}

	@Override
	public void setPanelsVisibility() {
		List<Component> myComponents = new ArrayList<Component>();
		myComponents = myComponentGetter.getComponents(frame);
		for (Component comp : myComponents) {
			if (comp.getClass().equals(visiblePanel) && !comp.equals(visiblePanel)) {
				comp.setVisible(false);
			}
		}
		this.setVisible(false);
		visiblePanel.setVisible(true);

	}

	@Override
	public JFrame getFrame() {
		return frame;
	}

	public Image getImage() {
		return image;
	}

	public JPanel getVisiblePanel() {
		return visiblePanel;
	}

	@Override
	public void setVisiblePanel(JPanel visiblePanel, JFrame frame) {
		this.visiblePanel = visiblePanel;
		this.frame = frame;
	}

	public void setUser(User userAccess) {
		this.currentUser = userAccess;

	}

	public User getUser() {
		return currentUser;
	}

	public DatabaseUser getDbUser() {
		return dbUser;
	}

	public DatabaseMovie getDbMovie() {
		return dbMovie;
	}

	public void setDbUser(DatabaseUser dbUser) {
		this.dbUser = dbUser;
	}

	public void setDbMovie(DatabaseMovie dbMovie) {
		this.dbMovie = dbMovie;
	}

}
