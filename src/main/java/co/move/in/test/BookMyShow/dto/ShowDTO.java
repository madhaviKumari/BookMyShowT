package co.move.in.test.BookMyShow.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class ShowDTO {
	@NotNull(message = "Audi must ot be null")
	@NotEmpty(message = "Audi must not be empty")
	private String audi;
	@NotNull(message = "Theater must ot be null")
	@NotEmpty(message = "Theater must not be empty")
	private String movie;
	@Valid
	private String start;
	@Valid
	private String end;
	public String getAudi() {
		return audi;
	}
	public void setAudi(String audi) {
		this.audi = audi;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	
	
	
}
