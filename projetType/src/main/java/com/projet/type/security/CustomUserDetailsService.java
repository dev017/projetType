package com.projet.type.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.type.dao.IUserDao;
import com.projet.type.entity.Users;


@Service
@Transactional(readOnly=true)
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	IUserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {
		Users domainUser = userDao.getUserByLogin(login);
		
		if(domainUser!=null){
	        boolean accountNonExpired = true;  
	        boolean credentialsNonExpired = true;  
	        boolean accountNonLocked = true;  
	        
	        return new SecurityUser(  
	                domainUser.getLogin(),   
	                domainUser.getPassword(),  
	                domainUser.isActif(),   
	                accountNonExpired,   
	                credentialsNonExpired,   
	                accountNonLocked,  
	                getAuthorities(domainUser),domainUser.getName());
		}else{
            throw new UsernameNotFoundException("User Not Found!!!");
        }
    }

	private Collection<? extends GrantedAuthority> getAuthorities(Users u) {
		List<String> roles=new ArrayList<String>();
		roles.add(u.getProfil().name());
		List<GrantedAuthority> authList = getGrantedAuthorities(roles);
		return authList;
	}

	private List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}


}
