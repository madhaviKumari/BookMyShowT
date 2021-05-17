package co.move.in.test.BookMyShow.exceptions;

public class UndefinedUserException extends EntityNotFoundException{

	
	public UndefinedUserException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;

}
