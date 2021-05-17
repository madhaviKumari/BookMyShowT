package co.move.in.test.BookMyShow.services.rating;

import java.util.List;

import co.move.in.test.BookMyShow.model.Movie;

public interface SearchRatingManager {
	
	void onSearch(Movie movie);
	void onSearch(List<Movie> movie);

}
