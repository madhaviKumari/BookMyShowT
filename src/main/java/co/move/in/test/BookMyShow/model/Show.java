package co.move.in.test.BookMyShow.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Show {
	@Id
	private String id;
	@DBRef
	private Audi audi;
	@DBRef
	private CinemaHall theater;
	@DBRef
	private Movie movie;
	private Date start;
	private Date end;
	@Indexed
	private String language;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Audi getAudi() {
		return audi;
	}
	public void setAudi(Audi audi) {
		this.audi = audi;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public CinemaHall getTheater() {
		return theater;
	}
	public void setTheater(CinemaHall theater) {
		this.theater = theater;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
}
