package com.megagiganto.ypTracker.api.service;

import java.util.List;

import com.megagiganto.ypTracker.api.model.Pattern;
import com.megagiganto.ypTracker.app.model.PatternImpl;

public interface PatternService {

	List<Pattern> findAllPatterns();
	
	Pattern findPattern(Integer id);
	
	Pattern savePattern(PatternImpl pattern);

	void updatePattern(Pattern currentPattern);

	void deletePattern(Integer valueOf);
}
