package com.vtctuto.vtctuto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConductorController {

    @Autowired private ConductorEntityRepository conductorEntityRepository;

    @PostMapping("/createConductor")
    public String addConductor(@RequestParam String prenom, @RequestParam String nom){

        ConductorEntity conductorEntity = new ConductorEntity();
        conductorEntity.setConductorName(nom);
        conductorEntity.setConductorLname(prenom);

        conductorEntityRepository.save(conductorEntity);
        return "Conducteur ajouté";
    }

    @GetMapping("/listConductors")
    public Iterable<ConductorEntity> getConductors(){
        return conductorEntityRepository.findAll();
    }
}
