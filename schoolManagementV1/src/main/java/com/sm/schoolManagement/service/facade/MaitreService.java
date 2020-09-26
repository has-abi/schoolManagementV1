package com.sm.schoolManagement.service.facade;

import java.util.List;

import com.sm.schoolManagement.bean.Maitre;

public interface MaitreService {
	Maitre findByid(Long id);
	List<Maitre> findAll();
	int save(Maitre maitre);
	int edit(Maitre maitre);
	int deleteById(Long id);
}
