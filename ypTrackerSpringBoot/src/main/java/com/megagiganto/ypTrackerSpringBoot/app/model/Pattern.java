package com.megagiganto.ypTrackerSpringBoot.app.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Entity(name="PATTERN")
@Table(name="pattern")
@Getter @Setter
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

	@Override
	public String toString() {
		return "Pattern [id=" + id + ", name=" + name + ", size=" + size + ", colors=" + colors + "]";
	}
	


}
