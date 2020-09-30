package com.sm.schoolManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sm.schoolManagement.bean.Niveau;
import com.sm.schoolManagement.bean.Niveau;
import com.sm.schoolManagement.dao.NiveauDao;
import com.sm.schoolManagement.exception.AlreadyExistsException;
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
public ResponseEntity<Niveau> save(Niveau niveau) {
	if(niveau.getId() != null) {
		return null;
	}else {
		if(findByid(niveau.getId()) != null) {
			throw new AlreadyExistsException("un niveau avec cette Id est dèjà existe!");
		}else {
			return  new ResponseEntity<Niveau>(coursDao.save(niveau), HttpStatus.OK);			
		}
	}
}
@Override
public Page<Niveau> findAllWithPagination(int page, int size, String sort) {
	if (sort == "desc") {
		return coursDao.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id")));
	} else {
		return coursDao.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "id")));
	}
}
@Override
public ResponseEntity<Niveau> edit(Niveau niveau) {
	if(niveau.getId() == null) {
		return null;
	}else {
		if(findByid(niveau.getId()) == null) {
			throw new AlreadyExistsException("un niveau avec cette Id n'existe pas!");
		}else
		return new ResponseEntity<Niveau>(coursDao.save(niveau), HttpStatus.OK);
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
