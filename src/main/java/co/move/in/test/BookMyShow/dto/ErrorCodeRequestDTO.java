package co.move.in.test.BookMyShow.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ErrorCodeRequestDTO {
	
	private int code;
	@NotNull(message = "Message mst ot be null")
	@NotEmpty(message = "Message must not be empty")
	private String msg;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
