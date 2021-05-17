package co.move.in.test.BookMyShow.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.move.in.test.BookMyShow.model.Language;
import co.move.in.test.BookMyShow.model.Movie;
public interface MovieRepository extends MongoRepository<Movie, String>{
	
	List<Movie> findByMovieName(String name);
	List<Movie> findByMovieNameRegex(String name);
	List<Movie> findByLanguage(Language language);
	

}
