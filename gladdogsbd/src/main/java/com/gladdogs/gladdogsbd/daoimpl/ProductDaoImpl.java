package com.gladdogs.gladdogsbd.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gladdogs.gladdogsbd.DAO.ProductDao;
import com.gladdogs.gladdogsbd.model.Product;
import com.google.gson.Gson;

@Repository
public class ProductDaoImpl implements ProductDao
{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean insertproduct(Product P) 
	{
		try 
		{
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			s.save(P);
			t.commit();
			s.close();
			return true;
		} 
		catch (Exception e)
		{
			return false;
		}

	}
	
	public boolean editproduct(Product P) 
	{
		try 
		{
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			s.update(P);
			t.commit();
			s.close();
			return true;
		} 
		catch (Exception e)
		{
			return false;
		}


	}

	public boolean deleteproduct(int id) 
	{
		try 
		{
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			Product proddel=s.get(Product.class,id);
			s.delete(proddel);
			t.commit();
			s.close();
			return true;
		} 
		catch (Exception e)
		{
			return false;
		}

	}

	@Override
	public List<Product> showproduct() 
	{

		Session s = sessionFactory.openSession();
		Transaction t = s.getTransaction();
		t.begin();
		List<Product> l=s.createQuery("from Product").list();
		t.commit();
		s.close();
		return l;
	}

	
	public Product showoneproduct(int id) 
	{
		try 
		{
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			Product showpro=s.get(Product.class,id);
			t.commit();
			s.close();
			return showpro;
		} 
		catch (Exception e)
		{
			return null;
		}
	}
}
