package movietime.gui.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTextField;

public class StandardTextField extends JTextField implements StandardComponentInterface {

	private JTextField TextFieldTemp;

	@Override
	public void setComponentDimension(int x, int y, int width, int height) {
		TextFieldTemp.setBounds(x, y, width, height);
		TextFieldTemp.setColumns(10);

	}

	@Override
	public void setComponentText(String text, String font, int fontSize, Color textColor) {
		TextFieldTemp.setFont(new Font(font, Font.PLAIN, fontSize));
		TextFieldTemp.setBackground(new Color(255, 255, 255));

	}

	@Override
	public Component getStandardComponent() {

		return TextFieldTemp;
	}

	@Override
	public void createNewComponent() {
		TextFieldTemp = new JTextField();

	}

}
