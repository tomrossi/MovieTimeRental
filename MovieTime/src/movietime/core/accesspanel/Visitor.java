package movietime.core.accesspanel;

import movietime.core.user.Admin;
import movietime.core.user.Client;

public interface Visitor {

	public MenuPanel createPanelAccess(Client client);

	public MenuPanel createPanelAccess(Admin admin);

	public MenuPanel getMenuPanel();
}
