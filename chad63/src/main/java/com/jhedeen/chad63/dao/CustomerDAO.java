package com.jhedeen.chad63.dao;

import java.util.List;

import com.jhedeen.chad63.entity.Customer;

public interface CustomerDAO {

	List<Customer> getCustomers();

	void saveCustomer(Customer theCustomer);

	Customer getCustomer(int theId);

	void deleteCustomer(int theId);
	
}
