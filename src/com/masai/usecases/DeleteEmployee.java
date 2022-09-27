package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDAO;
import com.masai.dao.EmployeeDAOImpl;
import com.masai.exceptions.EmplyeeException;

public class DeleteEmployee {
	
	public static void main(String[] args) {
		EmployeeDAO edao = new EmployeeDAOImpl();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter employee ID");
		int eid = scan.nextInt();
		scan.close();
		
		try {
			boolean isDeleted = edao.deleteEmployee(eid);
			System.out.println(isDeleted);
		} catch (EmplyeeException e) {
			System.out.println(e.getMessage());
		}
	}
}
