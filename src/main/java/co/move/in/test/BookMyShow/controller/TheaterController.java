package co.move.in.test.BookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.move.in.test.BookMyShow.services.TheaterService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/theater")
public class TheaterController extends ParentController{
	
	@Autowired
	private TheaterService theaterService;
	
	@GetMapping("get")
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	public ResponseEntity<?> getAllTheater(@RequestParam("page")int pageNumber,@RequestParam("size")int pageSize){
			return super.getListResponse(theaterService.getAllTheater(pageNumber, pageSize), "success");
	}
	
	@GetMapping("get/city")
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	public ResponseEntity<?> getAllTheaterByCities(@RequestParam("city") String city){
			return super.getListResponse(theaterService.getAllTheaterByCity(city), "success");
	}
	@GetMapping("get/name")
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	public ResponseEntity<?> getAllTheaterByName(@RequestParam("name") String name){
			return super.getListResponse(theaterService.searchTheaterByName(name), "success");
	}

}
