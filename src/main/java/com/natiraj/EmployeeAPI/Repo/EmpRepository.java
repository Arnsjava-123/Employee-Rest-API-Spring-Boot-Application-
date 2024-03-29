package com.natiraj.EmployeeAPI.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.natiraj.EmployeeAPI.Entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer>{

	Employee save(Integer id);
	

}
