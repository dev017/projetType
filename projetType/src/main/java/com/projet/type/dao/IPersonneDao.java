package com.projet.type.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.projet.type.entity.Personne;

@Repository
public interface IPersonneDao  extends JpaRepository<Personne, Integer>, JpaSpecificationExecutor<Personne> {


}
