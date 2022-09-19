package com.megagiganto.ypTracker.app.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.megagiganto.ypTracker.api.service.NoteService;
import com.megagiganto.ypTracker.app.model.Note;

@Service
public class NoteServiceImpl implements NoteService {
	
	private static String NOTE_SERVICES_ENDPOINT = "http://localhost:8081/api";

	@Autowired
	public RestTemplate restTemplate;
	
	@Override
	public List<Note> findAllNotes() {
		ResponseEntity<Note[]> response = null;
		response = restTemplate.getForEntity(NOTE_SERVICES_ENDPOINT+"/notes", Note[].class);
		List<Note> list = Arrays.asList(response.getBody());
		return list;
	}

	@Override
	public void saveNote(Note note) {
		HttpEntity<Note> request = new HttpEntity<>(note);
		ResponseEntity<Note> response = restTemplate.exchange(NOTE_SERVICES_ENDPOINT+"/notes", HttpMethod.POST, request, Note.class);
	}
}
