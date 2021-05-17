package co.move.in.test.BookMyShow.exceptions;

public class InvalidSeatSelectionException extends BMSException {

	public InvalidSeatSelectionException(String message) {
		super(message);
		errorCode = 502;
	}

	private static final long serialVersionUID = 1L;

}
