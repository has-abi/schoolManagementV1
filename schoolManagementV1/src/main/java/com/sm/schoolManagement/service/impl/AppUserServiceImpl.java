package com.sm.schoolManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sm.schoolManagement.bean.AppUser;
import com.sm.schoolManagement.dao.AppUserDao;
import com.sm.schoolManagement.service.facade.AppUserService;

/**
 * 
 * @author Abida Hassan
 * @version 1.0
 *
 */
@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	private AppUserDao appUserDao;

	@Override
	public AppUser findByUsername(String username) {
		return appUserDao.findByUsername(username);
	}

	@Override
	public List<AppUser> findAll() {
		return appUserDao.findAll();
	}

	@Override
	public Page<AppUser> findAllWithPagination(int page, int size, String sort) {
		if (sort == "desc") {
			return appUserDao.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id")));
		} else {
			return appUserDao.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "id")));
		}
	}

	@Override
	public ResponseEntity<AppUser> create(AppUser appUser) {
		return null;
	}

	@Override
	public ResponseEntity<AppUser> update(AppUser appUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<AppUser> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<AppUser>> search(Specification<AppUser> spec) {
		return new ResponseEntity<List<AppUser>>(appUserDao.findAll(Specification.where(spec)), HttpStatus.OK);
	}

}
