package movietime.core.tabledatabase;

import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import movietime.core.database.DatabaseMovie;
import movietime.core.movie.Movie;

public class TableMovie extends JTable implements TableInterface {

	private Object[][] data;
	private String[] columnName = { "id_movie", "title", "director", "year", "category", "cover", "trama",
			"newrelease" };

	private JTable table;
	private DefaultTableModel tableModel;

	private DatabaseMovie dbMovie;
	private DefaultListModel<Movie> listMovie;

	private CreateTableDatabase select;

	public TableMovie() {
		dbMovie = new DatabaseMovie();
		select = new CreateTableDatabase();
		tableModel = new DefaultTableModel();
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

		Object[][] data = select.selectAllRow("MOVIE", nomicolonne);
		for (int i = 0; i < data.length; i++) {
			tableModel.addRow(data[i]);
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
				for (int j = 0; j < data.length; j++) {
					tableModel.setValueAt(data[j], i, j);

				}

			}
		}

	}
}
