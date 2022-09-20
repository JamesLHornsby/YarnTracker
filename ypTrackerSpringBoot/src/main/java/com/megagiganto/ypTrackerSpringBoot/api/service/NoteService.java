package com.megagiganto.ypTrackerSpringBoot.api.service;

import java.util.List;

import com.megagiganto.ypTrackerSpringBoot.app.model.Note;

public interface NoteService {

	List<Note> findAllNotes();
	
	Note saveNote(Note note);

}