package com.sm.schoolManagement.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

/**
 * 
 * @author Abida Hassan
 * @version 1.0
 *
 */
@Service
public class EtudiantServiceImpl implements EtudiantService {
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
		if (sort == "desc") {
			return etudiantDao.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id")));
		} else {
			return etudiantDao.findAll(PageRequest.of(page, size));
		}
	}
	public int listeDesEtudiantsExcel() {
		Workbook workbook = new XSSFWorkbook();
	      Sheet sheet = workbook.createSheet("Liste employes");
		List<Etudiant> etudiants = findAll();
		Row header = sheet.createRow(0);
	      header.createCell(0).setCellValue("etudiant cne");
	      header.createCell(1).setCellValue("parent cin");
	  
	      int rowNum = 1;
	     for (Etudiant etudiant : etudiants) {
	         Row row = sheet.createRow(rowNum++);
	         row.createCell(0).setCellValue(etudiant.getCne());
	         row.createCell(1).setCellValue(etudiant.getParent().getCin());
		}
	     String fileLocation = "C:/Users/hp/Desktop/";
	     try {
		     FileOutputStream outputStream = new FileOutputStream("Liste etudiant.xlsx");
			workbook.write(outputStream);
		     workbook.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	     return 1;
	}


	@Override
	public ResponseEntity<Etudiant> create(Etudiant etudiant) {
		Parent foundedParent = parentService.findByCin(etudiant.getParent().getCin());
		if (etudiant.getCne() == null || etudiant.getCne() == "")
			throw new EmptyElementException("CNE est obligatoire!");
		else if (foundedParent == null)
			throw new NotFoundException("parent invalid!");
		else {
			Etudiant foundedEtudiant = findByCne(etudiant.getCne());
			if (foundedEtudiant != null)
				throw new AlreadyExistsException("un étudiant(e) avec ce CNE est dèjà existe!");

			else {
				etudiant.setAppUser(appUserService.create(etudiant.getAppUser()).getBody());
				etudiant.setParent(foundedParent);
				Etudiant inserted = etudiantDao.save(etudiant);
				if (inserted == null)
					throw new NotPersistedException("on ne peut pas enregistrer l'étudiant(e)");
				else
					return new ResponseEntity<Etudiant>(inserted, HttpStatus.OK);
			}
		}
	}

	@Override
	public ResponseEntity<Etudiant> update(Etudiant etudiant) {
		if (etudiant.getCne() == null || etudiant.getCne() == "")
			throw new EmptyElementException("CNE est obligatoire!");
		else {
			Etudiant foundedEtudiant = findByCne(etudiant.getCne());
			if (foundedEtudiant == null)
				throw new NotFoundException("Aucun étudiant(e) avec ce CNE!");
			etudiant.setAppUser(appUserService.findByUsername(etudiant.getAppUser().getUsername()));
			etudiant.setParent(parentService.findByCin(etudiant.getParent().getCin()));

			Etudiant updated = etudiantDao.save(etudiant);
			if (updated == null)
				throw new NotUpdatedException("on ne peut pas modifié l'étudiant(e)");
			else
				return new ResponseEntity<Etudiant>(updated, HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<Etudiant> deleteByCne(String cne) {
		Etudiant foundedEtudiant = findByCne(cne);
		if (foundedEtudiant == null)
			throw new NotFoundException("Aucun étudiant(e) avec ce CNE!");
		else {
			etudiantDao.delete(foundedEtudiant);
			if (etudiantDao.existsById(foundedEtudiant.getId()))
				throw new NotDeletedException("on ne peut pas supprimé l'étudiant(e)");
			else
				return new ResponseEntity<Etudiant>(foundedEtudiant, HttpStatus.OK);
		}

	}

	@Override
	public ResponseEntity<List<Etudiant>> search(Specification<Etudiant> spec) {
		return new ResponseEntity<List<Etudiant>>(etudiantDao.findAll(Specification.where(spec)), HttpStatus.OK);
	}

}
