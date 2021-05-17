package co.move.in.test.BookMyShow.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import co.move.in.test.BookMyShow.exceptions.MovieNotFoundWithID;
import co.move.in.test.BookMyShow.model.CinemaHall;
import co.move.in.test.BookMyShow.model.Language;
import co.move.in.test.BookMyShow.model.Movie;
import co.move.in.test.BookMyShow.model.Show;
import co.move.in.test.BookMyShow.repository.CinemaHallRepository;
import co.move.in.test.BookMyShow.repository.MovieRepository;
import co.move.in.test.BookMyShow.repository.ShowRepository;
import co.move.in.test.BookMyShow.services.rating.SearchRatingManager;
@Service
public class MovieShowServiceImpl implements MovieShowService {
	
	@Autowired
	private ShowRepository repository;
	
	
	@Autowired
	private MovieRepository movieRepository;
	
	
	@Autowired
	private SearchRatingManager searchRatingService;
	
	@Autowired
	private CinemaHallRepository theaterRepository;

	@Override
	public List<Show> findByLanguageAndTimeRange(Language language, Date start, Date end) {
		System.out.println("Lang "+language.name());
		return repository.findByLanguageAndStartBetween(language.name(), start, end);
	}

	@Override
	public List<Movie> searchByName(String name) {
		List<Movie> movies = movieRepository.findByMovieNameRegex(name);
		// Runs in different thread
		searchRatingService.onSearch(movies);
		return movies;
	}
	@Override
	public List<Show> getByMovie(String movieId){
			Movie movie = movieRepository.findById(movieId).orElseThrow(()->  new MovieNotFoundWithID("No Movie found with Id"));
			return repository.findByMovie(movie);
	}
	@Override
	public List<Show> getByMovieAndCity(String movieId,String city){
			Movie movie = movieRepository.findById(movieId).orElseThrow(()->  new MovieNotFoundWithID("No Movie found with Id"));
			List<CinemaHall> theaters = theaterRepository.findTheaterInCity(city);
			//return repository.findByMovie(movie);
			return repository.findByMovieAndTheaterIn(movie, theaters);
	}

	@Override
	public Page<Movie> topRatedMove(int page, int size) {

		return movieRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC,"searchCount")));

	}

	

}
