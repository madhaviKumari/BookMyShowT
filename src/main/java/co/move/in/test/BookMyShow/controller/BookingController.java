package co.move.in.test.BookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.move.in.test.BookMyShow.dto.BookingRequest;
import co.move.in.test.BookMyShow.dto.BookingResponse;
import co.move.in.test.BookMyShow.model.User;
import co.move.in.test.BookMyShow.services.BookingService;
import co.move.in.test.BookMyShow.services.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/booking")
public class BookingController extends ParentController {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("made")
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	public ResponseEntity<?> bookTiket(@Validated @RequestBody BookingRequest request,@RequestHeader("Authorization") String token){
		String username = getUserIdByToken(token);
		User user = userService.getUser(username);
		BookingResponse response = bookingService.book(request, user);
		return getResponse(response);
	}

}
