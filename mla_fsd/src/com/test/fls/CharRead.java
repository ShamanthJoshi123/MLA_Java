package com.test.fls;

import java.io.*;

public class CharRead {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new FileReader("src/ct.txt"));
		System.out.println(br.readLine());
	}

}
