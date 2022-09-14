package com.megagiganto.ypTracker.app.model;

import org.springframework.stereotype.Component;

import com.megagiganto.ypTracker.api.model.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Entity(name="PATTERN")
@Table(name="pattern")
public class PatternImpl implements Pattern {
	
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
	
	@Override
	public Integer getId() {
		return id;
	}
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public Integer getSize() {
		return size;
	}
	@Override
	public void setSize(Integer size) {
		this.size = size;
	}
	@Override
	public String getColors() {
		return colors;
	}
	@Override
	public void setColors(String colors) {
		this.colors = colors;
	}
	
	


}
