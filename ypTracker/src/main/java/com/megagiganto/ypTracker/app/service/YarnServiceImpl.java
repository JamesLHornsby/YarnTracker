package com.megagiganto.ypTracker.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megagiganto.ypTracker.api.dao.YarnDAO;
import com.megagiganto.ypTracker.api.model.Yarn;
import com.megagiganto.ypTracker.api.service.YarnService;
import com.megagiganto.ypTracker.app.model.YarnImpl;

@Service
public class YarnServiceImpl implements YarnService {

	@Autowired
	private YarnDAO yarnPatternDAO;
	
	@Override
	public List<Yarn> findAllYarn() {
		return yarnPatternDAO.findAllYarn();
	}
	
	@Override
	public Yarn findYarn(Long id) {
		return yarnPatternDAO.findYarnById(id);
	}

	@Override
	public Yarn saveYarn(YarnImpl yarn) {
		return yarnPatternDAO.saveYarn(yarn);
	}

	@Override
	public Object deleteYarn(Long id) {
		return yarnPatternDAO.deleteYarn(id);
	}

	@Override
	public void updateYarn(Yarn yarn) {
		yarnPatternDAO.updateYarn(yarn);
		
	}



}
