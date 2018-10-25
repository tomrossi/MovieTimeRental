package movietime.core.tabledatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableDatabase extends OperationDatabase {

	public Object[][] selectAllRow(String tableName, String[] columnName) throws ClassNotFoundException {
		String sql = "SELECT * from " + tableName + ";";
		int row = 0;
		Object[][] data = null;
		try {
			Class.forName("org.sqlite.JDBC");
			Connection c = DriverManager.getConnection("jdbc:sqlite:res\\Database.sqlite");
			c.setAutoCommit(false);

			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			row = 0;

			while (rs.next()) {
				row++;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		try {

			ResultSet rs2 = stmt.executeQuery(sql);

			data = new Object[row][10];
			row = 0;
			int j = 0;
			while (rs2.next()) {
				for (int i = 1; i < columnName.length; i++) {
					data[row][0] = rs2.getInt(columnName[0]);
					data[row][i] = rs2.getString(columnName[i]);
				}
				row++;

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return data;
	}

}
