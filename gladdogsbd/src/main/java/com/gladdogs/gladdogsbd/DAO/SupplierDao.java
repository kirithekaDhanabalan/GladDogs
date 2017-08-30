package com.gladdogs.gladdogsbd.DAO;

import java.util.List;

import com.gladdogs.gladdogsbd.model.Supplier;

public interface SupplierDao 
{
	 List<Supplier> showsupplier();
	 boolean insertsupplier(Supplier S);
	 boolean editsupplier(Supplier S);
	 boolean deletesupplier(int id);
	 Supplier showonesupplier(int id);

}
