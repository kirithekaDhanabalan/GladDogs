        package com.gladdogs.gladdogsbd.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gladdogs.gladdogsbd.DAO.CategoryDao;
import com.gladdogs.gladdogsbd.model.Category;
import com.google.gson.Gson;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;

	public boolean insertcategory(Category C) 
	{
		try 
		{
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			s.save(C);;
			t.commit();
			s.close();
			return true;
		} 
		catch (Exception e)
		{
			return false;
		}

	}

	public boolean editcategory(Category C) 
	{
		try 
		{
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			s.update(C);
			t.commit();
			s.close();
			return true;
		} 
		catch (Exception e)
		{
			return false;
		}


	}

	public boolean deletecategory(int id) 
	{
		try 
		{
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			Category delcat=s.get(Category.class,id);
			s.delete(delcat);
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
	public List<Category> showcategory()
	{
		Session s = sessionFactory.openSession();
		Transaction t = s.getTransaction();
 		t.begin();
		List<Category> l=s.createQuery("from Category").list();
		t.commit();
		s.close();
		return l;
	}

	@Override
	public Category showonecat(int id) 
	{
		try 
		{
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			Category showcat=s.get(Category.class,id);
			t.commit();
			s.close();
			return showcat;
		} 
		catch (Exception e)
		{
			return null;
		}
	
	}
    
}


