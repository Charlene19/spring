package com.vtctuto.vtctuto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @Autowired private LoanEntityRepository loanEntityRepository;

    @GetMapping("/listLoan")
    public Iterable<LoanEntity> getLoans(){
        return loanEntityRepository.findAll();

    }

}
