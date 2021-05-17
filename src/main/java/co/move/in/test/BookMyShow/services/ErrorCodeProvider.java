package co.move.in.test.BookMyShow.services;

import co.move.in.test.BookMyShow.exceptions.EntityNotFoundException;
import co.move.in.test.BookMyShow.model.ErrorCodes;

public interface ErrorCodeProvider {
	ErrorCodes getByCode(int code) throws EntityNotFoundException;

}
