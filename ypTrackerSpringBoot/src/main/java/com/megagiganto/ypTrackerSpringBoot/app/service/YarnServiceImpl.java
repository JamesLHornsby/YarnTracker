package com.megagiganto.ypTrackerSpringBoot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megagiganto.ypTrackerSpringBoot.api.dao.YarnDAO;
import com.megagiganto.ypTrackerSpringBoot.app.model.Yarn;
import com.megagiganto.ypTrackerSpringBoot.api.service.YarnService;

@Service
public class YarnServiceImpl implements YarnService {

	@Autowired
	private YarnDAO yarnDAO;
	
	@Override
	public List<Yarn> findAllYarn() {
		return yarnDAO.findAllYarn();
	}
	
	@Override
	public Yarn findYarnById(Integer id) {
		return yarnDAO.findYarnById(id);
	}

	@Override
	public Yarn saveYarn(Yarn yarn) {
		return yarnDAO.saveYarn(yarn);
	}
	
	@Override
	public Yarn updateYarn(Yarn yarn) {
		return yarnDAO.updateYarn(yarn);
	}

	@Override
	public void deleteYarnById(Integer id) {
		yarnDAO.deleteYarnById(id);
	}


}
