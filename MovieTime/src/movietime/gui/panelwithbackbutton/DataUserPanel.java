package movietime.gui.panelwithbackbutton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import movietime.core.card.Gold;
import movietime.core.card.RentalCard;
import movietime.core.creator.ComponentCreator;
import movietime.core.database.DatabaseMovie;
import movietime.core.database.DatabaseUser;
import movietime.core.user.User;
import movietime.gui.panel.SetterComponentUserData;

public class DataUserPanel extends JPanelWithBackgroundAndBackButton
		implements SetterComponentUserData, InitializeComponentDataUserPanel {

	private JButton btnMod;
	private JButton btnSave;
	private JLabel lblTitle;
	private JLabel lblName;
	private JLabel lblSurname;
	private JLabel lblAddress;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblTypeOfCard;
	private JLabel lblNumberOfCard;
	private JLabel lblCreditOfCard;
	private JLabel lblGoldPoint;
	private JLabel lbltypecard;
	private JLabel lblnumbercard;
	private JLabel lblcreditcard;
	private JLabel lblgoldpoint;
	private JLabel lblPhoto;
	private JLabel lblPhotoCard;
	private int[] XLabel = { 10, 178, 178, 178, 178, 178, 178, 178, 207, 207, 207, 207, 401, 401, 401, 401 };
	private int[] YLabel = { 11, 59, 84, 109, 134, 159, 184, 209, 265, 300, 331, 366, 300, 331, 366, 265 };
	private int[] widthLabel = { 754, 213, 213, 213, 213, 213, 213, 213, 213, 213, 213, 213, 174, 174, 174, 174 };
	private int[] heightLabel = { 22, 14, 14, 14, 14, 14, 14, 14, 24, 24, 24, 24, 24, 24, 24, 24 };
	private String[] txtLabel = { "User Details", "Name", "Surname", "Address", "Phone", "EMail", "Username",
			"Password", "Type of Card", "Number of Card", "Credit", "GoldPoint", "numbercard", "creditcard",
			"goldpoint", "typecard" };
	private int[] fontSizeLabel = { 21, 15, 15, 15, 15, 15, 15, 15, 18, 18, 18, 18, 15, 15, 15, 15 };
	private JLabel[] lbl = { lblTitle, lblName, lblSurname, lblAddress, lblPhone, lblEmail, lblUsername, lblPassword,
			lblTypeOfCard, lblNumberOfCard, lblCreditOfCard, lblGoldPoint, lblnumbercard, lblcreditcard, lblgoldpoint,
			lbltypecard };
	private JTextField textFieldName;
	private JTextField textFieldSurname;
	private JTextField textFieldAddress;
	private JTextField textFieldPhone;
	private JTextField textFieldEmail;
	private JTextField textFieldUsername;
	private JTextField[] textFields = { textFieldName, textFieldSurname, textFieldAddress, textFieldPhone,
			textFieldEmail, textFieldUsername };
	private int[] XTextField = { 339 };
	private int[] YTextField = { 58, 83, 108, 133, 158, 183 };
	private int[] widthTextField = { 333 };
	private int[] heightTextField = { 20 };
	private JPasswordField passwordFieldPassword;

	private ComponentCreator componentCreator;

	public DataUserPanel(JFrame frame) {
		super(frame);
		componentCreator = new ComponentCreator();
		initializeButton();
		initializeTextField();
		initializePasswordField();
		initializeLabel();
	}

	@Override
	public void initializeLabel() {
		for (int i = 0; i < lbl.length; i++) {
			componentCreator.createLabel(txtLabel[i], "Britannic Bold", 15, Color.WHITE);
			componentCreator.setUpComponentProp(XLabel[i], YLabel[i], widthLabel[i], heightLabel[i]);
			this.lbl[i] = componentCreator.getLabel();
			this.add(lbl[i]);
		}
		
		lblPhoto = new JLabel("Photo");
		lblPhoto.setIcon(new ImageIcon(DataUserPanel.class.getResource("foto profilo.jpg")));
		lblPhoto.setBounds(57, 59, 150, 150);
		lblPhoto.setForeground(Color.RED);
		lblPhoto.setBackground(Color.WHITE);
		lblPhoto.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(lblPhoto);

		lblPhotoCard = new JLabel("Photo Card");
		lblPhotoCard.setBounds(55, 266, 150, 124);

		lblPhotoCard.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhotoCard.setForeground(Color.WHITE);
		this.add(lblPhotoCard);
	}

	@Override
	public void initializePasswordField() {

		passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.setBounds(339, 209, 333, 20);
		this.add(passwordFieldPassword);
	}

	@Override
	public void initializeTextField() {

		for (int i = 0; i < textFields.length; i++) {
			componentCreator.createTextField("", "Tahoma", 14, Color.BLACK);
			componentCreator.setUpComponentProp(339, YTextField[i], 333, 20);
			this.textFields[i] = componentCreator.getTextField();
			this.textFields[i].setEditable(false);
			this.add(textFields[i]);

		}

	}

	@Override
	public void initializeButton() {
		// back
		super.getBtnBack().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				setPanelsVisibility();
			}
		});
		// modify
		componentCreator.createButton("Modify", "Tahoma", 14, Color.BLACK);
		componentCreator.setUpComponentProp(20, 475, 183, 65);
		this.btnMod = componentCreator.getButton();
		this.add(btnMod);
		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFields[0].setEditable(true);
				textFields[1].setEditable(true);
				textFields[2].setEditable(true);
				textFields[3].setEditable(true);
				textFields[4].setEditable(true);
				textFields[5].setEditable(true);
				passwordFieldPassword.setEditable(true);

			}
		});

		// BUTTON Save

		componentCreator.createButton("Save", "Tahoma", 14, Color.BLACK);
		componentCreator.setUpComponentProp(213, 475, 183, 65);
		this.btnSave = componentCreator.getButton();
		this.add(btnSave);

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textFields[0].setText(textFields[0].getText());
				textFields[1].setText(textFields[1].getText());
				textFields[2].setText(textFields[2].getText());
				textFields[3].setText(textFields[3].getText());
				textFields[4].setText(textFields[4].getText());
				textFields[5].setText(textFields[5].getText());

				passwordFieldPassword.setText(passwordFieldPassword.getText());
				textFields[0].setEditable(false);
				textFields[1].setEditable(false);
				textFields[2].setEditable(false);
				textFields[3].setEditable(false);
				textFields[4].setEditable(false);
				textFields[5].setEditable(false);
				passwordFieldPassword.setEditable(false);

				

			}
		});

		this.add(btnSave);

	}

	@Override
	public void setComponent(User u, DatabaseMovie dbMovie, DatabaseUser dbUser) {
		setUser(u);
		setDbMovie(dbMovie);
		setDbUser(dbUser);
		textFields[0].setText(dbUser.getUser(u.getId()).getName());
		textFields[1].setText(dbUser.getUser(u.getId()).getSurname());
		textFields[2].setText(dbUser.getUser(u.getId()).getAddress());
		textFields[3].setText(dbUser.getUser(u.getId()).getPhone());
		textFields[4].setText(dbUser.getUser(u.getId()).getE_mail());
		textFields[5].setText(dbUser.getUser(u.getId()).getUsername());
		passwordFieldPassword.setText(dbUser.getUser(u.getId()).getPassword());
		lbl[15].setText(getUser().getRentalcard().getClass().getSimpleName());
		lbl[12].setText(Long.toString((getUser().getRentalcard().getNumber())));
		lbl[13].setText(Double.toString(getUser().getRentalcard().getCredit()));
		RentalCard card = getUser().getRentalcard();

		lblPhotoCard.setIcon(new ImageIcon(
				DataUserPanel.class.getResource(getUser().getRentalcard().getClass().getSimpleName() + ".jpg")));
		if (card instanceof Gold) {
			String gold = Integer.toString(((Gold) card).getCollectionGoldPoint().getGoldPoint());
			lbl[14].setText(gold);
		} else {
			lbl[14].setText("0");
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(getImage(), 0, 0, null);
	}

}
