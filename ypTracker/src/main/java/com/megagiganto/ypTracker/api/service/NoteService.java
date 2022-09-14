package com.megagiganto.ypTracker.api.service;

import java.util.List;

import com.megagiganto.ypTracker.app.model.NoteImpl;

public interface NoteService {

	List<NoteImpl> getAllNotes();
	
	NoteImpl addNote(NoteImpl note);

}