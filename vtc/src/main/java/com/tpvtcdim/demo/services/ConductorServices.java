package com.tpvtcdim.demo.services;

import com.tpvtcdim.demo.model.Conductor;
import com.tpvtcdim.demo.repository.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConductorServices {

    @Autowired
    ConductorRepository conductorRepository;

    public void createConductor(Conductor conductor){conductorRepository.save(conductor);}
public void deleteConductor(Conductor conductor){conductorRepository.delete(conductor);}
public List<Conductor> listConductor(){return conductorRepository.findAll();}
}
