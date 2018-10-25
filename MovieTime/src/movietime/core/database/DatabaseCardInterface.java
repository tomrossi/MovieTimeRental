package movietime.core.database;

import javax.swing.DefaultListModel;

import movietime.core.card.RentalCard;

public interface DatabaseCardInterface {

	public void createListCard();

	public DefaultListModel<RentalCard> getListCard();

	public void addCard(RentalCard card);

	public RentalCard getCard(int id_owner);

}
