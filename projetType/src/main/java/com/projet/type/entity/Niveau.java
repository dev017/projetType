package com.projet.type.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "niveau")
public class Niveau implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -591573714269366398L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 50)
	private String libelle;

	@OneToMany(mappedBy = "niveau")
	private List<Personne> listPersonne;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Personne> getListPersonne() {
		return listPersonne;
	}

	public void setListPersonne(List<Personne> listPersonne) {
		this.listPersonne = listPersonne;
	}

	@Override
	public String toString() {
		return libelle  ;
	}

}
