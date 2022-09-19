package com.megagiganto.ypTracker.api.service;

import java.util.List;

import com.megagiganto.ypTracker.app.model.Pattern;

public interface PatternService {

	List<Pattern> findAllPatterns();
	
	Pattern findPatternById(Integer id);
	
	void savePattern(Pattern pattern);
	
	void updatePattern(Pattern pattern);

	void deletePatternById(Integer valueOf);

	
}
