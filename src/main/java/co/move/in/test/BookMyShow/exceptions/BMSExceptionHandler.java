package co.move.in.test.BookMyShow.exceptions;

import java.util.HashMap;


import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import co.move.in.test.BookMyShow.BookMyShowApplication;
import co.move.in.test.BookMyShow.model.ErrorCodes;
import co.move.in.test.BookMyShow.services.ErrorCodeProvider;



@ControllerAdvice
public class BMSExceptionHandler {
	private static final Logger logger = LogManager.getLogger(BookMyShowApplication.class);
	@Autowired
	private ErrorCodeProvider provider;
	@ExceptionHandler(value = BMSException.class)
	public ResponseEntity<?> exception(BMSException exception) {
		if(exception.getErrorCode() == null) {
			return build(exception.getLocalizedMessage(),403);
		}
		else {
			System.out.println("Found code ............... ");
			ErrorCodes apiError = provider.getByCode(exception.getErrorCode());
			return build(apiError.getMsg(),apiError.getCode());
		}
	}
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> exception(MethodArgumentNotValidException exception) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("msg", exception.getLocalizedMessage());
		ResponseEntity<Map<String,String>> res = new ResponseEntity<>(map,HttpStatus.OK);
		logger.info(exception.getLocalizedMessage());
		return res;
	}
	@ExceptionHandler(value = AccessDeniedException.class)
	public ResponseEntity<?> exception(AccessDeniedException exception) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("msg", exception.getLocalizedMessage());
		ResponseEntity<Map<String,String>> res = new ResponseEntity<>(map,HttpStatus.OK);
		logger.info("UnAuthorize access of resources found");
		logger.info(exception.getLocalizedMessage());
		return res;
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception exception) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("msg", "Internal server error");
		ResponseEntity<Map<String,String>> res = new ResponseEntity<>(map,HttpStatus.OK);
		exception.printStackTrace();
		logger.info("System found unhandled exception;");
		logger.info(exception.getLocalizedMessage());
		return res;
	}
	
	private ResponseEntity<?> build(String message, int code){
		Map<String,String> map = new HashMap<String,String>();
		map.put("msg", message);
		map.put("status", ""+code);
		ResponseEntity<Map<String,String>> res = new ResponseEntity<>(map,HttpStatus.OK);
		return res;
	}

}
