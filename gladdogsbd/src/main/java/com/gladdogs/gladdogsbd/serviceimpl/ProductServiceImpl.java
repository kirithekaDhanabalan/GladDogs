package com.gladdogs.gladdogsbd.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gladdogs.gladdogsbd.DAO.ProductDao;
import com.gladdogs.gladdogsbd.model.Product;
import com.gladdogs.gladdogsbd.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService
{
	@Autowired
	ProductDao productservice;

	
	@Override
	public boolean insertproduct(Product P) 
	{
		boolean b=productservice.insertproduct(P);
		return b;
	}


	@Override
	public boolean editproduct(Product P) 
	{
		boolean b=productservice.editproduct(P);
		return b;
		
	}


	@Override
	public boolean deleteproduct(int id) 
	{
		boolean b=productservice.deleteproduct(id);
		return b;
		
	}
	
	
	@Override
	public List<Product> showproduct() 
	{
		return  productservice.showproduct();
	
	}


	@Override
	public Product showoneproduct(int id) 
	{
	return productservice.showoneproduct(id);
	}
	
}
