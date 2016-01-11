package com.projet.type.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;

import com.projet.type.security.SecurityUser;


@Configuration
@Profile({ "dev","testprod" })
public class BeanConfig {

	private static final Logger LOG = LoggerFactory.getLogger(BeanConfig.class);
	@Bean
	@Scope("prototype")
	public SecurityUser getUtilisateur() {
		try{
			
		// user.setTypeCompte(valeurTypeCompte); // définir le type de compte, actionPerf ou AOD
			return (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}catch(Exception e){
			LOG.debug("getUtilisateur >>" , e.toString());
			return null;
		}
	}
}
