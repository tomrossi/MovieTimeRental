package movietime.core.finder;

import javax.swing.DefaultListModel;

import movietime.core.movie.Movie;

public class ResearchForDirector extends ResearchMovie {

	public ResearchForDirector() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void research(DefaultListModel<Movie> listmodelMovie, String record) {
		for (int i = 0; i < listmodelMovie.size(); i++) {
			if (listmodelMovie.getElementAt(i).getDirector().contains(record)) {
				super.getTempResearch().addElement(listmodelMovie.getElementAt(i));
				
			}
		}

	}

}
