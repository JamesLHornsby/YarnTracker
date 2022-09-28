package com.megagiganto.ypTrackerSpringBoot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.megagiganto.ypTrackerSpringBoot.app.model.Note;
import com.megagiganto.ypTrackerSpringBoot.app.repository.NoteRepository;

@Service
public class NoteService{
	
	@Autowired
	private NoteRepository noteRepo;
		@Transactional
	public List<Note> findAllNotes() {
		return noteRepo.findAll();
	}
	@Transactional
	public Note saveNote(Note note) {
		return noteRepo.save(note);
	}
}
