package co.move.in.test.BookMyShow.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document
public class Seat {
	@Id
	private String id;
	private SeatType type;
	private SeatStatus status;
	private Double price;
	private int seatNumber;
	@DBRef
	@JsonIgnore
	private Show show;
	
	public SeatType getType() {
		return type;
	}
	public void setType(SeatType type) {
		this.type = type;
	}
	public SeatStatus getStatus() {
		return status;
	}
	public void setStatus(SeatStatus status) {
		this.status = status;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
}
