package co.move.in.test.BookMyShow.exceptions;

public class ShowOverlappedException extends BMSException{

	public ShowOverlappedException(String message) {
		super(message);
		super.errorCode = 407;// Constant shows overlapped exception
	}
	private static final long serialVersionUID = 1L;

}
