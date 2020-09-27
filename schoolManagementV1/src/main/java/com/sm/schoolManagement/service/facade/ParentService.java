package com.sm.schoolManagement.service.facade;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.sm.schoolManagement.bean.Parent;

public interface ParentService {
	Parent findByCin(String cin);
	
	List<Parent> findAll();
	
	Page<Parent> findAllWithPagination(int page,int size,String sort);
	
	ResponseEntity<Parent> Create(Parent parent);
	
	ResponseEntity<Parent> update(Parent parent);
	
	ResponseEntity<Parent> deleteByCin(String Cin);
	
	ResponseEntity<List<Parent>> search(Specification<Parent> spec);
}
