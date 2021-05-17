package co.move.in.test.BookMyShow.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.move.in.test.BookMyShow.model.SystemSequenceIds;


public interface SequenceRepossitory extends MongoRepository<SystemSequenceIds,String>{

}
