package com.megagiganto.ypTracker.api.model;

import java.math.BigDecimal;

public interface Yarn {

	Integer getId();

	void setId(Integer id);

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