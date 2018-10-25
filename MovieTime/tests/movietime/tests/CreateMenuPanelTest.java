package movietime.tests;

import static org.junit.Assert.assertEquals;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.junit.Before;
import org.junit.Test;

import movietime.core.accesspanel.CreateMenuPanel;
import movietime.core.accesspanel.MenuPanel;
import movietime.core.user.Admin;
import movietime.core.user.Client;
import movietime.core.user.User;
import movietime.gui.component.ComponentGetter;

public class CreateMenuPanelTest {

	private JFrame frame;
	private String fileNameImage = "star.jpg";
	private List<Component> myComponents;
	private boolean check;
	private User client;
	private User admin;

	private CreateMenuPanel createMenu;
	private ComponentGetter myComponentsGetter;

	@Before
	public void setUp() {

		frame = new JFrame();
		createMenu = new CreateMenuPanel(frame);
		myComponentsGetter = new ComponentGetter();
		myComponents = new ArrayList<Component>();
		check = false;
		client = new Client(0, "", "", "", "", "", "", "", "Client");
		admin = new Admin(1, "", "", "", "", "", "", "", "Admin");
	}

	@Test
	public void createMenuClientTest() {
		MenuPanel menuClient = createMenu.createPanelAccess((Client) client);
		frame.add(menuClient);
		myComponents = myComponentsGetter.getComponents(frame);
		checkComponent(menuClient);
		assertEquals(true, check);

	}

	@Test
	public void createMenuAdminTest() {
		MenuPanel menuAdmin = createMenu.createPanelAccess((Admin) admin);
		frame.add(menuAdmin);
		myComponents = myComponentsGetter.getComponents(frame);
		checkComponent(menuAdmin);
		assertEquals(true, check);
	}

	private void checkComponent(Component myComponent) {
		for (int i = 0; i < myComponents.size(); i++) {
			if (myComponent.equals(myComponents.get(i))) {
				check = true;
			}
		}
	}

}
