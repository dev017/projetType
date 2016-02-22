package com.projet.type.service.data;

import java.util.List;

import com.projet.type.entity.Niveau;


public interface INiveauService {

	public Niveau getNiveauById(Integer id);
	
	public List<Niveau> findAll();
	
	public void save(Niveau n);
	
}
