package com.megagiganto.ypTracker.api.service;

import java.util.List;

import com.megagiganto.ypTracker.app.model.Yarn;

public interface YarnService {

	List<Yarn> findAllYarn();
	
	Yarn findYarnById(Integer id);

	void saveYarn(Yarn yarn);

	void updateYarn(Yarn yarn);
	
	void deleteYarnById(Integer valueOf);


}