package com.megagiganto.ypTracker.app.model;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Entity(name="YARN")
@Table(name="yarn")
public class Yarn {
	
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
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public BigDecimal getLength() {
		return length;
	}

	public void setLength(BigDecimal length) {
		this.length = length;
	}
	

	public String toString() {
		return "YarnModelImpl [id=" + id + ", color=" + color + ", location=" + location + ", size=" + size
				+ ", length=" + length + "]";
	}
	
	
	
}
