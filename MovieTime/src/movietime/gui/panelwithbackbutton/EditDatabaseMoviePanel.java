package movietime.gui.panelwithbackbutton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import movietime.core.creator.CreateMovie;
import movietime.core.database.DatabaseMovie;
import movietime.core.database.DatabaseUser;
import movietime.core.movie.Movie;
import movietime.core.tabledatabase.TableMovie;
import movietime.core.user.User;
import movietime.gui.panel.SetterComponentUserData;

public class EditDatabaseMoviePanel extends EditDatabasePanel
		implements SetterComponentUserData, InitializeComponentEditDatabasePanel {

	private JLabel labelTitle;
	private TableMovie table;
	private JLabel lblTitleMovie;
	private JLabel lblDirector;
	private JLabel lblYear;
	private JLabel lblCategory;
	private JLabel lblCover;
	private JLabel lblNewRelease;
	private JLabel lblTimeLine;
	private JLabel[] lbl = { labelTitle, lblTitleMovie, lblDirector, lblYear, lblCategory, lblCover, lblNewRelease,
			lblTimeLine };
	private int[] XLabel = { 10, 35, 35, 35, 35, 35, 26, 339 };
	private int[] YLabel = { 11, 24, 59, 94, 129, 164, 199, 98 };
	private int[] widthLabel = { 754, 86, 86, 86, 86, 86, 95, 86 };
	private int[] heightLabel = { 22, 24, 24, 24, 24, 24, 24, 24 };
	private String[] txtLabel = { "Edit Database Movie", "Title", "Director", "Year", "Category", "Cover", "NewRelease",
			"TimeLine" };
	private int[] fontSizeLabel = { 15, 15, 15, 15, 15, 15, 15, 15 };
	private JTextField textFieldTitle;
	private JTextField textFieldDirector;
	private JTextField textFieldYear;
	private JTextField textFieldCategory;
	private JTextField textFieldCover;
	private JTextField textFieldNewRelease;

	private JTextField[] textFields = { textFieldTitle, textFieldDirector, textFieldYear, textFieldCategory,
			textFieldCover, textFieldNewRelease };
	private int[] XTextField = { 131, 131, 131, 131, 131, 131 };
	private int[] YTextField = { 28, 63, 98, 133, 168, 203 };
	private int[] widthTextField = { 173, 173, 173, 173, 173, 173 };
	private int[] heightTextField = { 20, 20, 20, 20, 20, 20 };

	private JTextArea textAreaTimeLine;
	private JScrollPane scrollPaneTimeLine;
	private CreateMovie createMovie;

	private DatabaseMovie dbMovie;

	public EditDatabaseMoviePanel(JFrame frame) {
		super(frame);
		dbMovie = new DatabaseMovie();
		createMovie = new CreateMovie();
		initializeTextFields();
		initializeTable();
		initializeLabels();
		setDatabaseButtonAction();
		initializeTextArea();
	}

	@Override
	public void setDatabaseButtonAction() {
		// OPTION ADD MOVIE

		super.getOptionAdd().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				textFields[0].setText(null);
				textFields[1].setText(null);
				textFields[2].setText(null);
				textFields[3].setText(null);
				textFields[4].setText(null);
				textFields[5].setText(null);
				textAreaTimeLine.setText(null);

				getAddObject().setVisible(true);
				getRemoveObject().setVisible(false);
				getUpdateObject().setVisible(false);

			}
		});

		// ADD MOVIE

		getAddObject().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (controlData(textFields) == true) {
					Object[] row = { table.getRowCount() + 1, textFields[0].getText(), textFields[1].getText(),
							textFields[2].getText(), textFields[3].getText(), textFields[4].getText(),
							textAreaTimeLine.getText(), textFields[5].getText() };

					table.addRow(row);
					getScrollPaneTable().setViewportView(table);

					Movie m = createMovie.create(table.getRowCount(), textFields[0].getText(), textFields[1].getText(),
							textFields[2].getText(), textFields[3].getText(), new JLabel(textFields[4].getText()),
							textAreaTimeLine.getText(), textFields[5].getText());

					getDbMovie().addMovie(m);
					setComponent(getCurrentUser(), getDbMovie(), getDbUser());

				} else {
					JOptionPane.showMessageDialog(null, "Dati Mancanti");
				}

			}

		});

		// OPTION update movie

		getOptionUpdate().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textFields[0].setEditable(true);
				textFields[1].setEditable(true);
				textFields[2].setEditable(true);
				textFields[3].setEditable(true);
				textFields[4].setEditable(true);
				textFields[5].setEditable(true);
				textAreaTimeLine.setEditable(true);

				getUpdateObject().setVisible(true);
				getAddObject().setVisible(false);
				getRemoveObject().setVisible(false);

			}
		});

		// update

		super.getUpdateObject().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (controlData(textFields) == true) {
					Object[] row = { table.getValueAt(table.getSelectedRow(), 0), textFields[0].getText(),
							textFields[1].getText(), textFields[2].getText(), textFields[3].getText(),
							textFields[4].getText(), textFields[5].getText() };
					table.updateRow(row);
				} else {
					JOptionPane.showMessageDialog(null, "Dati Mancanti");
				}

				Movie m = createMovie.create(table.getRowCount(), textFields[0].getText(), textFields[1].getText(),
						textFields[2].getText(), textFields[3].getText(), new JLabel(textFields[4].getText()),
						textAreaTimeLine.getText(), textFields[5].getText());

				getDbMovie().updateMovie(m);
				setComponent(getCurrentUser(), getDbMovie(), getDbUser());

			}
		});

		// OPTION BUTTON RIMUOVI

		super.getOptionRemove().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getRemoveObject().setVisible(true);
				getAddObject().setVisible(false);
				getUpdateObject().setVisible(false);

			}
		});

		// remove

		super.getRemoveObject().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < table.getRowCount(); i++) {
					if (table.isRowSelected(i)) {
						setRemovable(false);
						table.removeRow(i);
						setRemovable(true);
						getDbMovie().deleteMovie((getDbMovie().getMovie(i)));

					}
				}
				setComponent(getCurrentUser(), getDbMovie(), getDbUser());
			}

		});

	}

	@Override
	public void initializeTextFields() {
		for (int i = 0; i < textFields.length; i++) {
			super.getComponentCreator().createTextField("", "Britannic Bold", 14, Color.BLACK);
			super.getComponentCreator().setUpComponentProp(131, YTextField[i], 173, 20);
			this.textFields[i] = super.getComponentCreator().getTextField();
			this.textFields[i].setEditable(true);
			super.getPanel().add(textFields[i]);

		}

	}

	@Override
	public void initializeLabels() {
		super.getComponentCreator().createLabel(txtLabel[0], "Britannic Bold", 21, Color.WHITE);
		super.getComponentCreator().setUpComponentProp(XLabel[0], YLabel[0], widthLabel[0], heightLabel[0]);
		this.add(super.getComponentCreator().getLabel());

		for (int i = 1; i < 8; i++) {
			super.getComponentCreator().createLabel(txtLabel[i], "Britannic Bold", fontSizeLabel[i], Color.BLACK);
			super.getComponentCreator().setUpComponentProp(XLabel[i], YLabel[i], widthLabel[i], heightLabel[i]);
			lbl[i] = super.getComponentCreator().getLabel();
			lbl[i].setHorizontalAlignment(SwingConstants.CENTER);
			lbl[i].setLabelFor(super.getPanel());
			super.getPanel().add(lbl[i]);
		}

	}

	@Override
	public void initializeTable() {
		// table
		table = new TableMovie();
		// selezione
		table.getSelectionModel().addListSelectionListener(e -> {
			if (super.isRemovable() == true) {
				textFields[0].setText((table.getValueAt(table.getSelectedRow(), 1).toString()));
				textFields[1].setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				textFields[3].setText(table.getValueAt(table.getSelectedRow(), 4).toString());
				textFields[2].setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				textFields[4].setText(table.getValueAt(table.getSelectedRow(), 5).toString());
				textFields[5].setText(table.getValueAt(table.getSelectedRow(), 7).toString());
				textAreaTimeLine.setText(table.getValueAt(table.getSelectedRow(), 6).toString());

				textFields[0].setEditable(true);
				textFields[1].setEditable(true);
				textFields[2].setEditable(true);
				textFields[3].setEditable(true);
				textFields[4].setEditable(true);
				textFields[5].setEditable(true);
				textAreaTimeLine.setEditable(true);

			}

		});

	}

	private void initializeTextArea() {

		textAreaTimeLine = new JTextArea();
		textAreaTimeLine.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textAreaTimeLine.setLineWrap(true);

		scrollPaneTimeLine = new JScrollPane(textAreaTimeLine);
		scrollPaneTimeLine.setBounds(435, 29, 307, 130);
		super.getPanel().add(scrollPaneTimeLine);

	}

	@Override
	public void setComponent(User u, DatabaseMovie dbMovie, DatabaseUser dbUser) {
		setUser(u);
		setDbMovie(dbMovie);
		setDbUser(dbUser);
		super.getScrollPaneTable().setViewportView(table);

	}

}
