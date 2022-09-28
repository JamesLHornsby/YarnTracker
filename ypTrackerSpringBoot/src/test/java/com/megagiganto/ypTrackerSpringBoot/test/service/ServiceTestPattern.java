package com.megagiganto.ypTrackerSpringBoot.test.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.megagiganto.ypTrackerSpringBoot.app.model.Pattern;
import com.megagiganto.ypTrackerSpringBoot.app.repository.PatternRepository;
import com.megagiganto.ypTrackerSpringBoot.app.service.PatternService;

public class ServiceTestPattern extends AbstractTestNGSpringContextTests {
	Pattern pattern = new Pattern();

	@Mock
	PatternRepository patternRepo;
	
	@InjectMocks
	PatternService patternService;
	
	@BeforeClass
	public void setup() {
		MockitoAnnotations.openMocks(this);
		
		pattern.setId(1);
		pattern.setName("Grimace");
		pattern.setColors("Purple");
		pattern.setSize(4);
		patternService.savePattern(pattern);
		
	}
	
	@AfterMethod
	@AfterClass
	public void tearDown() throws Exception {
		MockitoAnnotations.openMocks(this).close();
	}

	//Pattern Tests
	@Test
	private void findAllPatterns() {
		patternService.findAllPatterns();
	}
	
	@Test
	private void savePattern_successfully() {
		when(patternRepo.save(any(Pattern.class))).thenReturn(pattern);
		Pattern patternReturn = patternService.savePattern(pattern);
		AssertJUnit.assertEquals(patternReturn.getId(), pattern.getId());
		
	}
	
	@Test
	private void updatePattern_successfully() {
		Pattern updatedPattern = new Pattern();
		updatedPattern = pattern;
		updatedPattern.setName("Lumpy Space Princess");
		patternService.savePattern(updatedPattern);
		
		when(patternRepo.save(any(Pattern.class))).thenReturn(pattern);
		when(patternRepo.findById(any(Integer.class))).thenReturn(Optional.of(updatedPattern));
		
		Pattern savedPattern = patternService.updatePattern(pattern);
		assertEquals(savedPattern.getName(), pattern.getName());
		
		
	}
	
	@Test
	private void deletePattern_successfully() {
		Boolean wasDeleted = patternService.deletePatternById(pattern.getId());
		assertTrue(wasDeleted);
	}

	
}
