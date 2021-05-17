package co.move.in.test.BookMyShow.repository;

import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;

import co.move.in.test.BookMyShow.model.ERole;
import co.move.in.test.BookMyShow.model.Role;



public interface RoleRepository extends MongoRepository<Role,String> {
	Optional<Role> findByName(ERole name);
}
