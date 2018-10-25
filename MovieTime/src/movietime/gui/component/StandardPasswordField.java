package movietime.gui.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JPasswordField;

public class StandardPasswordField extends JPasswordField implements StandardComponentInterface {

	private JPasswordField passwordFieldTemp;

	@Override
	public void setComponentDimension(int x, int y, int width, int height) {
		passwordFieldTemp.setBounds(x, y, width, height);
		passwordFieldTemp.setBackground(Color.WHITE);

	}

	@Override
	public void setComponentText(String text, String font, int fontSize, Color textColor) {
		passwordFieldTemp.setFont(new Font(font, Font.PLAIN, 12));
	}

	@Override
	public Component getStandardComponent() {
		// TODO Auto-generated method stub
		return passwordFieldTemp;
	}

	@Override
	public void createNewComponent() {
		passwordFieldTemp = new JPasswordField();

	}

}
