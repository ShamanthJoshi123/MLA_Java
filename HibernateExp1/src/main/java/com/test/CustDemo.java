package com.test;

import java.util.List;

public class CustDemo {
	public static void main(String[] args) {
		CustDao cdao = new CustDao();
		Customer cst = new Customer();
		cst.setC_id(3);
		cst.setC_name("Sanath");
		cst.setC_city("Chennai");
		cdao.saveCustomer(cst);
		//cdao.updateCustomer(cst);
		//cdao.deleteCustomer(cst);
		List<Customer> list = cdao.getAllCustomers();
		list.forEach(System.out::println);
	} 
}
