package com.megagiganto.ypTrackerSpringBoot.api.dao;

import java.util.List;

import com.megagiganto.ypTrackerSpringBoot.app.model.Yarn;

public interface YarnDAO {

	List<Yarn> findAllYarn();

	Yarn findYarnById(Integer id);

	Yarn saveYarn(Yarn yarn);

	void deleteYarnById(Integer id);

	Yarn updateYarn(Yarn yarn);

}
