package com.sm.schoolManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sm.schoolManagement.bean.Manager;

@Repository
public interface ManagerDao extends JpaRepository<Manager, Long>,JpaSpecificationExecutor<Manager>{
	Manager findByCin(String cin);
}
