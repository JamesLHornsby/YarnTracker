package com.megagiganto.ypTrackerSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megagiganto.ypTrackerSpringBoot.app.service.NoteService;
import com.megagiganto.ypTrackerSpringBoot.app.model.Note;

@CrossOrigin(origins = "http://localhost:8081")
@Controller
@RequestMapping("/api")
public class NoteController {

	@Autowired
	NoteService noteService;
	
	//calls viewNote and adds notes
	@GetMapping(value = "/notes")
	public ResponseEntity<List<Note>> findAllNotes() {
		return new ResponseEntity<>(noteService.findAllNotes(), HttpStatus.OK);
	}
	
	//and gets form ready
	@PostMapping("/notes")
	public ResponseEntity<?> saveNotes(@RequestBody Note note) {
		Note savedNote = noteService.saveNote(note);
		return new ResponseEntity<>((Note) savedNote, HttpStatus.OK);
	}
	
}
