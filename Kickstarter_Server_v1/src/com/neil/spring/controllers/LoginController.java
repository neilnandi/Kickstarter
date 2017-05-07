package com.neil.spring.controllers;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neil.hibernate.dao.UserDao;
import com.neil.spring.model.LoginDetails;


@Controller
@RequestMapping("/login")
public class LoginController {
	
	
	
	
	@Autowired
	private UserDao udao;
	
	@Autowired
	private HttpSession session;
	

	@RequestMapping(value="/viewlogin")
	public ModelAndView home(){
		System.out.println("getting login page");
		ModelAndView mav = new ModelAndView();
		LoginDetails ld = new LoginDetails();
		String viewName= "login";
		mav.setViewName(viewName);
		mav.addObject("logindet",ld);
		return mav;
	}
	
	
	
	
	@RequestMapping(value="/validatelogin", method=RequestMethod.POST)
	public ModelAndView validateLoginDetails(
			@ModelAttribute("logindet") LoginDetails loginDet,BindingResult result){
		System.out.println("getting validate page");
		System.out.println("loginDet=="+loginDet);
		if(loginDet!=null){
			System.out.println("user name::::"+loginDet.getUsername());
			System.out.println("password::::"+loginDet.getPassword());
			if(StringUtils.isBlank(loginDet.getUsername())){
				result.rejectValue("userName", "ERR_001");
			}
			if(StringUtils.isBlank(loginDet.getPassword())){
				result.rejectValue("password", "ERR_001");
			}
		}
		ModelAndView mav = new ModelAndView();

		if(udao.authenticateUser(loginDet)){
			String viewName= "profile";
			mav.setViewName(viewName);
			mav.addObject("user", loginDet);
			System.out.println("Authenticated");
			
			
		}
		
		else{
			System.out.println("Incorrect login");
			String viewName= "home";
			mav.setViewName(viewName);
				
		}

		return mav;
	}

}
