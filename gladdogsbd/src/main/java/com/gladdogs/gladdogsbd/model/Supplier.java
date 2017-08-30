package com.gladdogs.gladdogsbd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Supplier
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int SupplierId;
	@Column(unique=true,nullable=false)
	String SupplierName;
	@Column(nullable=false)
	String SupplierAddress;
	@Column(unique=true,nullable=false)
	int SupplierPhonenumber;
	int SupplierAlternatePhonenumber;
	@Column(unique=true,nullable=false)
	String SupplierEmailid;
	
	public int getSupplierId() {
		return SupplierId;
	}
	public void setSupplierId(int supplierId) {
		SupplierId = supplierId;
	}
	public String getSupplierName() {
		return SupplierName;
	}
	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}
	public String getSupplierAddress() {
		return SupplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		SupplierAddress = supplierAddress;
	}
	public int getSupplierPhonenumber() {
		return SupplierPhonenumber;
	}
	public void setSupplierPhonenumber(int supplierPhonenumber) {
		SupplierPhonenumber = supplierPhonenumber;
	}
	public int getSupplierAlternatePhonenumber() {
		return SupplierAlternatePhonenumber;
	}
	public void setSupplierAlternatePhonenumber(int supplierAlternatePhonenumber) {
		SupplierAlternatePhonenumber = supplierAlternatePhonenumber;
	}
	public String getSupplierEmailid() {
		return SupplierEmailid;
	}
	public void setSupplierEmailid(String supplierEmailid) {
		SupplierEmailid = supplierEmailid;
	}
	

	
}
