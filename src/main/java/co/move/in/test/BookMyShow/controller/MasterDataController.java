package co.move.in.test.BookMyShow.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.poiji.bind.Poiji;
import com.poiji.exception.PoijiExcelType;

import co.move.in.test.BookMyShow.dto.AudiDTO;
import co.move.in.test.BookMyShow.dto.MovieDTO;
import co.move.in.test.BookMyShow.dto.SeatRow;
import co.move.in.test.BookMyShow.dto.ShowDTO;
import co.move.in.test.BookMyShow.model.Audi;
import co.move.in.test.BookMyShow.model.CinemaHall;
import co.move.in.test.BookMyShow.model.Genre;
import co.move.in.test.BookMyShow.model.Movie;
import co.move.in.test.BookMyShow.model.Show;
import co.move.in.test.BookMyShow.services.MasterService;
import co.move.in.test.BookMyShow.util.DateConverterHelper;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/master")
public class MasterDataController extends ParentController {
	
	@Autowired
	private MasterService service;
	 
	@PostMapping("add/theater")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> addCinemaHall(@Validated @RequestBody CinemaHall cinemaHall){
		service.addTheater(cinemaHall);
		return getResponse("Theater added successfully");
	}
	
	@GetMapping("get/theater")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> getAllTheater(){
		return super.getListResponse(service.getCinemaHall(), "success");
	}
	
	@PostMapping("add/audi")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> addAudi(@Validated @RequestBody AudiDTO dto){
		CinemaHall hall = service.getCinemaHall(dto.getCinemaHall());
		Audi audi = new Audi();
		audi.setName(dto.getName());
		audi.setTotalSeats(dto.getTotalSeats());
		audi.setCinemaHall(hall);
		service.addAudi(audi);
		return getResponse("Audi added successfully");
	}
	@GetMapping("get/audi")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> getAllAudi(@RequestParam("theater") String theater){
		CinemaHall hall = service.getCinemaHall(theater);
		return super.getListResponse(service.getAudiByTheater(hall), "success");
	}
	@PostMapping("add/genre")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> addGenre(@Validated @RequestBody Genre genre){
		service.addMovieGenre(genre);
		return getResponse("Movie type added successfully");
	}
	@GetMapping("get/genre")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> getAllGenre(){
		return super.getListResponse(service.getAllGenre(), "success");
	}

	@PostMapping("add/movie")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> addMovie(@Validated @RequestBody MovieDTO dto){
		Genre genre = service.getMovieGenre(dto.getGenre());
		Movie movie = new Movie();
		movie.setDurationInMin(dto.getDurationInMin());
		movie.setGenre(genre);
		movie.setMovieName(dto.getMovieName());
		movie.setreleaseDate(dto.getReleaseDate());
		movie.setThumbnail(dto.getThumbnail());
		movie.setLanguage(dto.getLanguage());
		service.addMovie(movie);
		return getResponse("Movie added successfully");
	}
	@GetMapping("get/movie")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> getAllMovie(){
		return super.getListResponse(service.getAllMovies(), "success");
	}
	@PostMapping("add/show")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> addShow(@Validated @RequestBody ShowDTO dto){
		Audi audi = service.getAudi(dto.getAudi());
		CinemaHall hall = audi.getCinemaHall();
		Movie movie = service.getMovie(dto.getMovie());
		Show show = new Show();
		show.setAudi(audi);
		show.setEnd(DateConverterHelper.fromString(dto.getEnd()));
		show.setMovie(movie);
		show.setStart(DateConverterHelper.fromString(dto.getStart()));
		show.setTheater(hall);
		show.setLanguage(movie.getLanguage().name());//Added direct property for indexing on search (Optimization step)
		service.addShow(show);
		return getResponse("Show added successfully");
	}
	@GetMapping("get/show")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> getAllShows(@RequestParam("theater") String theater){
		CinemaHall hall = service.getCinemaHall(theater);
		return super.getListResponse(service.getShowByTheater(hall), "success");
	}
	
	@PostMapping("add/seats")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> uploadFile(@RequestParam(value = "file") MultipartFile file) throws IOException
    {
		
		List<SeatRow> seats = Poiji.fromExcel(file.getInputStream(),PoijiExcelType.XLSX, SeatRow.class);
		String str = service.addSeat(seats);
		return getResponse(str);
        
    }
	
	
}
