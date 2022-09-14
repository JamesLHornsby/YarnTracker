package com.megagiganto.ypTracker.api.dao;

import java.util.List;

import com.megagiganto.ypTracker.app.model.NoteImpl;

public interface NoteDAO {

	List<NoteImpl> getAllNotes();

	NoteImpl addNote(NoteImpl note);

}