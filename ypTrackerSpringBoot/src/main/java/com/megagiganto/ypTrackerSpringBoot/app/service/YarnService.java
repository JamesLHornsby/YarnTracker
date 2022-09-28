package com.megagiganto.ypTrackerSpringBoot.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.megagiganto.ypTrackerSpringBoot.app.model.Yarn;
import com.megagiganto.ypTrackerSpringBoot.app.repository.YarnRepository;

@Service
public class YarnService{

	@Autowired
	private YarnRepository yarnRepository;
		@Transactional
	public List<Yarn> findAllYarn() {
		return yarnRepository.findAll();
	}
		@Transactional
	public Yarn findYarnById(Integer id) {
		Optional<Yarn> yarn = yarnRepository.findById(id);
		return yarn.get();
	}
	@Transactional
	public Yarn saveYarn(Yarn yarn) {
		yarnRepository.save(yarn);
		return yarn;
	}
		@Transactional
	public Yarn updateYarn(Yarn yarn) {
		Optional<Yarn> entity = Optional.ofNullable(findYarnById(yarn.getId()));

		Yarn currentYarn = entity.get();
		if(currentYarn != null) {
			currentYarn.setId(yarn.getId());
			currentYarn.setColor(yarn.getColor());
			currentYarn.setSize(yarn.getSize());
			currentYarn.setLength(yarn.getLength());
			currentYarn.setLocation(yarn.getLocation());
		}
		
		return yarnRepository.save(currentYarn);

	}
	@Transactional
	public boolean deleteYarnById(Integer id) {
		yarnRepository.deleteById(id);
		return true;
	}


}
