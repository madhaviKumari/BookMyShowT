package co.move.in.test.BookMyShow.services;


import co.move.in.test.BookMyShow.model.Audi;
import co.move.in.test.BookMyShow.model.CinemaHall;
import co.move.in.test.BookMyShow.model.Genre;
import co.move.in.test.BookMyShow.model.Movie;
import co.move.in.test.BookMyShow.model.Seat;
import co.move.in.test.BookMyShow.model.Show;

public interface MasterCreator {

	public void addTheater(CinemaHall hall);
	public void addAudi(Audi audi);
	public void addMovie(Movie movie);
	public void addMovieGenre(Genre genre);
	public void addShow(Show show);
	public void addSeat(Seat seat);
}
