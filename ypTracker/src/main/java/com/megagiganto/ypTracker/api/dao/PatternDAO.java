package com.megagiganto.ypTracker.api.dao;

import java.util.List;

import com.megagiganto.ypTracker.api.model.Pattern;

public interface PatternDAO {
	List<Pattern> findAllPatterns();
	
	Pattern findPatternById(Integer id);
	
	Pattern savePattern(Pattern pattern);
	
	void deletePattern(Integer id);
	
	void updatePattern(Pattern pattern);
}
