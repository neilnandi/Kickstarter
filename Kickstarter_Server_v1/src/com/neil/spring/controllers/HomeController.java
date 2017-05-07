package com.neil.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView home(){
		System.out.println("getting home page");
		ModelAndView mav = new ModelAndView();
		String viewName= "home";
		mav.setViewName(viewName);
		return mav;
	}

}
