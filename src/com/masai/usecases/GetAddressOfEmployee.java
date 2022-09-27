package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDAO;
import com.masai.dao.EmployeeDAOImpl;
import com.masai.exceptions.EmplyeeException;

public class GetAddressOfEmployee {

	public static void main(String[] args) {
		EmployeeDAO edao = new EmployeeDAOImpl();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter employee ID");
		int eid = scan.nextInt();
		scan.close();
		
		try {
			String address = edao.getAddressOfEmployee(eid);
			System.out.println("Employees whose id is "+ eid +" is from "+ address);
		} catch (EmplyeeException e) {
			System.out.println(e.getMessage());
		}
	}
}
