package co.move.in.test.BookMyShow.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import co.move.in.test.BookMyShow.model.Language;

public class MovieDTO {
	
	@NotNull(message = "Name must ot be null")
	@NotEmpty(message = "Name  must not be empty")
	private String movieName;

	
	private int durationInMin;
	

	private Language language;
	
	@NotNull(message = "Genre must ot be null")
	@NotEmpty(message = "Genre must not be empty")
	private String genre;
	@NotNull(message = "releaseDate must ot be null")
	@NotEmpty(message = "releaseDate  must not be empty")
	private String releaseDate;
	@NotNull(message = "thumbnail must ot be null")
	@NotEmpty(message = "thumbnail  must not be empty")
	private String thumbnail;
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getDurationInMin() {
		return durationInMin;
	}
	public void setDurationInMin(int durationInMin) {
		this.durationInMin = durationInMin;
	}
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	

}
