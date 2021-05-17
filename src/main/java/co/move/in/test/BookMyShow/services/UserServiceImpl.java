package co.move.in.test.BookMyShow.services;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import co.move.in.test.BookMyShow.exceptions.DuplicateEntityException;
import co.move.in.test.BookMyShow.exceptions.EmailAlreadyExistsException;
import co.move.in.test.BookMyShow.exceptions.PhoneAlreadyExistsException;
import co.move.in.test.BookMyShow.exceptions.UndefinedUserException;
import co.move.in.test.BookMyShow.model.User;
import co.move.in.test.BookMyShow.repository.UserRepository;




@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired 
	private SystemService seqService;

	@Override
	public void addUser(User user) throws DuplicateEntityException {
		
		if(repository.existsByEmail(user.getEmail())) {
			throw new EmailAlreadyExistsException("Email "+user.getEmail()+" already exists.");
		}
		if(repository.existsByPhone(user.getPhone())) {
			throw new PhoneAlreadyExistsException("Phone "+user.getPhone()+" already exists.");
		}
		if(repository.existsByUsername(user.getUsername())) {
			throw new DuplicateEntityException("Username already exists");
		}
		user.setId(seqService.getNextSequence());
		System.out.println("Adding user : "+user);
		repository.save(user);
		
	}

	@Override
	public User getUser(String username) throws UndefinedUserException {
		return repository.findByUsername(username).orElseThrow(()->new UndefinedUserException("No user exits with username "+username));
	}

}
