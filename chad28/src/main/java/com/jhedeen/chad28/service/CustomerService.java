package com.jhedeen.chad28.service;

import com.jhedeen.chad28.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);
}
