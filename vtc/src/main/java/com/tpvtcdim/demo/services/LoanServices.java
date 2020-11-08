package com.tpvtcdim.demo.services;

import com.tpvtcdim.demo.model.Loan;
import com.tpvtcdim.demo.repository.LoanRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    Session session = sessionFactory.getCurrentSession();
    String lastID = "select max(loanId) from Loan;";
    Query query  = session.createQuery(lastID);
    Integer lastLoanId = query.getFirstResult();
return lastLoanId;}

public List<Loan> loanList(){return loanRepository.findAll();}
}
