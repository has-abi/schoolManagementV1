package com.sm.schoolManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sm.schoolManagement.bean.Professeur;

/**
 * 
 * @author Abida Hassan
 * @version 1.0
 *
 */
@Repository
public interface ProfesseurDao extends JpaRepository<Professeur, Long>, JpaSpecificationExecutor<Professeur> {
	Professeur findByCin(String cin);
}
