package com.sm.schoolManagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sm.schoolManagement.bean.MatiereItem;
@Repository
public interface MatiereItemDao extends JpaRepository<MatiereItem, Long>{
	Optional<MatiereItem> findById(Long id);
	List<MatiereItem> findByMatiereNiveauLibelle(String libelle);
}
