package com.gladdogs.gladdogsbd.service;

import java.util.List;

import com.gladdogs.gladdogsbd.model.Cart;
import com.gladdogs.gladdogsbd.model.CartId;

public interface CartService 
{
	boolean insertproducttocart(Cart cart);
	List<Cart> singleUserCart(String username);
	boolean updateproducttocart(Cart cart);
	List<Cart> singleprodfromcart(String prodname,String username);
	
	boolean initCartforuser(CartId cartid);
	boolean deletecartproduct(int id);

}




//package com.gladdogs.gladdogsbd.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.gladdogs.gladdogsbd.model.Cart;
//import com.gladdogs.gladdogsbd.model.Product;
//
//public interface CartService 
//{
//	boolean insertproduct(Product P);
//    boolean editproduct(Product P);
//	boolean deleteproduct(int id);
//	List<Cart> viewItemsInCart(int id);
//}
