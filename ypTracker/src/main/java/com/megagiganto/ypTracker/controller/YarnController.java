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

import com.megagiganto.ypTracker.api.service.YarnService;
import com.megagiganto.ypTracker.app.model.Yarn;

@RestController
@RequestMapping(value="/yarns")
public class YarnController {
	
	@Autowired
	YarnService yarnService;
	
	//Read all
	@GetMapping(value="/")
	public ResponseEntity<List<Yarn>> findAllYarn() {
		List<Yarn> yarns = yarnService.findAllYarn();
		if (yarns.isEmpty()) {
			return new ResponseEntity<List<Yarn>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Yarn>>(yarns, HttpStatus.OK);
	}
	
	//Read One
	@GetMapping(value="/{id}")
	public ResponseEntity<?> findYarnById(@PathVariable String id) {
		Yarn yarn = yarnService.findYarnById(Integer.valueOf(id));
		if(yarn.getId() == null) {
			return new ResponseEntity<>("Not Found", HttpStatus.OK);
		}
		return new ResponseEntity<>(yarn, HttpStatus.OK);
	}
	
	
	//Create
	@PostMapping(value="/")
	public ResponseEntity<?> saveYarn(@RequestBody Yarn yarn) {
		yarnService.saveYarn(yarn);
		return new ResponseEntity<>(yarn, HttpStatus.CREATED);
	}
	
	//Update
	@PutMapping(value="/{id}")
	public ResponseEntity<?> updateYarnById(@RequestBody Yarn yarn) {
		yarnService.updateYarn(yarn);
		return new ResponseEntity<>(yarn, HttpStatus.CREATED);
	}
	
	
	//Delete
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> deleteYarnById(@PathVariable String id) {
		yarnService.deleteYarnById(Integer.valueOf(id));
		return new ResponseEntity<>(yarnService.findAllYarn(), HttpStatus.OK);
	}
	

}
