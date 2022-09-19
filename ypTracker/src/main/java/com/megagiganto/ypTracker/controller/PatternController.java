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

import com.megagiganto.ypTracker.api.service.PatternService;
import com.megagiganto.ypTracker.app.model.Pattern;

@RestController
@RequestMapping(value="/patterns")
public class PatternController {
	
	@Autowired
	PatternService patternService;
	
	//Read all
	@GetMapping(value="/")
	public ResponseEntity<List<Pattern>> findAllPatterns() {
		List<Pattern> patterns = patternService.findAllPatterns();
		if (patterns.isEmpty()) {
			return new ResponseEntity<List<Pattern>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Pattern>>(patterns, HttpStatus.OK);
	}
	
	//Read One
	@GetMapping(value="/{id}")
	public ResponseEntity<?> findPatternById(@PathVariable String id) {
		Pattern pattern = patternService.findPatternById(Integer.valueOf(id));
		if(pattern.getId() == null) {
			return new ResponseEntity<>("Not Found", HttpStatus.OK);
		}
		return new ResponseEntity<>(pattern, HttpStatus.OK);
	}
	
	//Create
	@PostMapping(value="/")
	public ResponseEntity<?> savePattern(@RequestBody Pattern pattern) {
		patternService.savePattern(pattern);
		return new ResponseEntity<>(pattern, HttpStatus.CREATED);
	}
	
	//Update
	@PutMapping(value="/{id}")
	public ResponseEntity<?> updatePatternById(@RequestBody Pattern pattern) {
		patternService.updatePattern(pattern);
		return new ResponseEntity<>(pattern,HttpStatus.CREATED);
	}
	
	//Delete
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> deletePatternById(@PathVariable String id) {
		patternService.deletePatternById(Integer.valueOf(id));
		return new ResponseEntity<>(patternService.findAllPatterns(), HttpStatus.OK);
	}
	

}
