package com.sm.schoolManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.schoolManagement.bean.MatiereItem;
import com.sm.schoolManagement.dao.MatiereItemDao;
import com.sm.schoolManagement.service.facade.MatiereItemService;

@Service
public class MatiereItemServiceImpl implements MatiereItemService{
@Autowired
private MatiereItemDao coursDao;

@Override
public MatiereItem findByid(Long id) {
	return coursDao.findById(id).get();
}

@Override
public List<MatiereItem> findAll() {
	return coursDao.findAll();
}

@Override
public int save(MatiereItem niveau) {
	if(niveau.getId() != null) {
		return -1;
	}else {
		coursDao.save(niveau);
		return 1;
	}
}
@Override
public int edit(MatiereItem niveau) {
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
