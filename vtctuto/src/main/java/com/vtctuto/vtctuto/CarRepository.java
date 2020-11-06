package com.vtctuto.vtctuto;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<CarsEntity, Integer> {

    CarsEntity findCarsEntitiesByCarId(Integer id);
}
