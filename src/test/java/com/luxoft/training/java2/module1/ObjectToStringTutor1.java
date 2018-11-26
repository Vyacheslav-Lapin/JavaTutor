package com.luxoft.training.java2.module1;

import static com.luxoft.training.Logger.log;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.luxoft.training.java2.module1.ObjectMethodsTutor1.EmployeeType;

public class ObjectToStringTutor1 {
	class Employee {
		public String name;
		public String surname;
		public int age;
		
		public Employee(String name, String surname, int age) {
			this.name = name;
			this.surname = surname;
			this.age = age;
		}
		
		public String toString() {
			return this.name+" "+this.surname+", возраст:"+age;
		}

	}
	
	public List<Employee> getEmployees(EmployeeType type) {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee( "Иван", "Иванов", 35));
		employees.add(new Employee("Иван", "Иванов", 30));
		employees.add(new Employee("Иван", "Петров", 25));
		employees.add(new Employee("Иван", "Сидоров", 25));
		return employees;
	}
	
	@Test
	public void testEmployees() {	
		List<Employee> employees = getEmployees(EmployeeType.Default);
		int index=0;
		for (Employee employee: employees) {
			log("emp"+ index++ +"="+employee);
		}
	}
	
}
