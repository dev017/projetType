package com.projet.type.service.data;

import java.util.List;

import com.projet.type.entity.Personne;


public interface IPersonneService {

	public Personne getPersonneById(Integer id);
	
	public List<Personne> findAll();
	
	public void save(Personne p);
	
	public List<Personne>getListAllPersonne();
	
	public List<Personne>getListAllPersonneByNiveau(String id);
	
	
}
