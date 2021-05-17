package co.move.in.test.BookMyShow.repository;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import co.move.in.test.BookMyShow.model.CinemaHall;
public interface CinemaHallRepository extends MongoRepository<CinemaHall, String>{
	
	boolean existsByName(String name);
	@Query("{'address.city':?0}")
	List<CinemaHall> findTheaterInCity(String city);
	@Query("{'address.city':?0}")
	List<CinemaHall> findTheaterInCity(String city,Pageable pageable);
	List<CinemaHall> findByName(String name, Pageable pageable);
	
	//TODO: Ignore case 
	List<CinemaHall> findByNameRegex(String name);
	@Query("{'address.city':?1}")
	List<CinemaHall> findByQueryAndNameRegex(String city,String name);

}
