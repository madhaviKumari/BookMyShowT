package co.move.in.test.BookMyShow.repository;

import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;

import co.move.in.test.BookMyShow.model.ErrorCodes;

public interface ErrorCodeRepository extends MongoRepository<ErrorCodes,String> {
	
	Optional<ErrorCodes> findByCode(int code);
	boolean existsByCode(int code);

}
