package com.test;


interface Inf1{
	float pi=3.14f; // public static final float pi=3.14;
	
	void disp(); // public abstract void disp();
	void cat();
	default void human() {
		System.out.println("default inf");
		animal();
	}
	static String greetUser(String msg) {
		//animal();
		return msg;
	}
	private void animal() {
		System.out.println("private method");
	}
	
	/*
	public Inf1() {
		//Interfaces cant have constructors
	}
	*/
}

interface Inf2{
	void book();
}

abstract class Abs1{
	public Abs1() {
		System.out.println("constructor");
	}
	public abstract void fox();
	public void color() { 
		System.out.println("implemented method abs1");
	}
}

class Impl1 extends Abs1 implements Inf1,Inf2{
	@Override
	public void fox() {
		System.out.println("abs implemented");
	}
	@Override
	public void book() {
		System.out.println("inf2 implemented");
	}
	@Override
	public void disp() {
		System.out.println("inf1 implemented");
	}
	@Override
	public void cat() {
		System.out.println("inf1 implemented");
	}
}

public class Exp1 {
	public static void main(String[] args) {
		Impl1 obj=new Impl1();
		obj.book();
		obj.cat();
		obj.disp();
		obj.human();
		obj.fox();
		obj.color();
		
	    System.out.println(Inf1.greetUser("Hello MLA Coders..."));
	}
}

/*
 * Different ways to create objects for a class
 * new Keyword
 * factory method
 * clone() method
 * Class.forName() dynamic object creation
 * static/compile-time polymorphism - overloading
 * dynamic/run-time polymorphism - overriding
 */

