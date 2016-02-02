package com.projet.type.entity.test;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Voiture {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_VOITURE")
	private long id;

	private String marque;

	private String modele;

	@Temporal(TemporalType.DATE)
	private Date dateAchat;

	@ManyToOne
	private Personnee proprietaire;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}

	public Personnee getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Personnee proprietaire) {
		this.proprietaire = proprietaire;
	}

}
