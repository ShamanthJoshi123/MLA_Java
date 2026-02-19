package com.test.cls;

import java.util.Stack;


public class Exp2 {

	public static void main(String[] args) {
		Stack data=new Stack();
		data.add(200);
		data.add('a');
		data.add(33);
		data.add(200);
		data.add("java");
		data.add("test");
		data.add(33.33f);
		data.add(false);
		data.add("java");
		data.add(345l);
		System.out.println(data.peek());
		data.push("mla");
		System.out.println(data.peek());
		System.out.println(data.pop());
		System.out.println(data.search("java"));
		System.out.println(data.empty());
		data.clear();
		System.out.println(data.empty());
	}

}
