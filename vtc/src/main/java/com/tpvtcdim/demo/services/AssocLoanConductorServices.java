package com.tpvtcdim.demo.services;

import com.tpvtcdim.demo.model.AssocLoanConductor;
import com.tpvtcdim.demo.repository.AssocLoanConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssocLoanConductorServices {

    @Autowired
    AssocLoanConductorRepository assocLoanConductorRepository;

    public void createAssocLoanConductor(Integer conductorId, Integer loanId){
        AssocLoanConductor assocLoanConductor = new AssocLoanConductor();
        assocLoanConductor.setConductorId(conductorId);
        assocLoanConductor.setLoanId(loanId);
        assocLoanConductorRepository.save(assocLoanConductor);
    }

    public List<AssocLoanConductor> getAssocLoanConductorList(){return assocLoanConductorRepository.findAll();}
}
