package com.sm.schoolManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.schoolManagement.bean.Maitre;
import com.sm.schoolManagement.dao.MaitreDao;
import com.sm.schoolManagement.service.facade.MaitreService;

@Service
public class MaitreServiceImpl implements MaitreService{
@Autowired
private MaitreDao coursDao;

@Override
public Maitre findByid(Long id) {
	return coursDao.findById(id).get();
}

@Override
public List<Maitre> findAll() {
	return coursDao.findAll();
}

@Override
public int save(Maitre Maitre) {
	if(Maitre.getId() != null) {
		return -1;
	}else {
		coursDao.save(Maitre);
		return 1;
	}
}
@Override
public int edit(Maitre maitre) {
	if(maitre.getId() == null) {
		return -1;
	}else {
		coursDao.save(maitre);
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
