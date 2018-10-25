package movietime.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

import movietime.core.card.Basic;
import movietime.core.movie.NewRelease;
import movietime.core.movie.NormalMovie;
import movietime.core.ordermanager.Order;

public class BasicCardTest {

	private double delta = 0.0;
	private int id_owner = 0;
	private int number = 120;
	private double myCredit;

	private Basic basicCard;
	private Order myOrder;
	private NormalMovie normalMovie;
	private NewRelease newReleaseMovie;

	@Before
	public void setUp() {
		myCredit = 100.0;
		basicCard = new Basic(id_owner, number, myCredit);
		myOrder = new Order();
		normalMovie = new NormalMovie(0, "title", "director", "year", "category", new JLabel(), "trama");
		newReleaseMovie = new NewRelease(0, "title1", "director1", "year1", "category1", new JLabel(), "trama1");
	}

	@Test
	public void calculateTotalPriceWithoutDiscountTest() {
		myOrder.getMyRentals().addElement(normalMovie);
		myOrder.getMyRentals().addElement(newReleaseMovie);
		basicCard.calculateTotal(myOrder);
		double expected = 3.0;
		assertEquals(expected, basicCard.getTotPrice(), delta);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void executePaymentWithDiscountTest() {
		myOrder.getMyRentals().addElement(normalMovie);
		double expectedCredit = 99.2;// sconto 20%
		basicCard.calculateTotal(myOrder);
		basicCard.executePayment(myOrder.getMyRentals());
		double actual = basicCard.getCredit();
		assertEquals(expectedCredit, actual, delta);
	}

	@Test
	public void executePaymentWithDiscountTestWrong() {
		myOrder.getMyRentals().addElement(normalMovie);
		double fakeCredit = 154446;
		basicCard.calculateTotal(myOrder);
		basicCard.executePayment(myOrder.getMyRentals());
		double actual = basicCard.getCredit();
		assertNotEquals(fakeCredit, actual, delta);
	}

}
