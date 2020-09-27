package com.sm.schoolManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.schoolManagement.bean.Matiere;
import com.sm.schoolManagement.dao.MatiereDao;
import com.sm.schoolManagement.service.facade.MatiereService;

@Service
public class MatiereServiceImpl implements MatiereService{
@Autowired
private MatiereDao coursDao;

@Override
public Matiere findByid(Long id) {
	return coursDao.findById(id).get();
}

@Override
public List<Matiere> findAll() {
	return coursDao.findAll();
}

@Override
public int save(Matiere niveau) {
	if(niveau.getId() != null) {
		return -1;
	}else {
		coursDao.save(niveau);
		return 1;
	}
}
@Override
public int edit(Matiere niveau) {
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
