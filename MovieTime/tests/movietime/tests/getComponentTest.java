package movietime.tests;

import static org.junit.Assert.assertEquals;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

import movietime.gui.component.ComponentGetter;

public class getComponentTest {

	private ComponentGetter myComponentsGetter;
	private List<Component> myComponents;
	private JFrame myFrame;
	private JButton myButton;
	private JLabel myLabel;

	private boolean check;

	@Before
	public void setUp() {
		myFrame = new JFrame("");
		myButton = new JButton("");
		myLabel = new JLabel("");
		myComponentsGetter = new ComponentGetter();
		myComponents = new ArrayList<Component>();
		check = false;
	}

	@Test
	public void getButtonFromContainerTest() {
		myFrame.add(myButton);
		myComponents = myComponentsGetter.getComponents(myFrame);
		checkComponent(myButton);
		assertEquals(true, check);
	}

	@Test
	public void getLabelFromContainerTest() {
		myFrame.add(myLabel);
		myComponents = myComponentsGetter.getComponents(myFrame);
		checkComponent(myLabel);
		assertEquals(true, check);
	}

	@Test
	public void getFalseButtonFromContainerTest() {
		myFrame.add(myLabel);
		myComponents = myComponentsGetter.getComponents(myFrame);
		checkComponent(myButton);
		assertEquals(false, check);
	}

	@Test
	public void getFalseLabelFromContainerTest() {
		myFrame.add(myButton);
		myComponents = myComponentsGetter.getComponents(myFrame);
		checkComponent(myLabel);
		assertEquals(false, check);
	}

	@Test
	public void getNullLabelComponent() {
		myComponents = myComponentsGetter.getComponents(myFrame);
		checkComponent(myLabel);
		assertEquals(false, check);
	}

	@Test
	public void getNullButtonComponent() {
		myComponents = myComponentsGetter.getComponents(myFrame);
		checkComponent(myButton);
		assertEquals(false, check);
	}

	@Test
	public void getWrongComponent() {
		myComponents = myComponentsGetter.getComponents(myLabel);
		checkComponent(myButton);
		assertEquals(false, check);
	}

	private void checkComponent(Component myComponent) {
		for (int i = 0; i < myComponents.size(); i++) {
			if (myComponent.equals(myComponents.get(i))) {
				check = true;
			}
		}
	}

}
