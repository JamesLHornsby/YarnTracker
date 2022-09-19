package com.megagiganto.ypTrackerSpringBoot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megagiganto.ypTrackerSpringBoot.api.dao.NoteDAO;
import com.megagiganto.ypTrackerSpringBoot.app.model.Note;
import com.megagiganto.ypTrackerSpringBoot.api.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	NoteDAO noteDAO;
	
	@Override
	public List<Note> findAllNotes() {
		return noteDAO.findAllNotes();
	}

	@Override
	public Note saveNote(Note note) {
		return noteDAO.saveNote(note);
	}
}
