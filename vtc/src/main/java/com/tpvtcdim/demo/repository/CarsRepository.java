package com.tpvtcdim.demo.repository;

import com.tpvtcdim.demo.model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepository extends JpaRepository<Cars, Integer> {
}
