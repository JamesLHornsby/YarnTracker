package com.megagiganto.ypTracker.app.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.megagiganto.ypTracker.api.dao.NoteDAO;
import com.megagiganto.ypTracker.app.model.NoteImpl;

@Repository
public class NoteDAOImpl implements NoteDAO {

	@Override
	public List<NoteImpl> getAllNotes() {
		
		List<NoteImpl> notes = new ArrayList<>();
		
		NoteImpl note1 = new NoteImpl();
		note1.setContents("Here is my first note!");
		
		NoteImpl note2 = new NoteImpl();
		note2.setContents("Here is my second note!");
		
		notes.add(note1);
		notes.add(note2);
		
		return notes;
	}
	
}
