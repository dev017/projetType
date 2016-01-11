package com.projet.type.service.data;

import java.util.List;

import com.projet.type.common.enumeration.EProfil;
import com.projet.type.entity.Users;

public interface IUsersService {

	public abstract long countAllUserses();

	public abstract void deleteUsers(Users users);

	public abstract Users findUsers(Long id);

	public abstract List<Users> findAllUserses();

	public abstract List<Users> findUsersEntries(int firstResult, int maxResults);

	public abstract void saveUsers(Users users);

	public abstract Users updateUsers(Users users);

	public void desactiverForDeleteUsers(List<Users> listUser);

	public List<Users> findAllWithoutConnected(Users user);

	public Users getUserByLogin(String login);

	public Users cloneUser(Users user);

	public abstract List<Users> getUserByProfil(EProfil profil);

	public abstract List<Users> getUsersNotInProfils(List<EProfil> listprofils);

	public abstract List<Users> getUserByProfilwithoutCurrent(EProfil profil,
			Users user);

	public abstract List<Users> findNotDeletedUser(Users userConnected);

}
