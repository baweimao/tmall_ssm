package com.how2java.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.mapper.PropertyValueMapper;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.pojo.PropertyExample;
import com.how2java.tmall.pojo.PropertyValue;
import com.how2java.tmall.pojo.PropertyValueExample;
import com.how2java.tmall.service.PropertyService;
import com.how2java.tmall.service.PropertyValueService;

@Service
public class PropertyValueServiceImpl implements PropertyValueService{
	
	@Autowired
	PropertyValueMapper propertyValueMapper;
	
	@Autowired
	PropertyService propertyService;
	
	@Override
	public PropertyValue get(int pid, int ptid) {
		PropertyValueExample example = new PropertyValueExample();
		example.createCriteria().andPidEqualTo(pid).andPtidEqualTo(ptid);
		List<PropertyValue> pvs = propertyValueMapper.selectByExample(example);
		if(pvs.isEmpty())
			return null;
		return pvs.get(0);
	}
	
	@Override
	public List<PropertyValue> list(int pid) {
		PropertyValueExample example = new PropertyValueExample();
		example.createCriteria().andPidEqualTo(pid);
		List<PropertyValue> result = propertyValueMapper.selectByExample(example);
		for (PropertyValue pv : result) {
			Property property = propertyService.get(pv.getPtid());
			pv.setProperty(property);
		}
		return result;
	}
	
	@Override
	public void init(Product p) {
		List<Property> pts = propertyService.list(p.getCid());
		
		for(Property pt : pts) {
			PropertyValue pv = get(p.getId(), pt.getId());
			if(null==pv) {
				pv = new PropertyValue();
				pv.setPid(p.getId());
				pv.setPtid(pt.getId());
				propertyValueMapper.insert(pv);
			}
		}
	}
	
	@Override
	public void update(PropertyValue pv) {
		propertyValueMapper.updateByPrimaryKeySelective(pv);
		
	}
}
