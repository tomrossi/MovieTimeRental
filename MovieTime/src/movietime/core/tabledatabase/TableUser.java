package movietime.core.tabledatabase;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import movietime.core.database.DatabaseUser;

public class TableUser extends JTable implements TableInterface {

	private Object[][] data;
	private String[] columnName = { "id_user", "username", "password", "name", "surname", "address", "phone", "email",
			"admin", "cardnumber" };

	private JTable table;
	private DefaultTableModel tableModel;

	private DatabaseUser dbUser;
	private CreateTableDatabase create;

	public TableUser() {
		tableModel = new DefaultTableModel();
		create = new CreateTableDatabase();

		try {
			createTable(columnName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void createTable(String[] nomicolonne) throws ClassNotFoundException {
		for (int i = 0; i < nomicolonne.length; i++) {
			tableModel.addColumn(nomicolonne[i]);
		}

		Object[][] data = create.selectAllRow("USER", nomicolonne);

		for (int i = 0; i < data.length; i++) {
			tableModel.addRow(data[i]);
			;
		}

		this.setModel(tableModel);

	}

	@Override
	public void addRow(Object[] data) {

		tableModel.addRow(data);
	}

	@Override
	public void removeRow(int id) {
		tableModel.removeRow(id);

	}

	@Override
	public void updateRow(Object[] data) {
		int row = 0;
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			if (tableModel.getValueAt(i, 0).equals(data[0])) {
				tableModel.setValueAt(data[1], i, 1);
				tableModel.setValueAt(data[2], i, 2);
				tableModel.setValueAt(data[3], i, 3);
				tableModel.setValueAt(data[4], i, 4);
				tableModel.setValueAt(data[5], i, 5);
				tableModel.setValueAt(data[6], i, 6);
				tableModel.setValueAt(data[7], i, 7);
				tableModel.setValueAt(data[8], i, 8);

			}
		}

	}

	public String[] getColumnName() {
		return columnName;
	}

}
