package com.sm.schoolManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sm.schoolManagement.bean.Parent;

@Repository
public interface ParentDao extends JpaRepository<Parent, Long>,JpaSpecificationExecutor<Parent>{
	Parent findByCin(String cin);
}
