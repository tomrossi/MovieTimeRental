package movietime.core.card;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import movietime.core.movie.Movie;
import movietime.core.movie.NewRelease;
import movietime.core.ordermanager.Order;

public class Children extends RentalCard {

	public Children(int id_owner, long number, double credit) {
		super(id_owner, number, credit);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void calculateTotal(Order myorder) {
		super.setTotPrice(myorder.getPriceListMovie());
		double sale = 0;
		for (int i = 0; i < myorder.getMyRentals().size(); i++) {
			Movie current = myorder.getMyRentals().getElementAt(i);
			if (current instanceof NewRelease) {
				sale += ((current.getPrice() / 100) * 20);
			}
		}
		super.setDiscount(sale);
		super.setTotalOrder(super.getTotPrice() - super.getDiscount());

	}

	@Override
	public void executePayment(DefaultListModel<Movie> myRentals) {
		if (parentalControl(myRentals)) {
			JOptionPane.showMessageDialog(null, "Puoi noleggiare solo film di genere Animazione");
		} else {
			super.setMycredit(super.getCredit() - super.getTotalOrder());
			myRentals.removeAllElements();
		}

	}

	public boolean parentalControl(DefaultListModel<Movie> myRentals) {
		boolean danger = false;
		for (int i = 0; i < myRentals.size(); i++) {
			if (!myRentals.getElementAt(i).getCategory().equals("Animation")) {
				danger = true;
			}
		}
		return danger;
	}

	@Override
	public void setGoldPoint(CollectionGoldPoint collection) {
		// TODO Auto-generated method stub

	}

}
