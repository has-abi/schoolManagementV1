package com.sm.schoolManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sm.schoolManagement.bean.Matiere;
import com.sm.schoolManagement.bean.Matiere;
import com.sm.schoolManagement.dao.MatiereDao;
import com.sm.schoolManagement.exception.AlreadyExistsException;
import com.sm.schoolManagement.service.facade.MatiereService;
import com.sm.schoolManagement.service.facade.NiveauService;

@Service
public class MatiereServiceImpl implements MatiereService{
@Autowired
private MatiereDao coursDao;
@Autowired
private NiveauService niveauService;

@Override
public Matiere findByid(Long id) {
	return coursDao.findById(id).get();
}

@Override
public List<Matiere> findAll() {
	return coursDao.findAll();
}

@Override
public ResponseEntity<Matiere> save(Matiere niveau) {
	if(niveau.getId() != null) {
		return null;
	}else {
		if(findByid(niveau.getId()) != null) {
			throw new AlreadyExistsException("une matiere avec cette Id est dèjà existe!");
		}else if(niveauService.findByid(niveau.getNiveau().getId()) == null) {
			throw new AlreadyExistsException("le niveau selectionné dans cette Matiere n'existe pas!");
		}else {
			niveau.setNiveau(niveauService.findByid(niveau.getNiveau().getId()));
			return  new ResponseEntity<Matiere>(coursDao.save(niveau), HttpStatus.OK);			
		}
	}
}
@Override
public Page<Matiere> findAllWithPagination(int page, int size, String sort) {
	if (sort == "desc") {
		return coursDao.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id")));
	} else {
		return coursDao.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "id")));
	}
}
@Override
public ResponseEntity<Matiere> edit(Matiere niveau) {
	if(niveau.getId() == null) {
		return null;
	}else {
		if(findByid(niveau.getId()) == null) {
			throw new AlreadyExistsException("une matiere avec cette Id n'existe pas!");
		}else if(niveauService.findByid(niveau.getNiveau().getId()) == null) {
			throw new AlreadyExistsException("le niveau selectionné dans cette Matiere n'existe pas!");
		}else {
			niveau.setNiveau(niveauService.findByid(niveau.getNiveau().getId()));
			return new ResponseEntity<Matiere>(coursDao.save(niveau), HttpStatus.OK);			
		}
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

@Override
public Matiere findByLibelleAndNiveau(String libelle, String niveau) {
	return coursDao.findByLibelleAndNiveau(libelle, niveau);
}
}
