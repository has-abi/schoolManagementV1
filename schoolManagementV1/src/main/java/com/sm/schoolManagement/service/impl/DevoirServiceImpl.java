package com.sm.schoolManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.schoolManagement.bean.Devoir;
import com.sm.schoolManagement.dao.DevoirDao;
import com.sm.schoolManagement.service.facade.DevoirService;

@Service
public class DevoirServiceImpl implements DevoirService{
@Autowired
private DevoirDao coursDao;

@Override
public Devoir findByid(Long id) {
	return coursDao.findById(id).get();
}

@Override
public List<Devoir> findAll() {
	return coursDao.findAll();
}

@Override
public int save(Devoir niveau) {
	if(niveau.getId() != null) {
		return -1;
	}else {
		coursDao.save(niveau);
		return 1;
	}
}
@Override
public int edit(Devoir niveau) {
	if(niveau.getId() == null) {
		return -1;
	}else {
		coursDao.save(niveau);
		return 1;
	}
}

@Override
public int deleteById(Long id) {
	coursDao.deleteById(id);
	if(this.findByid(id) != null) {
		return -1;
	}else {
		return 1;		
	}
}
}
