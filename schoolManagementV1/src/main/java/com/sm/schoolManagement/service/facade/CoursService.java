package com.sm.schoolManagement.service.facade;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.sm.schoolManagement.bean.Cours;

public interface CoursService {
	Cours findByid(Long id);
	List<Cours> findAll();
	ResponseEntity<Cours> save(Cours Cours);
	ResponseEntity<Cours> edit(Cours Cours);
	int deleteById(Long id);
	public Page<Cours> findAllWithPagination(int page, int size, String sort);
}
