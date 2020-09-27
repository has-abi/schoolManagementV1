package com.sm.schoolManagement.service.facade;

import java.util.List;

import com.sm.schoolManagement.bean.Devoir;

public interface DevoirService {
	Devoir findByid(Long id);
	List<Devoir> findAll();
	int save(Devoir devoir);
	int edit(Devoir devoir);
	int deleteById(Long id);
}
