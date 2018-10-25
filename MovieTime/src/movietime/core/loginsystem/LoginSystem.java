package movietime.core.loginsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import movietime.core.database.DataSource;



public class LoginSystem {

	private String username;
	private String password;
	private DataSource dbsource;
	private boolean access;

	public LoginSystem() {
		dbsource = new DataSource();
	}

	public boolean controlAccess(String use, String pas) throws SQLException {
		Connection c = dbsource.connectDB();
		access = false;
		try {
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM USER,CARD WHERE username LIKE '" + use
					+ "' AND password LIKE '" + pas + "'" + "AND CARD.id_owner=USER.id_user;");
			// mettere in un metodo unico

			this.username = rs.getString("username");
			this.password = rs.getString("password");

		} catch (Exception e) {
			// TODO: handle exception
		}
		if (use.equals(username) && pas.equals(password)) {

			setAccess(true);
		} else {
			setAccess(false);

		}

		return access;
	}

	public boolean isAccess() {
		return access;
	}

	public void setAccess(boolean access) {
		this.access = access;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
