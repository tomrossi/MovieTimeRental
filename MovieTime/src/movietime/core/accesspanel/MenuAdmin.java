package movietime.core.accesspanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import movietime.core.creator.ComponentCreator;
import movietime.core.database.DatabaseMovie;
import movietime.core.database.DatabaseUser;
import movietime.core.user.User;
import movietime.gui.panelwithbackbutton.EditDatabaseMoviePanel;
import movietime.gui.panelwithbackbutton.EditDatabaseUserPanel;

public class MenuAdmin extends MenuClient {

	private JButton btnModDBMovie;
	private JButton btnModDBUser;
	private EditDatabaseUserPanel DBUserPanel;
	private EditDatabaseMoviePanel DBMoviePanel;
	private ComponentCreator componentCreator;

	public MenuAdmin(JFrame frame, String fileNameImage) {
		super(frame, fileNameImage);
		componentCreator = new ComponentCreator();
		DBUserPanel = new EditDatabaseUserPanel(getFrame());
		DBMoviePanel = new EditDatabaseMoviePanel(getFrame());
		getFrame().getContentPane().add(DBMoviePanel);
		getFrame().getContentPane().add(DBUserPanel);
		createButtonEditDBUser();
		createButtonEditDBMovie();
	}

	private void createButtonEditDBMovie() {

		componentCreator.createButton("Edit Database Movie", "Tahoma", 15, Color.BLACK);
		componentCreator.setUpComponentProp(130, 326, 270, 100);
		this.btnModDBMovie = componentCreator.getButton();
		btnModDBMovie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setUserDataComponent(getUser(), getDbMovie(), getDbUser());
				setVisiblePanel(DBMoviePanel, getFrame());
				setPanelsVisibility();
				setBackPanel(DBMoviePanel);

			}

		});
		super.add(btnModDBMovie);
	}

	private void createButtonEditDBUser() {
		componentCreator.createButton("Edit Database User", "Tahoma", 15, Color.BLACK);
		componentCreator.setUpComponentProp(405, 326, 270, 100);
		this.btnModDBUser = componentCreator.getButton();
		btnModDBUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setUserDataComponent(getUser(), getDbMovie(), getDbUser());
				setVisiblePanel(DBUserPanel, getFrame());
				setPanelsVisibility();
				setBackPanel(DBUserPanel);

			}

		});
		super.add(btnModDBUser);

	}

	@Override
	public void setUserDataComponent(User u, DatabaseMovie dbMovie, DatabaseUser dbUser) {
		super.setUserDataComponent(u, dbMovie, dbUser);
		DBUserPanel.setComponent(u, dbMovie, dbUser);
		DBMoviePanel.setComponent(u, dbMovie, dbUser);

	}

}
