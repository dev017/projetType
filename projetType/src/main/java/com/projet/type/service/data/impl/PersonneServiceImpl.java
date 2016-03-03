package com.projet.type.service.data.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.type.dao.IPersonneDao;
import com.projet.type.entity.Personne;
import com.projet.type.service.data.IPersonneService;

@Service
public class PersonneServiceImpl implements IPersonneService {

	@Autowired
	IPersonneDao dao;

	public Personne getPersonneById(Integer id) {
		return dao.findOne(id);
	}

	public List<Personne> findAll() {
		return dao.findAll();
	}

	@Override
	public void save(Personne p) {
		dao.save(p);
	}

	@Override
	public List<Personne> getListAllPersonne() {
		return dao.getListAllPersonne();
	}

	@Override
	public List<Personne> getListAllPersonneByNiveau(String libelle) {
		return dao.getListPersonneByNiveau(libelle);
	}

	@Override
	public Page<Personne> findArchiveTask(String nom, Pageable pageable) {
		return dao.findArchiveTask(nom, pageable);
	}

}
