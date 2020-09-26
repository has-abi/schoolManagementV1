package com.sm.schoolManagement.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sm.schoolManagement.bean.User;
@Repository
public interface UserDao extends JpaRepository<User, Long>{
	Optional<User> findById(Long id);
}
