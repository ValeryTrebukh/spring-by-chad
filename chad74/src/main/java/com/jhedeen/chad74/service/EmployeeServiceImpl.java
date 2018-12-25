package com.jhedeen.chad74.service;

import com.jhedeen.chad74.dao.EmployeeDao;
import com.jhedeen.chad74.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(@Qualifier("employeeDaoJpaImpl") EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Override
    @Transactional
    public Employee getById(int id) {
        return employeeDao.getById(id);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDao.deleteById(id);
    }
}
