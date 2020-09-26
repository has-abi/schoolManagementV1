package com.sm.schoolManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.schoolManagement.bean.Local;
import com.sm.schoolManagement.dao.LocalDao;
import com.sm.schoolManagement.service.facade.LocalService;

@Service
public class LocalServiceImpl implements LocalService{
@Autowired
private LocalDao coursDao;

@Override
public Local findByid(Long id) {
	return coursDao.findById(id).get();
}

@Override
public List<Local> findAll() {
	return coursDao.findAll();
}

@Override
public int save(Local niveau) {
	if(niveau.getId() != null) {
		return -1;
	}else {
		coursDao.save(niveau);
		return 1;
	}
}
@Override
public int edit(Local niveau) {
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
