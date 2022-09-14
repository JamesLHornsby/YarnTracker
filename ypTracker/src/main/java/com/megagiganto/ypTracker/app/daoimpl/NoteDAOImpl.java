package com.megagiganto.ypTracker.app.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.megagiganto.ypTracker.api.dao.NoteDAO;
import com.megagiganto.ypTracker.app.model.NoteImpl;

@Repository
public class NoteDAOImpl implements NoteDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<NoteImpl> getAllNotes() {
		Session session = sessionFactory.getCurrentSession();
		List<NoteImpl> noteList = session.createQuery("from NOTE",NoteImpl.class).list();
		return noteList;
	}
	
	@Transactional
	@Override
	public NoteImpl addNote(NoteImpl note) {
		Session session = sessionFactory.getCurrentSession();
		Integer id = (Integer) session.save(note);
		note.setId(id);
		return note;
	}
	
}
