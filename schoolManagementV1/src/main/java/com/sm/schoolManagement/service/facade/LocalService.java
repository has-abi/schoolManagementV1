package com.sm.schoolManagement.service.facade;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.sm.schoolManagement.bean.Local;
import com.sm.schoolManagement.bean.Local;

public interface LocalService {
	Local findByid(Long id);
	List<Local> findAll();
	ResponseEntity<Local> save(Local niveau);
	ResponseEntity<Local> edit(Local niveau);
	int deleteById(Long id);
	public Page<Local> findAllWithPagination(int page, int size, String sort);
}
