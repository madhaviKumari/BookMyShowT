package co.move.in.test.BookMyShow.controller;

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

import co.move.in.test.BookMyShow.dto.ErrorCodeRequestDTO;
import co.move.in.test.BookMyShow.exceptions.BMSException;
import co.move.in.test.BookMyShow.model.ErrorCodes;
import co.move.in.test.BookMyShow.services.ErrorCodeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/codes")
public class ErrorCodeController extends ParentController {

	@Autowired
	private ErrorCodeService service;
	
	@GetMapping("get")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> getAllErrorCodes(){
		List<ErrorCodes> codes = service.getAllErrorCodes();
		return super.getListResponse(codes, "success");
	}
	
	@PostMapping("add")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> addCodes(@Validated @RequestBody ErrorCodeRequestDTO dto){
		ErrorCodes codes = new ErrorCodes();
		codes.setCode(dto.getCode());
		codes.setMsg(dto.getMsg());
		service.addCode(codes);
		return getResponse("Error code and message added successfully");
		
	}
	@GetMapping("tes")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> tests(@RequestParam("q") int q){
		if(q==1) {
			throw new BMSException("Error",203);
		}
		List<ErrorCodes> codes = service.getAllErrorCodes();
		return super.getListResponse(codes, "success");
	}
	
	
	
}
