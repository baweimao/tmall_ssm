package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.Property;

public interface PropertyService {

	void add(Property p);
	
	void delete(int id);
	
	void update(Property p);
	
	Property get(int id);
	
	List list(int cid);
}
