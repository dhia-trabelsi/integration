package com.example.demo.controller;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Training;
import com.example.demo.service.TrainingService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/training")
@AllArgsConstructor
public class TrainingController {
	
private final TrainingService trainingService;
	
	
	@PostMapping("/create")
	public Training create(@RequestBody Training training) {
		return trainingService.create(training);
		
	}
	
	
	@GetMapping("/all")
	public List<Training> getTrainings(){
		return trainingService.getTrainings();
	}
	
	@PutMapping("/update/{id}")
	public Training updateTraining(@PathVariable String id,@RequestBody Training training) {
		return trainingService.update(id, training);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteTraining(@PathVariable String id) {
		return trainingService.delete(id);
	}

}
