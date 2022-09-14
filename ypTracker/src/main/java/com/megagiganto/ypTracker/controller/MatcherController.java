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

import com.megagiganto.ypTracker.api.model.Yarn;
import com.megagiganto.ypTracker.api.service.YarnService;
import com.megagiganto.ypTracker.app.model.YarnImpl;

@RestController
@RequestMapping(value="/yarns")
public class MatcherController {
	
	@Autowired
	YarnService yarnService;
	
	//Read all
	@GetMapping(value="/")
	public ResponseEntity<List<Yarn>> fetchAllYarn() {
		List<Yarn> yarns = yarnService.findAllYarn();
		if (yarns.isEmpty()) {
			return new ResponseEntity<List<Yarn>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Yarn>>(yarns, HttpStatus.OK);
	}
	
	//Read One
	@GetMapping(value="/{id}")
	public ResponseEntity<?> findYarn(@PathVariable String id) {
		Yarn yarn = yarnService.findYarn(Integer.valueOf(id));
		if(yarn.getId() == null) {
			return new ResponseEntity<>("Not Found", HttpStatus.OK);
		}
		return new ResponseEntity<>(yarn, HttpStatus.OK);
	}
	
	
	//Create
	@PostMapping(value="/")
	public ResponseEntity<?> createYarn(@RequestBody YarnImpl yarn) {
		Yarn savedYarn = yarnService.saveYarn(yarn);
		return new ResponseEntity<>((YarnImpl) savedYarn, HttpStatus.CREATED);
	}
	
	
	//Delete
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> deleteYarn(@PathVariable String id) {
		yarnService.deleteYarn(Integer.valueOf(id));
		return new ResponseEntity<>(yarnService.findAllYarn(), HttpStatus.OK);
	}
	

}
