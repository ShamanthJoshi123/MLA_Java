package com.test;

import java.util.List;

public class TestDemo {
	public static void main(String[] args) {
		EmpDao edao = new EmpDao();
		Employee emp1 = new Employee();
		emp1.setId(3);
		emp1.setName("Surya");
		emp1.setCmp("Meta");
		emp1.setCity("Hyderabad");
		
//		edao.saveEmployee(emp1);
//		System.out.println("Saved Employee Data.");
//		edao.updateEmployee(emp1);
//		System.out.println("Updated Employee Data.");
		edao.deleteEmployee(3);
		System.out.println("Deleted Employee Data.");
		List<Employee> data = edao.getAllEmployees();
		data.forEach(System.out::println);
		
	}
}
