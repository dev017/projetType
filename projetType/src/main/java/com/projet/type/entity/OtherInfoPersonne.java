package com.projet.type.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "OtherInfoPersonne")
public class OtherInfoPersonne {

	@Id
	@GeneratedValue(generator = "customForeignGenerator")
	@org.hibernate.annotations.GenericGenerator(name = "customForeignGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "personne"))
	private Integer id;

	@OneToOne(mappedBy = "otherInfo")
	@PrimaryKeyJoinColumn
	private Personne personne;

	@Column(length = 20)
	private String dateNaissance;

	@Column(length = 100)
	private String adresse;

	@Column(length = 10)
	private String cin;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

}
