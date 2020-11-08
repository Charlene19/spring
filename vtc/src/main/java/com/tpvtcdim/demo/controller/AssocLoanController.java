package com.tpvtcdim.demo.controller;

import com.tpvtcdim.demo.model.Loan;
import com.tpvtcdim.demo.services.AssocLoanConductorServices;
import com.tpvtcdim.demo.services.LoanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;



@Controller
public class AssocLoanController {

    @Autowired
    AssocLoanConductorServices assocLoanConductorServices;

    @Autowired
    LoanServices loanServices;

    @RequestMapping (value="/createLoan", method = RequestMethod.POST)
    public String createAssoc(@RequestParam Integer conductorId, Integer loanId) {
        Loan loan = new Loan();
        Date date = new Date(17/11/2010);
        loan.setLoanDateEnd(date);
        loan.setLoanDateStart(date);
        loanServices.createLoan(loan);

        loanId = loanServices.findLast();
      assocLoanConductorServices.createAssocLoanConductor(conductorId, loanId);

        return "Réservation ajoutée";
    }


}
