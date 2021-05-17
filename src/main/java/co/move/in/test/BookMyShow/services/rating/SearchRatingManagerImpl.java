package co.move.in.test.BookMyShow.services.rating;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.move.in.test.BookMyShow.model.Movie;
import co.move.in.test.BookMyShow.repository.MovieRepository;

@Service
public class SearchRatingManagerImpl implements SearchRatingManager{

	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public void onSearch(Movie movie) {
		movie.setSearchCount(movie.getSearchCount()+1);
		movieRepository.save(movie);
	}

	@Override
	public void onSearch(List<Movie> movies) {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				for(Movie movie:movies) {
					movie.setSearchCount(movie.getSearchCount()+1);
				}	
				movieRepository.saveAll(movies);
			}
			
		});
		thread.start();
		
	}

}
