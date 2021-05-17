package co.move.in.test.BookMyShow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import co.move.in.test.BookMyShow.model.CinemaHall;
import co.move.in.test.BookMyShow.repository.CinemaHallRepository;

@Service
public class TheaterServiceImpl implements TheaterService{
	
	@Autowired
	private CinemaHallRepository repository;

	@Override
	public List<CinemaHall> getAllTheater(int pageSize, int pageNumber) {
		return repository.findAll(PageRequest.of(pageSize, pageNumber)).getContent();
	}

	@Override
	public List<CinemaHall> getAllTheaterByCity(String city) {
		//System.out.println("Searching for "+city);
		return repository.findTheaterInCity(city);
	}

	@Override
	public List<CinemaHall> searchTheaterByName(String name) {
		return repository.findByNameRegex(name);
	}

	@Override
	public List<CinemaHall> searchTheaterByNameAndCity(String name, String city) {
		return repository.findByQueryAndNameRegex(name, city);
		//return repository.findByNameRegex(name);
	}
	

	

}
