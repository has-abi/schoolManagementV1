package com.sm.schoolManagement.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sm.schoolManagement.bean.Matiere;
@Repository
public interface MatiereDao extends JpaRepository<Matiere, Long>{
	Optional<Matiere> findById(Long id);
	Matiere findByLibelleAndNiveau(String libelle, String niveau);
}
