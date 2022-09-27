package com.masai.dao;

import java.util.List;

import com.masai.exceptions.EmplyeeException;
import com.masai.model.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getAllEmployee() throws EmplyeeException;
	public String getAddressOfEmployee(int empId) throws EmplyeeException;
	public String giveBonusToEmployee(int empId, int bonus) throws EmplyeeException;
	public boolean deleteEmployee(int empId) throws EmplyeeException;
	public String[] getNameAndAddress(int empId) throws EmplyeeException;

}
