package movietime.gui.panelwithbackbutton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import movietime.core.creator.ComponentCreator;
import movietime.core.user.Admin;

public class EditDatabasePanel extends JPanelWithBackgroundAndBackButton {

	private JPanel panel;
	private JScrollPane scrollPaneTable;
	private JButton optionAdd;
	private JButton optionUpdate;
	private JButton optionRemove;
	private JButton add;
	private JButton update;
	private JButton remove;
	private boolean editable = true;
	private boolean removable = true;
	private Admin currentUser;
	private ComponentCreator componentCreator;

	public EditDatabasePanel(JFrame frame) {
		super(frame);
		componentCreator = new ComponentCreator();
		initializePanel();
		initializeScrollPane();
		initializeButton(); // 6
	}

	protected void initializePanel() {
		panel = new JPanel();
		panel.setBounds(20, 194, 764, 266);
		add(panel);
		panel.setLayout(null);

	}

	protected void initializeButton() {
		super.getBtnBack().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				setPanelsVisibility();
			}
		});

		// OPTION ADD MOVIE
		componentCreator.createButton("Add Object", "Tahoma", 14, Color.BLACK);
		componentCreator.setUpComponentProp(20, 475, 183, 65);
		this.optionAdd = componentCreator.getButton();
		this.add(optionAdd);

		// ADD MOVIE

		componentCreator.createButton("Add", "Tahoma", 14, Color.BLACK);
		componentCreator.setUpComponentProp(517, 180, 183, 65);
		this.add = componentCreator.getButton();
		add.setVisible(false);
		panel.add(add);

		// OPTION update movie

		componentCreator.createButton("Update Object", "Tahoma", 14, Color.BLACK);
		componentCreator.setUpComponentProp(406, 475, 183, 65);
		this.optionUpdate = componentCreator.getButton();
		this.add(optionUpdate);

		// update
		componentCreator.createButton("Update", "Tahoma", 14, Color.BLACK);
		componentCreator.setUpComponentProp(517, 180, 183, 65);
		this.update = componentCreator.getButton();
		update.setVisible(false);
		panel.add(update);

		// OPTION BUTTON RIMUOVI
		componentCreator.createButton("Remove Object", "Tahoma", 14, Color.BLACK);
		componentCreator.setUpComponentProp(213, 475, 183, 65);
		this.optionRemove = componentCreator.getButton();
		this.add(optionRemove);

		// remove
		componentCreator.createButton("Remove", "Tahoma", 14, Color.BLACK);
		componentCreator.setUpComponentProp(517, 180, 183, 65);
		this.remove = componentCreator.getButton();
		remove.setVisible(false);
		panel.add(remove);

	}

	protected void initializeScrollPane() {
		scrollPaneTable = new JScrollPane();
		scrollPaneTable.setBounds(20, 46, 764, 137);
		scrollPaneTable.setBackground(Color.WHITE);
		add(scrollPaneTable);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(getImage(), 0, 0, null);
	}

	public JButton getOptionAdd() {
		return optionAdd;
	}

	public JButton getOptionUpdate() {
		return optionUpdate;
	}

	public JButton getOptionRemove() {
		return optionRemove;
	}

	public JButton getAddObject() {
		return add;
	}

	public JButton getUpdateObject() {
		return update;
	}

	public JButton getRemoveObject() {
		return remove;
	}

	public ComponentCreator getComponentCreator() {
		return componentCreator;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JScrollPane getScrollPaneTable() {
		return scrollPaneTable;
	}

	public boolean isEditable() {
		return editable;
	}

	public boolean isRemovable() {
		return removable;
	}

	public Admin getCurrentUser() {
		return currentUser;
	}

	protected boolean controlData(JTextField[] textFields) {
		boolean c = true;
		int i = 0;
		while (i < textFields.length && c) {
			if (textFields[i].equals("")) {
				c = false;
			}
			i++;
		}
		return c;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public void setRemovable(boolean removable) {
		this.removable = removable;
	}

}
