package com.megagiganto.ypTracker.api.service;

import java.util.List;

import com.megagiganto.ypTracker.app.model.Note;

public interface NoteService {

	List<Note> findAllNotes();
	
	void saveNote(Note note);

}