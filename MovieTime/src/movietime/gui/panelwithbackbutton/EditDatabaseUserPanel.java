package movietime.gui.panelwithbackbutton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import movietime.core.creator.CreateCard;
import movietime.core.creator.CreateUser;
import movietime.core.database.DatabaseMovie;
import movietime.core.database.DatabaseUser;
import movietime.core.tabledatabase.TableUser;
import movietime.core.user.AbsUser;
import movietime.core.user.User;
import movietime.gui.panel.SetterComponentUserData;

public class EditDatabaseUserPanel extends EditDatabasePanel
		implements SetterComponentUserData, InitializeComponentEditDatabasePanel {

	private JLabel labelTitle;
	private JLabel lblName;
	private JLabel lblSurname;
	private JLabel lblAddress;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblCardNumber;
	private JLabel lblAdmin;

	private JLabel[] lbl = { labelTitle, lblName, lblSurname, lblAddress, lblPhone, lblEmail, lblUsername, lblPassword,
			lblCardNumber, lblAdmin };
	private int[] XLabel = { 10, 35, 35, 35, 35, 35, 35, 412, 412, 412 };
	private int[] YLabel = { 11, 24, 59, 94, 129, 164, 199, 24, 59, 94 };
	private int[] widthLabel = { 754, 86, 86, 86, 86, 86, 86, 95, 95, 95 };
	private int[] heightLabel = { 22, 24, 24, 24, 24, 24, 24, 24, 24, 24 };
	private String[] txtLabel = { "Edit Database User", "Name", "Surname", "Address", "Phone", "EMail", "Username",
			"Password", "Card Number", "Admin" };
	private int[] fontSizeLabel = { 21, 15, 15, 15, 15, 15, 15, 15, 15, 15 };

	private JTextField textFieldName;
	private JTextField textFieldSurname;
	private JTextField textFieldAddress;
	private JTextField textFieldPhone;
	private JTextField textFieldEmail;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JTextField textFieldCardnumber;
	private JTextField textFieldAdmin;

	private JTextField[] textFields = { textFieldName, textFieldSurname, textFieldAddress, textFieldPhone,
			textFieldEmail, textFieldUsername, textFieldPassword, textFieldCardnumber, textFieldAdmin };
	private int[] XTextField = { 131, 131, 131, 131, 131, 131, 517, 517, 517 };
	private int[] YTextField = { 28, 63, 98, 133, 168, 203, 28, 94, 59 };
	private int[] widthTextField = { 173, 173, 173, 173, 173, 173, 173, 173, 173 };
	private int[] heightTextField = { 20, 20, 20, 20, 20, 20, 20, 20, 20 };

	private TableUser table;

	private CreateUser createUser;

	private CreateCard createCard;

	public EditDatabaseUserPanel(JFrame frame) {
		super(frame);
		createUser = new CreateUser();
		createCard = new CreateCard();
		initializeTextFields();
		initializeLabels();
		initializeTable();
		setDatabaseButtonAction();

	}

	@Override
	public void initializeTextFields() {
		for (int i = 0; i < textFields.length; i++) {
			super.getComponentCreator().createTextField("", "Britannic Bold", 14, Color.BLACK);
			super.getComponentCreator().setUpComponentProp(XTextField[i], YTextField[i], 173, 20);
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

		for (int i = 1; i < lbl.length; i++) {
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
		table = new TableUser();

		// selezione
		table.getSelectionModel().addListSelectionListener(e -> {
			if (super.isRemovable() == true) {
				textFields[0].setText((table.getValueAt(table.getSelectedRow(), 3).toString()));
				textFields[1].setText(table.getValueAt(table.getSelectedRow(), 4).toString());
				textFields[2].setText(table.getValueAt(table.getSelectedRow(), 5).toString());
				textFields[3].setText(table.getValueAt(table.getSelectedRow(), 6).toString());
				textFields[4].setText(table.getValueAt(table.getSelectedRow(), 7).toString());
				textFields[5].setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				textFields[6].setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				textFields[7].setText(table.getValueAt(table.getSelectedRow(), 8).toString());
				textFields[8].setText(table.getValueAt(table.getSelectedRow(), 9).toString());

				textFields[0].setEditable(true);
				textFields[1].setEditable(true);
				textFields[2].setEditable(true);
				textFields[3].setEditable(true);
				textFields[4].setEditable(true);
				textFields[5].setEditable(true);
				textFields[6].setEditable(true);
				textFields[7].setEditable(true);
				textFields[8].setEditable(true);

			}

		});

	}

	@Override
	public void setDatabaseButtonAction() {
		// OPTION ADD USER

		super.getOptionAdd().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				textFields[0].setText(null);
				textFields[1].setText(null);
				textFields[2].setText(null);
				textFields[3].setText(null);
				textFields[4].setText(null);
				textFields[5].setText(null);
				textFields[6].setText(null);
				textFields[7].setText(null);
				textFields[8].setText(null);

				getAddObject().setVisible(true);
				getRemoveObject().setVisible(false);
				getUpdateObject().setVisible(false);

			}
		});

		// ADD USER

		getAddObject().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (controlData(textFields) == true) {
					Object[] row = { table.getRowCount(), textFields[5].getText(), textFields[6].getText(),
							textFields[0].getText(), textFields[1].getText(), textFields[2].getText(),
							textFields[3].getText(), textFields[4].getText(), textFields[7].getText(),
							textFields[8].getText() };

					AbsUser u = createUser.create(table.getRowCount(), textFields[0].getText(), textFields[1].getText(),
							textFields[2].getText(), textFields[3].getText(), textFields[4].getText(),
							textFields[5].getText(), textFields[6].getText(), textFields[7].getText());

					table.addRow(row);
					getScrollPaneTable().setViewportView(table);
					getDbUser().addUser(u);

				} else {
					JOptionPane.showMessageDialog(null, "Dati Mancanti");
				}

			}

		});

		// OPTION update user

		getOptionUpdate().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textFields[0].setEditable(true);
				textFields[1].setEditable(true);
				textFields[2].setEditable(true);
				textFields[3].setEditable(true);
				textFields[4].setEditable(true);
				textFields[5].setEditable(true);
				textFields[6].setEditable(true);
				textFields[7].setEditable(true);
				textFields[8].setEditable(true);

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
					Object[] row = { table.getSelectedRow(), textFields[5].getText(), textFields[6].getText(),
							textFields[0].getText(), textFields[1].getText(), textFields[2].getText(),
							textFields[3].getText(), textFields[4].getText(), textFields[7].getText(),
							textFields[8].getText() };
					table.updateRow(row);
					AbsUser u = createUser.create(table.getSelectedRow(), textFields[0].getText(),
							textFields[1].getText(), textFields[2].getText(), textFields[3].getText(),
							textFields[4].getText(), textFields[5].getText(), textFields[6].getText(),
							textFields[7].getText());
					getDbUser().updateUser(u);

				} else {
					JOptionPane.showMessageDialog(null, "Dati Mancanti");
				}

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
						getDbUser().delete(getDbUser().getUser(i));

					}
				}

			}

		});

	}

	@Override
	public void setComponent(User u, DatabaseMovie dbMovie, DatabaseUser dbUser) {
		setUser(u);
		setDbMovie(dbMovie);
		setDbUser(dbUser);
		super.getScrollPaneTable().setViewportView(table);

	}

}
