package co.move.in.test.BookMyShow.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.move.in.test.BookMyShow.dto.SeatRow;
import co.move.in.test.BookMyShow.exceptions.DuplicateEntityException;
import co.move.in.test.BookMyShow.exceptions.EntityNotFoundException;
import co.move.in.test.BookMyShow.model.Audi;
import co.move.in.test.BookMyShow.model.CinemaHall;
import co.move.in.test.BookMyShow.model.Genre;
import co.move.in.test.BookMyShow.model.Movie;
import co.move.in.test.BookMyShow.model.Seat;
import co.move.in.test.BookMyShow.model.Show;
import co.move.in.test.BookMyShow.repository.AudiRepository;
import co.move.in.test.BookMyShow.repository.CinemaHallRepository;
import co.move.in.test.BookMyShow.repository.MovieGenreRepository;
import co.move.in.test.BookMyShow.repository.MovieRepository;
import co.move.in.test.BookMyShow.repository.SeatRepository;
import co.move.in.test.BookMyShow.repository.ShowRepository;

@Service
public class MasterService implements MasterCreator {
	
	@Autowired
	private CinemaHallRepository repository;
	
	@Autowired
	private AudiRepository audiRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private MovieGenreRepository genreRepository;
	
	@Autowired
	private ShowRepository showRepository;
	
	@Autowired
	private SeatRepository seatRepository;

	@Override
	public void addTheater(CinemaHall hall) {
		if(repository.existsByName(hall.getName())) {
			throw new DuplicateEntityException("Already a cinema hall with same name exists ");
		}
		repository.save(hall);
	}

	public List<CinemaHall> getCinemaHall() {
		return repository.findAll();
	}

	@Override
	public void addAudi(Audi audi) {
		if(audiRepository.existsByNameAndCinemaHall(audi.getName(), audi.getCinemaHall())) {
			 throw new DuplicateEntityException("Already an audi with same name exists ");
		}
		audiRepository.save(audi);
		
	}
	
	public CinemaHall getCinemaHall(String id) {
		return repository.findById(id).orElseThrow(()->new EntityNotFoundException("No Theater exists with id "+id));
	}
	
	public List<Audi> getAudiByTheater(CinemaHall hall){
		return audiRepository.findByCinemaHall(hall);
	}

	public Audi getAudi(String id) {
		return audiRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No audi found with this is id"));
	}
	@Override
	public void addMovie(Movie movie) {
		movieRepository.save(movie);
	}
	public List<Movie> getAllMovies(){
		return movieRepository.findAll();
	}
	public Movie getMovie(String id) {
		return movieRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No movie exists with this id"));
	}
	@Override
	public void addMovieGenre(Genre genre) {
		if(genreRepository.existsByCategory(genre.getCategory())) {
			throw new DuplicateEntityException("Already a movie type with same category exists");
		}
		genreRepository.save(genre);
	}

	public List<Genre> getAllGenre(){
		return genreRepository.findAll();
	}
	
	public Genre getMovieGenre(String id) {
		return genreRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No Movie type exists with id "+id));
	}
	
	// TODO: Overlapping condition
	@Override
	public void addShow(Show show) {
		/*if(showRepository.existsByAudiAndStartBetween(show.getAudi(), show.getStart(), show.getEnd())
				|| showRepository.existsByAudiAndEndBetween(show.getAudi(), show.getStart(), show.getEnd())) {
			throw new ShowOverlappedException("Show overlapped with another show on same audi and theater");
		}
		if(showRepository.existsByQuery(show.getAudi(), show.getStart(), show.getEnd())) {
			throw new ShowOverlappedException("Show overlapped with another show on same audi and theater");
		}*/
			
		showRepository.save(show);
	}
	public List<Show> getShowByTheater(CinemaHall hall){
		return showRepository.findByTheater(hall);
	}
	public Show getShowById(String id) {
		return showRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No show exists with id "+id));
	}
	@Override
	public void addSeat(Seat seat) {
		if(seatRepository.existsByShowAndSeatNumber(seat.getShow(), seat.getSeatNumber())) {
			throw new DuplicateEntityException("A seat with seat number "+seat.getSeatNumber()+"  already exists ");
		}
		seatRepository.save(seat);
	}
	public String addSeat(List<SeatRow> seats) {
		if(seats.size()==0) {
			return "No seat to be added";
		}
		List<Seat> added = new ArrayList<>();
		StringBuilder builder = new StringBuilder();
		Show show = getShowById(seats.get(0).getShow());
		for(SeatRow row:seats) {
			try {
				Seat seat = new Seat();
				seat.setPrice(row.getPrice());
				seat.setSeatNumber(row.getNumber());
				seat.setShow(show);
				seat.setStatus(row.getStatus());
				seat.setType(row.getType());
				addSeat(seat);
				added.add(seat);
				builder.append(" , "+seat.getSeatNumber()+" added at show "+seat.getShow().getId());
				//builder.append(System.getProperty("line.separator"));
				System.out.println(""+seat.getSeatNumber()+" added at show "+seat.getShow().getId());
			}catch(Exception e) {
				e.printStackTrace();
				// RollBack
				builder.append("\n Issue:  "+e.getLocalizedMessage());
				seatRepository.deleteAll(added);
				break;
			}
		}
		System.out.println(seatRepository.count()+" count");
		return builder.toString();
		
	}
}
