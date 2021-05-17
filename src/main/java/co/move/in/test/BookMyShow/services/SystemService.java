package co.move.in.test.BookMyShow.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import co.move.in.test.BookMyShow.model.SystemSequenceIds;
import co.move.in.test.BookMyShow.repository.SequenceRepossitory;



@Service
public class SystemService {
	
	@Autowired
	private SequenceRepossitory repository;
	
	public String getNextSequence() {
		return getNextSequence(SystemSequenceIds.UNIQUE_SYS_GEN);
	}
	
	public String getNextSequence(String key) {
		try {
			SystemSequenceIds ids = repository.findById(key).orElseGet(null);
			
			if(ids == null) {
				System.out.println("Found null values");
				addInitialSequence(key);
				return getNextSequence(key);
			}
			System.out.println("Get new at "+ids.getSeq());
			String nextSequence = new String(""+(ids.getSeq()));
			ids.setSeq(ids.getSeq()+1);
			repository.save(ids);
			return nextSequence;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public void addInitialSequence(String key) {
		if(repository.existsById(key)) {
			return;
		}
		SystemSequenceIds ids = new SystemSequenceIds(SystemSequenceIds.UNIQUE_SYS_GEN,SystemSequenceIds.counter);
		repository.save(ids);
	}

}
