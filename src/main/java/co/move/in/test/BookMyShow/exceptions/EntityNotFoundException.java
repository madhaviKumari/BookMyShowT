package co.move.in.test.BookMyShow.exceptions;

public class EntityNotFoundException extends BMSException{

	
	public EntityNotFoundException(String message) {
		super(message);
	}
	public EntityNotFoundException(String message,int errorCode) {
		super(message,errorCode);
	}

	private static final long serialVersionUID = 1L;

}
