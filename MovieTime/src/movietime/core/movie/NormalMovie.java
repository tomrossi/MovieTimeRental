package movietime.core.movie;

import javax.swing.JLabel;

public class NormalMovie extends Movie {

	private final static double PRICE_NORMAL_MOVIE = 1.00;

	public NormalMovie(long ID_Movie, String title, String director, String year, String category, JLabel cover,
			String trama) {
		super(ID_Movie, title, director, year, category, cover, trama);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return PRICE_NORMAL_MOVIE;
	}

}
