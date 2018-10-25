package movietime.core.loginsystem;

import javax.swing.DefaultListModel;

import movietime.core.card.RentalCard;
import movietime.core.creator.CreateCard;
import movietime.core.creator.CreateUser;
import movietime.core.database.DatabaseCard;
import movietime.core.database.DatabaseUser;
import movietime.core.ordermanager.Order;
import movietime.core.user.AbsUser;
import movietime.core.user.User;

public class SetAccessUser {

	private String username;
	private String password;
	private User userAccess;
	private DatabaseUser userDB = new DatabaseUser();
	private CreateUser createUser = new CreateUser();
	private DatabaseCard cardDB = new DatabaseCard();
	private CreateCard createCard = new CreateCard();
	private RentalCard card;
	private Order myOrder;

	public SetAccessUser(String use, String pas) {
		this.username = use;
		this.password = pas;
		checkUser(use, pas);
		checkRentalCard(userAccess.getId());
	}

	private void checkUser(String username, String password) {
		userDB.createListUserFromDatabase();
		DefaultListModel<AbsUser> listUser = userDB.getList();
		for (int i = 0; i < listUser.size(); i++) {
			if (this.username.equals(listUser.get(i).getUsername())
					&& this.password.equals(listUser.get(i).getPassword())) {
				this.userAccess = listUser.get(i);
			}
		}

		// TODO Auto-generated method stub

	}

	private void checkRentalCard(int id) {
		this.card = cardDB.getCard(id);
	}

	public User getUserAccess() {
		return userAccess;
	}

	public RentalCard getCard() {
		return card;
	}

}
