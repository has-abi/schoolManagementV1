package com.sm.schoolManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sm.schoolManagement.bean.Cours;
import com.sm.schoolManagement.bean.Cours;
import com.sm.schoolManagement.dao.CoursDao;
import com.sm.schoolManagement.exception.AlreadyExistsException;
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
public ResponseEntity<Cours> save(Cours niveau) {
	if(niveau.getId() != null) {
		return null;
	}else {
		if(findByid(niveau.getId()) != null) {
			throw new AlreadyExistsException("un cours avec cette Id est dèjà existe!");
		}else {
			return  new ResponseEntity<Cours>(coursDao.save(niveau), HttpStatus.OK);			
		}
	}
}
@Override
public Page<Cours> findAllWithPagination(int page, int size, String sort) {
	if (sort == "desc") {
		return coursDao.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id")));
	} else {
		return coursDao.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "id")));
	}
}
@Override
public ResponseEntity<Cours> edit(Cours niveau) {
	if(niveau.getId() == null) {
		return null;
	}else {
		if(findByid(niveau.getId()) == null) {
			throw new AlreadyExistsException("un cours avec cette Id n'existe pas!");
		}else
		return new ResponseEntity<Cours>(coursDao.save(niveau), HttpStatus.OK);
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
