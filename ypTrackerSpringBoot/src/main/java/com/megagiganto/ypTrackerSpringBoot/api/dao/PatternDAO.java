package com.megagiganto.ypTrackerSpringBoot.api.dao;

import java.util.List;

import com.megagiganto.ypTrackerSpringBoot.app.model.Pattern;

public interface PatternDAO {
	
	List<Pattern> findAllPatterns();
	
	Pattern findPatternById(Integer id);
	
	Pattern savePattern(Pattern pattern);
	
	void deletePatternById(Integer id);

	Pattern updatePattern(Pattern pattern);
}
