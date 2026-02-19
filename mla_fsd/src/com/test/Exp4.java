package com.test;

public class Exp4 {

	public static void main(String[] args) {
//		System.out.println("MLA");
//		System.out.println(11/0); -DivisionByZero Exception
//		System.out.println("coders");
//		String name="java"; - StringIndexOutOfBound Exception
//		System.out.println(name.charAt(6));
//		int[] arr= {2,4,5,6,6,7}; - ArrayIndexOutOfBound Exception
//		System.out.println(arr[8]);
//		int x=Integer.parseInt("22a3"); - Number format Exception
		
		try {
			System.out.println(11/11);
		}
		catch(ArithmeticException ae) {
			
		}
		catch(NullPointerException ne) {
			
		}
		catch(Exception e) {
			System.out.println("Try Again");
		}
		finally {
			System.out.println("Finally block");
		}
		
	}

}

/*Default Package-java.lang.*;
 * Default super class - java.lang.Object; 
 */
