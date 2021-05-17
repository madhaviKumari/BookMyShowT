package co.move.in.test.BookMyShow.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.move.in.test.BookMyShow.model.Audi;
import co.move.in.test.BookMyShow.model.CinemaHall;

public interface AudiRepository extends MongoRepository<Audi,String>{
	
	boolean existsByNameAndCinemaHall(String name,CinemaHall hall);
	List<Audi> findByCinemaHall(CinemaHall hall);

}
