package com.sm.schoolManagement.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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
public class Professeur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, nullable = false)
	private String cin;
	private double salaire;
	@Temporal(TemporalType.DATE)
	private Date dateEmbauche;
	@OneToOne
	private AppUser appUser;
	@ManyToMany
	private List<Etudiant> etudiants;
}
