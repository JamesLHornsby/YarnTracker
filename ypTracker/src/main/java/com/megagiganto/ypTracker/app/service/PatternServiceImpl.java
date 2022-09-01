package com.megagiganto.ypTracker.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megagiganto.ypTracker.api.dao.PatternDAO;
import com.megagiganto.ypTracker.api.model.Pattern;
import com.megagiganto.ypTracker.api.service.PatternService;
import com.megagiganto.ypTracker.app.model.PatternImpl;

@Service
public class PatternServiceImpl implements PatternService{
	
	@Autowired
	private PatternDAO patternDAO;
	
	@Override
	public List<Pattern> findAllPatterns() {
		return patternDAO.findAllPatterns();
	}

	@Override
	public Pattern findPattern(Long id) {
		return patternDAO.findPatternById(id);
	}

	@Override
	public Pattern savePattern(PatternImpl pattern) {
		return patternDAO.savePattern(pattern);
	}

	@Override
	public void updatePattern(Pattern currentPattern) {
		patternDAO.updatePattern(currentPattern);
		
	}

	@Override
	public Object deletePattern(Long id) {
		return patternDAO.deletePattern(id);
	}
}
