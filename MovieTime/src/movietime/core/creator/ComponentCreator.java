package movietime.core.creator;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import movietime.gui.component.StandardButton;
import movietime.gui.component.StandardComboBox;
import movietime.gui.component.StandardComponentInterface;
import movietime.gui.component.StandardJList;
import movietime.gui.component.StandardJSpinner;
import movietime.gui.component.StandardLabel;
import movietime.gui.component.StandardPasswordField;
import movietime.gui.component.StandardTextField;

public class ComponentCreator implements ComponentCreatorInterface {

	private StandardLabel myStandardLabel;
	private StandardComponentInterface standardComponent;
	private StandardButton myStandardButton;
	private StandardComboBox myStandardComboBox;
	private StandardTextField myStandardTextField;
	private StandardPasswordField myStandardPasswordField;
	private StandardJSpinner myJSpinner;
	private StandardJList myJList;

	public ComponentCreator() {
		myStandardButton = new StandardButton();
		myStandardLabel = new StandardLabel();
		myStandardComboBox = new StandardComboBox();
		myStandardTextField = new StandardTextField();
		myStandardPasswordField = new StandardPasswordField();
		myJSpinner = new StandardJSpinner();
		myJList = new StandardJList();
	}

	// imposta componente
	private void setUpComponent(String text, String componentFont, int componentFontSize, Color componentColor) {
		standardComponent.createNewComponent();
		standardComponent.setComponentText(text, componentFont, componentFontSize, componentColor);
	}

	@Override
	public void createButton(String text, String componentFont, int componentFontSize, Color componentColor) {
		standardComponent = myStandardButton;
		setUpComponent(text, componentFont, componentFontSize, componentColor);
	}

	@Override
	public void createLabel(String text, String componentFont, int componentFontSize, Color componentColor) {
		standardComponent = myStandardLabel;
		setUpComponent(text, componentFont, componentFontSize, componentColor);
	}

	@Override
	public void setUpComponentProp(int componentX, int componentY, int componentWidth, int componentHeight) {
		standardComponent.setComponentDimension(componentX, componentY, componentWidth, componentHeight);
	}

	@Override
	public JButton getButton() {
		return (JButton) standardComponent.getStandardComponent();
	}

	@Override
	public JLabel getLabel() {
		return (JLabel) standardComponent.getStandardComponent();
	}

	@Override
	public void createComboBox(String text, String componentFont, int componentFontSize, Color componentColor) {
		standardComponent = myStandardComboBox;
		setUpComponent(text, componentFont, componentFontSize, componentColor);
	}

	@SuppressWarnings("unchecked")
	@Override
	public JComboBox getComboBox() {
		return (JComboBox) standardComponent.getStandardComponent();
	}

	@Override
	public void createTextField(String text, String componentFont, int componentFontSize, Color componentColor) {
		standardComponent = myStandardTextField;
		setUpComponent(text, componentFont, componentFontSize, componentColor);

	}

	@Override
	public JTextField getTextField() {
		// TODO Auto-generated method stub
		return (JTextField) standardComponent.getStandardComponent();
	}

	@Override
	public void createJPasswordField(String text, String componentFont, int componentFontSize, Color componentColor) {
		standardComponent = myStandardPasswordField;
		setUpComponent(text, componentFont, componentFontSize, componentColor);

	}

	@Override
	public JPasswordField getPasswordField() {
		// TODO Auto-generated method stub
		return (JPasswordField) standardComponent.getStandardComponent();
	}

	@Override
	public void createJSpinner(String text, String componentFont, int componentFontSize, Color componentColor) {
		standardComponent = myJSpinner;
		setUpComponent(text, componentFont, componentFontSize, componentColor);
	}

	@Override
	public JSpinner getJSpinner() {
		// TODO Auto-generated method stub
		return (JSpinner) standardComponent.getStandardComponent();
	}

	@Override
	public void createJList(String text, String componentFont, int componentFontSize, Color componentColor) {
		standardComponent = myJList;
		setUpComponent(text, componentFont, componentFontSize, componentColor);

	}

	@Override
	public JList getJList() {
		// TODO Auto-generated method stub
		return (JList) standardComponent.getStandardComponent();
	}
}