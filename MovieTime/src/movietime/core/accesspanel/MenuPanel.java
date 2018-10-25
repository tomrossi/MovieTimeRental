package movietime.core.accesspanel;

import javax.swing.JFrame;

import movietime.core.database.DatabaseMovie;
import movietime.core.database.DatabaseUser;
import movietime.core.user.User;

public abstract class MenuPanel extends JPanelWithBackgroundAndLogoutBtn {

	public MenuPanel(JFrame frame, String fileNameImage) {
		super(frame, fileNameImage);
		// TODO Auto-generated constructor stub
	}

	public abstract void setUserDataComponent(User u, DatabaseMovie dbMovie, DatabaseUser dbUser);

}
