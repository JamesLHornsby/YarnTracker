package com.megagiganto.ypTracker.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megagiganto.ypTracker.api.dao.NoteDAO;
import com.megagiganto.ypTracker.api.service.NoteService;
import com.megagiganto.ypTracker.app.model.NoteImpl;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	NoteDAO noteDAO;
	
	@Override
	public List<NoteImpl> getAllNotes() {
		return noteDAO.getAllNotes();
	}
}
