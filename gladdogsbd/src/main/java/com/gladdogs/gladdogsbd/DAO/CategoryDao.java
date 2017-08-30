package com.gladdogs.gladdogsbd.DAO;

import java.util.List;

import com.gladdogs.gladdogsbd.model.Category;

public interface CategoryDao 
{
	List<Category> showcategory();
	boolean insertcategory(Category C);
	boolean editcategory(Category C);
	boolean deletecategory(int id);
	Category showonecat(int id);
}
