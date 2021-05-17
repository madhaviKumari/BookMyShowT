package co.move.in.test.BookMyShow.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.move.in.test.BookMyShow.model.Booking;

public interface BookingRepository extends MongoRepository<Booking,String>{

}
