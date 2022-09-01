package com.megagiganto.ypTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.megagiganto.ypTracker.api.model.Pattern;
import com.megagiganto.ypTracker.api.service.PatternService;
import com.megagiganto.ypTracker.app.model.PatternImpl;

@RestController
@RequestMapping(value="/patterns")
public class PatternController {
	
	@Autowired
	PatternService patternService;
	
	//Read all
	@GetMapping(value="/")
	public ResponseEntity<List<Pattern>> fetchAllPatterns() {
		List<Pattern> patterns = patternService.findAllPatterns();
		if (patterns.isEmpty()) {
			return new ResponseEntity<List<Pattern>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Pattern>>(patterns, HttpStatus.OK);
	}
	
	//Read One
	@GetMapping(value="/{id}")
	public ResponseEntity<?> findPattern(@PathVariable String id) {
		Pattern pattern = patternService.findPattern(Long.valueOf(id));
		if(pattern.getId() == null) {
			return new ResponseEntity<>("Not Found", HttpStatus.OK);
		}
		return new ResponseEntity<>(pattern, HttpStatus.OK);
	}
	
	
	//Create
	@PostMapping(value="/")
	public ResponseEntity<?> createPattern(@RequestBody PatternImpl pattern) {
		Pattern savedPattern = patternService.savePattern(pattern);
		return new ResponseEntity<>((PatternImpl) savedPattern, HttpStatus.CREATED);
	}
	
	//Update
	@PutMapping(value = "/pattern/{id}")
	public ResponseEntity<Pattern> updatePattern(@PathVariable("id") long id, @RequestBody Pattern pattern) {
		Pattern currentPattern = patternService.findPattern(id);
		if (currentPattern == null) {
			return new ResponseEntity<Pattern>(HttpStatus.NOT_FOUND);
		}
		
		currentPattern.setName(pattern.getName());
		currentPattern.setSize(pattern.getSize());
		currentPattern.setColors(pattern.getColors());
		
		patternService.updatePattern(currentPattern);
		return new ResponseEntity<Pattern>(currentPattern, HttpStatus.OK);
	}
	
	//Delete
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> deletePattern(@PathVariable String id) {
		return new ResponseEntity<>(patternService.deletePattern(Long.valueOf(id)), HttpStatus.OK);
	}
	

}
