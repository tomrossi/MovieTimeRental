package movietime.gui.panelwithbackbutton;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import movietime.core.accesspanel.CreateMenuPanel;
import movietime.gui.panel.JPanelWithBackground;

public abstract class JPanelWithBackgroundAndBackButton extends JPanelWithBackground {

	public CreateMenuPanel createMenuPanel;
	private JButton btnBack;
	private JPanel prevPanel;

	public JPanelWithBackgroundAndBackButton(JFrame frame) {
		super(frame, "star.jpg");
		drawBackButton();
	}

	private void drawBackButton() {
		// BUTTON back
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(599, 475, 185, 65);
		add(btnBack);

	}

	public JButton getBtnBack() {
		return btnBack;
	}

}
