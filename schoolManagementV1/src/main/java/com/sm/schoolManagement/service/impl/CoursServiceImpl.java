package com.sm.schoolManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.schoolManagement.bean.Cours;
import com.sm.schoolManagement.dao.CoursDao;
import com.sm.schoolManagement.service.facade.CoursService;

@Service
public class CoursServiceImpl implements CoursService{
@Autowired
private CoursDao coursDao;

@Override
public Cours findByid(Long id) {
	return coursDao.findById(id).get();
}

@Override
public List<Cours> findAll() {
	return coursDao.findAll();
}

@Override
public int save(Cours Cours) {
	if(Cours.getId() != null) {
		return -1;
	}else {
		coursDao.save(Cours);
		return 1;
	}
}
@Override
public int edit(Cours Cours) {
	if(Cours.getId() == null) {
		return -1;
	}else {
		coursDao.save(Cours);
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
