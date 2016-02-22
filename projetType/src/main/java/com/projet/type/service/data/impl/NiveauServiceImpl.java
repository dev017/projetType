package com.projet.type.service.data.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.type.dao.INiveauDao;
import com.projet.type.entity.Niveau;
import com.projet.type.service.data.INiveauService;

@Service
public class NiveauServiceImpl implements INiveauService {

	@Autowired
	INiveauDao dao;

	@Override
	public Niveau getNiveauById(Integer id) {
		return dao.findOne(id);
	}

	@Override
	public List<Niveau> findAll() {
		return dao.findAll();
	}

	@Override
	public void save(Niveau n) {
		dao.save(n);
	}

}
