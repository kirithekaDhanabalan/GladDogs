package com.gladdogs.gladdogsbd.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gladdogs.gladdogsbd.DAO.CategoryDao;
import com.gladdogs.gladdogsbd.model.Category;
import com.gladdogs.gladdogsbd.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService 
{
	@Autowired
	CategoryDao categoryservice;
	
	@Override
    public boolean insertcategory(Category C)
    {
		boolean b=categoryservice.insertcategory(C);
		return b;
    }

	@Override
	public boolean editcategory(Category C)
	{
		boolean b=categoryservice.editcategory(C);
		return b;
	}

	@Override
	public boolean deletecategory(int id)
	{
		boolean b=categoryservice.deletecategory(id);
		return b;
	}

	@Override
	public List<Category> showcategory() 
	{
		return  categoryservice.showcategory();
	}

	@Override
	public Category showonecat(int id) 
	{
			return categoryservice.showonecat(id);
	}
   
}
