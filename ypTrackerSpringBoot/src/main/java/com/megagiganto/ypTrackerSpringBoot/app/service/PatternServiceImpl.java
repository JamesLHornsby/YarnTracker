package com.megagiganto.ypTrackerSpringBoot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megagiganto.ypTrackerSpringBoot.api.dao.PatternDAO;
import com.megagiganto.ypTrackerSpringBoot.app.model.Pattern;
import com.megagiganto.ypTrackerSpringBoot.api.service.PatternService;

@Service
public class PatternServiceImpl implements PatternService{
	
	@Autowired
	private PatternDAO patternDAO;
	
	@Override
	public List<Pattern> findAllPatterns() {
		return patternDAO.findAllPatterns();
	}

	@Override
	public Pattern findPatternById(Integer id) {
		return patternDAO.findPatternById(id);
	}

	@Override
	public Pattern savePattern(Pattern pattern) {
		return patternDAO.savePattern(pattern);
	}

	@Override
	public Pattern updatePattern(Pattern pattern) {
		return patternDAO.updatePattern(pattern);
	}
	
	@Override
	public void deletePatternById(Integer id) {
		patternDAO.deletePatternById(id);
	}


}
