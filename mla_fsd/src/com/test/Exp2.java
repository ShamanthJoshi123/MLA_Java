package com.test;

@FunctionalInterface
interface FunInf{ //one abstract method, multiple static/default methods
	void draw();
	
	default void dog() {
		
	}
	static void cat() {
		
	}
}

class Circle implements FunInf{
	@Override
	public void draw() {
		System.out.println("circle");
	}
}
class Square implements FunInf{
	@Override
	public void draw() {
		System.out.println("sqaure");
	}
	//factory method
	public Square getObj() {
		System.out.println("object returned");
		return new Square();
	}
}
public class Exp2 {
	public static void main(String[] args) {
		Circle obj1=new Circle();
		obj1.draw();
		FunInf obj2=new Square(); //Dynamic Binding- Parent reference to child class object creation
		
		obj2.draw();
//		Square obj3=obj2.getObj(); //factory method
		
		FunInf obj3= () -> {
			System.out.println("circle1"); //Lambda Exp
			return;
		};
		obj3.draw();
	}
}
