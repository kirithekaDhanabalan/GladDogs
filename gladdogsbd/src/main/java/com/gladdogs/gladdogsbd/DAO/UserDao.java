package com.gladdogs.gladdogsbd.DAO;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gladdogs.gladdogsbd.model.UserReg;


public interface UserDao
{
	boolean insertuser(UserReg U);
	UserReg showuser(String emailid);
	List<UserReg> allUsers();
}
