package movietime.core.card;

import javax.swing.DefaultListModel;

import movietime.core.movie.Movie;
import movietime.core.ordermanager.Order;

public interface RentalCardPriceStrategy {

	public void calculateTotal(Order order);

	public void executePayment(DefaultListModel<Movie> myRentals);

}
