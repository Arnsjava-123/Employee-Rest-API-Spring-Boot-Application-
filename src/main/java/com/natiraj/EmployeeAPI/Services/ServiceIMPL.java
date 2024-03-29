package com.natiraj.EmployeeAPI.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natiraj.EmployeeAPI.Entity.Employee;
import com.natiraj.EmployeeAPI.Repo.EmpRepository;

@Service
public class ServiceIMPL implements Emp_Service{

    @Autowired
    private EmpRepository empRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return empRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return empRepository.getById(id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return empRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee updatedEmployee) {
       
        Employee updateEmployee = empRepository.findById(updatedEmployee.getId())
                .orElseThrow(() -> new IllegalArgumentException("Employee with ID " + updatedEmployee.getId() + " not found"));

       
        updateEmployee.setFname(updatedEmployee.getFname());
        updateEmployee.setLname(updatedEmployee.getLname());
        updateEmployee.setEmail(updatedEmployee.getEmail());
        updateEmployee.setPhone(updatedEmployee.getPhone());
        updateEmployee.setAddress(updatedEmployee.getAddress());
        
       
        // Save and return the updated employee
        return empRepository.save(updateEmployee);
    }

    @Override
    public Employee deleteEmployee(Integer id) {
        Employee employeeToDelete = empRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee with ID " + id + " not found"));

        empRepository.delete(employeeToDelete);
        return employeeToDelete;
    }

	
}
