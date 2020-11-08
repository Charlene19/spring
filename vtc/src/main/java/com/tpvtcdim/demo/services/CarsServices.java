package com.tpvtcdim.demo.services;

import com.tpvtcdim.demo.model.Cars;
import com.tpvtcdim.demo.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsServices {

    @Autowired
    CarsRepository carsRepository;

    public void createCar(Cars cars){carsRepository.save(cars); }

    public void deleteCar(Cars car){carsRepository.delete(car);
    }
    public List<Cars> listCars(){return carsRepository.findAll();}
}
