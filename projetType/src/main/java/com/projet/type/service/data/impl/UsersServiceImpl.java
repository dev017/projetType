package com.projet.type.service.data.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.type.common.enumeration.EProfil;
import com.projet.type.dao.IUserDao;
import com.projet.type.entity.Users;
import com.projet.type.service.data.IUsersService;

@Service
@Transactional
public class UsersServiceImpl implements IUsersService {

	@Autowired
	IUserDao userDao;

	@Override
	public long countAllUserses() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteUsers(Users users) {
		// TODO Auto-generated method stub

	}

	@Override
	public Users findUsers(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> findAllUserses() {
		return userDao.findAll();
	}

	@Override
	public List<Users> findUsersEntries(int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUsers(Users users) {
		// TODO Auto-generated method stub

	}

	@Override
	public Users updateUsers(Users users) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void desactiverForDeleteUsers(List<Users> listUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Users> findAllWithoutConnected(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getUserByLogin(String login) {
		return userDao.getUserByLogin(login);
	}

	@Override
	public Users cloneUser(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> getUserByProfil(EProfil profil) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> getUsersNotInProfils(List<EProfil> listprofils) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> getUserByProfilwithoutCurrent(EProfil profil, Users user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> findNotDeletedUser(Users userConnected) {
		// TODO Auto-generated method stub
		return null;
	}

}
