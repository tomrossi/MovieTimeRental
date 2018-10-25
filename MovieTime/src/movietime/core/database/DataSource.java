package movietime.core.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DataSource {

	static Connection connection = null;

	Statement stmt = null;

	ResultSet rs = null;

	public static Connection connectDB() {

		Connection con = null;

		try {
			if (connection != null) {
				System.out.println("impossibile connettersi");
			} else {
				Class.forName("org.sqlite.JDBC");
				con = DriverManager.getConnection("jdbc:sqlite:res\\Database.sqlite");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error");
		}
		return con;
	}

	public Statement createStatement() {
		try {
			stmt = DataSource.connectDB().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;

	}

	public ResultSet executeQuery(String sql) {
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
