package com.tpvtcdim.demo.repository;

import com.tpvtcdim.demo.model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface CarsRepository extends JpaRepository<Cars, Integer> {

    @Transactional
    @Query("update Cars c SET c.carBrand = :carBrand, c.carModel = :carModel, c.carColor = :carColor, c.carRegistration = :carRegistration where c.carId = :carId")
    @Modifying
    void metAJourNom(@Param("carId")Integer carId);
}
