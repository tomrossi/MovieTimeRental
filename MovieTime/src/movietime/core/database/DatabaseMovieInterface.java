package movietime.core.database;

import javax.swing.DefaultListModel;

import movietime.core.movie.Movie;

public interface DatabaseMovieInterface {

	public void createListMovieFromDatabase();

	public void addMovie(Movie m);

	public DefaultListModel<Movie> getList();

	public Movie getMovie(int id_movie);

	public void updateMovie(Movie m);

	public void deleteMovie(Movie m);

}
