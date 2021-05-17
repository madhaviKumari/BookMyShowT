package co.move.in.test.BookMyShow.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Booking {
	
	@Id
	private String id;
	@DBRef
	@JsonIgnore
	private User user;
	List<Seat> seats = new ArrayList<>();
	List<CustomerBooking> customerBokking;
	Date bookingDate;
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	
}
