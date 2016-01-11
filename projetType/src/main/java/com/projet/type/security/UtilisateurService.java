package com.projet.type.security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;


//@Service
public class UtilisateurService extends JdbcDaoImpl {
	
	public UtilisateurService() {
		super();
		setUsersByUsernameQuery("select u.login,u.password, u.first_name,u.name,u.actif,u.id,p.name,u.mail,u.type_compte "
				+ "from users u,profil p "
				+ "where u.profil_id=p.id and u.login=?");
		
		setAuthoritiesByUsernameQuery("select u.login,p.name from users u,profil p where u.profil_id=p.id and u.login=?");
	}

	@Override
	public List<UserDetails> loadUsersByUsername(String username) {
		return getJdbcTemplate().query(getUsersByUsernameQuery(), new String[] { username }, new RowMapper<UserDetails>() {

			public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
				Long id = rs.getLong(6);
				String username = rs.getString(1);
				String password = rs.getString(2);
				String nom = rs.getString(3);
				String prenom = rs.getString(4);
				String profil = rs.getString(7);
				boolean enabled = rs.getBoolean(5);
				String mail = rs.getString(8);
				String typeCompte = rs.getString(9);
				return new Utilisateur(mail, id, username, password, profil, nom, prenom, typeCompte, enabled, true, true, true, AuthorityUtils.NO_AUTHORITIES);
			}

		});
	}

	@Autowired
	protected void setDataSrc(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	protected UserDetails createUserDetails(String username, UserDetails userFromUserQuery, List<GrantedAuthority> combinedAuthorities) {
		String returnUsername = userFromUserQuery.getUsername();
		Utilisateur userDetail = (Utilisateur) userFromUserQuery;

		if (!isUsernameBasedPrimaryKey()) {
			returnUsername = username;
		}

		return new Utilisateur(userDetail.getMail(),userDetail.getId(), returnUsername, userDetail.getPassword(), userDetail.getProfil(), userDetail.getNom(), userDetail.getPrenom(), 
				userDetail.getTypeCompte(), userDetail.isEnabled(), true, true, true, combinedAuthorities);

	}
}
