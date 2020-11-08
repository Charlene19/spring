package com.tpvtcdim.demo.services;

import com.tpvtcdim.demo.model.Loan;
import com.tpvtcdim.demo.repository.LoanRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.ejb.HibernateEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;

@Service
public class LoanServices {
@Autowired
    LoanRepository loanRepository;

public void createLoan(Loan loan){loanRepository.save(loan);}
public Integer findLast(){
   List<Loan> findLast = loanRepository.findAll();
int lastLoanId = 0;
    for (Loan loan: findLast) {
        while (lastLoanId > loan.getLoanId())
            lastLoanId = loan.getLoanId();
    }
return lastLoanId;}

public List<Loan> loanList(){return loanRepository.findAll();}
}
