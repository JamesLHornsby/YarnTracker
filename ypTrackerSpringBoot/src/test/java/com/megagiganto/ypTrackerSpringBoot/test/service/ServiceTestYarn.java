package com.megagiganto.ypTrackerSpringBoot.test.service;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
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

import com.megagiganto.ypTrackerSpringBoot.app.model.Yarn;
import com.megagiganto.ypTrackerSpringBoot.app.repository.YarnRepository;
import com.megagiganto.ypTrackerSpringBoot.app.service.YarnService;

public class ServiceTestYarn extends AbstractTestNGSpringContextTests {
	Yarn yarn = new Yarn();	

	@Mock
	YarnRepository yarnRepository;
	
	@InjectMocks
	YarnService yarnService;
	
	@BeforeClass
	public void setup() {
		MockitoAnnotations.openMocks(this);
		yarn.setId(1);
		yarn.setColor("Purple");
		yarn.setSize(4);
		yarn.setLength(BigDecimal.valueOf(1.5));
		yarn.setLocation("Tote bin");
		yarnService.saveYarn(yarn);
		
	}
	
	@AfterMethod
	@AfterClass
	public void tearDown() throws Exception {
		MockitoAnnotations.openMocks(this).close();
	}
	
	//Yarn Tests
	@Test
	private void findAllYarn() {
		yarnService.findAllYarn();
	}
	
	@Test
	private void saveYarn_successfully() {
			
		when(yarnRepository.save(any(Yarn.class))).thenReturn(yarn);
		Yarn yarnReturn = yarnService.saveYarn(yarn);
		AssertJUnit.assertEquals(yarnReturn.getId(), yarn.getId());
	}
	
	@Test
	private void updateYarn_successfully() {
		
		when(yarnRepository.save(any(Yarn.class))).thenReturn(yarn);
		when(yarnRepository.findById(any(Integer.class))).thenReturn(Optional.of(yarn));
		yarn.setColor("Blue");
		Yarn savedYarn = yarnService.updateYarn(yarn);
		
		assertEquals(savedYarn.getColor(), yarn.getColor());
	
	}
	
	@Test
	private void deleteYarn_successfully() {
		Boolean wasDeleted = yarnService.deleteYarnById(yarn.getId());
		assertTrue(wasDeleted);
	}
	
	@Test(expectedExceptions = {NoSuchElementException.class})
	private void givenInvalidId_whenFindingYarn_thenThrowsNoSuchElementException() throws NoSuchElementException {
		
		when(yarnRepository.findById((int) anyLong())).thenReturn(Optional.empty());
		yarnService.findYarnById(99);
		
	}
	
	@Test(expectedExceptions = {NoSuchElementException.class})
	private void updateYarn_unsuccessfully() throws NoSuchElementException {
		
		when(yarnRepository.save(any(Yarn.class))).thenReturn(yarn);
		when(yarnRepository.findById(any(Integer.class))).thenReturn(Optional.of(yarn));
		Yarn badYarn = new Yarn();
		badYarn.setColor("Blue");
		yarnService.updateYarn(badYarn);
	
	}
}
