package com.jhedeen.chad63.rest;

import com.jhedeen.chad63.entity.Customer;
import com.jhedeen.chad63.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomers(@PathVariable int id) {
        Customer customer = customerService.getCustomer(id);

        if(customer == null) {
            throw new CustomerNotFoundException("Customer not found for id " + id);
        }

        return customer;
    }

}
