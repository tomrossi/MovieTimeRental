package movietime.core.creator;

import movietime.core.user.AbsUser;
import movietime.core.user.Admin;
import movietime.core.user.Client;

public class CreateUser {

	// crea istanze di utenti
	public AbsUser create(int id, String n, String s, String add, String ph, String e_mail, String use, String pas,
			String type) {
		if (type.equals("Admin")) {
			return new Admin(id, n, s, add, ph, e_mail, use, pas, type);
		} else {
			return new Client(id, n, s, add, ph, e_mail, use, pas, type);
		}

	}

}
