package com.test.fls;

import java.io.*;

public class ByteWrite {

	public static void main(String[] args) throws Exception{
		File file=new File("src/emp.text");
		FileOutputStream fos=new FileOutputStream(file);
		/*
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		String msg="This is simple byte stream write and read msg";
		bos.write(msg.getBytes());
		bos.flush();
		*/
		ObjectOutputStream obj=new ObjectOutputStream(fos);
		Employee emp = new Employee();
		obj.writeObject(emp);
		System.out.println("Done.");
	}

}
