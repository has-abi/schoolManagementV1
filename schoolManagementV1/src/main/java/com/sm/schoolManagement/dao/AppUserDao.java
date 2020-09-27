package com.sm.schoolManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sm.schoolManagement.bean.AppUser;

@Repository
public interface AppUserDao extends JpaRepository<AppUser, Long>,JpaSpecificationExecutor<AppUser> {
	AppUser findByUsername(String username);
}
