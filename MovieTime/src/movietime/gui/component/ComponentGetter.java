package movietime.gui.component;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

public class ComponentGetter implements ComponentGetterInterface {

	@Override
	public List<Component> getComponents(Container currentComponent) {
		Component[] allComponents = currentComponent.getComponents();
		List<Component> componentsList = new ArrayList<Component>();
		for (Component comp : allComponents) {
			componentsList.add(comp);
			if (comp instanceof Container)
				componentsList.addAll(getComponents((Container) comp));
		}
		return componentsList;
	}

}
