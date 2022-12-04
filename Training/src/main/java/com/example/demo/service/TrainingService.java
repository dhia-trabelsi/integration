package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.Training;


@Service
public interface TrainingService {

	
Training create(Training training);
	
	List<Training> getTrainings();
	
	Training update(String id,Training training);
	
	String delete(String id);
	
}
