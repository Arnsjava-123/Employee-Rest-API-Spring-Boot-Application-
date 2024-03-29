package com.natiraj.EmployeeAPI.Services;

import java.util.List;

import com.natiraj.EmployeeAPI.Entity.Employee;

public interface Emp_Service {


	List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer id);

    Employee saveEmployee(Employee employee);
    
    Employee deleteEmployee(Integer id);

//    Employee updateEmployee(Integer id);

	Employee updateEmployee(Employee updatedEmployee);

	


	
	

}
