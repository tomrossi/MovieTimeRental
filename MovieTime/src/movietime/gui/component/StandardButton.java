package movietime.gui.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class StandardButton extends JButton implements StandardComponentInterface {

	private JButton buttonTemp;

	@Override
	public void setComponentDimension(int x, int y, int width, int height) {
		buttonTemp.setBounds(x, y, width, height);
		buttonTemp.setHorizontalAlignment(SwingConstants.CENTER);
		buttonTemp.setVerticalAlignment(SwingConstants.CENTER);
		buttonTemp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	}

	@Override
	public void setComponentText(String text, String font, int fontSize, Color textColor) {
		buttonTemp.setText(text);
		buttonTemp.setFont(new Font(font, Font.BOLD, fontSize));
		buttonTemp.setForeground(textColor);

	}

	@Override
	public Component getStandardComponent() {
		return buttonTemp;
	}

	@Override
	public void createNewComponent() {
		buttonTemp = new JButton();

	}

}
