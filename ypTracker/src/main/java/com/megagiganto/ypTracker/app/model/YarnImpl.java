package com.megagiganto.ypTracker.app.model;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.megagiganto.ypTracker.api.model.Yarn;

@Component
public class YarnImpl implements Yarn{
	
	Long id;
	String color;
	String location;
	Integer size;
	BigDecimal length;
	
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String getColor() {
		return color;
	}
	@Override
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String getLocation() {
		return location;
	}
	@Override
	public void setLocation(String location) {
		this.location = location;
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
	public BigDecimal getLength() {
		return length;
	}
	@Override
	public void setLength(BigDecimal length) {
		this.length = length;
	}
	
	@Override
	public String toString() {
		return "YarnModelImpl [id=" + id + ", color=" + color + ", location=" + location + ", size=" + size
				+ ", length=" + length + "]";
	}
	
	
	
}
