package com.sm.schoolManagement.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
@NoArgsConstructor
@AllArgsConstructor
public class Parent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String cin;
	@OneToOne
	private AppUser appUser;
	@OneToMany(mappedBy = "parent")
	private List<Etudiant> etudiants;
}
