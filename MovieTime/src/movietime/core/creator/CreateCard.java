package movietime.core.creator;

import movietime.core.card.Basic;
import movietime.core.card.Children;
import movietime.core.card.Gold;
import movietime.core.card.RentalCard;

public class CreateCard {

	
	public RentalCard create(int id_owner, long number, double credit, String type) {
		if (type.equals("Basic")) {
			return new Basic(id_owner, number, credit);
		} else if (type.equals("Children")) {
			return new Children(id_owner, number, credit);
		} else {
			return new Gold(id_owner, number, credit);
		}

	}

}
