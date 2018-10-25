package movietime.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

import movietime.core.card.Children;
import movietime.core.movie.NewRelease;
import movietime.core.movie.NormalMovie;
import movietime.core.ordermanager.Order;

public class ChildrenCardTest {

	private double delta = 0.0;
	private int id_owner = 0;
	private int number = 130;
	private double myCredit;

	private Children childrenCard;
	private Order myOrder;

	private boolean checkChildrenMovie = false;

	private NormalMovie dangerMovie;

	private NormalMovie unknownMovie;
	private NormalMovie animationMovie;
	private NewRelease animationNewReleaseMovie;

	@Before
	public void setUp() {

		myCredit = 100.0;
		childrenCard = new Children(id_owner, number, myCredit);
		unknownMovie = new NormalMovie(0, "", "", "", "aaaa", new JLabel(), "trama");
		animationMovie = new NormalMovie(0, "", "", "", "Animation", new JLabel(), "trama");
		dangerMovie = new NormalMovie(0, "", "", "", "Action", new JLabel(), "trama");
		animationNewReleaseMovie = new NewRelease(0, "", "", "", "Animation", new JLabel(), "trama");

	}

	@Test
	public void calculateTotalPriceWithoutDiscountTest() {
		childrenCard = new Children(id_owner, number, myCredit);
		myOrder = new Order();
		myOrder.getMyRentals().addElement(animationMovie);
		myOrder.getMyRentals().addElement(animationMovie);
		double expected = 2.0;
		assertNotEquals(expected, childrenCard.getTotPrice(), delta);
	}

	@Test
	public void parentalControlDangerMovieTest() {
		myOrder = new Order();
		myOrder.getMyRentals().addElement(dangerMovie);
		myOrder.getMyRentals().addElement(animationMovie);
		assertTrue(childrenCard.parentalControl(myOrder.getMyRentals()));
	}

	@Test
	public void parentalControlWhithUnknownCategoryTest() {
		myOrder = new Order();
		myOrder.getMyRentals().addElement(dangerMovie);
		myOrder.getMyRentals().addElement(animationMovie);
		assertTrue((childrenCard.parentalControl(myOrder.getMyRentals())));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void executePaymentWithDiscountTest() {
		myCredit = 100.0;
		childrenCard = new Children(id_owner, number, myCredit);
		myOrder = new Order();
		myOrder.getMyRentals().addElement(animationNewReleaseMovie);
		double expectedCredit = 98.4;// sconto 20% sullla novità
		childrenCard.calculateTotal(myOrder);
		childrenCard.executePayment(myOrder.getMyRentals());
		double actual = childrenCard.getCredit();
		assertEquals(expectedCredit, actual, delta);

	}

	@Test
	public void executePaymentWithNotDiscountTest() {
		myCredit = 100.0;
		childrenCard = new Children(id_owner, number, myCredit);
		myOrder = new Order();
		myOrder.getMyRentals().addElement(animationMovie);
		double expectedCredit = 99.0;
		childrenCard.calculateTotal(myOrder);
		childrenCard.executePayment(myOrder.getMyRentals());
		double actual = childrenCard.getCredit();
		assertEquals(expectedCredit, actual, delta);
	}

}
