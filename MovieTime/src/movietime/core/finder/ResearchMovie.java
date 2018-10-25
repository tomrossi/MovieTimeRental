package movietime.core.finder;

import javax.swing.DefaultListModel;

import movietime.core.movie.Movie;

public abstract class ResearchMovie {

	private DefaultListModel<Movie> tempResearch;
	private String record;

	public ResearchMovie() {
		super();
		tempResearch = new DefaultListModel<Movie>();
	}

	public DefaultListModel<Movie> getTempResearch() {
		return tempResearch;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public abstract void research(DefaultListModel<Movie> listmodelMovie, String record);

}
