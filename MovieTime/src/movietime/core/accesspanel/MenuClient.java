package movietime.core.accesspanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import movietime.core.creator.ComponentCreator;
import movietime.core.database.DatabaseMovie;
import movietime.core.database.DatabaseUser;
import movietime.core.user.User;
import movietime.gui.panel.JPanelWithBackground;
import movietime.gui.panelwithbackbutton.DataUserPanel;
import movietime.gui.panelwithbackbutton.OrderPanel;
import movietime.gui.panelwithbackbutton.RechargePanel;
import movietime.gui.panelwithbackbutton.RentalPanel;

public class MenuClient extends MenuPanel {

	private RentalPanel rentalPanel;// pannello noleggia
	private RechargePanel recPanel;// ricarica
	private DataUserPanel datePanel;// dati
	private OrderPanel orderPanel;// ordini
	private JButton btnRental;
	private JButton btnRecCredit;
	private JButton btnMyOrder;
	private JButton btnMyData;
	private ComponentCreator componentCreator;
	

	public MenuClient(JFrame frame, String fileNameImage) {
		super(frame, fileNameImage);
		initialize();
	}

	public void initialize() {
		componentCreator = new ComponentCreator();
		rentalPanel = new RentalPanel(getFrame());
		recPanel = new RechargePanel(getFrame());
		orderPanel = new OrderPanel(getFrame());
		datePanel = new DataUserPanel(getFrame());
		createRentalButton();
		createRechargeButton();
		createOrderButton();
		createDateUserButton();
		getFrame().getContentPane().add(rentalPanel);
		getFrame().getContentPane().add(recPanel);
		getFrame().getContentPane().add(orderPanel);
		getFrame().getContentPane().add(datePanel);

	}

	private void createRentalButton() {
		componentCreator.createButton("Rental", "Tahoma", 15, Color.BLACK);
		componentCreator.setUpComponentProp(130, 116, 270, 100);
		this.btnRental = componentCreator.getButton();
		btnRental.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setUserDataComponent(getUser(), getDbMovie(), getDbUser());
				setVisiblePanel(rentalPanel, getFrame());
				setPanelsVisibility();
				setBackPanel(rentalPanel);

			}

		});
		this.add(btnRental);
	}

	private void createDateUserButton() {
		componentCreator.createButton("User date", "Tahoma", 15, Color.BLACK);
		componentCreator.setUpComponentProp(405, 221, 270, 100);
		this.btnMyData = componentCreator.getButton();
		btnMyData.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setUserDataComponent(getUser(), getDbMovie(), getDbUser());
				setVisiblePanel(datePanel, getFrame());
				setPanelsVisibility();
				setBackPanel(datePanel);

			}
		});
		this.add(btnMyData);
	}

	private void createOrderButton() {

		componentCreator.createButton("My Order", "Tahoma", 15, Color.BLACK);
		componentCreator.setUpComponentProp(130, 221, 270, 100);
		this.btnMyOrder = componentCreator.getButton();
		btnMyOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setUserDataComponent(getUser(), getDbMovie(), getDbUser());
				setVisiblePanel(orderPanel, getFrame());
				setPanelsVisibility();
				setBackPanel(orderPanel);

			}
		});
		this.add(btnMyOrder);
	}

	private void createRechargeButton() {
		componentCreator.createButton("Recharge Credit", "Tahoma", 15, Color.BLACK);
		componentCreator.setUpComponentProp(405, 116, 270, 100);
		this.btnRecCredit = componentCreator.getButton();
		btnRecCredit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setUserDataComponent(getUser(), getDbMovie(), getDbUser());
				setVisiblePanel(recPanel, getFrame());
				setPanelsVisibility();
				setBackPanel(recPanel);

			}
		});
		this.add(btnRecCredit);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(super.getImage(), 0, 0, null);
	}

	public void setBackPanel(JPanelWithBackground rentalPanel2) {
		rentalPanel2.setVisiblePanel(this, getFrame());

	}

	@Override
	public void setUserDataComponent(User u, DatabaseMovie dbMovie, DatabaseUser dbUser) {
		setUser(u);
		setDbMovie(dbMovie);
		setDbUser(dbUser);
		rentalPanel.setComponent(u, dbMovie, dbUser);
		datePanel.setComponent(u, dbMovie, dbUser);
		recPanel.setComponent(u, dbMovie, dbUser);
		orderPanel.setComponent(u, dbMovie, dbUser);
	}

}
