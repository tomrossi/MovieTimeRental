package movietime.gui.panel;

import movietime.core.database.DatabaseMovie;
import movietime.core.database.DatabaseUser;
import movietime.core.user.User;

public interface SetterComponentUserData {

	void setComponent(User u, DatabaseMovie dbMovie, DatabaseUser dbUser);

}
