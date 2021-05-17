package co.move.in.test.BookMyShow.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RestController;

import co.move.in.test.BookMyShow.dto.ErrorResponse;
import co.move.in.test.BookMyShow.dto.ListResponse;
import co.move.in.test.BookMyShow.dto.SuccessResponse;
import co.move.in.test.BookMyShow.exceptions.BMSException;
import co.move.in.test.BookMyShow.security.jwt.JwtUtils;
import co.move.in.test.BookMyShow.util.SystemCodes;

@RestController
public class ParentController {
	
	  @Autowired	
	  private JwtUtils jwtUtils;
	
	public ResponseEntity<?> getResponse(String message){
		SuccessResponse error = SystemCodes.buildSuccessResponse(message);
		ResponseEntity<SuccessResponse> res = new ResponseEntity<>(error,HttpStatus.OK);
		return res;
	}
	
	public ResponseEntity<?> getResponse(Exception e) {
		e.printStackTrace();
		ErrorResponse error = SystemCodes.buildServerErrorResponse(e.getLocalizedMessage());
		ResponseEntity<ErrorResponse> res = new ResponseEntity<>(error,HttpStatus.OK);
		return res;	
	}
	
	public ResponseEntity<?> getResponse(BMSException e){
		ErrorResponse error = SystemCodes.buildErrorResponse(e.getLocalizedMessage());
		ResponseEntity<ErrorResponse> res = new ResponseEntity<>(error,HttpStatus.OK);
		return res;	
	}
	public <T> ResponseEntity<?> getResponse(T response){
		ResponseEntity<T> res=new ResponseEntity<>(response,HttpStatus.OK);
		return res;
	}
	protected final String getUserIdByToken(@NonNull String auth)throws BMSException {
		try {
			String token = auth.substring(7, auth.length());
			String username = jwtUtils.getUserNameFromJwtToken(token);
			return username;
		}catch(Exception e) {
			e.printStackTrace();
			throw new BMSException("Invalid authorization token");
		}
		
	}
	
	public <T> ResponseEntity<?> getListResponse(List<T> list,@NonNull String message){
		ListResponse<T> r = new ListResponse<>();
		r.setData(list);
		r.setMessage(message);
		ResponseEntity<ListResponse<T>> res = new ResponseEntity<> (r,HttpStatus.OK);
		return res;
	}
	

}
