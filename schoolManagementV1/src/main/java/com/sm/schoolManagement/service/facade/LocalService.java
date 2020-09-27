package com.sm.schoolManagement.service.facade;

import java.util.List;

import com.sm.schoolManagement.bean.Local;

public interface LocalService {
	Local findByid(Long id);
	List<Local> findAll();
	int save(Local local);
	int edit(Local local);
	int deleteById(Long id);
}
