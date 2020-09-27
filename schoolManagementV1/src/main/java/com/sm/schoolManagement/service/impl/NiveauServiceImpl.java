package com.sm.schoolManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.schoolManagement.bean.Niveau;
import com.sm.schoolManagement.dao.NiveauDao;
import com.sm.schoolManagement.service.facade.NiveauService;

@Service
public class NiveauServiceImpl implements NiveauService{
@Autowired
private NiveauDao coursDao;

@Override
public Niveau findByid(Long id) {
	return coursDao.findById(id).get();
}

@Override
public List<Niveau> findAll() {
	return coursDao.findAll();
}

@Override
public int save(Niveau niveau) {
	if(niveau.getId() != null) {
		return -1;
	}else {
		coursDao.save(niveau);
		return 1;
	}
}
@Override
public int edit(Niveau niveau) {
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
