package co.move.in.test.BookMyShow.services;

import co.move.in.test.BookMyShow.exceptions.DuplicateEntityException;
import co.move.in.test.BookMyShow.exceptions.UndefinedUserException;
import co.move.in.test.BookMyShow.model.User;

public interface UserService {
		public void addUser(User user) throws DuplicateEntityException;
		public User getUser(String username) throws UndefinedUserException;
}
