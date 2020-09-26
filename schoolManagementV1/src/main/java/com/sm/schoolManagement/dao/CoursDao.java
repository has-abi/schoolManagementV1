package com.sm.schoolManagement.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sm.schoolManagement.bean.Cours;
@Repository
public interface CoursDao extends JpaRepository<Cours, Long>{
	Optional<Cours> findById(Long id);

}
