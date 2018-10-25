package movietime.core.tabledatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class OperationDatabase {

	Connection conn = null;

	Statement stmt = null;

	ResultSet rs = null;

	public OperationDatabase() {
		conn = connectDB();
		stmt = createStatement();
	}

	public static Connection connectDB() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:res\\Database.sqlite");
			return conn;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error");
		}
		return null;
	}

	public Statement createStatement() {
		try {
			stmt = OperationDatabase.connectDB().createStatement();
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

	public Connection getConn() {
		return conn;
	}

	public Statement getStmt() {
		return stmt;
	}

	public ResultSet getRs() {
		return rs;
	}

}
