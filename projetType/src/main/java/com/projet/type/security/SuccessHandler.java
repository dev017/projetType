package com.projet.type.security;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.projet.type.entity.Users;
import com.projet.type.service.data.IUsersService;


public class SuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	IUsersService usersService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		SecurityUser user=(SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users u=usersService.getUserByLogin(user.getUsername());
		String userId=u.getLogin().toString();
		//mettre le userId dans la sessions
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userId", userId);
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", u);
        
		response.sendRedirect("personne.do");
	}

}