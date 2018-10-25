package movietime.gui.panelwithbackbutton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import movietime.core.creator.ComponentCreator;
import movietime.core.database.DatabaseMovie;
import movietime.core.database.DatabaseUser;
import movietime.core.movie.Movie;
import movietime.core.user.User;
import movietime.gui.panel.SetterComponentUserData;

public class OrderPanel extends JPanelWithBackgroundAndBackButton
		implements SetterComponentUserData, InitializeComponentDataOrderPanel {

	private ComponentCreator componentCreator;
	private JButton btnPay;
	private JButton btnRemoveMovie;
	private JButton btnRemoveAll;
	private DefaultListModel<Movie> listModeltemp;
	private JList listOrder;

	private JLabel lblTitle;
	private JLabel lblUsername;
	private JLabel lblUserData;
	private JLabel lblCard;
	private JLabel lblCardType;
	private JLabel lblCredit;
	private JLabel lblOrderPrice;
	private JLabel lblDiscountCalculated;
	private JLabel lblTotal;
	private JLabel lblDay;

	private JLabel lblusername;
	private JLabel lblcard;
	private JLabel lblcardtype;
	private JLabel lblcredit;
	private JLabel lblorderPrice;
	private JLabel lbldiscount;
	private JLabel lbltotal;
	private int[] XLabel = { 10, 10, 10, 10, 10, 10, 142, 142, 142, 142, 10, 152, 152, 161, 10, 10, 10 };
	private int[] YLabel = { 11, 78, 11, 117, 156, 195, 78, 117, 156, 195, 11, 11, 65, 147, 11, 65, 147 };
	private int[] widthLabel = { 774, 129, 233, 129, 129, 129, 101, 101, 101, 101, 184, 141, 141, 132, 141, 141, 141 };
	private int[] heightLabel = { 26, 28, 28, 28, 28, 28, 28, 28, 28, 28, 22, 43, 43, 43, 43, 43, 43 };
	private String[] txtLabel = { "Order Details", "Username", "User Data", "Card Number", "Card Type", "Credit",
			"username", "cardnumber", "cardtype", "credit", "Day Of Rental", "Order Price", "Discount", "Total",
			"orderprice", "discount", "total" };
	private int[] fontSizeLabel = { 21, 18, 21, 18, 18, 18, 16, 16, 16, 16, 21, 18, 18, 22, 20, 20, 23 };
	private JLabel[] lbl = { lblTitle, lblUsername, lblUserData, lblCard, lblCardType, lblCredit, lblusername, lblcard,
			lblcardtype, lblcredit, lblDay, lblOrderPrice, lblDiscountCalculated, lblTotal, lblorderPrice, lbldiscount,
			lbltotal };

	private JPanel panel;

	private JPanel panel_2;
	private JPanel panel_3;

	private JSpinner spinner;
	private SpinnerListModel listDayOfRental;

	private JScrollPane scrollPane;

	public OrderPanel(JFrame frame) {
		super(frame);
		componentCreator = new ComponentCreator();
		initializePanel();
		initializeLabel();
		initializeButton();
		initializeList();
		initializeJSpinner();
		initializeScrollPane();

	}

	@Override
	public void initializeScrollPane() {

		scrollPane = new JScrollPane(listOrder);
		scrollPane.setBounds(20, 48, 761, 170);
		this.add(scrollPane);

	}

	@Override
	public void initializeJSpinner() {
		componentCreator.createJSpinner("", "Britannic Bold", 20, Color.BLACK);
		componentCreator.setUpComponentProp(10, 62, 184, 69);
		ArrayList<Integer> list = new ArrayList();
		for (int i = 1; i < 6; i++) {
			list.add(i);
		}
		listDayOfRental = new SpinnerListModel(list);
		this.spinner = componentCreator.getJSpinner();
		panel_2.add(spinner);
		spinner.setModel(listDayOfRental);
		spinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				int day = (int) spinner.getValue();
				getUser().getMyOrder().setDayOfRentals(day);
				getUser().getRentalcard().calculateTotal(getUser().getMyOrder());
				setComponent(getUser(), getDbMovie(), getDbUser());

			}
		});

	}

	@Override
	public void initializePanel() {
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		panel.setBounds(20, 229, 243, 235);
		this.add(panel);
		panel.setLayout(null);

		panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		panel_2.setBounds(273, 229, 204, 235);
		this.add(panel_2);
		panel_2.setLayout(null);

		panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		panel_3.setBounds(487, 229, 295, 235);
		this.add(panel_3);
		panel_3.setLayout(null);

	}

	@Override
	public void initializeLabel() {
		componentCreator.createLabel(txtLabel[0], "Britannic Bold", fontSizeLabel[0], Color.WHITE);
		componentCreator.setUpComponentProp(XLabel[0], YLabel[0], widthLabel[0], heightLabel[0]);
		this.add(componentCreator.getLabel());

		for (int i = 1; i < 10; i++) {
			componentCreator.createLabel(txtLabel[i], "Britannic Bold", fontSizeLabel[i], Color.BLACK);
			componentCreator.setUpComponentProp(XLabel[i], YLabel[i], widthLabel[i], heightLabel[i]);
			lbl[i] = componentCreator.getLabel();
			panel.add(lbl[i]);
		}

		componentCreator.createLabel(txtLabel[10], "Britannic Bold", fontSizeLabel[10], Color.BLACK);
		componentCreator.setUpComponentProp(XLabel[10], YLabel[10], widthLabel[10], heightLabel[10]);
		panel_2.add(componentCreator.getLabel());

		for (int i = 11; i < lbl.length; i++) {
			componentCreator.createLabel(txtLabel[i], "Britannic Bold", fontSizeLabel[i], Color.BLACK);
			componentCreator.setUpComponentProp(XLabel[i], YLabel[i], widthLabel[i], heightLabel[i]);
			this.lbl[i] = componentCreator.getLabel();
			panel_3.add(lbl[i]);
		}

	}

	@Override
	public void initializeList() {
		listModeltemp = new DefaultListModel<Movie>();
		componentCreator.createJList("", "Tahome", 14, Color.BLACK);
		this.listOrder = componentCreator.getJList();
		listOrder.setModel(listModeltemp);
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

		componentCreator.createButton("Pay Order", "Tahoma", 14, Color.BLACK);
		componentCreator.setUpComponentProp(20, 475, 183, 65);
		this.btnPay = componentCreator.getButton();
		this.add(btnPay);
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (getUser().getRentalcard().getCredit() < getUser().getRentalcard().getTotalOrder()) {
					JOptionPane.showMessageDialog(null, "Credito insufficiente");
				} else if (getUser().getMyOrder().getMyRentals().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nessun film nell'ordine");
				} else {

					getUser().getRentalcard().executePayment(getUser().getMyOrder().getMyRentals());
					getUser().getRentalcard().setMycredit(getUser().getRentalcard().getCredit());
					setComponent(getUser(), getDbMovie(), getDbUser());

				}
			}

		});

		componentCreator.createButton("Remove Movie", "Tahoma", 14, Color.BLACK);
		componentCreator.setUpComponentProp(406, 475, 183, 65);
		this.btnRemoveMovie = componentCreator.getButton();
		this.add(btnRemoveMovie);
		btnRemoveMovie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getUser().getMyOrder().getMyRentals().removeElement(listOrder.getSelectedValue());
				setComponent(getUser(), getDbMovie(), getDbUser());
			}
		});

		componentCreator.createButton("Remove All", "Tahoma", 14, Color.BLACK);
		componentCreator.setUpComponentProp(213, 475, 183, 65);
		this.btnRemoveAll = componentCreator.getButton();
		this.add(btnRemoveAll);
		btnRemoveAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getUser().getMyOrder().getMyRentals().removeAllElements();
				setComponent(getUser(), getDbMovie(), getDbUser());
			}
		});

	}

	@Override
	public void setComponent(User u, DatabaseMovie dbMovie, DatabaseUser dbUser) {
		setUser(u);
		setDbMovie(dbMovie);
		setDbUser(dbUser);
		listOrder.setModel(u.getMyOrder().getMyRentals());
		lbl[6].setText(u.getUsername());
		lbl[7].setText(Long.toString(u.getRentalcard().getNumber()));
		lbl[8].setText(u.getRentalcard().getClass().getSimpleName());

		u.getRentalcard().calculateTotal(u.getMyOrder());
		u.getRentalcard().setMycredit(u.getRentalcard().getCredit() - u.getMyOrder().getTotal());
		lbl[9].setText(Double.toString(u.getRentalcard().getCredit()));
		lbl[11].setText(Double.toString(u.getMyOrder().getPriceListMovie()));
		lbl[12].setText(Double.toString(u.getRentalcard().getDiscount()));
		lbl[13].setText(Double.toString(u.getRentalcard().getTotalOrder()));

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(getImage(), 0, 0, null);
	}

}
