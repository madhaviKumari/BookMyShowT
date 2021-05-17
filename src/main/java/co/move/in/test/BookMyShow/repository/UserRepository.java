package co.move.in.test.BookMyShow.repository;


import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;

import co.move.in.test.BookMyShow.model.User;



public interface UserRepository extends MongoRepository<User,String>{
	
	boolean existsByEmail(String mail);
	boolean existsByPhone(String phone);
	boolean existsByUsername(String username);
	Optional<User> findByUsername(String username);

}
