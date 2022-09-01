package com.megagiganto.ypTracker.api.service;

import java.util.List;

import com.megagiganto.ypTracker.api.model.Yarn;
import com.megagiganto.ypTracker.app.model.YarnImpl;

public interface YarnService {

	List<Yarn> findAllYarn();
	
	Yarn findYarn(Long id);

	Yarn saveYarn(YarnImpl yarn);
	
	void updateYarn(Yarn currentYarn);

	Object deleteYarn(Long valueOf);

	

	

}