package com.sm.schoolManagement.service.facade;

import java.util.List;

import com.sm.schoolManagement.bean.Cours;

public interface CoursService {
	Cours findByid(Long id);
	List<Cours> findAll();
	int save(Cours Cours);
	int edit(Cours Cours);
	int deleteById(Long id);
}
