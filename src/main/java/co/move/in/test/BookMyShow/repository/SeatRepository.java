package co.move.in.test.BookMyShow.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.move.in.test.BookMyShow.model.Seat;
import co.move.in.test.BookMyShow.model.Show;

public interface SeatRepository extends MongoRepository<Seat,String> {
		List<Seat> findByShow(Show show);
		boolean existsByShowAndSeatNumber(Show show, int seatNumber);
}
