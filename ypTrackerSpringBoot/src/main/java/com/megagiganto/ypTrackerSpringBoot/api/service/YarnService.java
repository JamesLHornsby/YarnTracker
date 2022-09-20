package com.megagiganto.ypTrackerSpringBoot.api.service;

import java.util.List;

import com.megagiganto.ypTrackerSpringBoot.app.model.Yarn;

public interface YarnService {

	List<Yarn> findAllYarn();
	
	Yarn findYarnById(Integer id);

	Yarn saveYarn(Yarn yarn);
	
	Yarn updateYarn(Yarn yarn);

	void deleteYarnById(Integer valueOf);


}