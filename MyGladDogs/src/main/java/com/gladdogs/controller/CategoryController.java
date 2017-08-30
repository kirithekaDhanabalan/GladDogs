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
import com.gladdogs.gladdogsbd.service.CategoryService;
import com.google.gson.Gson;

@Controller
public class CategoryController 
{
	@Autowired
	CategoryService catserv;
	
//	@RequestMapping("/showcatpage")
//	ModelAndView addcat() {
//		List<Category> catobj = catserv.showcategory();
//		ModelAndView mv = new ModelAndView("category", "catdetails", new Category());
//		mv.addObject("catobjstring", catobj);
//		mv.addObject("check", "true");
//		return mv;
//	}
	
	@RequestMapping("/showcatpage")
	String dispcat(Model M)
	{
		List<Category> catobj=catserv.showcategory();
		M.addAttribute("catobjstring",catobj);
		M.addAttribute("catdetails",new Category());
		M.addAttribute("check", "true");
		return "category";
	}
	
	
	@RequestMapping("/addcategory")
	String addcategory(@Valid @ModelAttribute("catdetails") Category C,BindingResult br)
	{
		if(br.hasErrors())
		{
			return "redirect:/showcatpage";
		}
		else
		{
			if(catserv.insertcategory(C))
			{
				return "redirect:/showcatpage";		
			}
			else
			{
				return "redirect:/showcatpage";		
			}
		}
	}

	@RequestMapping("/removecategory/{num}")
	String removecat(@PathVariable("num")int id)
	{
		if(catserv.deletecategory(id))
		{
			return "redirect:/showcatpage";		
		}
		else
		{
			return "redirect:/showcatpage";		
		}
		
		
	}
	
//	@RequestMapping("/editcategory")
//	ModelAndView editcat(@RequestParam("getcid") int id)
//	{
//		List<Category> catobj=catserv.showcategory();
//		ModelAndView mv=new ModelAndView("category","catdetails",catserv.showonecat(id));
//		mv.addObject("catobjstring",catobj );
//		mv.addObject("check", "false");
//		return mv;
//	}
	@RequestMapping("/editcategory")
	String neweditcat(Model M,@RequestParam("getcid") int id)
	{
		List<Category> catobj=catserv.showcategory();
		M.addAttribute("catobjstring",catobj);
		M.addAttribute("catdetails",catserv.showonecat(id));
		M.addAttribute("check", "false");
		return "category";
	}
	
	
	@RequestMapping("/updatecategory")
	String updatecategory(@Valid @ModelAttribute("catdetails") Category C,BindingResult br)
	{
		if(br.hasErrors())
		{
			return "redirect:/showcatpage";
		}
		else
		{
			if(catserv.editcategory(C))
			{
				return "redirect:/showcatpage";		
			}
			else
			{
				return "redirect:/showcatpage";		
			}
		}
	}
}
