package movietime.core.accesspanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import movietime.gui.panel.HomepagePanel;
import movietime.gui.panel.JPanelWithBackground;

public abstract class JPanelWithBackgroundAndLogoutBtn extends JPanelWithBackground {

	private JButton btnLogout;

	public JPanelWithBackgroundAndLogoutBtn(JFrame frame, String fileNameImage) {
		super(frame, fileNameImage);
		drowLogoutButton();
		// TODO Auto-generated constructor stub
	}

	private void drowLogoutButton() {
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisiblePanel(new HomepagePanel(getFrame(), "star.jpg"), getFrame());
				setPanelsVisibility();

			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogout.setBounds(599, 477, 123, 53);
		this.add(btnLogout);

	}

}
