package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.PropertyValue;

public interface PropertyValueService {

	void init(Product p);
	void update(PropertyValue pv);
	
	PropertyValue get(int pid, int ptid);
	List<PropertyValue> list(int pid);
}
