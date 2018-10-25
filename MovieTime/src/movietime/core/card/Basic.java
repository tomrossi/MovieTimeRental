package movietime.core.card;

import javax.swing.DefaultListModel;

import movietime.core.movie.Movie;
import movietime.core.ordermanager.Order;

public class Basic extends RentalCard {

	public Basic(int id_owner, long number, double credit) {
		super(id_owner, number, credit);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void calculateTotal(Order myOrder) {
		super.setTotPrice(myOrder.getPriceListMovie());
		super.setDiscount(((super.getTotPrice() / 100) * 20));
		super.setTotalOrder(super.getTotPrice() - super.getDiscount());
	}

	@Override
	public void executePayment(DefaultListModel<Movie> myRentals) {
		super.setMycredit(super.getCredit() - super.getTotalOrder());
		myRentals.removeAllElements();
	}

	@Override
	public void setGoldPoint(CollectionGoldPoint collection) {
		// TODO Auto-generated method stub

	}

}
