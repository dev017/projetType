package com.projet.type.view.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.LazyDataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.projet.type.entity.Niveau;
import com.projet.type.entity.OtherInfoPersonne;
import com.projet.type.entity.Personne;
import com.projet.type.service.data.INiveauService;
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

	private static final Logger LOG = LoggerFactory.getLogger(PersonneBean.class);

	private boolean init;

	private Personne pers = new Personne();

	private OtherInfoPersonne otherInfoPers = new OtherInfoPersonne();

	private List<Personne> listPers = new ArrayList<Personne>();

	private List<Personne> selectedPersonnes = new ArrayList<Personne>();

	private String nom;

	private String prenom;

	private Personne selectedOnePersonne;

	private String option;

	// ** Actions
	private String selectedAction;

	private Map<String, String> actions;

	private List<Niveau> listNiveau = new ArrayList<Niveau>();;

	private Niveau selectedNiveau = new Niveau();

	private LazyDataModel<Personne> lazyListPersonne;

	@Autowired
	IPersonneService persService;

	@Autowired
	INiveauService niveauService;

	public boolean isInit() {

		if (null != listPers && listPers.isEmpty()) {
			initActions();
			listPers = persService.getListAllPersonne();
		}

		if (null != listNiveau && listNiveau.isEmpty()) {
			listNiveau = niveauService.findAll();
		}

		// pour travailler en mode lazy
		// lazyListPersonne = new LazyPersonnelDataModel(persService);

		return init;
	}

	public void initActions() {
		actions = new LinkedHashMap<String, String>();
		actions.put("Ajouter", "ajo");
		actions.put("Editer", "edi");
		actions.put("Supprimer", "sup");
	}

	public void ajouter() {
		pers = new Personne();
		redirect("addPersonne.do");
	}

	private void redirect(String page) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(page);
		} catch (IOException e) {
			LOG.info("Erreur " + e.toString());
		}

	}

	public void addPersonne() {

		pers.setOtherInfo(otherInfoPers);
		otherInfoPers.setPersonne(pers);

		persService.save(pers);

		listPers = persService.findAll();
		redirect("personne.do");
	}

	public void onActionChange() {
		option = "liste";
		if (selectedAction != null && !selectedAction.equals("")) {
			switch (selectedAction) {
			case "ajo":
				ajouter();
				break;
			case "edi":
				// actionEditer();
				break;
			case "sup":
				// actionSupprimer();
				break;
			}
		}
	}

	public final void onFilterChange() {
		if (null == selectedNiveau.getLibelle() || "".equalsIgnoreCase(selectedNiveau.getLibelle())) {
			listPers = persService.getListAllPersonne();
		} else {
			listPers = persService.getListAllPersonneByNiveau(selectedNiveau.getLibelle());
		}
	}

	public Niveau getSelectedNiveau() {
		return selectedNiveau;
	}

	public void setSelectedNiveau(Niveau selectedNiveau) {
		this.selectedNiveau = selectedNiveau;
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

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getSelectedAction() {
		return selectedAction;
	}

	public void setSelectedAction(String selectedAction) {
		this.selectedAction = selectedAction;
	}

	public Map<String, String> getActions() {
		return actions;
	}

	public void setActions(Map<String, String> actions) {
		this.actions = actions;
	}

	public List<Niveau> getListNiveau() {
		return listNiveau;
	}

	public void setListNiveau(List<Niveau> listNiveau) {
		this.listNiveau = listNiveau;
	}

	public OtherInfoPersonne getOtherInfoPers() {
		return otherInfoPers;
	}

	public void setOtherInfoPers(OtherInfoPersonne otherInfoPers) {
		this.otherInfoPers = otherInfoPers;
	}

	public LazyDataModel<Personne> getLazyListPersonne() {
		return lazyListPersonne;
	}

	public void setLazyListPersonne(LazyDataModel<Personne> lazyListPersonne) {
		this.lazyListPersonne = lazyListPersonne;
	}

}
