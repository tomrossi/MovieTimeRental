package movietime.gui.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JComboBox;

public class StandardComboBox<E> extends JComboBox implements StandardComponentInterface {

	

	private JComboBox<E> tempComboBox;

	@Override
	public void setComponentDimension(int x, int y, int width, int height) {
		tempComboBox.setBounds(x, y, width, height);

	}

	@Override
	public void setComponentText(String text, String font, int fontSize, Color textColor) {
		tempComboBox.setFont(new Font(font, Font.BOLD, fontSize));
		tempComboBox.setForeground(textColor);
		tempComboBox.setBackground(Color.WHITE);

	}

	@Override
	public Component getStandardComponent() {
		// TODO Auto-generated method stub
		return tempComboBox;
	}

	@Override
	public void createNewComponent() {
		tempComboBox = new JComboBox();

	}

}
