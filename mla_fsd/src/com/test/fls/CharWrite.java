package com.test.fls;

import java.io.*;

public class CharWrite {

	public static void main(String[] args) throws Exception{
		FileWriter fw=new FileWriter("src/ct.txt");
		BufferedWriter bw=new BufferedWriter(fw);
		String msg="This is simple char stream write and read msg";
		bw.write(msg);
		bw.flush();
		System.out.println("Done.");
	}

}
