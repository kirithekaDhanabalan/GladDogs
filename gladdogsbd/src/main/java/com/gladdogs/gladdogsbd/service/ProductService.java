package com.gladdogs.gladdogsbd.service;

import java.util.List;

import com.gladdogs.gladdogsbd.model.Product;

public interface ProductService 
{
	List<Product> showproduct();
	boolean insertproduct(Product P);
	boolean editproduct(Product P);
	boolean deleteproduct(int id);
	Product showoneproduct(int id);
}
