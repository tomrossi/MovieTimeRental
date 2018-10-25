package movietime.gui.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JList;

public class StandardJList extends JList implements StandardComponentInterface {

	private JList list;

	@Override
	public void setComponentText(String text, String font, int fontSize, Color textColor) {
		list.setFont(new Font(font, Font.PLAIN, fontSize));
		list.setForeground(textColor);

	}

	@Override
	public void setComponentDimension(int x, int y, int width, int height) {
		list.setBounds(x, y, width, height);
		list.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	}

	@Override
	public void createNewComponent() {
		list = new JList();

	}

	@Override
	public Component getStandardComponent() {
		// TODO Auto-generated method stub
		return list;
	}

}
