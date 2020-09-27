package com.sm.schoolManagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sm.schoolManagement.bean.Etudiant;


/**
 * 
 * @author Abida Hassan
 * @version 1.0
 *
 */
@Repository
public interface EtudiantDao extends JpaRepository<Etudiant, Long>, JpaSpecificationExecutor<Etudiant> {
	Etudiant findByCne(String cne);

	List<Etudiant> findByParentCin(String cin);
}
