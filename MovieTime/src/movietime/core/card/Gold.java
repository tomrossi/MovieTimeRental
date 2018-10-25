package movietime.core.card;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import movietime.core.movie.Movie;
import movietime.core.movie.NewRelease;
import movietime.core.ordermanager.Order;


public class Gold extends RentalCard {
	
	private CollectionGoldPoint collectionPoint;

	public Gold(int id_owner, long number, double credit) {
		super(id_owner, number, credit);
		collectionPoint = new CollectionGoldPoint();
	}

	

	@Override
	public void calculateTotal(Order myorder) {
		super.setTotalOrder(myorder.getPriceListMovie());

	}

	@Override
	public void executePayment(DefaultListModel<Movie> myRentals) {
		int dialogResult = 0;
		if (controlDiscount(collectionPoint.getGoldPoint())) {
			// 50% su l'ordine
			dialogResult = JOptionPane.showConfirmDialog(null, "Hai diritto allo sconto del 50%.Vuoi applicarlo?");
			if (dialogResult == JOptionPane.YES_OPTION) {
				super.setTotalOrder(super.getTotalOrder() * 0.50);
				collectionPoint.setGoldPoint(collectionPoint.getGoldPoint() - 50);
				super.setMycredit(super.getCredit() - super.getTotalOrder());

				myRentals.removeAllElements();
			} else if (dialogResult == JOptionPane.NO_OPTION) {
				normalPayment(myRentals);
			}
		} else {
			normalPayment(myRentals);

		}
	}

	private void normalPayment(DefaultListModel<Movie> myRentals) {
		int newpoint = calculateNewGold_point(myRentals);
		super.setMycredit(super.getCredit() - super.getTotalOrder());
		myRentals.removeAllElements();
		collectionPoint.setGoldPoint(collectionPoint.getGoldPoint() + newpoint);
		JOptionPane.showMessageDialog(null, "Nuovi GoldPoint:" + collectionPoint.getGoldPoint());

	}

	private boolean controlDiscount(int goldPoint) {
		boolean d = false;
		if (goldPoint >= 50) {
			d = true;
		}
		return d;
	}

	public int calculateNewGold_point(DefaultListModel<Movie> myRental) {
		int point = 0;
		int i = 0;
		while (i < myRental.size()) {
			if (myRental.get(i) instanceof NewRelease) {
				point = point + 8;
			} else {
				point = point + 5;
			}
			i++;
		}
		return point;
	}

	@Override
	public void setGoldPoint(CollectionGoldPoint collection) {
		this.collectionPoint = collection;

	}

	public CollectionGoldPoint getCollectionGoldPoint() {
		// TODO Auto-generated method stub
		return collectionPoint;
	}

}
