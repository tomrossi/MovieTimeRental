package movietime.core.database;

import javax.swing.DefaultListModel;

import movietime.core.user.AbsUser;
import movietime.core.user.User;



public interface DatabaseUserInterface {

	public void createListUserFromDatabase();

	public void addUser(AbsUser u);

	public DefaultListModel<AbsUser> getList();

	public User getUser(int id);

	public void updateUser(AbsUser u);

	public void delete(AbsUser u);

}
