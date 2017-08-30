package com.gladdogs.gladdogsbd.service;

import java.util.List;

import com.gladdogs.gladdogsbd.model.Supplier;

public interface SupplierService
{
	 List<Supplier> showsupplier(); 
	 boolean insertsupplier(Supplier S);
	 boolean editsupplier(Supplier S);
	 boolean deletesupplier(int id);
	 Supplier showonesupplier(int id);


}
