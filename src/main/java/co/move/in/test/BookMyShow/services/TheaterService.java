package co.move.in.test.BookMyShow.services;

import java.util.List;

import co.move.in.test.BookMyShow.model.CinemaHall;

public interface TheaterService {
	
	public List<CinemaHall> getAllTheater(int pageSize, int pageNumber);
	public List<CinemaHall> getAllTheaterByCity(String city);
	public List<CinemaHall> searchTheaterByName(String name);
	public List<CinemaHall> searchTheaterByNameAndCity(String name, String city);

}
