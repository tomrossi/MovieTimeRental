package movietime.gui.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JSpinner;

public class StandardJSpinner extends JSpinner implements StandardComponentInterface {

	private JSpinner spinner;

	@Override
	public void setComponentDimension(int x, int y, int width, int height) {
		spinner.setBounds(x, y, width, height);
		spinner.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	}

	@Override
	public void createNewComponent() {
		spinner = new JSpinner();

	}

	@Override
	public Component getStandardComponent() {
		// TODO Auto-generated method stub
		return spinner;
	}

	@Override
	public void setComponentText(String text, String font, int fontSize, Color textColor) {
		spinner.setFont(new Font(font, Font.PLAIN, fontSize));
		spinner.setForeground(textColor);

	}

}
