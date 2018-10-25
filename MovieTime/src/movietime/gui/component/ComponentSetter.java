package movietime.gui.component;

import java.awt.Color;
import java.awt.Component;

public class ComponentSetter {

	private StandardComponentInterface standardComponent;

	public void setCurrentComponent(StandardComponentInterface standardComponent) {
		this.standardComponent = standardComponent;
		this.standardComponent.createNewComponent();
	}

	public void setComponentTextProp(String text, String font, int fontSize, Color textColor) {
		standardComponent.setComponentText(text, font, fontSize, textColor);
	}

	public void setComponentProp(int x, int y, int width, int height) {
		standardComponent.setComponentDimension(x, y, width, height);
	}

	public Component getFormattedComponent() {
		return standardComponent.getStandardComponent();
	}
}
