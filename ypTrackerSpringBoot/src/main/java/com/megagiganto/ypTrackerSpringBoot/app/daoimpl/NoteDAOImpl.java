package com.megagiganto.ypTrackerSpringBoot.app.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.megagiganto.ypTrackerSpringBoot.api.dao.NoteDAO;
import com.megagiganto.ypTrackerSpringBoot.app.model.Note;
import com.megagiganto.ypTrackerSpringBoot.app.repository.NoteRepository;

@Repository
public class NoteDAOImpl implements NoteDAO {
	
	@Autowired
	private NoteRepository noteRepository;


	@Transactional
	@Override
	public List<Note> findAllNotes() {
		return noteRepository.findAll();
	}
	
	@Transactional
	@Override
	public Note saveNote(Note note) {
		noteRepository.save(note);
		return note;
	}
	
}
