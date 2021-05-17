package co.move.in.test.BookMyShow.exceptions;

public class DuplicateEntityException extends BMSException{


	public DuplicateEntityException(String message) {
		super(message);
	}

	public DuplicateEntityException(String message,int errorCode) {
		super(message,errorCode);
	}
	
	private static final long serialVersionUID = 1L;

}
