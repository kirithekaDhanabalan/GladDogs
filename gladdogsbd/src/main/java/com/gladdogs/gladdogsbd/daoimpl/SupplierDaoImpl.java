package com.gladdogs.gladdogsbd.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gladdogs.gladdogsbd.DAO.SupplierDao;
import com.gladdogs.gladdogsbd.model.Supplier;
import com.google.gson.Gson;

@Repository
public class SupplierDaoImpl implements SupplierDao {
	@Autowired
	SessionFactory sessionFactory;

	public boolean insertsupplier(Supplier S) {
		try {
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			s.save(S);
			t.commit();
			s.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean editsupplier(Supplier S) {
		try {
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			s.update(S);
			;
			t.commit();
			s.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deletesupplier(int id) {
		try {
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			Supplier delsup = s.get(Supplier.class, id);
			s.delete(delsup);
			t.commit();
			s.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Supplier> showsupplier() {
		Session s = sessionFactory.openSession();
		Transaction t = s.getTransaction();
		t.begin();
		List<Supplier> l = s.createQuery("from Supplier").list();
		t.commit();
		s.close();
		return l;

	}

	@Override
	public Supplier showonesupplier(int id) {
		try {
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			Supplier showsup = s.get(Supplier.class, id);
			t.commit();
			s.close();
			return showsup;
		} catch (Exception e) {
			return null;
		}
	}
}
