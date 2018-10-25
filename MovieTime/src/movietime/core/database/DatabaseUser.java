package movietime.core.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultListModel;

import movietime.core.creator.CreateUser;
import movietime.core.user.AbsUser;

public class DatabaseUser implements DatabaseUserInterface {

	private DefaultListModel<AbsUser> listUser;

	public DatabaseUser() {
		listUser = new DefaultListModel<AbsUser>();
	}

	@Override
	public void createListUserFromDatabase() {
		DataSource ds = new DataSource();
		Connection con = ds.connectDB();
		Statement st = null;
		ResultSet rs = null;

		CreateUser createUser = new CreateUser();

		try {
			String query = "Select * from USER;";
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				int id_user = rs.getInt("id_user");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String admin = rs.getString("admin");
				AbsUser u = createUser.create(id_user, name, surname, address, phone, email, username, password, admin);
				listUser.addElement(u);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		finally {

			try {

				con.close();

				st.closeOnCompletion();

				rs.close();

			} catch (Exception exe) {
				exe.printStackTrace();
			}

		}

	}

	@Override
	public void addUser(AbsUser u) {
		listUser.addElement(u);

	}

	@Override
	public AbsUser getUser(int id) {
		return listUser.getElementAt(id);
	}

	@Override
	public void updateUser(AbsUser u) {
		for (int i = 0; i < listUser.size(); i++) {
			if (u.getId() == listUser.getElementAt(i).getId()) {
				listUser.getElementAt(i).setName(u.getName());
				listUser.getElementAt(i).setSurname(u.getSurname());
				listUser.getElementAt(i).setAddress(u.getAddress());
				listUser.getElementAt(i).setPhone(u.getPhone());
				listUser.getElementAt(i).setE_mail(u.getE_mail());
				listUser.getElementAt(i).setUsername(u.getUsername());
				listUser.getElementAt(i).setPassword(u.getPassword());
				listUser.getElementAt(i).setAdmin(u.getAdmin());
			}
		}

	}

	@Override
	public DefaultListModel<AbsUser> getList() {
		// TODO Auto-generated method stub
		return listUser;
	}

	@Override
	public void delete(AbsUser u) {
		for (int i = 0; i < listUser.size(); i++) {
			if (u.getId() == listUser.getElementAt(i).getId()) {
				listUser.removeElementAt(i);
			}
		}

	}

}
