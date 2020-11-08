package com.tpvtcdim.demo.controller;


import com.tpvtcdim.demo.model.Conductor;
import com.tpvtcdim.demo.services.ConductorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ConductorController {

    @Autowired
    ConductorServices conductorServices;

    @PostMapping("/createConductor")
    public String addConductor(@RequestParam String prenom, @RequestParam String nom){

        Conductor conductor = new Conductor();
        conductor.setConductorName(nom);
        conductor.setConductorLname(prenom);

        conductorServices.createConductor(conductor);
        return ("/Ajout");
    }

    @GetMapping("/listConductors")
    public String getConductors(Model model){
        java.util.List<Conductor> conductors = conductorServices.listConductor();
        model.addAttribute("conductors", conductors);

        return "listConductors";
    }

    @RequestMapping(value ="/deleteConductor/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(name = "id") String id){


        return ("listConductors");
    }
}
