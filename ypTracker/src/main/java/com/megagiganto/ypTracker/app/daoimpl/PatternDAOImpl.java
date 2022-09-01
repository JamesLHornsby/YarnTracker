package com.megagiganto.ypTracker.app.daoimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.google.common.collect.ImmutableList;
import com.megagiganto.ypTracker.api.dao.PatternDAO;
import com.megagiganto.ypTracker.api.model.Pattern;
import com.megagiganto.ypTracker.app.model.PatternImpl;

@Repository
public class PatternDAOImpl implements PatternDAO {

	private static Long patternId = Long.valueOf(0);
	private static List<PatternImpl> patterns = new ArrayList<>();

	static {
		patterns = populatePatterns();
	}

	private static List<PatternImpl> populatePatterns() {
		PatternImpl pattern1 = new PatternImpl();
		pattern1.setId(++patternId);
		pattern1.setName("Stormtrooper");
		pattern1.setSize(4);
		pattern1.setColors("White, Black");
		
		PatternImpl pattern2 = new PatternImpl();
		pattern2.setId(++patternId);
		pattern2.setName("Racoon");
		pattern2.setSize(4);
		pattern2.setColors("White, Black, Gray");
		
		patterns.add(pattern1);
		patterns.add(pattern2);
		
		return patterns;
		
	}

	@Override
	public List<Pattern> findAllPatterns() {
		return ImmutableList.copyOf(patterns);
	}

	@Override
	public Pattern findPatternById(Long id) {
		for (Pattern pattern : patterns) {
			if(pattern.getId()==id) {
				return pattern;
			}
		}
		return null;
	}

	@Override
	public Pattern savePattern(Pattern pattern) {
		if (pattern.getId()!= null) {
			Pattern existingPattern = findPatternById(pattern.getId());
			if(existingPattern != null) {
				patterns = patterns.stream()
						.map(p ->p.getId().equals(pattern.getId()) ? (PatternImpl) pattern : p)
						.collect(Collectors.toList());
				return pattern;
			}
		}
		pattern.setId(++patternId);
		patterns.add((PatternImpl) pattern);
		return pattern;
	}
	
	@Override
	public Object deletePattern(Long id) {
		return patterns.removeIf(pattern -> id.equals(pattern.getId()));
	}
	
	@Override
	public void updatePattern(Pattern pattern) {
		Pattern foundPattern = findPatternById(pattern.getId());
		patterns = patterns.stream().map(p -> p.getId().equals(pattern.getId()) ? (PatternImpl) pattern : p)
				.collect(Collectors.toList());
	}

}
