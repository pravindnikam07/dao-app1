package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDAO;
import com.masai.dao.EmployeeDAOImpl;
import com.masai.exceptions.EmplyeeException;

public class GiveBonusToEmployee {

	public static void main(String[] args) {
		EmployeeDAO edao = new EmployeeDAOImpl();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter employee ID");
		int eid = scan.nextInt();
		System.out.println("Enter bonus amount");
		int bonus = scan.nextInt();
		scan.close();
		
		try {
			String message = edao.giveBonusToEmployee(eid, bonus);
			System.out.println(message);
		} catch (EmplyeeException e) {
			System.out.println(e.getMessage());
		}
	}
}
