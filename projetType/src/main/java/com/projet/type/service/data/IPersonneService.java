package com.projet.type.service.data;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.projet.type.entity.Personne;

public interface IPersonneService {

	public Personne getPersonneById(Integer id);

	public List<Personne> findAll();

	public void save(Personne p);

	public List<Personne> getListAllPersonne();

	public List<Personne> getListAllPersonneByNiveau(String id);

	public Page<Personne> findArchiveTask(String nom, Pageable pageable);

}
