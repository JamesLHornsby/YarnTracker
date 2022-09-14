package com.megagiganto.ypTracker.app.model;

import org.springframework.stereotype.Component;

import com.megagiganto.ypTracker.api.model.Note;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Entity(name="NOTE")
@Table(name="NOTE")
public class NoteImpl{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;
	
	@Column(name = "contents")
	String contents;

	public NoteImpl() {
		
	}
	
	//@Override
	public String getContents() {
		return contents;
	}
	
	//@Override
	public void setContents(String contents) {
		this.contents = contents;
	}

	//@Override
	public Integer getId() {
		return id;
	}
	
	//@Override
	public void setId(Integer id) {
		this.id = id;
	}

	//@Override
	public String toString() {
		return "NoteImpl [contents=" + contents + "]";
	}

}
