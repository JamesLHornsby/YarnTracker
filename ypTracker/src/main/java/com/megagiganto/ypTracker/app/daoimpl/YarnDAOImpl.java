package com.megagiganto.ypTracker.app.daoimpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.google.common.collect.ImmutableList;
import com.megagiganto.ypTracker.api.dao.YarnDAO;
import com.megagiganto.ypTracker.api.model.Yarn;
import com.megagiganto.ypTracker.app.model.YarnImpl;

@Repository
public class YarnDAOImpl implements YarnDAO {
	
	private static Long yarnId = Long.valueOf(0);
	private static List<YarnImpl> yarns = new ArrayList<>();

	static {
		yarns = populateYarns();
	}
	
	private static List<YarnImpl> populateYarns() {
		YarnImpl yarn1 = new YarnImpl();
		yarn1.setId(++yarnId);
		yarn1.setColor("white");
		yarn1.setLocation("Under Table");
		yarn1.setSize(4);
		yarn1.setLength(BigDecimal.valueOf(.75));
		
		YarnImpl yarn2 = new YarnImpl();
		yarn2.setId(++yarnId);
		yarn2.setColor("black");
		yarn2.setLocation("In craft box");
		yarn2.setSize(4);
		yarn2.setLength(BigDecimal.valueOf(1.5));
		
		yarns.add(yarn1);
		yarns.add(yarn2);
		
		return yarns;
		
	}
	
	@Override
	public List<Yarn> findAllYarn() {
		return ImmutableList.copyOf(yarns);
	}

	@Override
	public Yarn findYarnById(Long id) {
		for(Yarn yarn : yarns) {
			if(yarn.getId()==id) {
				return yarn;
			}
		}
		return null;
	}

	@Override
	public Yarn saveYarn(Yarn yarn) {
		if (yarn.getId()!= null) {
			Yarn existingYarn = findYarnById(yarn.getId());
			if(existingYarn != null) {
				yarns = yarns.stream()
						.map(y ->y.getId().equals(yarn.getId()) ? (YarnImpl) yarn : y)
						.collect(Collectors.toList());
				return yarn;
			}
		}
		
		
		yarn.setId(++yarnId);
		yarns.add((YarnImpl) yarn);
		return yarn;
	}

	@Override
	public Object deleteYarn(Long id) {
		return yarns.removeIf(yarn -> id.equals(yarn.getId()));
	}

	@Override
	public void updateYarn(Yarn yarn) {
		Yarn foundYarn = findYarnById(yarn.getId());
		yarns = yarns.stream().map(y -> y.getId().equals(yarn.getId()) ? (YarnImpl) yarn : y)
				.collect(Collectors.toList());
	}

}
