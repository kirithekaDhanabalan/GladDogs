package com.gladdogs.gladdogsbd.service;

import java.util.List;

import com.gladdogs.gladdogsbd.model.Category;


public interface CategoryService 
{
	List<Category> showcategory();
	boolean insertcategory(Category C);
	boolean editcategory(Category C);
	boolean deletecategory(int id);
	Category showonecat(int id);

}
