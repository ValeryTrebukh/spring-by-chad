package com.jhedeen.chad74.service;

import com.jhedeen.chad74.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();

    Employee getById(int id);

    void save (Employee employee);

    void deleteById(int id);
}
