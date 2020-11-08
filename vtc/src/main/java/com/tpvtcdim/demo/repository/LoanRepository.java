package com.tpvtcdim.demo.repository;

import com.tpvtcdim.demo.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
}
