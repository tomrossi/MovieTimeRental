package movietime.core.user;

import movietime.core.accesspanel.CreateMenuPanel;
import movietime.core.accesspanel.Visitor;
import movietime.core.card.RentalCard;
import movietime.core.ordermanager.Order;

public interface User {

	public int getId();

	public String getName();

	public String getSurname();

	public String getAddress();

	public String getPhone();

	public String getE_mail();

	public String getUsername();

	public String getPassword();

	public RentalCard getRentalcard();

	public void setRentalCard(RentalCard card);

	public String getAdmin();

	public Order getMyOrder();

	public void accept(Visitor menuCreator);

	

}
