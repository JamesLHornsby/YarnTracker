package com.megagiganto.ypTracker.app.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.megagiganto.ypTracker.api.model.Pattern;

@Component
public class PatternImpl implements Pattern {
	
	Long id;
	String name;
	Integer size;
	String colors;
	
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
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
