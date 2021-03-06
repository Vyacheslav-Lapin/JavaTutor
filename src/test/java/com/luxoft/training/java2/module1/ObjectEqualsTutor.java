package com.luxoft.training.java2.module1;

import static com.luxoft.training.Logger.log;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.luxoft.training.java2.module1.ObjectMethodsTutor.EmployeeType;

/**
 * Реализуйте в классе Employee методы hashSet() и equals() так, 
 * чтобы сравнивалось полное имя, но не возраст сотрудника.
 *
 */
public class ObjectEqualsTutor {
	class Employee {
		public String name;
		public String surname;
		public int age;
		
		public Employee(String name, String surname, int age) {
			this.name = name;
			this.surname = surname;
			this.age = age;
		}
		public String getFullName() {
			return this.name+" "+this.surname;
		}
		
		public String toString() {
			return this.name+" "+this.surname+", возраст:"+age;
		}
	}
	
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Иван", "Иванов", 35));
		employees.add(new Employee("Иван", "Иванов", 30));
		employees.add(new Employee("Иван", "Петров", 25));
		employees.add(new Employee("Иван", "Сидоров", 25));
		return employees;
	}
	
	public Set<Employee> getEmployeesSet(EmployeeType type) {
		Set<Employee> employeesSet = new HashSet<Employee>();
		employeesSet.addAll(getEmployees());
		return employeesSet;
	}

	@Test
	public void testEmployees() {	
		List<Employee> employees = getEmployees();
		int index=0;
		for (Employee employee: employees) {
			log("emp"+ index++ +"="+employee);
		}
		
		log("***“Тестируем equals: ***");
		employees = getEmployees(); 
		for (int i=0;i<3;i++) {
			log("emp"+i+".equals(emp"+(i+1)+")="+
					employees.get(i).equals(employees.get(i+1)));
		}
		assertEquals(employees.get(0), employees.get(1));
		assertNotSame(employees.get(1), employees.get(2));
		assertNotSame(employees.get(2), employees.get(3));
	}
	
	@Test
	public void testEmployeesSet() {
		Set<Employee> employeesSet;
		log("***Тестируем HashSet: Employee");
		employeesSet = getEmployeesSet(EmployeeType.ByName);
		for (Employee employee: employeesSet) {
			log(employee);
		}
		assertEquals(employeesSet.size(), 3);
	}
}
