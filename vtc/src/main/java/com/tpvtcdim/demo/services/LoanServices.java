package com.tpvtcdim.demo.services;

import com.tpvtcdim.demo.model.Loan;
import com.tpvtcdim.demo.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

public Optional<Loan> findById(Integer id){return loanRepository.findById(id);}

public void deleteLoan(Loan loan){loanRepository.delete(loan);}
}
