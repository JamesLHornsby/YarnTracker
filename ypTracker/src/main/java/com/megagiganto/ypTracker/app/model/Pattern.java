package com.megagiganto.ypTracker.app.model;

import org.springframework.stereotype.Component;

import com.megagiganto.ypTracker.app.model.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Entity(name="PATTERN")
@Table(name="pattern")
public class Pattern {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "size")
	Integer size;
	
	@Column(name = "colors")
	String colors;
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getSize() {
		return size;
	}
	
	public void setSize(Integer size) {
		this.size = size;
	}
	
	public String getColors() {
		return colors;
	}
	
	public void setColors(String colors) {
		this.colors = colors;
	}
	
	


}
