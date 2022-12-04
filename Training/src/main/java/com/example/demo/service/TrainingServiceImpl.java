package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.model.Training;
import com.example.demo.repository.TrainingRepository;
import com.google.common.net.HttpHeaders;
import com.google.common.net.MediaType;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TrainingServiceImpl implements TrainingService {
	

private final TrainingRepository trainingRepository;
	
	WebClient webClient;
	
	/*
	 * @PostConstruct public void init() { webClient = WebClient.builder()
	 * .baseUrl("http://localhost:8080/training")
	 * .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
	 * .build(); }
	 */
	
	
	
	@Override
	public Training create(Training training) {
		
		
		return trainingRepository.save(training);
		
	}

	@Override
	public List<Training> getTrainings() {
		
		return trainingRepository.findAll();
	}

	@Override
	public Training update(String id, Training training) {
		return trainingRepository.findById(id)
				.map(t -> {
					t.setName(t.getName());
					t.setDate(t.getDate());
					return trainingRepository.save(t);
				}).orElseThrow(() -> new RuntimeException("training not find"));
	}

	@Override
	public String delete(String id) {
		trainingRepository.deleteById(id);
		return "training deleted";
	}

}
