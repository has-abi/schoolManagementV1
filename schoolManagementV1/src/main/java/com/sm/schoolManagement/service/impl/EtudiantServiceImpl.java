package com.sm.schoolManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sm.schoolManagement.bean.Etudiant;
import com.sm.schoolManagement.bean.Parent;
import com.sm.schoolManagement.dao.EtudiantDao;
import com.sm.schoolManagement.exception.AlreadyExistsException;
import com.sm.schoolManagement.exception.EmptyElementException;
import com.sm.schoolManagement.exception.NotDeletedException;
import com.sm.schoolManagement.exception.NotFoundException;
import com.sm.schoolManagement.exception.NotPersistedException;
import com.sm.schoolManagement.exception.NotUpdatedException;
import com.sm.schoolManagement.service.facade.AppUserService;
import com.sm.schoolManagement.service.facade.EtudiantService;
import com.sm.schoolManagement.service.facade.ParentService;
@Service
public class EtudiantServiceImpl implements EtudiantService{
	@Autowired
	private EtudiantDao etudiantDao;
	@Autowired
	private AppUserService appUserService;
	@Autowired
	private ParentService parentService;
	@Override
	public Etudiant findByCne(String cne) {
		return etudiantDao.findByCne(cne);
	}

	@Override
	public List<Etudiant> findByParentCin(String cin) {
		return etudiantDao.findByParentCin(cin);
	}

	@Override
	public List<Etudiant> findAll() {
		return etudiantDao.findAll();
	}

	@Override
	public Page<Etudiant> findAllWithPagination(int page, int size, String sort) {
		if(sort == "desc") {
			return etudiantDao.findAll(PageRequest.of(page, size,Sort.by(Sort.Direction.DESC,"id")));
		}else {
			return etudiantDao.findAll(PageRequest.of(page, size));
		}
	}

	@Override
	public ResponseEntity<Etudiant> create(Etudiant etudiant) {
		Parent foundedParent = parentService.findByCin(etudiant.getParent().getCin());
		if(etudiant.getCne() == null || etudiant.getCne() == "") throw new EmptyElementException("CNE est obligatoire!");
		else if(foundedParent == null) throw new NotFoundException("parent invalid!");
		else {
			Etudiant foundedEtudiant = findByCne(etudiant.getCne());
			if(foundedEtudiant != null) throw new AlreadyExistsException("un étudiant(e) avec ce CNE est dèjà existe!");
			
			else {
					etudiant.setAppUser(appUserService.create(etudiant.getAppUser()).getBody());
					etudiant.setParent(foundedParent);
					Etudiant inserted = etudiantDao.save(etudiant);
					if(inserted == null)  throw new NotPersistedException("on ne peut pas enregistrer l'étudiant(e)");
					else return new ResponseEntity<Etudiant>(inserted,HttpStatus.OK);
			}
		}
	}

	@Override
	public ResponseEntity<Etudiant> update(Etudiant etudiant) {
		if(etudiant.getCne() == null || etudiant.getCne() == "") throw new EmptyElementException("CNE est obligatoire!");
		else {
			Etudiant foundedEtudiant = findByCne(etudiant.getCne());
			if(foundedEtudiant == null) throw new NotFoundException("Aucun étudiant(e) avec ce CNE!");
			etudiant.setAppUser(appUserService.findByUsername(etudiant.getAppUser().getUsername()));
			etudiant.setParent(parentService.findByCin(etudiant.getParent().getCin()));
			
			Etudiant updated = etudiantDao.save(etudiant);
			if(updated == null)  throw new NotUpdatedException("on ne peut pas modifié l'étudiant(e)");
			else return new ResponseEntity<Etudiant>(updated,HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<Etudiant> deleteByCne(String cne) {
		Etudiant foundedEtudiant = findByCne(cne);
		if(foundedEtudiant == null) throw new NotFoundException("Aucun étudiant(e) avec ce CNE!");
		else {
			etudiantDao.delete(foundedEtudiant);
			if(etudiantDao.existsById(foundedEtudiant.getId())) throw new NotDeletedException("on ne peut pas supprimé l'étudiant(e)");
			else return new ResponseEntity<Etudiant>(foundedEtudiant,HttpStatus.OK);
		}
		
	}

	@Override
	public ResponseEntity<List<Etudiant>> search(Specification<Etudiant> spec) {
		return new ResponseEntity<List<Etudiant>>(etudiantDao.findAll(Specification.where(spec)),HttpStatus.OK);
	}

}
