package com.sm.schoolManagement.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sm.schoolManagement.bean.Local;
@Repository
public interface LocalDao extends JpaRepository<Local, Long>{
	Optional<Local> findById(Long id);

}
