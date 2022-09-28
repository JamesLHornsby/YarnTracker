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

import com.megagiganto.ypTrackerSpringBoot.app.service.YarnService;
import com.megagiganto.ypTrackerSpringBoot.app.model.Yarn;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class YarnController {

	@Autowired
	YarnService yarnService;
	
	@GetMapping("/yarns")
	public ResponseEntity<List<Yarn>> findAllYarn(){
		return new ResponseEntity<>(yarnService.findAllYarn(), HttpStatus.OK);
	}
	
	@GetMapping(value="/yarns/{id}")
	public ResponseEntity<Yarn> findYarnById(@PathVariable String id) {
		Yarn yarn = yarnService.findYarnById(Integer.valueOf(id));
		return new ResponseEntity<>(yarn, HttpStatus.OK);
	}
	
	@PostMapping(value="/yarns")
	public ResponseEntity<?> saveYarn(@RequestBody Yarn yarn) {
		Yarn savedYarn = yarnService.saveYarn(yarn);
		return new ResponseEntity<>((Yarn) savedYarn, HttpStatus.OK);
	}
	
	@PutMapping(value="/yarns/{id}")
	public ResponseEntity<?> updateYarn(@RequestBody Yarn yarn) {
		Yarn updatedYarn = yarnService.updateYarn(yarn);
		return new ResponseEntity<>(updatedYarn, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value="/yarns/{id}")
	public ResponseEntity<?> deleteYarnById(@PathVariable String id) {
		yarnService.deleteYarnById(Integer.valueOf(id));
		return new ResponseEntity<>(yarnService.findAllYarn(), HttpStatus.OK);
	}
	
}
