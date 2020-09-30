package com.sm.schoolManagement.service.facade;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.sm.schoolManagement.bean.Niveau;

public interface NiveauService {
	Niveau findByid(Long id);
	List<Niveau> findAll();
	ResponseEntity<Niveau> save(Niveau niveau);
	ResponseEntity<Niveau> edit(Niveau niveau);
	int deleteById(Long id);
	public Page<Niveau> findAllWithPagination(int page, int size, String sort);
}
