package com.projet.type.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projet.type.entity.Personne;

@Repository
public interface IPersonneDao extends JpaRepository<Personne, Integer>,
		JpaSpecificationExecutor<Personne> {

	@Query("Select distinct p from Personne p inner join p.niveau n ")
	public List<Personne> getListAllPersonne();

	@Query("Select distinct p from Personne p inner join p.niveau n where n.libelle like (:niveauIds) ")
	public List<Personne> getListPersonneByNiveau(@Param("niveauIds") String  niveauIds);

}
