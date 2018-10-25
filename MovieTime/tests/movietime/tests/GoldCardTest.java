package movietime.tests;

import static org.junit.Assert.assertEquals;

import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

import movietime.core.card.CollectionGoldPoint;
import movietime.core.card.Gold;
import movietime.core.movie.NewRelease;
import movietime.core.movie.NormalMovie;
import movietime.core.ordermanager.Order;

public class GoldCardTest {

	private double delta = 0.0;
	private int id_owner = 0;
	private int number = 130;
	private double myCredit;

	private Gold goldCard;
	private Order myOrder;
	private CollectionGoldPoint goldPointColl;

	private NormalMovie normalMovie;
	private NewRelease newReleaseMovie;

	@Before
	public void setUp() {
		myOrder = new Order();
		myCredit = 100.0;
		goldCard = new Gold(id_owner, number, myCredit);
		goldPointColl = new CollectionGoldPoint();
		normalMovie = new NormalMovie(0, "title", "director", "year", "category", new JLabel(), "trama");
		newReleaseMovie = new NewRelease(0, "title1", "director1", "year1", "category1", new JLabel(), "trama1");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void executePaymentWithYesClickForDiscountTest() {
		int goldPoint = 50;
		goldCard.getCollectionGoldPoint().setGoldPoint(goldPoint);
		myOrder.getMyRentals().addElement(normalMovie);
		myOrder.getMyRentals().addElement(newReleaseMovie);
		goldCard.calculateTotal(myOrder);
		goldCard.executePayment(myOrder.getMyRentals());
		double expected = 98.5;
		double actual = goldCard.getCredit();
		assertEquals(expected, actual, delta);
	}

	@Test
	public void executePaymentWithNoClickForDiscountTest() {
		int goldPoint = 50;
		goldCard.getCollectionGoldPoint().setGoldPoint(goldPoint);
		myOrder.getMyRentals().addElement(normalMovie);
		myOrder.getMyRentals().addElement(newReleaseMovie);
		goldCard.calculateTotal(myOrder);
		goldCard.executePayment(myOrder.getMyRentals());
		double expected = 97;
		double actual = goldCard.getCredit();
		assertEquals(expected, actual, delta);
	}

	@Test
	public void calculateNewGoldPointTest() {
		int goldPoint = 0;
		goldCard.getCollectionGoldPoint().setGoldPoint(goldPoint);
		myOrder.getMyRentals().addElement(normalMovie);
		myOrder.getMyRentals().addElement(newReleaseMovie);
		myOrder.getMyRentals().addElement(newReleaseMovie);
		myOrder.getMyRentals().addElement(newReleaseMovie);
		goldCard.executePayment(myOrder.getMyRentals());
		goldCard.calculateNewGold_point(myOrder.getMyRentals());
		double expectedPoint = 29;
		assertEquals(expectedPoint, goldCard.getCollectionGoldPoint().getGoldPoint(), delta);
	}

}
