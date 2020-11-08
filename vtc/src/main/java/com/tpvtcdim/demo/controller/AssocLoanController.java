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




}
