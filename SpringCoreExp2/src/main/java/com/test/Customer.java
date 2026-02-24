package com.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Customer {
	private int id;
	private String name;
	@Autowired
	private List<Address> adr;
	
	public Customer() {}
	
	
	
	public Customer(int id, String name, List<Address> adr) {
		super();
		this.id = id;
		this.name = name;
		this.adr = adr;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Address> getAdr() {
		return adr;
	}

	public void setAdr(List<Address> adr) {
		this.adr = adr;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", adr=" + adr + "]";
	}
	
	
	
}
