package com.megagiganto.ypTracker.app.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.megagiganto.ypTracker.api.dao.YarnDAO;
import com.megagiganto.ypTracker.api.model.Yarn;
import com.megagiganto.ypTracker.app.model.YarnImpl;

@Repository
public class YarnDAOImpl implements YarnDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//CriteriaQuery
	@Transactional
	@Override
	public List<Yarn> findAllYarn() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Yarn> cr = builder.createQuery(Yarn.class);
		Root<YarnImpl> root = cr.from(YarnImpl.class);
		cr.select(root);
		
		Query<Yarn> query = session.createQuery(cr);
		List<Yarn> results = query.getResultList();
		return results;
	}

	@Transactional
	@Override
	public Yarn findYarnById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return session.byId(Yarn.class).load(id);
	}

	@Transactional
	@Override
	public Yarn saveYarn(Yarn yarn) {
		Session session = sessionFactory.getCurrentSession();
		
		if (yarn.getId()!=null) {	//existing yarn
			session.update(yarn);
			
		} else {	//new yarn
			Integer id = (Integer) session.save(yarn);
			yarn.setId(id);
		}
		return yarn;
	}
	
	@Transactional
	@Override
	public void deleteYarn(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Object persistentInstance = session.load(YarnImpl.class, id);
		if (persistentInstance !=null) {
			session.remove(persistentInstance);
		}
		
	}


}
