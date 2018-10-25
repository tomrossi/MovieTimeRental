package movietime.core.movie;

import javax.swing.JLabel;

public class NewRelease extends Movie {

	private final static double PRICE_NEW_RELEASE = 2.00;

	public NewRelease(long ID_Movie, String title, String director, String year, String category, JLabel cover,
			String trama) {
		super(ID_Movie, title, director, year, category, cover, trama);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return PRICE_NEW_RELEASE;
	}

}
