package com.megagiganto.ypTracker.api.model;

import java.math.BigDecimal;

public interface Yarn {

	Long getId();

	void setId(Long id);

	String getColor();

	void setColor(String color);

	String getLocation();

	void setLocation(String location);

	Integer getSize();

	void setSize(Integer size);

	BigDecimal getLength();

	void setLength(BigDecimal length);

	String toString();

}