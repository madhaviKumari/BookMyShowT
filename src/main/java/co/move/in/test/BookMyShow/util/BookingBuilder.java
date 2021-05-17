package co.move.in.test.BookMyShow.util;

import java.util.List;


import co.move.in.test.BookMyShow.exceptions.InValidBookingException;
import co.move.in.test.BookMyShow.model.Booking;
import co.move.in.test.BookMyShow.model.CustomerBooking;
import co.move.in.test.BookMyShow.model.User;

public class BookingBuilder {
	private User user;
	List<CustomerBooking> customerBokking;
	private String id;
	public Booking build() {
		if(user == null || customerBokking == null || customerBokking.size()==0 ) {
			throw new InValidBookingException("Invalid booking");
		}
		Booking booking = new Booking();
		booking.setId(id);
		booking.setCustomerBokking(customerBokking);
		booking.setUser(user);
		return booking;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<CustomerBooking> getCustomerBokking() {
		return customerBokking;
	}
	public void setCustomerBokking(List<CustomerBooking> customerBokking) {
		this.customerBokking = customerBokking;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

}
