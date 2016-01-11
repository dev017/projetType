package com.projet.type.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projet.type.entity.Personne;
import com.projet.type.service.data.IPersonneService;

@Controller
public class PersonneController {

//	@Autowired
//	IPersonneService persService;
//	
	@RequestMapping("/welcome")
	public String index(ModelMap model) {
		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "welcome";
	}
	
	
//	@RequestMapping(value="/list", method=RequestMethod.GET)
//	public ModelAndView shopListPage() {
//		ModelAndView mav = new ModelAndView("pers-list");
//		List<Personne> pList = persService.findAll();
//		mav.addObject("pList", pList);
//		return mav;
//	}
}
