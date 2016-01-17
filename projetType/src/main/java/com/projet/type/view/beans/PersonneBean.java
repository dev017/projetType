package com.projet.type.view.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.projet.type.entity.Personne;
import com.projet.type.service.data.IPersonneService;

@ManagedBean(name = "gestPersBean")
@Component("gestPersBean")
@Qualifier("gestPersBean")
@Scope("session")
public class PersonneBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9118752400514828767L;
	private static final Logger LOG = LoggerFactory
			.getLogger(PersonneBean.class);

	private boolean init;

	private Personne pers = new Personne();

	private List<Personne> listPers = new ArrayList<Personne>();

	private List<Personne> selectedPersonnes = new ArrayList<Personne>();

	private String nom;

	private String prenom;

	private Personne selectedOnePersonne;

	@Autowired
	IPersonneService persService;

	public boolean isInit() {
		if (null != listPers && listPers.isEmpty()) {
			listPers = persService.findAll();
		}
		return init;
	}

	public void ajouter() {
		pers = new Personne();
		redirect("addPersonne.do");
	}

	private void redirect(String page) {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(page);
		} catch (IOException e) {
			LOG.info("Erreur " + e.toString());
		}

	}

	public void addPersonne() {
		persService.save(pers);
		listPers = persService.findAll();
		redirect("personne.do");
	}

	public void setInit(boolean init) {
		this.init = init;
	}

	public Personne getPers() {
		return pers;
	}

	public void setPers(Personne pers) {
		this.pers = pers;
	}

	public List<Personne> getListPers() {
		return listPers;
	}

	public void setListPers(List<Personne> listPers) {
		this.listPers = listPers;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Personne> getSelectedPersonnes() {
		return selectedPersonnes;
	}

	public void setSelectedPersonnes(List<Personne> selectedPersonnes) {
		this.selectedPersonnes = selectedPersonnes;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Personne getSelectedOnePersonne() {
		return selectedOnePersonne;
	}

	public void setSelectedOnePersonne(Personne selectedOnePersonne) {
		this.selectedOnePersonne = selectedOnePersonne;
	}

}
