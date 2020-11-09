package com.tpvtcdim.demo.controller;

import com.tpvtcdim.demo.model.*;
import com.tpvtcdim.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @Autowired
    AssocLoanCarServices assocLoanCarServices;

    @Value("${erreur.car.unavailable}")
    private String erreurMessage;

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
    public String createAssoc(@RequestParam String Cars, AssocLoanConductor assocLoanConductor, Model model) {

        model.addAttribute("assocLoanConductor", assocLoanConductor);
        if (assocLoanCarServices.carAlreadyBooks(Integer.parseInt(Cars))){
            model.addAttribute("erreurMessage", erreurMessage);
            return ("/Erreur");
        }
        Loan loan = new Loan();
        loan.setLoanDateEnd(new java.sql.Date(2020,11,20));
        loan.setLoanDateStart(new java.sql.Date(2020,11,28));
        loanServices.createLoan(loan);

        int loanId = loanServices.findLast();

        assocLoanConductorServices.createAssocLoanConductor(assocLoanConductor);
        AssocLoanCar assocLoanCar = new AssocLoanCar();
        assocLoanCar.setCarId(Integer.parseInt(Cars));
        assocLoanCar.setLoanId(loanId);


        assocLoanCarServices.createAssocLoanCar(assocLoanCar);

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
