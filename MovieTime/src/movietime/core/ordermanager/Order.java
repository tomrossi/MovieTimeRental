package movietime.core.ordermanager;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import movietime.core.movie.Movie;



public class Order implements OrderManager {

	private DefaultListModel<Movie> myRentals;
	private int dayOfRentals = 1;
	private double priceOrder;
	private double discount;
	private double total;

	public Order() {
		myRentals = new DefaultListModel<Movie>();
	}

	@Override
	public void add(Movie movie) {
		myRentals.addElement((movie));

	}

	public boolean checkMovie(Movie m, DefaultListModel<Movie> list) {
		boolean find = false;
		int i = 0;
		if (!list.isEmpty()) {
			while (i < list.size() && !find) {
				if (m.getID_Movie() == list.getElementAt(i).getID_Movie()) {
					find = true;
				}
				i++;
			}
		}

		return find;
	}

	@Override
	public void remove(Movie movie) {
		if (!myRentals.contains(movie)) {
			JOptionPane.showMessageDialog(null, "Impossibile,elemento non presente nell'ordine");

		} else {
			myRentals.removeElement(movie);
			JOptionPane.showMessageDialog(null, movie.getTitle() + " rimosso dall'ordine");
		}

	}

	@Override
	public double getPriceListMovie() {
		double totPrice = 0;

		for (int i = 0; i < myRentals.size(); i++) {
			totPrice = totPrice + myRentals.get(i).getPrice();
		}
		return totPrice * this.getDayOfRentals();
	}

	public DefaultListModel<Movie> getMyRentals() {
		return myRentals;
	}

	public void setMyRentals(DefaultListModel<Movie> myRentals) {
		this.myRentals = myRentals;
	}

	public int getDayOfRentals() {
		return dayOfRentals;
	}

	public void setDayOfRentals(int dayOfRentals) {
		this.dayOfRentals = dayOfRentals;
	}

	public double getPriceOrder() {
		return priceOrder;
	}

	public void setPriceOrder(double priceOrder) {
		this.priceOrder = priceOrder;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
