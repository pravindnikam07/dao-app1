package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDAO;
import com.masai.dao.EmployeeDAOImpl;
import com.masai.exceptions.EmplyeeException;

public class GetNameAddress {
	public static void main(String[] args) {
		
		EmployeeDAO edao = new EmployeeDAOImpl();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter employee ID");
		int eid = scan.nextInt();
		scan.close();
		
		try {
			String[] nameAddress = edao.getNameAndAddress(eid);
			System.out.println("Employee name is "+nameAddress[0]+" & Address is "+nameAddress[1]);
		} catch (EmplyeeException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
