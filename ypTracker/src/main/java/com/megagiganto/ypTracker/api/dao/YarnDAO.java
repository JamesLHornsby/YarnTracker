package com.megagiganto.ypTracker.api.dao;

import java.util.List;

import com.megagiganto.ypTracker.api.model.Yarn;
import com.megagiganto.ypTracker.app.model.YarnImpl;

public interface YarnDAO {

	List<Yarn> findAllYarn();

	Yarn findYarnById(Long id);

	Yarn saveYarn(Yarn yarn);

	Object deleteYarn(Long id);

	void updateYarn(Yarn yarn);

}
