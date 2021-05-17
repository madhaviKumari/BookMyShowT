package co.move.in.test.BookMyShow.dto;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ListResponse<T> {
	
	private String message;
	private List<T> data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
	public ResponseEntity<?> toResponse(){
		ResponseEntity<ListResponse<T>> res = new ResponseEntity<>(this,HttpStatus.OK);
		return res;	
	}
	

}
