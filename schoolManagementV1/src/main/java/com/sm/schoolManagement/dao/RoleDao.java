package com.sm.schoolManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sm.schoolManagement.bean.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, Long>,JpaSpecificationExecutor<Role> {
	Role findByLibelle(String libelle);
}
