package com.gladdogs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gladdogs.gladdogsbd.model.Category;
import com.gladdogs.gladdogsbd.model.Supplier;
import com.gladdogs.gladdogsbd.service.SupplierService;

@Controller
public class SupplierController 
{

	@Autowired
	SupplierService supserv;
	
	@RequestMapping("/showsuppage")
	String dispsup(Model M)
	{
		List<Supplier> supobj=supserv.showsupplier();
		M.addAttribute("supobjstring",supobj);
		M.addAttribute("supdetails",new Supplier());
		M.addAttribute("check", "true");
		return "supplier";
	}
	
	@RequestMapping(value="/addsupplier",params="add")
	String addsupplier(@Valid @ModelAttribute("supdetails") Supplier S,BindingResult br)
	{
		
		if(br.hasErrors())
		{
			return"redirect:/showsuppage";
		}
		else
		{
			if(supserv.insertsupplier(S))
			{
				return"redirect:/showsuppage";
			}
			else
			{
				return"redirect:/showsuppage";
			}
		}
	}
	
	@RequestMapping(value="/addsupplier",params="edit")
	String esupplier(@Valid @ModelAttribute("supdetails") Supplier S,BindingResult br)
	{
		
		if(br.hasErrors())
		{
			return"redirect:/showsuppage";
		}
		else
		{
			if(supserv.editsupplier(S))
			{
				return"redirect:/showsuppage";
			}
			else
			{
				return"redirect:/showsuppage";
			}
		}
	}

	@RequestMapping("/removesupplier/{num}")
	String removesup(@PathVariable("num")int id)
	{
		if(supserv.deletesupplier(id))
		{
			return "redirect:/showsuppage";		
		}
		else
		{
			return "redirect:/showsuppage";		
		}
	}
	
	@RequestMapping("/editsupplier")
	String neweditsup(Model M,@RequestParam("getsid") int id)
	{
		List<Supplier> supobj=supserv.showsupplier();
		M.addAttribute("supobjstring",supobj);
		M.addAttribute("supdetails",supserv.showonesupplier(id));
		M.addAttribute("check", "false");
		return "supplier";
	}

	
	
}
