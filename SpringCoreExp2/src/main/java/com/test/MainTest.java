package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		//Customer obj = ctx.getBean("cst1", Customer.class); 
		//System.out.println(obj);
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AnnoConfig.class);
		Customer cst = ctx.getBean(Customer.class);	
		
		cst.setId(1122);
		cst.setName("SKY");
		List<Address> list = new ArrayList<>();
		Address aobj = ctx.getBean(AnnoConfig.getAddress().getClass());
		aobj.setCity("Tirumala");
		aobj.setState("AP");
		aobj.setCountry("INDIA");
		
		list.add(aobj);
		cst.setAdr(list);
		System.out.println(cst);
			
		Address aobj1 = ctx.getBean(AnnoConfig.getAddress1().getClass());
		aobj1.setCity("Bangalore");
		aobj1.setState("KA");
		aobj1.setCountry("INDIA");
		
		System.out.println(cst);
	}
}
