package com.sm.schoolManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sm.schoolManagement.bean.Notification;

/**
 * 
 * @author Abida Hassan
 * @version 1.0
 *
 */
@Repository
public interface NotificationDao extends JpaRepository<Notification, Long>, JpaSpecificationExecutor<Notification> {

}
