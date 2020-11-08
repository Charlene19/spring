package com.tpvtcdim.demo.controller;

import com.tpvtcdim.demo.model.Conductor;
import com.tpvtcdim.demo.model.Loan;
import com.tpvtcdim.demo.services.ConductorServices;
import com.tpvtcdim.demo.services.LoanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LoanController {

    @Autowired
    LoanServices loanServices;

    @Autowired
    ConductorServices conductorServices;

    @GetMapping("/listLoan")
    public String getLoans(Model model){
        java.util.List<Loan> loans = loanServices.loanList();
        java.util.List<Conductor> conductors = conductorServices.listConductor();
        model.addAttribute("loans", loans);
        return "listLoans";

    }

    @RequestMapping(value ="/deleteLoan/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(name = "id") String id){


        return ("listLoans");
    }


}
