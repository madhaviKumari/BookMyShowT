package co.move.in.test.BookMyShow.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import co.move.in.test.BookMyShow.model.Audi;
import co.move.in.test.BookMyShow.model.CinemaHall;
import co.move.in.test.BookMyShow.model.Movie;
import co.move.in.test.BookMyShow.model.Show;
public interface ShowRepository extends MongoRepository<Show,String>{
		List<Show> findByTheater(CinemaHall theater);
		@Query("{'audi':?0 $and:[{'start':{$lt:?2},{'end':{$gt:?1}}]}")
		boolean existsByQuery(Audi audi, Date start, Date end);
		boolean existsByAudiAndStartBetween(Audi audi, Date start, Date end);
		boolean existsByAudiAndEndBetween(Audi audi, Date start, Date end);
		
		/*
		@Query("{'language':?0}")
		List<Show> findByLanguageAndTimeRange(Language language, Date start, Date end);
		
		@Query("{'movie.$language':?0}")
		List<Show> findByLanguageAndTimeRange(String language, Date start, Date end);*/
		
		@Query("{'start' : { $gte: ?1, $lte: ?2 } }")  
		List<Show> findByQuery(String language,Date start, Date end);
		
		List<Show> findByLanguage(String language);
		List<Show> findByLanguageAndStartBetween(String language,Date start, Date end);
		List<Show> findByMovie(Movie movie);
		List<Show> findByMovieAndTheaterIn(Movie movie, List<CinemaHall> hall);
}
