package com.megagiganto.ypTracker.api.dao;

import java.util.List;

import com.megagiganto.ypTracker.api.model.Pattern;

public interface PatternDAO {
	List<Pattern> findAllPatterns();
	
	Pattern findPatternById(Long id);
	
	Pattern savePattern(Pattern pattern);
	
	Object deletePattern(Long id);
	
	void updatePattern(Pattern pattern);
}
