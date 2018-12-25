package com.jhedeen.chad74.rest;

import com.jhedeen.chad74.entity.Employee;
import com.jhedeen.chad74.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getById(id);

        if(employee == null) {
            throw new RuntimeException("Employee is not found for id " + id);
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {

        employee.setId(0);
        employeeService.save(employee);

        return employee;
    }


    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);

        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {

        if(employeeService.getById(id) == null) {
            throw new RuntimeException("Employee is not found for id " + id);
        }

        employeeService.deleteById(id);

        return "Deleted employee with id " + id;
    }
}
