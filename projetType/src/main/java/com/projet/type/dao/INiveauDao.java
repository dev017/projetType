package com.projet.type.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.projet.type.entity.Niveau;

@Repository
public interface INiveauDao  extends JpaRepository<Niveau, Integer>, JpaSpecificationExecutor<Niveau> {


}
