package com.sm.schoolManagement.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sm.schoolManagement.bean.Devoir;
@Repository
public interface DevoirDao extends JpaRepository<Devoir, Long>{
	Optional<Devoir> findById(Long id);
	Devoir findByFileName(String fileName);
}
