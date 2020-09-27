package com.sm.schoolManagement.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sm.schoolManagement.bean.Niveau;
@Repository
public interface NiveauDao extends JpaRepository<Niveau, Long>{
	 Optional<Niveau> findById(Long id);
}
