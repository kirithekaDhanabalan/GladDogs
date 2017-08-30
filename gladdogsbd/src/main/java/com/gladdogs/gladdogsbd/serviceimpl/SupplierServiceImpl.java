package com.gladdogs.gladdogsbd.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gladdogs.gladdogsbd.DAO.SupplierDao;
import com.gladdogs.gladdogsbd.model.Supplier;
import com.gladdogs.gladdogsbd.service.SupplierService;


@Service
@Transactional
public class SupplierServiceImpl implements SupplierService
{
	@Autowired
	SupplierDao supplierservice;

	@Override
	public boolean insertsupplier(Supplier S) 
	{
		boolean b=supplierservice.insertsupplier(S);
		return b;
	}

	@Override
	public boolean editsupplier(Supplier S) 
	{
		boolean b=supplierservice.editsupplier(S);
		return b;
	}

	@Override
	public boolean deletesupplier(int S)
	{
		boolean b=supplierservice.deletesupplier(S);
		return b;
	}

	@Override
	public List<Supplier> showsupplier() 
	{
		return supplierservice.showsupplier();
		
	}

	@Override
	public Supplier showonesupplier(int id)
	{
	
		return supplierservice.showonesupplier(id);
	}

	
}
