package co.move.in.test.BookMyShow.services;

import co.move.in.test.BookMyShow.dto.BookingRequest;
import co.move.in.test.BookMyShow.dto.BookingResponse;
import co.move.in.test.BookMyShow.model.User;

public interface BookingService {
	
	public BookingResponse book(BookingRequest request,User user);

}
