package movietime.tests;

import static org.junit.Assert.assertEquals;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

import movietime.core.finder.ResearchForTitle;
import movietime.core.movie.Movie;
import movietime.core.movie.NormalMovie;

public class ResearchMovieForTitleTest {

	private String recordTrue;
	private String recordFake;
	private ResearchForTitle res;
	private DefaultListModel<Movie> listModelMovie;
	private NormalMovie movie;

	@Before
	public void setUp() {
		res = new ResearchForTitle();
		listModelMovie = new DefaultListModel<Movie>();
		recordTrue = "Pulp Fiction";
		recordFake = "sqisujuej";
		movie = new NormalMovie(0, "Pulp Fiction", "", "", "", new JLabel(), "");
	}

	@Test
	public void researchRecordMovieForTitleTest() {
		listModelMovie.addElement(movie);
		res.research(listModelMovie, recordTrue);
		boolean actual = checkMovieIntoList(listModelMovie, recordTrue);
		boolean expected = checkMovieIntoList(res.getTempResearch(), recordTrue);
		assertEquals(expected, actual);

	}

	@Test
	public void researchRecordFakeMovieForTitleTest() {
		listModelMovie.addElement(movie);
		res.research(listModelMovie, recordFake);
		boolean actual = checkMovieIntoList(listModelMovie, recordFake);
		boolean expected = checkMovieIntoList(res.getTempResearch(), recordFake);
		assertEquals(expected, actual);
	}

	private boolean checkMovieIntoList(DefaultListModel<Movie> listmodelMovie, String record) {
		boolean check = false;
		for (int i = 0; i < listmodelMovie.size(); i++) {
			if (listmodelMovie.getElementAt(i).getTitle().contains(record)) {
				check = true;
			}
		}
		return check;
	}

}
