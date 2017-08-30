package com.gladdogs.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gladdogs.gladdogsbd.model.Cart;
import com.gladdogs.gladdogsbd.model.Product;
import com.gladdogs.gladdogsbd.model.UserReg;
import com.gladdogs.gladdogsbd.service.CartService;
import com.gladdogs.gladdogsbd.service.ProductService;
import com.gladdogs.gladdogsbd.service.UserService;

@Controller
public class CartController {
	
	@Autowired
	UserService us;
	
	@Autowired
	ProductService ps;
	
	@Autowired
	CartService cs;
	@RequestMapping(value={"/addtocart"})
	public String insertProdttoCart(@RequestParam("getprodid") int ProdId,HttpSession session,HttpSession sessionlog)
	{
		try
		{
			Product single=ps.showoneproduct(ProdId);
				if(single.getProductId()==ProdId)
				{
					String username=(String) session.getAttribute("UserLoggedIn");
					List<Cart> singleuser=(cs.singleUserCart(username));
					List<Cart> singleprodfromcart=cs.singleprodfromcart(single.getProductName(),username);
					if(singleprodfromcart.isEmpty())
					{
						Cart cart=new Cart();
						cart.setCartId((String)session.getAttribute("UserLoggedIn"));
						cart.setProductId(single.getProductId());
						cart.setPrice((int)single.getPrice());
						cart.setQuantity(1);
						cart.setProdname(single.getProductName());
						cart.setTotal(cart.getQuantity()*cart.getPrice());
						cs.insertproducttocart(cart);
					}
					else
					{
						singleprodfromcart.get(0).setQuantity(singleprodfromcart.get(0).getQuantity()+1);
						singleprodfromcart.get(0).setTotal(singleprodfromcart.get(0).getPrice()*singleprodfromcart.get(0).getQuantity());
						cs.updateproducttocart(singleprodfromcart.get(0));
						
					}
				}
			
		}
		catch(Exception e)
		{
			
		}
		
		return "redirect:/product";
	}

	
	
	@RequestMapping("/cart")
	String cartPage(HttpSession session,Model m)
	{
		
		String username=(String) session.getAttribute("UserLoggedIn");
		List<Cart> singleuser=(cs.singleUserCart(username));
		m.addAttribute("carobjstring", singleuser);
		return "cart";
	}
	
	@RequestMapping("/remove/{prodid}")
	String removesup(@PathVariable("prodid")int id)
	{
		if(cs.deletecartproduct(id))
		{
			return "redirect:/cartpage";		
		}
		else
		{
			return "redirect:/cartpage";		
		}
	}
}
