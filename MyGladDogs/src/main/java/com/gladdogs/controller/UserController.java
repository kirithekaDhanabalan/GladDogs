  package com.gladdogs.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gladdogs.gladdogsbd.model.UserReg;
import com.gladdogs.gladdogsbd.service.UserService;



@Controller
public class UserController 
{

	@Autowired
	UserService usd;
	
	@RequestMapping("/register")
	ModelAndView registerPage()
	{
		return new ModelAndView("register","userform",new UserReg()); 
	}
	
	@RequestMapping(value={"/submituserform"}, method=RequestMethod.POST)
	String submituserform(@Valid @ModelAttribute("userform")UserReg u,BindingResult result)
	{
		System.out.println(u.getUserName());
		
		if(result.hasErrors())
		{
			System.out.println(result.getAllErrors());
			System.out.println("because of errors");
			return "redirect:/register";
		}
		else
		{
			if(usd.insertuser(u))
			{
				return "redirect:/plogin";
			}
			else
			{
				System.out.println("beacuse ive not reavched");
				return "redirect:/register";
			}
		}
	}

	@RequestMapping("/plogin")
	String loginPage(@RequestParam(value="error",required=false)String Error,@RequestParam(value="logout",required=false)String Log,Model m)
	{
		
		if(Error!=null)
			m.addAttribute("msg","Username or password incorrect");
		else if(Log!=null)
			m.addAttribute("msg","You are successfully logout");
		return "login";
	}

	@RequestMapping("/loginsuccess")
	public String loginsuccess(HttpSession session,Model M) 
	{
		String role = "User_Role";
		String userid = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println(userid);
		UserReg us=usd.showuser(userid);
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (GrantedAuthority authority : authorities) 
		{
			if (authority.getAuthority().equals(role)) 
			{
				session.setAttribute("UserLoggedIn", us.getUserName());
				
			}
			else
			{
				session.setAttribute("AdminLoggedIn", us.getUserName());
			}
			
		}
		return "redirect:/home";
	}
}
