package movietime.core.loginsystem;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import movietime.core.creator.ComponentCreator;
import movietime.gui.component.StandardButton;
import movietime.gui.component.StandardLabel;

public class LoginPanel extends JPanel {

	private LoginSystem login;
	private boolean access;
	private JButton btnLogin;
	private int xButtonLogin = 112;
	private int yButtonLogin = 146;
	private int widthbtn = 96;
	private int heightbtn = 22;
	private String loginText = "Login";
	private String fontloginText = "Tahoma";
	private int fontSizeloginbtn = 12;
	private Color colorLoginbtn = Color.black;
	private StandardButton btnReset;
	private int xButtonReset = 218;
	private int yButtonReset = 146;
	private String resetText = "Reset";
	private JTextField textField;
	private int xTextField = 112;
	private int yTextField = 55;
	private int widthTextField = 151;
	private int heightTextField = 21;
	private String textTextField = null;
	private JPasswordField passwordField;
	private int xPassField = 112;
	private int yPassField = 92;
	private int widthPassField = 151;
	private int heightPassField = 22;


	private StandardLabel labelLoginSystem;
	private StandardLabel labelUsername;
	private StandardLabel labelPassword;

	private StandardLabel[] labelarray = { labelLoginSystem, labelUsername, labelPassword };

	private int[] XLabel = { 112, 10, 10 };
	private int[] YLabel = { 14, 54, 87 };
	private int[] widthLabel = { 151, 96, 96 };
	private int[] heightLabel = { 30, 22, 30 };

	private String[] txtLabel = { "Login System", "Username", "Password" };
	private int[] fontSizeLabel = { 17, 15, 15 };

	private ComponentCreator componentCreator;

	public LoginPanel() throws Exception {
		setCurrentPanel(this);
		componentCreator = new ComponentCreator();
		initialize();
	}

	

	public void initialize() {
		setCurrentPanel(this);
		createButtonLogin();
		createButtonReset();
		createLabel();// 3
		createTextField();
		createPasswordField();
		login = new LoginSystem();

	}

	public void setCurrentPanel(JPanel currentPanel) {
		currentPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0),
				SystemColor.desktop, SystemColor.desktop));
		currentPanel.setBackground(SystemColor.activeCaptionBorder);
		currentPanel.setForeground(Color.WHITE);
		currentPanel.setBounds(239, 364, 355, 196);
		currentPanel.setLayout(null);

	}

	public void createButtonLogin() {
		componentCreator.createButton(loginText, fontloginText, fontSizeloginbtn, colorLoginbtn);
		componentCreator.setUpComponentProp(xButtonLogin, yButtonLogin, widthbtn, heightbtn);
		this.btnLogin = componentCreator.getButton();
		this.add(btnLogin);
	}

	public void createButtonReset() {

		componentCreator.createButton(resetText, fontloginText, fontSizeloginbtn, colorLoginbtn);
		componentCreator.setUpComponentProp(xButtonReset, yButtonReset, widthbtn, heightbtn);
		this.add(componentCreator.getButton());
		componentCreator.getButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getTextField().setText(null);
				getPasswordField().setText(null);
			}
		});

	}

	public void createTextField() {
		componentCreator.createTextField("", fontloginText, fontSizeloginbtn, colorLoginbtn);
		componentCreator.setUpComponentProp(xTextField, yTextField, widthTextField, heightTextField);
		this.textField = componentCreator.getTextField();
		this.add(textField);
	}

	private void createPasswordField() {
		componentCreator.createJPasswordField(textTextField, fontloginText, fontSizeloginbtn, colorLoginbtn);
		componentCreator.setUpComponentProp(xPassField, yPassField, widthPassField, heightPassField);
		this.passwordField = componentCreator.getPasswordField();
		this.add(passwordField);
	}

	private void createLabel() {

		for (int i = 0; i < labelarray.length; i++) {
			componentCreator.createLabel(txtLabel[i], fontloginText, fontSizeLabel[i], Color.BLACK);
			componentCreator.setUpComponentProp(XLabel[i], YLabel[i], widthLabel[i], heightLabel[i]);
			this.add(componentCreator.getLabel());

		}

	}

	public JTextField getTextField() {
		return textField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public LoginSystem getLogin() {
		return login;
	}

	public void setLogin(LoginSystem login) {
		this.login = login;
	}

	public boolean isAccess() {
		return access;
	}

	public void setAccess(boolean access) {
		this.access = access;
	}

	public ComponentCreator getComponentCreator() {
		return componentCreator;
	}

}
