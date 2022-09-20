package com.megagiganto.ypTracker.app.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.megagiganto.ypTracker.api.service.PatternService;
import com.megagiganto.ypTracker.app.model.Pattern;

@Service
public class PatternServiceImpl implements PatternService{
	
	private static String PATTERN_SERVICES_ENDPOINT = "http://localhost:8081/api/patterns";
	
	@Autowired
	public RestTemplate restTemplate;
	
	@Override
	public List<Pattern> findAllPatterns() {
		ResponseEntity<Pattern[]> response = null;
		response = restTemplate.getForEntity(PATTERN_SERVICES_ENDPOINT+"/", Pattern[].class);
		List<Pattern> list = Arrays.asList(response.getBody());
		return list;
	}

	@Override
	public Pattern findPatternById(Integer id) {
		ResponseEntity<Pattern> response = restTemplate.getForEntity(PATTERN_SERVICES_ENDPOINT+"/"+id, Pattern.class);
		return response.getBody();
	}

	@Override
	public void savePattern(Pattern pattern) {
		HttpEntity<Pattern> request = new HttpEntity<>(pattern);
		restTemplate.exchange(PATTERN_SERVICES_ENDPOINT+"/", HttpMethod.POST, request, Pattern.class);
		
	}

	@Override
	public void deletePatternById(Integer id) {
		restTemplate.delete(PATTERN_SERVICES_ENDPOINT+"/"+id, HttpMethod.DELETE, Pattern.class);
	}

	@Override
	public void updatePattern(Pattern pattern) {
		HttpEntity<Pattern> request = new HttpEntity<>(pattern);
		restTemplate.exchange(PATTERN_SERVICES_ENDPOINT+"/"+pattern.getId(), HttpMethod.PUT, request, Pattern.class);
		
	}
}
