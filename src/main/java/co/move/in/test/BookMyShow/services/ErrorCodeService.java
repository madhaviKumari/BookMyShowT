package co.move.in.test.BookMyShow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.move.in.test.BookMyShow.exceptions.DuplicateEntityException;
import co.move.in.test.BookMyShow.exceptions.EntityNotFoundException;
import co.move.in.test.BookMyShow.model.ErrorCodes;
import co.move.in.test.BookMyShow.repository.ErrorCodeRepository;

@Service
public class ErrorCodeService implements ErrorCodeProvider{
	
	@Autowired
	private ErrorCodeRepository repository;
	
	@Autowired 
	private SystemService seqService;
	
	public void addCode(ErrorCodes code) {
		
		if(repository.existsByCode(code.getCode())) {
			throw new DuplicateEntityException("An Error message with this error code already exists.");
		}
		code.setId(seqService.getNextSequence());
		repository.save(code);
	}
	
	public List<ErrorCodes> getAllErrorCodes(){
		return repository.findAll();
	}

	@Override
	public ErrorCodes getByCode(int code) throws EntityNotFoundException {
		return repository.findByCode(code).orElseThrow(()-> new EntityNotFoundException("No Error message found with code "+code));
	}
	

}
