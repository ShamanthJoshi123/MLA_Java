package com.test;

import java.util.List;

public class TestStudent {
	public static void main(String[] args) {
		StudentDao sdao = new StudentDao();
		Student stud1 = new Student();
		stud1.setUsn(125);
		stud1.setName("Sandeep");
		stud1.setClg("RVCE");
		stud1.setBranch("IOT");
		
//		sdao.saveStudent(stud1);
//		System.out.println("Saved Student Data.");
//		sdao.updateStudent(stud1);
//		System.out.println("Updated Student Data.");
		sdao.deleteStudent(125);
		System.out.println("Deleted Student Data.");
		List<Student> data = sdao.getAllStudents();
		data.forEach(System.out::println);
	}
}
