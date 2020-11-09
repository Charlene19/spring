package com.tpvtcdim.demo.repository;

import com.tpvtcdim.demo.model.AssocLoanCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssocLoanCarRepository extends JpaRepository<AssocLoanCar, Integer> {

boolean existsAssocLoanCarByCarId(int carId);
}
