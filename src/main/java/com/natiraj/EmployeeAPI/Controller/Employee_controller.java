package com.natiraj.EmployeeAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.natiraj.EmployeeAPI.Entity.Employee;
import com.natiraj.EmployeeAPI.Services.Emp_Service;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class Employee_controller {

    @Autowired
    private Emp_Service employeeService;

    @GetMapping("/get")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Integer id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found with ID: " + id);
        }
    }

    @PostMapping("/save")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Integer id, @RequestBody Employee updatedEmployee) {
        updatedEmployee.setId(id); // Set the ID of the updated employee
        Employee updated = employeeService.updateEmployee(updatedEmployee);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found with ID: " + id);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Integer id) {
        Employee deletedEmployee = employeeService.deleteEmployee(id);
        if (deletedEmployee != null) {
            return ResponseEntity.ok(deletedEmployee);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found with ID: " + id);
        }
    }
}
