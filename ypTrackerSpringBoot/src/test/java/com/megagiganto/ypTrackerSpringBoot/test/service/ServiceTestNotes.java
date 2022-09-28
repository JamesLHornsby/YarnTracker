package com.megagiganto.ypTrackerSpringBoot.test.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.megagiganto.ypTrackerSpringBoot.app.model.Note;
import com.megagiganto.ypTrackerSpringBoot.app.repository.NoteRepository;
import com.megagiganto.ypTrackerSpringBoot.app.service.NoteService;

public class ServiceTestNotes extends AbstractTestNGSpringContextTests {
	Note note = new Note();
	
	@Mock
	NoteRepository noteRepo;
	
	@InjectMocks
	NoteService noteService;
	
	@BeforeClass
	public void setup() {
		MockitoAnnotations.openMocks(this);
		note.setId(1);
		note.setContents("Here is a note.");
		
	}
	
	@AfterMethod
	@AfterClass
	public void tearDown() throws Exception {
		MockitoAnnotations.openMocks(this).close();
	}
	
	//Actual Note Tests
	
	@Test
	private void findAllNotes() {
		noteService.findAllNotes();
	}
	
	@Test
	private void saveNote_successfully() {
		when(noteRepo.save(any(Note.class))).thenReturn(note);
		Note noteReturn = noteService.saveNote(note);
		AssertJUnit.assertEquals(noteReturn.getId(), note.getId());
	}
	

}
