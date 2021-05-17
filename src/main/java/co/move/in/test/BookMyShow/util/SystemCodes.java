package co.move.in.test.BookMyShow.util;

import java.util.ArrayList;

import java.util.List;

import co.move.in.test.BookMyShow.dto.ErrorResponse;
import co.move.in.test.BookMyShow.dto.SuccessResponse;
import co.move.in.test.BookMyShow.model.ERole;
import co.move.in.test.BookMyShow.model.Role;

public class SystemCodes {
	
	public static final int REQUEST_FAIL = 403;
	public static final int REQUEST_SUCCESS = 200;
	public static final int REQUEST_SERVEER_ERROR = 500;
	public static final String sysGen = "annonemous";
	public static final String sysGenDec = "ano desc";
	
	public static final ErrorResponse buildServerErrorResponse(String message) {
		return new ErrorResponse(REQUEST_SERVEER_ERROR,message);
	}
	
	public static final ErrorResponse buildErrorResponse(String message) {
		return new ErrorResponse(REQUEST_FAIL,message);
	}
	
	public static final SuccessResponse buildSuccessResponse(String message) {
		return new SuccessResponse(REQUEST_SUCCESS,message);
	}
	
	public static List<Role> getInitialSystemRoles(){
		List<Role> roles = new ArrayList<>();
		int count = 1;
		for(ERole r: ERole.values()) {
			roles.add(new Role(""+(count++),r,"system gen "+r.toString()));
		}
		return roles;
	}
	
	

}
