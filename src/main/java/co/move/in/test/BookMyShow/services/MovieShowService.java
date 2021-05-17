package co.move.in.test.BookMyShow.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import co.move.in.test.BookMyShow.model.Language;
import co.move.in.test.BookMyShow.model.Movie;
import co.move.in.test.BookMyShow.model.Show;

public interface MovieShowService {
	
	List<Show> findByLanguageAndTimeRange(Language language, Date start, Date end);
	List<Movie> searchByName(String name);
	public List<Show> getByMovie(String movieId);
	List<Show> getByMovieAndCity(String movieId, String city);
	Page<Movie> topRatedMove(int page, int size);

}
