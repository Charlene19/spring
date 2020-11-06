package com.vtctuto.vtctuto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @PostMapping("/createCars")
    public String addCar(@RequestParam String marque, @RequestParam String modele, @RequestParam String couleur, @RequestParam String registration) {
        CarsEntity carsEntity = new CarsEntity();
        carsEntity.setCarBrand(marque);
        carsEntity.setCarColor(couleur);
        carsEntity.setCarModel(modele);
        carsEntity.setCarRegistration(registration);

        return "Nouvelle voiture ajoutée";
    }

    @GetMapping("/listCars")
    public Iterable<CarsEntity> getCars(){
        return carRepository.findAll();
    }
}
