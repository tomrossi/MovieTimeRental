package movietime.core.creator;

import javax.swing.JLabel;

import movietime.core.movie.Movie;
import movietime.core.movie.NewRelease;
import movietime.core.movie.NormalMovie;

public class CreateMovie {

	public Movie create(long ID_Movie, String title, String director, String year, String category, JLabel cover,
			String trama, String type) {
		if (type.equals("NewRelease")) {
			return new NewRelease(ID_Movie, title, director, year, category, cover, trama);
		} else {
			return new NormalMovie(ID_Movie, title, director, year, category, cover, trama);
		}

	}

}
