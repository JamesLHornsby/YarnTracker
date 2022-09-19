package com.megagiganto.ypTrackerSpringBoot.app.model;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Entity(name="YARN")
@Table(name="yarn")
@Getter @Setter
public class Yarn{
	
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
	

	
	public String toString() {
		return "YarnModelImpl [id=" + id + ", color=" + color + ", location=" + location + ", size=" + size
				+ ", length=" + length + "]";
	}
	
	
	
}
