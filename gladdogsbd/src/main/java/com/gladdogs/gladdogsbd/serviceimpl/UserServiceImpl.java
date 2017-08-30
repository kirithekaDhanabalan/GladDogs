package com.gladdogs.gladdogsbd.serviceimpl;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gladdogs.gladdogsbd.DAO.UserDao;
import com.gladdogs.gladdogsbd.model.UserReg;
import com.gladdogs.gladdogsbd.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
	@Autowired
	UserDao userservice;
	
	public boolean insertuser(UserReg U)
	{
		boolean b=userservice.insertuser(U);
		return b;
	}

	@Override
	public UserReg showuser(String emailid)
	{
		return userservice.showuser(emailid); 
	}

	@Override
	public List<UserReg> allUsers() {
		// TODO Auto-generated method stub
		return userservice.allUsers();
	}

}
