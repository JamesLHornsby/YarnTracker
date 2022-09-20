package com.megagiganto.ypTrackerSpringBoot.api.service;

import java.util.List;

import com.megagiganto.ypTrackerSpringBoot.app.model.Pattern;

public interface PatternService {

	List<Pattern> findAllPatterns();
	
	Pattern findPatternById(Integer id);
	
	Pattern savePattern(Pattern pattern);
	
	Pattern updatePattern(Pattern pattern);

	void deletePatternById(Integer id);


}
