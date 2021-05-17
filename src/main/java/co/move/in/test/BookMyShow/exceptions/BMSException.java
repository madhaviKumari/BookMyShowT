package co.move.in.test.BookMyShow.exceptions;

public class BMSException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	Integer errorCode;
	
	public BMSException(String message) {
		super(message);
	}
	public BMSException(String message,int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	

}
