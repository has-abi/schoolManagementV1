package com.sm.schoolManagement.service.facade;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.sm.schoolManagement.bean.Matiere;

public interface MatiereService {
	Matiere findByid(Long id);
	List<Matiere> findAll();
	ResponseEntity<Matiere> save(Matiere matiere);
	ResponseEntity<Matiere> edit(Matiere matiere);
	int deleteById(Long id);
	public Page<Matiere> findAllWithPagination(int page, int size, String sort);
	Matiere findByLibelleAndNiveau(String libelle, String niveau);

}
