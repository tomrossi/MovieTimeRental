package movietime.gui.panel;

import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import movietime.core.accesspanel.CreateMenuPanel;
import movietime.core.accesspanel.MenuPanel;
import movietime.core.accesspanel.Visitor;
import movietime.core.database.DatabaseMovie;
import movietime.core.database.DatabaseUser;
import movietime.core.loginsystem.LoginPanel;
import movietime.core.loginsystem.SetAccessUser;

public class HomepagePanel extends JPanelWithBackground {

	private JLabel lblLoginSystem;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private JButton btnReset;

	private String username;
	private String password;

	private LoginPanel panelLogin;
	private Visitor menuCreator;
	private MenuPanel menuPanel;

	public HomepagePanel(JFrame frame, String fileNameImage) {
		super(frame, fileNameImage);
		try {
			initialize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(getImage(), 0, 0, null);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Exception
	 */

	public void initialize() throws Exception {

		panelLogin = new LoginPanel();

		panelLogin.getBtnLogin().addActionListener(new ActionListener() {

			

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					if (panelLogin.getLogin().controlAccess(panelLogin.getTextField().getText(),
							panelLogin.getPasswordField().getText())) {

						SetAccessUser setUser = new SetAccessUser(panelLogin.getLogin().getUsername(),
								panelLogin.getLogin().getPassword());
						try {
							menuCreator = new CreateMenuPanel(getFrame());
							setUser.getUserAccess().accept(menuCreator);
							setUser.getUserAccess().setRentalCard(setUser.getCard());
							menuPanel = (menuCreator).getMenuPanel();
							setUser(setUser.getUserAccess());
							getUser().setRentalCard(setUser.getCard());
							DatabaseMovie dbMovie = new DatabaseMovie();
							DatabaseUser dbUser = new DatabaseUser();
							dbMovie.createListMovieFromDatabase();
							dbUser.createListUserFromDatabase();
							setDbMovie(dbMovie);
							setDbUser(dbUser);

							menuPanel.setUserDataComponent(getUser(), getDbMovie(), getDbUser());

							getFrame().getContentPane().add(menuPanel);
							setVisiblePanel(menuPanel, getFrame());
							setPanelsVisibility();

						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					} else {
						JOptionPane.showMessageDialog(null, "Incorrect Username and Password");

					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});
		this.add(panelLogin);

	}

	public LoginPanel getPanelLogin() {
		return panelLogin;
	}

}
