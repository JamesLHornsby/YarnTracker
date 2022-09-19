package com.megagiganto.ypTrackerSpringBoot.app.daoimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.megagiganto.ypTrackerSpringBoot.api.dao.PatternDAO;
import com.megagiganto.ypTrackerSpringBoot.app.model.Pattern;
import com.megagiganto.ypTrackerSpringBoot.app.repository.PatternRepository;

@Repository
public class PatternDAOImpl implements PatternDAO {
	
	@Autowired
	private PatternRepository patternRepository;

	@Transactional
	@Override
	public List<Pattern> findAllPatterns() {
		return patternRepository.findAll();
	}

	@Transactional
	@Override
	public Pattern findPatternById(Integer id) {
		Optional<Pattern> pattern = patternRepository.findById(id);
		return pattern.get();
	}

	@Transactional
	@Override
	public Pattern savePattern(Pattern pattern) {
			patternRepository.save(pattern);

		return pattern;

	}
	
	@Transactional
	@Override
	public void deletePatternById(Integer id) {
		patternRepository.deleteById(id);
	}

	@Transactional
	@Override
	public Pattern updatePattern(Pattern pattern) {
		Pattern currentPattern = findPatternById(pattern.getId());
		currentPattern.setId(pattern.getId());
		currentPattern.setName(pattern.getName());
		currentPattern.setColors(pattern.getColors());
		currentPattern.setSize(pattern.getSize());
		
		return pattern;
		
	}

}
