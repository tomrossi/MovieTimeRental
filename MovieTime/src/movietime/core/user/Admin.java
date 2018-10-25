package movietime.core.user;

import movietime.core.accesspanel.CreateMenuPanel;
import movietime.core.accesspanel.MenuClient;
import movietime.core.accesspanel.Visitor;


public class Admin extends AbsUser  {

	private MenuClient adminPanel;

	public Admin(int id_user, String name, String surname, String address, String phone, String e_mail, String username,
			String password, String admin) {
		super(id_user, name, surname, address, phone, e_mail, username, password, admin);

	}

	@Override
	public void accept(Visitor v) {
		v.createPanelAccess(this);
		
	}

	

	

}
