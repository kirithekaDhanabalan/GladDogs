package com.gladdogs.gladdogsbd.daoimpl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.gladdogs.gladdogsbd.DAO.UserDao;
import com.gladdogs.gladdogsbd.model.Product;
import com.gladdogs.gladdogsbd.model.Supplier;
import com.gladdogs.gladdogsbd.model.UserReg;
import com.gladdogs.gladdogsbd.model.UserRegCred;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;

	public boolean insertuser(UserReg U) {
		try {
			System.out.println("at dao");
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			s.save(U);
			System.out.println(U.getUserName());
			UserRegCred uc = new UserRegCred();
			uc.setEmailid(U.getEmailId());
			uc.setUpassword(U.getUpassword());
			s.save(uc);
			t.commit();
			s.close();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public UserReg showuser(String emailid) {
		try {
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			UserReg r=null;
			List<UserReg> l = s.createQuery("from UserReg").list();
			Iterator<UserReg> u = l.iterator();
			while (u.hasNext()) {
				r = u.next();
				if (r.getEmailId().equals(emailid))
					break;
			}
			t.commit();
			s.close();
			return r;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<UserReg> allUsers() {
		// TODO Auto-generated method stub
		Session s = sessionFactory.openSession();
		Transaction t = s.getTransaction();
		t.begin();
		List<UserReg> l=s.createQuery("from UserReg").list();
		t.commit();
		s.close();
		return l;
	}
}
