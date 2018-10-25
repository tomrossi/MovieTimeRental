package movietime.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

import movietime.core.movie.Movie;
import movietime.core.movie.NormalMovie;
import movietime.core.ordermanager.Order;

public class OrderTest {

	private double delta = 0.0;
	private double OrderPrice = 0.0;
	private Order myOrder;

	private Movie m;

	@Before
	public void test() {
		myOrder = new Order();
		m = new NormalMovie(0, "title", "director", "year", "category", new JLabel(), "trama");

	}

	@Test
	public void emptyOrderList() {
		DefaultListModel<Movie> myList = myOrder.getMyRentals();
		assertTrue(myList.isEmpty());
	}

	@Test
	public void addAndremoveMovieFromList() throws Exception {
		myOrder.add(m);
		myOrder.remove(m);
		DefaultListModel<Movie> myList = myOrder.getMyRentals();
		assertTrue(myList.isEmpty());
	}

	@Test
	public void checkPriceAfterRemove() throws Exception {
		double moviePrice = myOrder.getPriceListMovie();
		myOrder.add(m);
		myOrder.remove(m);
		double currentPrice = myOrder.getPriceListMovie();
		assertEquals(moviePrice, currentPrice, delta);
	}

	@Test
	public void removeAllMovieFromOrder() throws Exception {
		myOrder.add(m);
		myOrder.add(m);
		myOrder.getMyRentals().removeAllElements();
		assertEquals(0, myOrder.getMyRentals().size());
	}

	@Test
	public void removeAllItemsFromEmptyOrder() throws Exception {
		myOrder.getMyRentals().removeAllElements();
		assertEquals(0, myOrder.getMyRentals().size());
	}

}
