package com.tpvtcdim.demo.repository;

import com.tpvtcdim.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
