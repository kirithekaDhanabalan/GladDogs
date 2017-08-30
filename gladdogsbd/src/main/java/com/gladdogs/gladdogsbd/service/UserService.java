package com.gladdogs.gladdogsbd.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gladdogs.gladdogsbd.model.UserReg;


public interface UserService
{
	boolean insertuser(UserReg U);
	UserReg showuser(String emailid);
	List<UserReg> allUsers();
}
