package movietime.gui.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class StandardLabel extends JLabel implements StandardComponentInterface {

	private JLabel labelTemp;

	@Override
	public void setComponentDimension(int x, int y, int width, int height) {
		labelTemp.setBounds(x, y, width, height);
		labelTemp.setHorizontalAlignment(SwingConstants.CENTER);
		labelTemp.setVerticalAlignment(SwingConstants.CENTER);

	}

	@Override
	public void setComponentText(String text, String font, int fontSize, Color textColor) {
		labelTemp.setText(text);
		labelTemp.setFont(new Font(font, Font.PLAIN, fontSize));
		labelTemp.setForeground(textColor);

	}

	@Override
	public Component getStandardComponent() {
		// TODO Auto-generated method stub
		return labelTemp;
	}

	@Override
	public void createNewComponent() {
		labelTemp = new JLabel();

	}

}
