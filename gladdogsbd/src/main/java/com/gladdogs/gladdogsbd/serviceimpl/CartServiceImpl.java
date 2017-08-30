package com.gladdogs.gladdogsbd.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gladdogs.gladdogsbd.DAO.CartDao;
import com.gladdogs.gladdogsbd.model.Cart;
import com.gladdogs.gladdogsbd.model.CartId;
import com.gladdogs.gladdogsbd.service.CartService;

@Service
@Transactional
public class CartServiceImpl implements CartService 
{

	@Autowired
    CartDao cartservice;
	
	@Override
	public boolean insertproducttocart(Cart cart) 
	{
		boolean b=cartservice.insertproducttocart(cart);
     	return b;

	}

	@Override
	public List<Cart> singleUserCart(String username) {
	
		return cartservice.singleUserCart(username);
	}

	@Override
	public boolean updateproducttocart(Cart cart) {
		boolean b=cartservice.updateproducttocart(cart);
     	return b;
	}

	@Override
	public List<Cart> singleprodfromcart(String prodname,String username) {
		// TODO Auto-generated method stub
		return cartservice.singleprodfromcart(prodname,username);
	}

	@Override
	public boolean initCartforuser(CartId cartid) {
		// TODO Auto-generated method stub
		return cartservice.initCartforuser(cartid);
	}

	@Override
	public boolean deletecartproduct(int id) {
		boolean b=cartservice.deletecartproduct(id);
		return b;
		
	}
	
}


//package com.gladdogs.gladdogsbd.serviceimpl;
//   
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.gladdogs.gladdogsbd.DAO.CartDao;
//import com.gladdogs.gladdogsbd.model.Cart;
//import com.gladdogs.gladdogsbd.model.Product;
//import com.gladdogs.gladdogsbd.service.CartService;
//
//public class CartServiceImpl implements CartService 
//{
//
//	@Autowired
//	CartDao cartservice;
//
//	@Override
//	public boolean insertproduct(Product P) 
//	{
//		boolean b=cartservice.insertproduct(P);
//		return b;
//
//	}
//
//	@Override
//	public boolean editproduct(Product P) 
//	{
//		boolean b=cartservice.editproduct(P);
//		return b;
//	}
//
//	@Override
//	public boolean deleteproduct(int id) 
//	{
//		boolean b=cartservice.deleteproduct(id);
//		return b;
//	}
//
//	@Override
//	public List<Cart> viewItemsInCart(int id) 
//	{
//		return cartservice.viewItemsInCart(id);
//	}
//
//
//
//}
