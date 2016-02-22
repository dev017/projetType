package com.projet.type.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "personne")
public class Personne implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5374229895631744548L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 50)
	private String nom;

	@Column(length = 50)
	private String prenom;

	@OneToOne(cascade = {CascadeType.ALL})
	@PrimaryKeyJoinColumn
	private OtherInfoPersonne otherInfo;

	@ManyToOne
	@JoinColumn(name = "niveau_id", referencedColumnName = "id")
	private Niveau niveau;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public OtherInfoPersonne getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(OtherInfoPersonne otherInfo) {
		this.otherInfo = otherInfo;
	}

}
