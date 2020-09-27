package com.sm.schoolManagement.service.facade;

import java.util.List;

import com.sm.schoolManagement.bean.Matiere;

public interface MatiereService {
	Matiere findByid(Long id);
	List<Matiere> findAll();
	int save(Matiere matiere);
	int edit(Matiere matiere);
	int deleteById(Long id);
}
