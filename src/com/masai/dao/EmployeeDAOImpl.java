package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.exceptions.EmplyeeException;
import com.masai.model.Employee;
import com.masai.utility.DBUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public List<Employee> getAllEmployee() throws EmplyeeException {
		List<Employee> employees = new ArrayList<>();
		try(Connection conn = DBUtil.ProvideConnection()) {
			PreparedStatement ps = conn.prepareStatement("Select * from emp");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				employees.add(new Employee(rs.getInt("eid"), rs.getString("name"), rs.getString("address"), rs.getInt("salary")));
			}
			if(employees.size() == 0)
				throw new EmplyeeException("Employees not found");
			
		} catch (SQLException e) {
			throw new EmplyeeException(e.getMessage());
		}
		
		return employees;
	}

	@Override
	public String getAddressOfEmployee(int empId) throws EmplyeeException {
		String address = null;
		try(Connection conn = DBUtil.ProvideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select address from emp where eid=?");
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				address = rs.getString("address");
			else
				throw new EmplyeeException("Employee not found with the empID "+empId);
			
		} catch (SQLException e) {
			throw new EmplyeeException(e.getMessage());
		}
		
		return address;
	}

	@Override
	public String giveBonusToEmployee(int empId, int bonus) throws EmplyeeException {
		String bonusGiven = null;
		try(Connection conn = DBUtil.ProvideConnection()) {
			PreparedStatement ps = conn.prepareStatement("update emp set salary = salary+? where eid=?");
			ps.setInt(1, bonus);
			ps.setInt(2, empId);
			int res = ps.executeUpdate();
			
			if(res>0)
				bonusGiven = "Bonus added successfully";
			else
				throw new EmplyeeException("Employee not found with the empID "+empId);
			
		} catch (SQLException e) {
			throw new EmplyeeException(e.getMessage());
		}
		
		return bonusGiven;
	}

	@Override
	public boolean deleteEmployee(int empId) throws EmplyeeException {
		boolean flag = false;
		try(Connection conn = DBUtil.ProvideConnection()) {
			PreparedStatement ps = conn.prepareStatement("delete from emp where eid=?");
			ps.setInt(1, empId);
			int res = ps.executeUpdate();
			
			if(res>0)
				flag = true;
			else
				throw new EmplyeeException("Employee not found with the empID "+empId);
		} catch (SQLException e) {
			throw new EmplyeeException(e.getMessage());
		}
		return flag;
	}

	@Override
	public String[] getNameAndAddress(int empId) throws EmplyeeException {
		String[] nameAddress = new String[2];
		try(Connection conn = DBUtil.ProvideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select name, address from emp where eid=?");
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				nameAddress[0] = rs.getString("name");
				nameAddress[1] = rs.getString("address");
			}
			else
				throw new EmplyeeException("Employee not found with the empID "+empId);
			
		} catch (SQLException e) {
			throw new EmplyeeException(e.getMessage());
		}
		return nameAddress;
	}

}
