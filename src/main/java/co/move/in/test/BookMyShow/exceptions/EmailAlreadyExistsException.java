package co.move.in.test.BookMyShow.exceptions;



public class EmailAlreadyExistsException extends BMSException {

	
	public EmailAlreadyExistsException(String message) {
		super(message);
	}

	public EmailAlreadyExistsException(String message,int errorCode) {
		super(message,errorCode);
	}
	
	private static final long serialVersionUID = 1L;

}
