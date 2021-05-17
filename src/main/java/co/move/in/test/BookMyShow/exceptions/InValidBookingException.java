package co.move.in.test.BookMyShow.exceptions;

public class InValidBookingException extends BMSException {


	public InValidBookingException(String message) {
		super(message);
		errorCode = 501;
	}

	private static final long serialVersionUID = 1L;

}
