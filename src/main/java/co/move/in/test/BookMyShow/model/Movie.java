package co.move.in.test.BookMyShow.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Movie {
		@Indexed
		private String movieName;
		@Id
		private String movieId;
		
		private int durationInMin;
		private Language language;
		@DBRef
		private Genre genre;
		private String releaseDate;
		private int searchCount=0;
		private int bookedCount=0;
		private String thumbnail;
		public String getMovieName() {
			return movieName;
		}
		public void setMovieName(String movieName) {
			this.movieName = movieName;
		}
		public String getMovieId() {
			return movieId;
		}
		public void setMovieId(String movieId) {
			this.movieId = movieId;
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
		public Genre getGenre() {
			return genre;
		}
		public void setGenre(Genre genre) {
			this.genre = genre;
		}
		public String getreleaseDate() {
			return releaseDate;
		}
		public void setreleaseDate(String releaseDate) {
			this.releaseDate = releaseDate;
		}
		public int getSearchCount() {
			return searchCount;
		}
		public void setSearchCount(int searchCount) {
			this.searchCount = searchCount;
		}
		public int getBookedCount() {
			return bookedCount;
		}
		public void setBookedCount(int bookedCount) {
			this.bookedCount = bookedCount;
		}
		public String getThumbnail() {
			return thumbnail;
		}
		public void setThumbnail(String thumbnail) {
			this.thumbnail = thumbnail;
		}
}
