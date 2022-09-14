package com.megagiganto.ypTracker.app.model;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.megagiganto.ypTracker.api.model.Yarn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Entity(name="YARN")
@Table(name="yarn")
public class YarnImpl implements Yarn{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;
	
	@Column(name = "color")
	String color;
	
	@Column(name = "location")
	String location;
	
	@Column(name = "size")
	Integer size;
	
	@Column(name = "length")
	BigDecimal length;
	
	@Override
	public Integer getId() {
		return id;
	}
	@Override
	public void setId(Integer id) {
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
