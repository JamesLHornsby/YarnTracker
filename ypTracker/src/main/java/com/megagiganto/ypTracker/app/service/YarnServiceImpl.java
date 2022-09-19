package com.megagiganto.ypTracker.app.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.megagiganto.ypTracker.api.service.YarnService;
import com.megagiganto.ypTracker.app.model.Yarn;

@Service
public class YarnServiceImpl implements YarnService {
	private static String YARN_SERVICES_ENDPOINT = "http://localhost:8081/api/yarns";

	@Autowired
	public RestTemplate restTemplate;
	
	@Override
	public List<Yarn> findAllYarn() {
		ResponseEntity<Yarn[]> response = null;
		response = restTemplate.getForEntity(YARN_SERVICES_ENDPOINT+"/", Yarn[].class);
		List<Yarn> list = Arrays.asList(response.getBody());
		return list;
	}
	
	@Override
	public Yarn findYarnById(Integer id) {
		ResponseEntity<Yarn> response = restTemplate.getForEntity(YARN_SERVICES_ENDPOINT+"/"+id, Yarn.class);
		return response.getBody();
	}

	@Override
	public void saveYarn(Yarn yarn) {
		HttpEntity<Yarn> request = new HttpEntity<>(yarn);
		restTemplate.exchange(YARN_SERVICES_ENDPOINT+"/", HttpMethod.POST, request, Yarn.class);
	}

	@Override
	public void deleteYarnById(Integer id) {
		restTemplate.delete(YARN_SERVICES_ENDPOINT+"/"+id, HttpMethod.DELETE, Yarn.class);
	}

	@Override
	public void updateYarn(Yarn yarn) {
		HttpEntity<Yarn> request = new HttpEntity<>(yarn);
		restTemplate.exchange(YARN_SERVICES_ENDPOINT+"/"+yarn.getId(), HttpMethod.PUT, request, Yarn.class);
		
	}


}
