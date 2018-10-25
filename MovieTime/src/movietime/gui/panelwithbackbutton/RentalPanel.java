package movietime.gui.panelwithbackbutton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import movietime.core.creator.ComponentCreator;
import movietime.core.database.DatabaseMovie;
import movietime.core.database.DatabaseUser;
import movietime.core.finder.ResearchForCategory;
import movietime.core.finder.ResearchForDirector;
import movietime.core.finder.ResearchForTitle;
import movietime.core.finder.ResearchMovie;
import movietime.core.movie.Movie;
import movietime.core.user.User;
import movietime.gui.panel.SetterComponentUserData;

public class RentalPanel extends JPanelWithBackgroundAndBackButton
		implements SetterComponentUserData, InitializeComponentRentalPanel {

	private JPanel panel;
	private JLabel lblprice;
	private JLabel lblCategory;
	private JLabel lblYear;
	private JLabel lblPrice;
	private JLabel lblCover;
	private JLabel lblTitle;
	private JLabel lblDirector;
	private JLabel lbldirector;
	private JLabel lblcategory;
	private JLabel lblyear;
	private JLabel[] lbl = { lblTitle, lblCategory, lblDirector, lblYear, lblPrice, lblCover, lblcategory, lbldirector,
			lblyear, lblprice };
	private int[] XLabel = { 10, 205, 204, 204, 204, 10, 272, 270, 243, 279 };
	private int[] YLabel = { 11, 69, 108, 147, 186, 46, 77, 116, 155, 186 };
	private int[] widthLabel = { 379, 80, 80, 80, 80, 189, 117, 117, 146, 80 };
	private int[] heightLabel = { 28, 28, 28, 28, 28, 250, 14, 14, 14, 28 };
	private String[] txtLabel = { "Title", "Category", "Director", "Year", "Price", "", "category", "director", "year",
			"price" };
	private int[] fontSizeLabel = { 18, 14, 14, 14, 14, 14, 14, 12, 14, 14, 14 };
	//////////////////////
	private JTextField textField;
	private JButton addToOrder;
	private JScrollPane scrollPane;
	private JList<Movie> listMovies;
	private DatabaseMovie dbMovie;
	private JComboBox comboBox;
	private JTextPane txtpnTrama;

	private JButton btnFind;
	private JButton btnViewOrder;
	private ResearchMovie res;
	private JButton btnShowAll;
	private JButton btnReset;

	private Movie m;

	private JButton btnRemoveFromOrder;
	private DefaultListModel<Movie> listModelMovie;
	private ComponentCreator componentCreator;

	public RentalPanel(JFrame frame) {
		super(frame);
		componentCreator = new ComponentCreator();
		dbMovie = new DatabaseMovie();
		initializePanel();
		initializeLabels();
		initializeTextField();
		initializeList();
		initializeScrollPane();
		initializeButton();
		initializeComboBox();
		initializeTextPane();

	}

	@Override
	public void initializeTextPane() {
		
		txtpnTrama = new JTextPane();
		txtpnTrama.setFont(new Font("Britannic Bold", Font.PLAIN, 12));
		txtpnTrama.setBounds(10, 307, 379, 135);
		txtpnTrama.setVisible(true);
		panel.add(txtpnTrama);

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

		componentCreator.createButton("Find", "Tahoma", 14, Color.BLACK);
		componentCreator.setUpComponentProp(121, 11, 131, 36);
		this.btnFind = componentCreator.getButton();
		add(btnFind);
		// BUTTON FIND
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String find = textField.getText();

				if (find.equals("")) {
					JOptionPane.showMessageDialog(null, "Inserisci film da cercare");

				} else {
					if (comboBox.getSelectedItem().equals("Title")) {
						res = new ResearchForTitle();
						res.research(listModelMovie, find);
					} else if (comboBox.getSelectedItem().equals("Director")) {
						res = new ResearchForDirector();
						res.research(listModelMovie, find);
					} else {
						res = new ResearchForCategory();
						res.research(listModelMovie, find);
					}
					listMovies.setModel(res.getTempResearch());

				}

			}
		});

		componentCreator.createButton("Add To Order", "Tahoma", 14, Color.BLACK);
		componentCreator.setUpComponentProp(20, 475, 183, 65);
		this.addToOrder = componentCreator.getButton();
		this.add(addToOrder);
		addToOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getUser().getMyOrder().checkMovie(listMovies.getSelectedValue(),
						getUser().getMyOrder().getMyRentals())) {
					

					JOptionPane.showMessageDialog(null, "film già nel tuo ordine o in prestito");
				} else {
					getUser().getMyOrder().add(listMovies.getSelectedValue());

					JOptionPane.showMessageDialog(null, "film aggiunto");
				}

			}

		});

		// BUTTON RESET
		componentCreator.createButton("Reset", "Tahoma", 14, Color.BLACK);
		componentCreator.setUpComponentProp(262, 11, 113, 36);
		this.btnReset = componentCreator.getButton();
		add(btnReset);
		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (listMovies.isSelectedIndex(listMovies.getSelectedIndex())) {
					listMovies.clearSelection();
				}
				textField.setText(null);
				listMovies.setModel(listModelMovie);
				listMovies.setVisible(true);
				lbl[5].setVisible(false);
				lbl[0].setVisible(false);
				lbl[6].setVisible(false);
				lbl[7].setVisible(false);
				lbl[9].setVisible(false);
				lbl[8].setVisible(false);
				txtpnTrama.setVisible(false);

			}
		});

	}

	@Override
	public void initializeComboBox() {
		// COMBO BOX
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setBounds(20, 11, 91, 36);
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Title", "Director", "Category" }));
		add(comboBox);

	}

	@Override
	public void initializeScrollPane() {
		// SCROLL PANE
		scrollPane = new JScrollPane(listMovies);
		scrollPane.setBounds(20, 104, 355, 360);
		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		this.add(scrollPane);

	}

	@Override
	public void initializeList() {
		componentCreator.createJList("", "Tahoma", 15, Color.BLACK);
		componentCreator.setUpComponentProp(20, 104, 353, 333);
		listMovies = componentCreator.getJList();
		listMovies.setModel(dbMovie.getList());
		listMovies.setBorder(UIManager.getBorder("ScrollPane.border"));
		// GESTIONE DELLA LISTA E SELEZIONE DEGLI OGGETTI

		listMovies.getSelectionModel().addListSelectionListener(e -> {
			if (listMovies.isSelectionEmpty()) {
				return;
			} else {
				Movie movieSel = listMovies.getSelectedValue();
				URL coverUrl = null;
				if (movieSel.getID_Movie() > 15) {
					coverUrl = Movie.class.getResource("image.jpg");
				} else {
					coverUrl = Movie.class.getResource("title" + movieSel.getID_Movie() + ".jpg");
				}

				lbl[5].setIcon(new ImageIcon(coverUrl));
				lbl[0].setText(movieSel.getTitle());
				lbl[6].setText(movieSel.getCategory());
				lbl[7].setText(movieSel.getDirector());
				lbl[9].setText(Double.toString(movieSel.getPrice()));
				lbl[8].setText(movieSel.getYear());
				txtpnTrama.setText(movieSel.getTrama());
				lbl[5].setVisible(true);
				lbl[5].setVisible(true);
				lbl[6].setVisible(true);
				lbl[7].setVisible(true);
				lbl[9].setVisible(true);
				lbl[8].setVisible(true);
				txtpnTrama.setVisible(true);
			}

		});

	}

	@Override
	public void initializeTextField() {
		componentCreator.createTextField("", "Britannic Bold", 15, Color.BLACK);
		componentCreator.setUpComponentProp(20, 57, 355, 36);
		this.textField = componentCreator.getTextField();
		this.add(textField);
	}

	@Override
	public void initializeLabels() {
		for (int i = 0; i < 10; i++) {
			componentCreator.createLabel(txtLabel[i], "Britannic Bold", fontSizeLabel[i], Color.BLACK);
			componentCreator.setUpComponentProp(XLabel[i], YLabel[i], widthLabel[i], heightLabel[i]);
			lbl[i] = componentCreator.getLabel();
			lbl[i].setHorizontalAlignment(SwingConstants.CENTER);
			lbl[i].setLabelFor(panel);
			panel.add(lbl[i]);
		}

	}

	@Override
	public void initializePanel() {

		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		panel.setBackground(Color.WHITE);
		panel.setBounds(385, 11, 399, 453);
		add(panel);
		panel.setLayout(null);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(getImage(), 0, 0, null);
	}

	@Override
	public void setComponent(User u, DatabaseMovie dbMovie, DatabaseUser dbUser) {
		setUser(u);
		setDbMovie(dbMovie);
		setDbUser(dbUser);
		listModelMovie = dbMovie.getList();
		listMovies.setModel(listModelMovie);
		scrollPane.setViewportView(listMovies);
	}

}
