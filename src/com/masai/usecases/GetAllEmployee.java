package com.masai.usecases;

import java.util.List;

import com.masai.dao.EmployeeDAO;
import com.masai.dao.EmployeeDAOImpl;
import com.masai.exceptions.EmplyeeException;
import com.masai.model.Employee;

public class GetAllEmployee {

	public static void main(String[] args) {
		EmployeeDAO edao = new EmployeeDAOImpl();
		try {
			List<Employee> employees = edao.getAllEmployee();
			employees.forEach(System.out::println);
			
		} catch (EmplyeeException e) {
			System.out.println(e.getMessage());
		}
	}
}
