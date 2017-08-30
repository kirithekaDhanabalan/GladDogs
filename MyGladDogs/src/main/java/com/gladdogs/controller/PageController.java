package com.gladdogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gladdogs.gladdogsbd.model.Product;
import com.gladdogs.gladdogsbd.service.ProductService;
import com.google.gson.Gson;

@Controller
public class PageController 
{
	@Autowired
	ProductService proserv;
	
	@RequestMapping(value={"/","/home"})
	String indexPage()
	{
		return "index";
	}
	
	@RequestMapping("/aboutus")
	String aboutPage()
	{
		return "aboutus";
	}
	@RequestMapping("/contactus")
	String contactusPage()
	{
		return "contactus";
	}

	@RequestMapping("/showproduct")
	String showproductpage()
	{
		return "showproduct";
	}
	
	
	@RequestMapping("/product")
	ModelAndView showproduct()
	{
		ModelAndView mv=new ModelAndView("showproduct");
		List<Product> proobj=proserv.showproduct();
		Gson g=new Gson();
		System.out.println(proobj);
		mv.addObject("proobjstring",g.toJson(proobj));
		return mv;
	}
	
	
	@RequestMapping(value="/moredetails")
	ModelAndView showoneproduct(@RequestParam("getpid")int id)
	{
		ModelAndView mv=new ModelAndView("showoneproduct");
		Gson j=new Gson();
		String proobj=j.toJson(proserv.showoneproduct(id));
		System.out.println(proobj);
		mv.addObject("proobjstring",proobj );
		return mv;
	}

	
}
