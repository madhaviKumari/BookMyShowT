package co.move.in.test.BookMyShow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.move.in.test.BookMyShow.model.Seat;
import co.move.in.test.BookMyShow.model.Show;
import co.move.in.test.BookMyShow.repository.SeatRepository;
import co.move.in.test.BookMyShow.repository.ShowRepository;
import co.move.in.test.BookMyShow.exceptions.*;
@Service
public class SeatServiceImpl implements SeatService{
	
	@Autowired
	private ShowRepository showRepository;
	
	@Autowired
	private SeatRepository seatRepository;
	
	
	@Override
	public List<Seat> getSeats(String showid) {
		Show show = showRepository.findById(showid).orElseThrow(()->new EntityNotFoundException("No show exists with showId"));
		return seatRepository.findByShow(show);
	}

}
