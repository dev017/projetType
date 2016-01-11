package com.projet.type.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projet.type.common.enumeration.EProfil;
import com.projet.type.entity.Users;

@Repository
public interface IUserDao extends JpaRepository<Users, Long>, JpaSpecificationExecutor<Users> {

	@Query("select u from Users u where u.login= :login and u.deleted=0")
    public Users getUserByLogin(@Param ("login") String login);
	
	@Query("select u from Users u where u.login <> :login and u.deleted=0")
	public List<Users> findAllWithoutConnected(@Param("login") String login);

	@Query("select u from Users u where u.login <> :login and u.deleted=0 and u.profil not in('administrateur', 'moderateur')")
	public List<Users> findAllWithoutConnectedProfil(
			@Param("login") String login);

	@Query("select u from Users u where u.profil= :profil and u.deleted=0")
	public List<Users> getUserByProfil(@Param("profil") EProfil profil);

	@Query("select distinct u from Users u where u.profil not in (:listprofils) and u.deleted=0")
	public List<Users> getUsersNotInProfils(
			@Param("listprofils") List<EProfil> listprofils);

	@Query("select u from Users u where u.profil= :profil and u.deleted=0 and u.id != :idUser")
	public List<Users> getUserByProfilwithoutCurrent(
			@Param("profil") EProfil profil, @Param("idUser") Long idUser);

	@Query("select u from Users u where u.deleted=0")
	public List<Users> findNotDeletedUser();

}
