package com.tpvtcdim.demo.controller;

import com.tpvtcdim.demo.model.AssocLoanConductor;
import com.tpvtcdim.demo.model.Cars;
import com.tpvtcdim.demo.model.Conductor;
import com.tpvtcdim.demo.model.Loan;
import com.tpvtcdim.demo.services.AssocLoanConductorServices;
import com.tpvtcdim.demo.services.CarsServices;
import com.tpvtcdim.demo.services.ConductorServices;
import com.tpvtcdim.demo.services.LoanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;


@Controller
public class LoanController {

    @Autowired
    LoanServices loanServices;
@Autowired
    CarsServices carsServices;
    @Autowired
    ConductorServices conductorServices;
    @Autowired
    AssocLoanConductorServices assocLoanConductorServices;

    @GetMapping("/listLoan")
    public String getLoans(Model model){
        java.util.List<Loan> loans = loanServices.loanList();
        java.util.List<Conductor> conductors = conductorServices.listConductor();
        model.addAttribute("conductors", conductors);
        model.addAttribute("loans", loans);
        return "listLoans";

    }
    
    @GetMapping(value="/Loan")
    public  String createBooking(Model model){
        java.util.List<Cars> cars = carsServices.listCars();
        java.util.List<Conductor> conductors = conductorServices.listConductor();
        model.addAttribute("conductors", conductors);
        model.addAttribute("cars", cars);
        AssocLoanConductor assocLoanConductor = new AssocLoanConductor();
        model.addAttribute("assocLoanConductor", assocLoanConductor);
        return "Loan";
    }

    @PostMapping (path="/createLoan")
    public String createAssoc(AssocLoanConductor assocLoanConductor, Model model) {

        model.addAttribute("assocLoanConductor", assocLoanConductor);
        Loan loan = new Loan();
        loan.setLoanDateEnd(new java.sql.Date(2020,11,20));
        loan.setLoanDateStart(new java.sql.Date(2020,11,28));
        loanServices.createLoan(loan);

        int loanId = loanServices.findLast();

        assocLoanConductorServices.createAssocLoanConductor(assocLoanConductor);

        return ("/Ajout");
    }

    @RequestMapping(value ="/createL", method = RequestMethod.POST)
    public String ajout(@Validated AssocLoanConductor assocLoanConductor, BindingResult bindingResult, Model model) {

        model.addAttribute("assocLoanConductor", new AssocLoanConductor());



        if(bindingResult.hasErrors()) {
            return "Erreur";
        }

        assocLoanConductorServices.createAssocLoanConductor(assocLoanConductor);

        return "redirect:/listCustomers";
    }

    @GetMapping(value ="/deleteLoan")
    public String delete(Loan loan, Model model){
        loan = (Loan) model.getAttribute("loan");
loanServices.deleteLoan(loan);

        return "/Ajout";
    }


}
