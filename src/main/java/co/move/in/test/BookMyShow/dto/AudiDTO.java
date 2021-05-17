package co.move.in.test.BookMyShow.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



public class AudiDTO {
	
	private String cinemaHall;
	@NotNull(message = "Name must ot be null")
	@NotEmpty(message = "Name  must not be empty")
	private String name;
	private int totalSeats;
	public String getCinemaHall() {
		return cinemaHall;
	}
	public void setCinemaHall(String cinemaHall) {
		this.cinemaHall = cinemaHall;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	
	
	
	

}
