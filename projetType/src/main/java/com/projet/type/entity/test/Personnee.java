package com.projet.type.entity.test;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONNEE")
public class Personnee {

	@Id
	@Column(name = "ID_PERSONNE")
	private long id;

	@OneToOne
	private PermisDeConduire permis;

	@OneToMany(mappedBy = "proprietaire")
	private List<Voiture> mesVoitures;

	@ManyToMany
	private Set<Personnee> collegues;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PermisDeConduire getPermis() {
		return permis;
	}

	public void setPermis(PermisDeConduire permis) {
		this.permis = permis;
	}

	public List<Voiture> getMesVoitures() {
		return mesVoitures;
	}

	public void setMesVoitures(List<Voiture> mesVoitures) {
		this.mesVoitures = mesVoitures;
	}

	public Set<Personnee> getCollegues() {
		return collegues;
	}

	public void setCollegues(Set<Personnee> collegues) {
		this.collegues = collegues;
	}

}
