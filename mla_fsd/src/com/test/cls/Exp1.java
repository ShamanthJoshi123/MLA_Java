package com.test.cls;

import java.util.ArrayList;
import java.util.ListIterator;

public class Exp1 {

	public static void main(String[] args) {
		//Collection data=new ArrayList();
		//List data=new ArrayList();
		ArrayList data=new ArrayList();
		//LinkedList data=new LinkedList();
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
		System.out.println(data);
		data.set(7, true);
		data.subList(6, 10);
		System.out.println(data.size());
		System.out.println(data.getFirst());
		System.out.println(data.getLast());
		
		ListIterator ltr=data.listIterator();
		while(ltr.hasNext()) {
			System.out.println(ltr.next());
		}
		System.out.println("========");
		while(ltr.hasPrevious()) {
			System.out.println(ltr.previous());
		}
	}

}
