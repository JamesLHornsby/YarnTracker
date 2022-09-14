package com.megagiganto.ypTracker.app.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.megagiganto.ypTracker.api.dao.PatternDAO;
import com.megagiganto.ypTracker.api.model.Pattern;
import com.megagiganto.ypTracker.app.model.PatternImpl;

@Repository
public class PatternDAOImpl implements PatternDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	private static List<PatternImpl> patterns = new ArrayList<>();


	//HQL Query...
	@Transactional
	@Override
	public List<Pattern> findAllPatterns() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from PATTERN");
		List<Pattern> patternList = query.list();
//		List<Pattern> patternList = session.createQuery("from PATTERN",Pattern.class).list();
		return patternList;
	}

	@Transactional
	@Override
	public Pattern findPatternById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return session.byId(Pattern.class).load(id);
	}

	@Transactional
	@Override
	public Pattern savePattern(Pattern pattern) {
		Session session = sessionFactory.getCurrentSession();
		if (pattern.getId()!=null) {
			session.update(pattern);
		} else {
			Integer id = (Integer) session.save(pattern);
			pattern.setId(id);
		}
		
		return pattern;

	}
	
	@Transactional
	@Override
	public void deletePattern(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Object persistentInstance = session.load(PatternImpl.class, id);
		if (persistentInstance !=null) {
			session.remove(persistentInstance);
		}
	}
	
	@Override
	public void updatePattern(Pattern pattern) {
		Pattern foundPattern = findPatternById(pattern.getId());
		patterns = patterns.stream().map(p -> p.getId().equals(pattern.getId()) ? (PatternImpl) pattern : p)
				.collect(Collectors.toList());
	}

}
