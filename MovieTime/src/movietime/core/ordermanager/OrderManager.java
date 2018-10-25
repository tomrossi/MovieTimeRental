package movietime.core.ordermanager;

import movietime.core.movie.Movie;

public interface OrderManager {

	void add(Movie movie); 

	void remove(Movie movie) throws Exception; 

	double getPriceListMovie(); 
								

}
