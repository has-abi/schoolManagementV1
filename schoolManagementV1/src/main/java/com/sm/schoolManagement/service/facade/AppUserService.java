package com.sm.schoolManagement.service.facade;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.sm.schoolManagement.bean.AppUser;

/**
 * 
 * @author Abida Hassan
 * @version 1.0
 *
 */
public interface AppUserService {
	AppUser findByUsername(String username);

	List<AppUser> findAll();

	Page<AppUser> findAllWithPagination(int page, int size, String sort);

	ResponseEntity<AppUser> create(AppUser appUser);

	ResponseEntity<AppUser> update(AppUser appUser);

	ResponseEntity<AppUser> delete(Long id);
	
	ResponseEntity<List<AppUser>> search(Specification<AppUser> spec);

}
