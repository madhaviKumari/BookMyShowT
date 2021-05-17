package co.move.in.test.BookMyShow.services;

import java.util.List;

import co.move.in.test.BookMyShow.model.Seat;

public interface SeatService {
	
	List<Seat> getSeats(String showid);

}
