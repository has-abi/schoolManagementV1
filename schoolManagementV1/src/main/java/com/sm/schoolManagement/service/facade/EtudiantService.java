package com.sm.schoolManagement.service.facade;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.sm.schoolManagement.bean.Etudiant;

/**
 * 
 * @author Abida Hassan
 * @version 1.0
 *
 */
public interface EtudiantService {

	Etudiant findByCne(String cne);

	List<Etudiant> findByParentCin(String cin);

	List<Etudiant> findAll();

	Page<Etudiant> findAllWithPagination(int page, int size, String sort);

	ResponseEntity<Etudiant> create(Etudiant etudiant);

	ResponseEntity<Etudiant> update(Etudiant etudiant);

	ResponseEntity<Etudiant> deleteByCne(String cne);

	ResponseEntity<List<Etudiant>> search(Specification<Etudiant> spec);
}
