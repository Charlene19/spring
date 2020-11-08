package com.tpvtcdim.demo.controller;


import com.tpvtcdim.demo.model.Cars;
import com.tpvtcdim.demo.services.CarsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    CarsServices carsServices;

    @PostMapping("/createCars")
    public String addCar(@RequestParam String marque, @RequestParam String modele, @RequestParam String couleur, @RequestParam String immatriculation) {
        Cars car = new Cars();
        car.setCarBrand(marque);
        car.setCarColor(couleur);
        car.setCarModel(modele);
        car.setCarRegistration(immatriculation);

        carsServices.createCar(car);
        String reponse = "Nouvelle voiture ajoutée";
        return reponse;
    }

    @GetMapping("/listCars")
    public String list(Model model) {

        java.util.List<Cars> cars = carsServices.listCars();
        model.addAttribute("cars", cars);



        return "listCars";
    }


   @RequestMapping(value ="/deleteCar/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(name = "id") String id){


        return ("listCars");
    }

}
