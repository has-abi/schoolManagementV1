package com.sm.schoolManagement.service.facade;

import java.util.List;

import com.sm.schoolManagement.bean.User;

public interface UserService {
	User findByid(Long id);
	List<User> findAll();
	int save(User user);
	int edit(User user);
	int deleteById(Long id);
}
