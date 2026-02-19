package com.test.fls;

import java.io.*;

public class Employee implements Serializable{

	private static final long serialVersionUID=1L;
	private int id=101;
	private String name="Shamanth";
	private String cmp="Mphasis";
	private transient int pin=560048;
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", cmp=" + cmp + "]";
	}
		
	
}
