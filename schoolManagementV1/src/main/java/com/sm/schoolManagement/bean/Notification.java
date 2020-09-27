package com.sm.schoolManagement.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "Text")
	private String contenu;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;
	private String typeNotification;
	private boolean statu;
	private String sender;
	private String recever;
	@ManyToMany
	private List<NotificationPermission> notificationPermissions;
}
