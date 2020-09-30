package com.sm.schoolManagement.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MatiereItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDebut;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateFin;
	@ManyToOne
	private Cours cours;
	@ManyToOne
	private Matiere matiere;
	@ManyToOne
	private Local local;
	private boolean deleted;
}
