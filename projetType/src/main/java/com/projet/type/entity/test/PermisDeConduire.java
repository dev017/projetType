package com.projet.type.entity.test;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PermisDeConduire {
	@Id
	@Column(name = "ID_PERMIS")
	private String numero;

	@Temporal(TemporalType.DATE)
	private Date dateDelivrancePermisA;

	@Temporal(TemporalType.DATE)
	private Date dateDelivrancePermisB;

	// bidirectionnelle
	@OneToOne(mappedBy = "permis")
	private Personnee beneficiaire;

	// unidirectionnelle
	@OneToOne
	private Personnee delivrerar;
}
