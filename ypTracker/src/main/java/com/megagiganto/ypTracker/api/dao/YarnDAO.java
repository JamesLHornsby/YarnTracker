package com.megagiganto.ypTracker.api.dao;

import java.util.List;

import com.megagiganto.ypTracker.api.model.Yarn;

public interface YarnDAO {

	List<Yarn> findAllYarn();

	Yarn findYarnById(Integer id);

	Yarn saveYarn(Yarn yarn);

	void deleteYarn(Integer id);

}
