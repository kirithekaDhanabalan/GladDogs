package com.gladdogs.gladdogsbd.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gladdogs.gladdogsbd.DAO.CartDao;
import com.gladdogs.gladdogsbd.model.Cart;
import com.gladdogs.gladdogsbd.model.CartId;
import com.gladdogs.gladdogsbd.model.Product;

@Repository
public class CartDaoImpl implements CartDao
{
	@Autowired
    SessionFactory sessionFactory;

	@Override
	public boolean insertproducttocart(Cart cart) 
	{
		try 
		{
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			s.save(cart);
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
	public List<Cart> singleUserCart(String username) {
		// TODO Auto-generated method stub
		try 
		{
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			Criteria c=s.createCriteria(Cart.class);
			c.add(Restrictions.eq("CartId", username));
			List<Cart> singleusercart=c.list();
			t.commit();
			s.close();
			return singleusercart;
		} 
		catch (Exception e)
		{
			return null;
		}
	}

	@Override
	public boolean updateproducttocart(Cart cart) {
		// TODO Auto-generated method stub
		try 
		{
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			s.update(cart);
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
	public List<Cart> singleprodfromcart(String prodname,String username) {
		// TODO Auto-generated method stub
		try 
		{
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			Criteria c=s.createCriteria(Cart.class);
			c.add(Restrictions.eq("prodname", prodname));
			c.add(Restrictions.eq("CartId", username));
			List<Cart> singleprodfromusercart=c.list();
			t.commit();
			s.close();
			return singleprodfromusercart;
		} 
		catch (Exception e)
		{
			return null;
		}
	}

	@Override
	public boolean initCartforuser(CartId cartid) {
		// TODO Auto-generated method stub
		try 
		{
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			s.save(cartid);
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
	public boolean deletecartproduct(int id) 
	{
		try 
		{
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			Cart cartprodel=s.get(Cart.class,id);
			s.delete(cartprodel);
			t.commit();
			s.close();
			return true;
		} 
		catch (Exception e)
		{
			return false;
		}
	}
}





//package com.gladdogs.gladdogsbd.daoimpl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.gladdogs.gladdogsbd.DAO.CartDao;
//import com.gladdogs.gladdogsbd.model.Cart;
//import com.gladdogs.gladdogsbd.model.Product;
//
//public class CartDaoImpl implements CartDao {
//	
//	@Autowired
//	SessionFactory sessionFactory;
//
//	@Override
//	public boolean insertproduct(Product P) {
//
//		return false;
//	} 
//	
//	@Override
//	public boolean editproduct(Product P) 
//	{
//		try 
//		{
//			Session s = sessionFactory.openSession();
//			Transaction t = s.getTransaction();
//			t.begin();
//			s.update(P);
//			t.commit();
//			s.close();
//			return true;
//		} 
//		catch (Exception e)
//		{
//			return false;
//		}
//	}
//
//	@Override
//	public boolean deleteproduct(int id) 
//	{
//		try 
//		{
//			Session s = sessionFactory.openSession();
//			Transaction t = s.getTransaction();
//			t.begin();
//			Product proddel=s.get(Product.class,id);
//			s.delete(proddel);
//			t.commit();
//			s.close();
//			return true;
//		} 
//		catch (Exception e)
//		{
//			return false;
//		}
//	}
//
//
//	@Override
//	public List<Cart> viewItemsInCart(int id) 
//	{
//		Session s = sessionFactory.openSession();
//		Transaction t = s.getTransaction();
//		t.begin();
//		List<Cart> l=s.createQuery("from Cart").list();
//		t.commit();
//		s.close();
//		return l;
//	}
//
//}