package com.megagiganto.ypTracker.api.service;

import java.util.List;

import com.megagiganto.ypTracker.api.model.Yarn;
import com.megagiganto.ypTracker.app.model.YarnImpl;

public interface YarnService {

	List<Yarn> findAllYarn();
	
	Yarn findYarn(Integer id);

	Yarn saveYarn(YarnImpl yarn);

	void deleteYarn(Integer valueOf);

	

	

}