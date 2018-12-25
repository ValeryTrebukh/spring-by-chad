package com.jhedeen.chad74.dao;

import com.jhedeen.chad74.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAll() {
        Query query = entityManager.createQuery("from Employee");
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee getById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {
        Employee emp = entityManager.merge(employee);
        employee.setId(emp.getId());
    }

    @Override
    public void deleteById(int id) {

        Query query = entityManager.createQuery("delete from Employee where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
