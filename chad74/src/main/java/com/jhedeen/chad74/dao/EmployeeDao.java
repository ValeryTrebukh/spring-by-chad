package com.jhedeen.chad74.dao;


import com.jhedeen.chad74.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAll();

    Employee getById(int id);

    void save (Employee employee);

    void deleteById(int id);
}
