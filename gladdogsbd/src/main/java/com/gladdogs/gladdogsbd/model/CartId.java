package com.gladdogs.gladdogsbd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CartId {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int Id;
	@Column
	String Cartid;
	@Column
	boolean Status=true;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}

	
	public String getCartid() {
		return Cartid;
	}
	public void setCartid(String cartid) {
		Cartid = cartid;
	}
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}


}
