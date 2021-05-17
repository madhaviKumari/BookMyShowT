package co.move.in.test.BookMyShow.exceptions;

public class MovieNotFoundWithID extends BMSException {


	public MovieNotFoundWithID(String message) {
		super(message);
		errorCode = 209;
	}

	private static final long serialVersionUID = 1L;

}
