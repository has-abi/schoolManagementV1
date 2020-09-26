package com.sm.schoolManagement.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sm.schoolManagement.bean.Maitre;
@Repository
public interface MaitreDao extends JpaRepository<Maitre, Long>{
	Optional<Maitre> findById(Long id);

}
