package com.megagiganto.ypTrackerSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.megagiganto.ypTrackerSpringBoot.app.service.PatternService;
import com.megagiganto.ypTrackerSpringBoot.app.model.Pattern;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PatternController {
	
	@Autowired
	PatternService patternService;
	
	//Read all
	@GetMapping(value="/patterns")
	public ResponseEntity<List<Pattern>> findAllPatterns() {
		return new ResponseEntity<>(patternService.findAllPatterns(), HttpStatus.OK);
	}
	
	//Read One
	@GetMapping(value="/patterns/{id}")
	public ResponseEntity<?> findPatternById(@PathVariable String id) {
		Pattern pattern = patternService.findPatternById(Integer.valueOf(id));
		return new ResponseEntity<>(pattern, HttpStatus.OK);
	}
	
	
	//Create
	@PostMapping(value="/patterns")
	public ResponseEntity<?> savePattern(@RequestBody Pattern pattern) {
		Pattern savedPattern = patternService.savePattern(pattern);
		return new ResponseEntity<>(savedPattern, HttpStatus.CREATED);
	}
	
	//Update
	@PutMapping(value="/patterns/{id}")
	public ResponseEntity<?> updatePattern(@RequestBody Pattern pattern) {
		Pattern updatedPattern = patternService.updatePattern(pattern);
		return new ResponseEntity<>(updatedPattern, HttpStatus.CREATED);
	}
	
	//Delete
	@DeleteMapping(value="/patterns/{id}")
	public ResponseEntity<?> deletePattern(@PathVariable String id) {
		patternService.deletePatternById(Integer.valueOf(id));
		return new ResponseEntity<>(patternService.findAllPatterns(), HttpStatus.OK);
	}
	

}
