package com.tpvtcdim.demo.services;

import com.tpvtcdim.demo.model.AssocLoanCar;
import com.tpvtcdim.demo.repository.AssocLoanCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssocLoanCarServices {

    @Autowired
    AssocLoanCarRepository assocLoanCarRepository;
    public void createAssocLoanCar(AssocLoanCar assocLoanCar){assocLoanCarRepository.save(assocLoanCar);
    }
    public boolean carAlreadyBooks(int carId){return assocLoanCarRepository.existsAssocLoanCarByCarId(carId);}
}
