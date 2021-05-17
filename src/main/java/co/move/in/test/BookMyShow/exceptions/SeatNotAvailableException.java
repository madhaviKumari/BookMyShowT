package co.move.in.test.BookMyShow.exceptions;


public class SeatNotAvailableException extends BMSException {


	public SeatNotAvailableException(String message) {
		super(message);
		errorCode = 503;
	}

	private static final long serialVersionUID = 1L;

}
