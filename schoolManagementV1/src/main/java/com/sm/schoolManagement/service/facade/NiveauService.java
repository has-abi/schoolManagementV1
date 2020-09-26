package com.sm.schoolManagement.service.facade;

import java.util.List;

import com.sm.schoolManagement.bean.Niveau;

public interface NiveauService {
	Niveau findByid(Long id);
	List<Niveau> findAll();
	int save(Niveau niveau);
	int edit(Niveau niveau);
	int deleteById(Long id);
}
