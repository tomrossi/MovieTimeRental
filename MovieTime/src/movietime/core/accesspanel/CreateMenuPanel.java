package movietime.core.accesspanel;

import javax.swing.JFrame;

import movietime.core.user.Admin;
import movietime.core.user.Client;

public class CreateMenuPanel implements Visitor {

	private JFrame frame;
	public MenuPanel menuPanel;
	private String fileNameImage = "star.jpg";

	public CreateMenuPanel(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public MenuPanel createPanelAccess(Client client) {
		menuPanel = new MenuClient(frame, fileNameImage);
		return menuPanel;
	}

	@Override
	public MenuPanel createPanelAccess(Admin admin) {
		menuPanel = new MenuAdmin(frame, fileNameImage);
		return menuPanel;
	}
	
	@Override
	public MenuPanel getMenuPanel() {
		return menuPanel;
	}

}
