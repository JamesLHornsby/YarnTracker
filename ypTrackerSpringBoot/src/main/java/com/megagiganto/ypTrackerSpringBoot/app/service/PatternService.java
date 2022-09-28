package com.megagiganto.ypTrackerSpringBoot.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.megagiganto.ypTrackerSpringBoot.app.model.Pattern;
import com.megagiganto.ypTrackerSpringBoot.app.repository.PatternRepository;

@Service
public class PatternService{
	
	@Autowired
	private PatternRepository patternRepo;
	
	@Transactional
	public List<Pattern> findAllPatterns() {
		return patternRepo.findAll();
	}
	@Transactional
	public Pattern findPatternById(Integer id) {
		Optional<Pattern> pattern = patternRepo.findById(id);
		return pattern.get();
	}
	@Transactional
	public Pattern savePattern(Pattern pattern) {
		patternRepo.save(pattern);
		return pattern;
	}
	@Transactional
	public Pattern updatePattern(Pattern pattern) {
		Optional<Pattern> entity = Optional.ofNullable(findPatternById(pattern.getId()));
		
		Pattern currentPattern = entity.get();
		if(currentPattern != null) {
			currentPattern.setId(pattern.getId());
			currentPattern.setName(pattern.getName());
			currentPattern.setColors(pattern.getColors());
			currentPattern.setSize(pattern.getSize());
		}
		return patternRepo.save(currentPattern);
	}
	
	public boolean deletePatternById(Integer id) {
		patternRepo.deleteById(id);
		return true;
	}


}
