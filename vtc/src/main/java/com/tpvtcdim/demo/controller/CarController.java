package com.tpvtcdim.demo.controller;


import com.tpvtcdim.demo.model.Cars;
import com.tpvtcdim.demo.services.CarsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class CarController {

    @Autowired
    CarsServices carsServices;
    @Value("${method.unavailable}")
    private String erreurMessage;

    @PostMapping("/createCars")
    public String addCar(@RequestParam String marque, @RequestParam String modele, @RequestParam String couleur, @RequestParam String immatriculation) {
        Cars car = new Cars();
        car.setCarBrand(marque);
        car.setCarColor(couleur);
        car.setCarModel(modele);
        car.setCarRegistration(immatriculation);

        carsServices.createCar(car);

        return ("/Ajout");
    }

    @GetMapping("/listCars")
    public String list(Model model) {

        java.util.List<Cars> cars = carsServices.listCars();
        model.addAttribute("cars", cars);



        return "listCars";
    }


    @GetMapping(value ="/deleteCar")
    public String delete(Cars cars, Model model){
        cars = (Cars) model.getAttribute("cars");
        carsServices.deleteCar(cars);

        return "/Ajout";
    }

    @GetMapping(value ="/updateCar")
    public  String updateCar(@ModelAttribute("cars")Cars cars, Model model){

         cars = (Cars) model.getAttribute("cars");
        if(cars != null) {
            model.addAttribute("cars", cars);
        }else{
            model.addAttribute("erreurMessage", erreurMessage);
            return "/Erreur";
        }
        return "/updateCar";
    }

}
