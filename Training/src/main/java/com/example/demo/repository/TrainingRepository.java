package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.model.Training;

public interface TrainingRepository extends MongoRepository<Training, String> {

	
	@Query("{name:'?0'}")
    Training findItemByName(String name);
    

    
    public long count();
}
