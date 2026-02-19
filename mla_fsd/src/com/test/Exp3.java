package com.test;

@FunctionalInterface
interface FunInf1{
	String greetUser(String name,String msg);
}

public class Exp3 {
	public void show() {
		System.out.println("Hello");
	}

	public static void main(String[] args) {
		FunInf1 obj1=(String name, String msg) -> {
			System.out.println("Hi "+name+" "+msg);
			return "Hello "+name+" MLA "+msg;
		};
		System.out.println(obj1.greetUser("Shamanth", ", Welcome to FSD MetaGeek Coders"));
		Exp3 obj2=new Exp3();
		obj2.show();
	}

}


//Integer xx=x; //Auto Boxing

/*
 * System - public final class
 * out - public static final property, object of printStream class
 * println - overloaded method of printStream class accessed by out object
 */