package com.tpvtcdim.demo.controller;


import com.tpvtcdim.demo.model.Cars;
import com.tpvtcdim.demo.services.CarsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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

   /* @GetMapping(value ="/updateCar")
    public  Cars updateCar(Cars cars, Model model){
        model.getAttribute("cars", cars);
        return
    }*/

}
