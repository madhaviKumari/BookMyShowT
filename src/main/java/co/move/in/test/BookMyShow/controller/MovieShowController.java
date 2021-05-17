package co.move.in.test.BookMyShow.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.move.in.test.BookMyShow.model.Language;
import co.move.in.test.BookMyShow.model.Movie;
import co.move.in.test.BookMyShow.services.MovieShowService;
import co.move.in.test.BookMyShow.services.SeatService;
import co.move.in.test.BookMyShow.util.DateConverterHelper;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/shows")
public class MovieShowController extends ParentController {
	
	@Autowired
	private MovieShowService service;
	
	
	@Autowired
	private SeatService seatService;
	
	@GetMapping("get")
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	public ResponseEntity<?> getAll(@RequestParam("language")Language language,@RequestParam("start")String start,
			@RequestParam("end")String end){
		Date startDate = DateConverterHelper.fromString(start);
		Date endDate = DateConverterHelper.fromString(end);
		return super.getListResponse(service.findByLanguageAndTimeRange(language, startDate, endDate), "success");
	}
	
	@GetMapping("movie/name")
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	public ResponseEntity<?> getAllMovie(@RequestParam("name")String name){
		return super.getListResponse(service.searchByName(name), "success");	
	}
	
	@GetMapping("movie/search/rating")
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	public ResponseEntity<?> getAllMovie(@RequestParam("page")int page,@RequestParam("size")int size){
		Page<Movie> movies = service.topRatedMove(page, size);
		return super.getListResponse(movies.getContent(), "success");	
	}
	
	@GetMapping("show/movie")
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	public ResponseEntity<?> getAllShow(@RequestParam("movie")String name){
		return super.getListResponse(service.getByMovie(name), "success");	
	}
	
	@GetMapping("show/by")
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	public ResponseEntity<?> getAllShowByMovieAndCity(@RequestParam("movie")String name,@RequestParam("city")String city){
		return super.getListResponse(service.getByMovieAndCity(name,city), "success");	
	}
	@GetMapping("get/seats")
	@PreAuthorize("hasRole('ROLE_CLIENT') || hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> getseats(@RequestParam("show")String showId){
		return super.getListResponse(seatService.getSeats(showId), "success");	
	}

}
