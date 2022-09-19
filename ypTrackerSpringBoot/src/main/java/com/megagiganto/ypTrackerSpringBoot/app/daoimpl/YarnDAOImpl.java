package com.megagiganto.ypTrackerSpringBoot.app.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.megagiganto.ypTrackerSpringBoot.api.dao.YarnDAO;
import com.megagiganto.ypTrackerSpringBoot.app.model.Yarn;
import com.megagiganto.ypTrackerSpringBoot.app.repository.YarnRepository;

@Repository
public class YarnDAOImpl implements YarnDAO {
	
	@Autowired
	private YarnRepository yarnRepository;
	
	@Transactional
	@Override
	public List<Yarn> findAllYarn() {
		return yarnRepository.findAll();
	}

	@Transactional
	@Override
	public Yarn findYarnById(Integer id) {
		Optional<Yarn> yarn = yarnRepository.findById(id);
		return yarn.get();
	}

	@Transactional
	@Override
	public Yarn saveYarn(Yarn yarn) {
		yarnRepository.save(yarn);
		return yarn;
	}
	
	@Transactional
	@Override
	public void deleteYarnById(Integer id) {
		yarnRepository.deleteById(id);
	}

	@Transactional
	@Override
	public Yarn updateYarn(Yarn yarn) {
		Yarn currentYarn = findYarnById(yarn.getId());
		currentYarn.setId(yarn.getId());
		currentYarn.setColor(yarn.getColor());
		currentYarn.setSize(yarn.getSize());
		currentYarn.setLength(yarn.getLength());
		currentYarn.setLocation(yarn.getLocation());
		return yarn;
	}


}
