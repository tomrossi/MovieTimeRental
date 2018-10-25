package movietime.core.movie;

import javax.swing.JLabel;

public abstract class Movie implements MovieInterface {

	private String type; 
	private long ID_Movie;
	private String title;
	private String director;
	private String year;
	private String category;
	private JLabel cover;
	private String trama;
	private double price;

	public Movie(long ID_Movie, String title, String director, String year, String category, JLabel cover,
			String trama) {
		this.ID_Movie = ID_Movie;
		this.title = title;
		this.director = director;
		this.year = year;
		this.category = category;
		this.cover = cover;
		this.trama = trama;
	}

	@Override
	public long getID_Movie() {
		// TODO Auto-generated method stub
		return ID_Movie;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}

	@Override
	public String getDirector() {
		// TODO Auto-generated method stub
		return director;
	}

	@Override
	public String getYear() {
		// TODO Auto-generated method stub
		return year;
	}

	@Override
	public String getCategory() {
		// TODO Auto-generated method stub
		return category;
	}

	public JLabel getCover() {
		return cover;
	}

	@Override
	public String toString() {
		return title;
	}

	@Override
	public String getTrama() {
		return trama;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setID_Movie(long iD_Movie) {
		ID_Movie = iD_Movie;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCover(JLabel cover) {
		this.cover = cover;
	}

	public void setTrama(String trama) {
		this.trama = trama;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public abstract double getPrice();

}
