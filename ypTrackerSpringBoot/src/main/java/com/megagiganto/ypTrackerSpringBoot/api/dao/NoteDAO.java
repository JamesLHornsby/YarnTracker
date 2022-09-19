package com.megagiganto.ypTrackerSpringBoot.api.dao;

import java.util.List;

import com.megagiganto.ypTrackerSpringBoot.app.model.Note;

public interface NoteDAO {

	List<Note> findAllNotes();

	Note saveNote(Note note);

}