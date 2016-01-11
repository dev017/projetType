package com.projet.type.security;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


public class Utilisateur extends User {

	
	public String getTypeCompte() {
		return typeCompte;
	}

	
	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}



	private static final long serialVersionUID = 6783492726034981613L;

	public Utilisateur(String mail, Long id, String username, String password,String profil ,String nom, String prenom, String typeCompte2, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked,
			List<GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.nom = nom;
		this.prenom = prenom;
		this.id = id;
		this.profil=profil;
		this.mail=mail;
		this.typeCompte = typeCompte2;
	}

	// Propriétés -- DEBUT

	Long id;
	
	String nom;

	String prenom;
	
	String profil;
	
	String mail;
	
	// Propriétés -- FIN	
	
	
	String typeCompte;	

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

	
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getProfil() {
		return profil;
	}

	
	public void setProfil(String profil) {
		this.profil = profil;
	}

	
	public String getMail() {
		return mail;
	}

	
	public void setMail(String mail) {
		this.mail = mail;
	}

	
}
