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
@Entity(name="NOTE")
@Table(name="NOTE")
@Getter @Setter
public class Note{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;
	
	@Column(name = "contents")
	String contents;

	public Note() {
		
	}

}
