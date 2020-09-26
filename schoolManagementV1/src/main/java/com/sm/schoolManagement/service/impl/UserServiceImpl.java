package com.sm.schoolManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.schoolManagement.bean.User;
import com.sm.schoolManagement.dao.UserDao;
import com.sm.schoolManagement.service.facade.UserService;

@Service
public class UserServiceImpl implements UserService{
@Autowired
private UserDao coursDao;

@Override
public User findByid(Long id) {
	return coursDao.findById(id).get();
}

@Override
public List<User> findAll() {
	return coursDao.findAll();
}

@Override
public int save(User niveau) {
	if(niveau.getId() != null) {
		return -1;
	}else {
		coursDao.save(niveau);
		return 1;
	}
}
@Override
public int edit(User niveau) {
	if(niveau.getId() == null) {
		return -1;
	}else {
		coursDao.save(niveau);
		return 1;
	}
}

@Override
public int deleteById(Long id) {
	coursDao.deleteById(id);
	if(this.findByid(id) != null) {
		return -1;
	}else {
		return 1;		
	}
}
}
