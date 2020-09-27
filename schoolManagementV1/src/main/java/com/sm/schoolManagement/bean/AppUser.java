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

/**
 * 
 * @author Abida Hassan
 * @version 1.0
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	// info personnel
	private String nom;
	private String prenom;
	private int age;
	private String sexe;
	private String telephone;
	private String imageUrl;
	// compte info
	@Column(unique = true, nullable = false)
	private String username;
	private String motDePass;
	private boolean activer;
	private String question;
	private String reponse;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateModification;
	private boolean supprimer;

	@ManyToMany
	private List<Role> role;

}
