package movietime.core.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;

import movietime.core.creator.CreateMovie;
import movietime.core.movie.Movie;

public class DatabaseMovie implements DatabaseMovieInterface {

	private DefaultListModel<Movie> listMovie;

	public DatabaseMovie() {
		listMovie = new DefaultListModel<Movie>();
	}

	@Override
	public void createListMovieFromDatabase() {
		DataSource ds = new DataSource();
		Connection con = ds.connectDB();
		Statement st = null;
		ResultSet rs = null;

		CreateMovie createMovie = new CreateMovie();

		try {
			String query = "Select * from MOVIE;";
			st = con.createStatement();
			rs = st.executeQuery(query);
			int i = 0;
			while (rs.next()) {
				i++;
				int id_movie = rs.getInt("id_movie");
				String title = rs.getString("title");
				String director = rs.getString("director");
				String year = rs.getString("year");
				String category = rs.getString("category");
				String cover = rs.getString("cover");
				String trama = rs.getString("trama");
				String type = rs.getString("newrelease");
				Movie m = createMovie.create(id_movie, title, director, year, category, new JLabel(cover), trama, type);
				listMovie.addElement(m);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		finally {

			try {

				con.close();

				st.closeOnCompletion();
				;

				rs.close();

			} catch (Exception exe) {
				exe.printStackTrace();
			}

		}

	}

	@Override
	public Movie getMovie(int id_movie) {
		return listMovie.getElementAt(id_movie);

	}

	@Override
	public void addMovie(Movie m) {
		listMovie.addElement(m);
	}

	@Override
	public void updateMovie(Movie m) {
		for (int i = 0; i < listMovie.size(); i++) {
			if (m.getID_Movie() == listMovie.getElementAt(i).getID_Movie()) {
				listMovie.getElementAt(i).setTitle(m.getTitle());
				listMovie.getElementAt(i).setDirector(m.getDirector());
				listMovie.getElementAt(i).setYear(m.getYear());
				listMovie.getElementAt(i).setCategory(m.getCategory());
				listMovie.getElementAt(i).setCover((m.getCover()));
			}
		}

	}

	@Override
	public void deleteMovie(Movie m) {
		for (int i = 0; i < listMovie.size(); i++) {
			if (m.getID_Movie() == listMovie.getElementAt(i).getID_Movie()) {
				listMovie.removeElementAt(i);
			}
		}

	}

	@Override
	public DefaultListModel<Movie> getList() {
		return listMovie;
	}

	public void setListMovie(DefaultListModel<Movie> listMovie) {
		this.listMovie = listMovie;
	}

}
