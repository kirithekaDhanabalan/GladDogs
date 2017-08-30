package com.gladdogs.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.tools.FileObject;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gladdogs.gladdogsbd.model.Category;
import com.gladdogs.gladdogsbd.model.Product;
import com.gladdogs.gladdogsbd.model.Supplier;
import com.gladdogs.gladdogsbd.service.CategoryService;
import com.gladdogs.gladdogsbd.service.ProductService;
import com.gladdogs.gladdogsbd.service.SupplierService;
import com.google.gson.Gson;

@Controller

public class ProductController 
{
	@Autowired
	CategoryService catserv;
	@Autowired
	SupplierService supserv;
	@Autowired
	ProductService proserv;
	
	
	@RequestMapping("/showprodpage")
	String Disppro(Model M)
	{
		List<Category> catobj=catserv.showcategory();
		M.addAttribute("catobjstring",catobj ); 
		M.addAttribute("catdetails",new Category());
		List<Supplier> supobj=supserv.showsupplier();
		M.addAttribute("supobjstring",supobj );
		M.addAttribute("supdetails",new Supplier());
		List<Product> proobj=proserv.showproduct();
		M.addAttribute("proobjstring",proobj );
		M.addAttribute("prodetails",new Product());
		M.addAttribute("check", "true");
		return "productform" ;
	}
	
	@RequestMapping(value="/addproduct",params="addpro")
	String addproduct(@Valid @ModelAttribute("prodetails") Product P,BindingResult br)
	{
		System.out.println(P.getProductDescription());
		if(br.hasErrors())
			return "redirect:/showprodpage";
		else
		{
			if(proserv.insertproduct(P))
			{
				try
				{
					String path="G:\\GladDog\\MyGladDogs\\src\\main\\webapp\\resources\\proimage\\";
					path=path+String.valueOf(P.getProductId())+".jpg";
					MultipartFile f=P.getPImage();
					if(!f.isEmpty())
					{
						byte[] b=f.getBytes();
						FileOutputStream f1=new FileOutputStream(new File(path));
						f1.write(b);
						f1.close();
						Thread.sleep(10000);
					}
					return "redirect:/showprodpage";		
				}
				catch (Exception e) 
				{
					return "redirect:/showprodpage";		
				}	
			}
			else
				return "redirect:/showprodpage";		
		}
	}
	
	@RequestMapping(value="/addproduct",params="editpro")
	String eproduct(@Valid @ModelAttribute("prodetails") Product P,BindingResult br)
	{
		System.out.println(P.getProductDescription());
		if(br.hasErrors())
		{
			return "redirect:/showprodpage";
		}
		else
		{
			if(proserv.editproduct(P))
			{
				try
				{
					String path="G:\\GladDog\\MyGladDogs\\src\\main\\webapp\\resources\\proimage\\";
					path=path+String.valueOf(P.getProductId())+".jpg";
					MultipartFile f=P.getPImage();
					if(!f.isEmpty())
					{
						byte[] b=f.getBytes();
						File p=new File(path);
						if(p.exists())
						{
							p.delete();
							FileOutputStream f1=new FileOutputStream(p);
							f1.write(b);
							f1.close();
							Thread.sleep(30000);
						}
					}
					return "redirect:/showprodpage";		
				}
				catch (Exception e) 
				{
					return "redirect:/showprodpage";		
				}
			}
			else
			{
				return "redirect:/showprodpage";
			}
		}
	}


	@RequestMapping("/removeproduct/{num}")
	String removepro(@PathVariable("num")int id)
	{
		if(proserv.deleteproduct(id))
		{
			String path="G:\\GladDog\\MyGladDogs\\src\\main\\webapp\\resources\\proimage\\";
			path=path+String.valueOf(id);
			File p=new File(path);
			if(p.exists())
			{
				p.delete();
			}
			return "redirect:/showprodpage";		
		}
		else
		{
			return "redirect:/showprodpage";		
		}			
	}
	
	@RequestMapping("/editproduct")
	String editpro(Model M,@RequestParam("getcid") int id)
	{
		
		List<Category> catobj=catserv.showcategory();
		M.addAttribute("catobjstring",catobj ); 
		List<Supplier> supobj=supserv.showsupplier();
		M.addAttribute("supobjstring",supobj );
		List<Product> proobj=proserv.showproduct();
		M.addAttribute("proobjstring",proobj );
		M.addAttribute("prodetails",proserv.showoneproduct(id));
		M.addAttribute("check", "false");
		return "productform";
	}
}
