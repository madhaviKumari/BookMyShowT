package co.move.in.test.BookMyShow.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.move.in.test.BookMyShow.dto.BookingRequest;
import co.move.in.test.BookMyShow.dto.BookingResponse;
import co.move.in.test.BookMyShow.exceptions.InvalidSeatSelectionException;
import co.move.in.test.BookMyShow.exceptions.SeatNotAvailableException;
import co.move.in.test.BookMyShow.model.Booking;
import co.move.in.test.BookMyShow.model.CustomerBooking;
import co.move.in.test.BookMyShow.model.Invoice;
import co.move.in.test.BookMyShow.model.User;
import co.move.in.test.BookMyShow.repository.BookingRepository;
import co.move.in.test.BookMyShow.repository.SeatRepository;
import co.move.in.test.BookMyShow.util.BookingBuilder;
import co.move.in.test.BookMyShow.model.Seat;
import co.move.in.test.BookMyShow.model.SeatStatus;

@Service
public class BookingServiceImpl implements BookingService {
	public static final int SEAT_LOCK_TIME_IN_MIN=5;
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private SeatRepository seatRepository;
	
	@Autowired 
	private SystemService seqService;


	private void book(Booking booking,List<Seat> seats) {
		for(Seat seat:seats) {
			seat.setStatus(SeatStatus.BOOKED);
		}
		seatRepository.saveAll(seats);
		bookingRepository.save(booking);
	}

	@Override
	public BookingResponse book(BookingRequest request,User user) {
		BookingBuilder builder = new BookingBuilder();
		builder.setCustomerBokking(request.getCustomerBokking());
		builder.setUser(user);
		List<Seat> seats = new ArrayList<>();
		for(CustomerBooking booking:request.getCustomerBokking()) {
			Seat seat = seatRepository.findById(booking.getSeatId()).orElseThrow(()->new InvalidSeatSelectionException("Invalid seat"));
			if(!seat.getStatus().name().equals(SeatStatus.AVAILABLE.name())) {
				throw new SeatNotAvailableException("Seat is not available");
			}
			seat.setStatus(SeatStatus.NOT_AVAILABLE);
			seats.add(seat);
		}
		lockSeats(seats,SEAT_LOCK_TIME_IN_MIN);
		Booking booking = builder.build();
		booking.setId(seqService.getNextSequence());
		book(booking,seats);
		Invoice invoice = generateInvoice(request,booking);
		BookingResponse response = new BookingResponse();
		response.setStatus(200);
		response.setBookingId(booking.getId());
		response.setInvoice(invoice);
		return response;
		
	}
	
	private Invoice generateInvoice(BookingRequest request,Booking booking) {
		System.out.println("Invoice generated");
		Invoice invoice = new Invoice();
		invoice.setId(seqService.getNextSequence());
		invoice.setBooking(booking);
		invoice.setGeneratedDate(new Date());
		invoice.setGstnNumber(request.getGstnNumber());
		invoice.setPaymentMethod(request.getPaymentMethod());
		invoice.setTotalPaidAmount(request.getTotalPaidAmount());
		return invoice;
	}
	private void lockSeats(List<Seat> seats,int min) {
		seatRepository.saveAll(seats);
		task(seats,min);
	}
	private synchronized void task(List<Seat> seats , int min) {
		Executors.newScheduledThreadPool(1).schedule(() -> {
			List<Seat> updates = new ArrayList<>();
			for(Seat seat:seats) {
				Seat updated = seatRepository.findById(seat.getId()).orElseThrow(()->new InvalidSeatSelectionException("Invalid seat"));
				if(updated.getStatus().name().equals(SeatStatus.NOT_AVAILABLE.name())) {
					updated.setStatus(SeatStatus.AVAILABLE);
					updates.add(seat);
				}
			}
			seatRepository.saveAll(updates);
		}, min, TimeUnit.MINUTES);
	}
	
	

}
