package movietime.gui.panelwithbackbutton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

import movietime.core.card.RentalCard;
import movietime.core.creator.ComponentCreator;
import movietime.core.database.DatabaseMovie;
import movietime.core.database.DatabaseUser;
import movietime.core.user.User;
import movietime.gui.panel.SetterComponentUserData;

public class RechargePanel extends JPanelWithBackgroundAndBackButton
		implements SetterComponentUserData, InitializeComponentRechargePanel {

	private JButton btnRes;
	private JSpinner spinnerRecharge;
	private RentalCard card;
	private JComboBox comboBoxCardList;
	private SpinnerListModel rechargeList;
	private ComponentCreator componentCreator;
	private JLabel[] labelarray = new JLabel[3];
	private int[] XLabel = { 10, 247, 247 };
	private int[] YLabel = { 11, 101, 313 };
	private int[] widthLabel = { 774, 294, 294 };
	private int[] heightLabel = { 26, 14, 14 };
	private String[] txtLabel = { "Recharge Credit", "Card", "Amount charge" };
	private int[] fontSizeLabel = { 21, 18, 18 };

	public RechargePanel(JFrame frame) {
		super(frame);
		componentCreator = new ComponentCreator();
		initializeLabel(labelarray);
		initializeButton();
		initializeJSpinner();
		initializeComboBox();

	}

	@Override
	public void initializeJSpinner() {
		componentCreator.createJSpinner("", "Britannic Bold", 22, Color.WHITE);
		componentCreator.setUpComponentProp(247, 350, 294, 34);
		ArrayList<Double> listrec = new ArrayList<>();
		listrec.add(20.0);
		listrec.add(50.0);
		listrec.add(100.0);
		listrec.add(500.0);
		rechargeList = new SpinnerListModel(listrec);
		componentCreator.getJSpinner().setModel(rechargeList);
		this.spinnerRecharge = componentCreator.getJSpinner();
		this.add(spinnerRecharge);

	}

	@Override
	public void initializeButton() {

		super.getBtnBack().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				setPanelsVisibility();
			}
		});

		componentCreator.createButton("Recharge", "Tahoma", 14, Color.BLACK);
		componentCreator.setUpComponentProp(247, 475, 294, 65);
		this.add(componentCreator.getButton());

		componentCreator.getButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double ric = (double) spinnerRecharge.getValue();
				double res = getUser().getRentalcard().getCredit();
				getUser().getRentalcard().setMycredit(ric + res);
				setComponent(getUser(), getDbMovie(), getDbUser());
				JOptionPane.showMessageDialog(null,
						"Ricarica Effettuata Nuovo Credito " + getUser().getRentalcard().getCredit());

			}
		});

	}

	@Override
	public void initializeLabel(JLabel[] arrayLabel) {
		for (int i = 0; i < arrayLabel.length; i++) {
			componentCreator.createLabel(txtLabel[i], "Britannic Bold", fontSizeLabel[i], Color.WHITE);
			componentCreator.setUpComponentProp(XLabel[i], YLabel[i], widthLabel[i], heightLabel[i]);
			this.add(componentCreator.getLabel());
		}

	}

	@Override
	public void initializeComboBox() {

		componentCreator.createComboBox("", "Britannic Bold", 22, Color.black);
		componentCreator.setUpComponentProp(247, 126, 294, 34);
		this.comboBoxCardList = componentCreator.getComboBox();
		this.add(comboBoxCardList);

	}

	@Override
	public void setComponent(User u, DatabaseMovie dbMovie, DatabaseUser dbUser) {
		setUser(u);
		setDbMovie(dbMovie);
		setDbUser(dbUser);
		String number = Long.toString(getUser().getRentalcard().getNumber());
		comboBoxCardList.setModel(new DefaultComboBoxModel(new String[] { number }));

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(getImage(), 0, 0, null);
	}

}
