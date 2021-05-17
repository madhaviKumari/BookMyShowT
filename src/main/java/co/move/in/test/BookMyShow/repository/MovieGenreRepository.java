package co.move.in.test.BookMyShow.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import co.move.in.test.BookMyShow.model.Genre;
public interface MovieGenreRepository extends MongoRepository<Genre,String>{
		boolean existsByCategory(String category);
}
