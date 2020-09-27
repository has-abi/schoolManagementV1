package com.sm.schoolManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sm.schoolManagement.bean.NotificationPermission;

@Repository
public interface NotificationPermissionDao extends JpaRepository<NotificationPermission, Long>,JpaSpecificationExecutor<NotificationPermission>{

}
