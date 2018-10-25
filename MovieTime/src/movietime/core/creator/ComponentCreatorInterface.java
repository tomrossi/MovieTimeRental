package movietime.core.creator;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public interface ComponentCreatorInterface {
	public void createButton(String text, String componentFont, int componentFontSize, Color componentColor);

	public void createLabel(String text, String componentFont, int componentFontSize, Color componentColor);

	public void setUpComponentProp(int componentX, int componentY, int componentWidth, int componentHeight);

	public JButton getButton();

	public JLabel getLabel();

	public void createComboBox(String text, String componentFont, int componentFontSize, Color componentColor);

	public JComboBox getComboBox();

	public void createTextField(String text, String componentFont, int componentFontSize, Color componentColor);

	public JTextField getTextField();

	public void createJPasswordField(String text, String componentFont, int componentFontSize, Color componentColor);

	public JPasswordField getPasswordField();

	public void createJSpinner(String text, String componentFont, int componentFontSize, Color componentColor);

	public JSpinner getJSpinner();

	public void createJList(String text, String componentFont, int componentFontSize, Color componentColor);

	public JList getJList();

}