package com.sm.schoolManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sm.schoolManagement.bean.AppUser;
import com.sm.schoolManagement.bean.Matiere;
import com.sm.schoolManagement.bean.MatiereItem;
import com.sm.schoolManagement.dao.MatiereItemDao;
import com.sm.schoolManagement.exception.AlreadyExistsException;
import com.sm.schoolManagement.exception.NotFoundException;
import com.sm.schoolManagement.service.facade.CoursService;
import com.sm.schoolManagement.service.facade.LocalService;
import com.sm.schoolManagement.service.facade.MatiereItemService;
import com.sm.schoolManagement.service.facade.MatiereService;

@Service
public class MatiereItemServiceImpl implements MatiereItemService{
@Autowired
private MatiereItemDao coursDao;
@Autowired
private MatiereService matiereService;
@Autowired
private CoursService coursService;
@Autowired
private LocalService localService;

@Override
public MatiereItem findByid(Long id) {
	return coursDao.findById(id).get();
}

@Override
public List<MatiereItem> findAll() {
	return coursDao.findAll();
}

@Override
public ResponseEntity<MatiereItem> save(MatiereItem niveau) {
	if(niveau.getId() != null) {
		return null;
	}else {
		if(findByid(niveau.getId()) != null) {
			throw new AlreadyExistsException("une matiereItem avec cette Id est dèjà existe!");
		}else if(matiereService.findByid(niveau.getMatiere().getId())== null) {
			throw new NotFoundException("la matiere selectionné dans cette matiere Item n'existe pas!");
		}else if(coursService.findByid(niveau.getCours().getId())==null) {
			throw new NotFoundException("le cours selectionné dans cette matiere Item n'existe pas!");
		}else  if(localService.findByid(niveau.getLocal().getId())==null) {
			throw new NotFoundException("le local selectionné dans cette matiere Item n'existe pas!");
		}else {
			niveau.setLocal(localService.findByid(niveau.getLocal().getId()));
			niveau.setCours(coursService.findByid(niveau.getCours().getId()));
			niveau.setMatiere(matiereService.findByid(niveau.getMatiere().getId()));
			return  new ResponseEntity<MatiereItem>(coursDao.save(niveau), HttpStatus.OK);												
	}
}
}
@Override
public Page<MatiereItem> findAllWithPagination(int page, int size, String sort) {
	if (sort == "desc") {
		return coursDao.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id")));
	} else {
		return coursDao.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "id")));
	}
}
@Override
public ResponseEntity<MatiereItem> edit(MatiereItem niveau) {
	if(niveau.getId() == null) {
		return null;
	}else {
		if(findByid(niveau.getId()) == null) {
			throw new AlreadyExistsException("une matiereItem avec cette Id n'existe pas!");
		}else if(matiereService.findByid(niveau.getMatiere().getId())== null) {
			throw new NotFoundException("la matiere selectionné dans cette matiere Item n'existe pas!");
		}else if(coursService.findByid(niveau.getCours().getId())==null) {
			throw new NotFoundException("le cours selectionné dans cette matiere Item n'existe pas!");
		}else  if(localService.findByid(niveau.getLocal().getId())==null) {
			throw new NotFoundException("le local selectionné dans cette matiere Item n'existe pas!");
		}else {
			niveau.setLocal(localService.findByid(niveau.getLocal().getId()));
			niveau.setCours(coursService.findByid(niveau.getCours().getId()));
			niveau.setMatiere(matiereService.findByid(niveau.getMatiere().getId()));
		return new ResponseEntity<MatiereItem>(coursDao.save(niveau), HttpStatus.OK);
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
public List<MatiereItem> findByMatiereNiveauLibelle(String libelle) {
	return coursDao.findByMatiereNiveauLibelle(libelle);
}
}
