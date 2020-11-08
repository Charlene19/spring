package com.tpvtcdim.demo.services;

import com.tpvtcdim.demo.model.Customer;
import com.tpvtcdim.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServices {

@Autowired
    CustomerRepository customerRepository;

public void createCustomer(Customer customer){customerRepository.save(customer);}
public void deleteCustomer(Customer customer){customerRepository.delete(customer);}
public List<Customer> customerList(){ return customerRepository.findAll();}
}
