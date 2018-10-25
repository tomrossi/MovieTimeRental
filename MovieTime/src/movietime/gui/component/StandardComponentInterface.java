package movietime.gui.component;

import java.awt.Color;
import java.awt.Component;

public interface StandardComponentInterface {

	
	public void setComponentText(String text, String font, int fontSize, Color textColor);

	
	public void setComponentDimension(int x, int y, int width, int height);

	public void createNewComponent(); 

	public Component getStandardComponent();

}
