package com.megagiganto.ypTracker.app.model;

import org.springframework.stereotype.Component;

import com.megagiganto.ypTracker.api.model.Note;

@Component
public class NoteImpl {
	
	String contents;

	public NoteImpl() {
		
	}
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	@Override
	public String toString() {
		return "NoteImpl [contents=" + contents + "]";
	}


}
