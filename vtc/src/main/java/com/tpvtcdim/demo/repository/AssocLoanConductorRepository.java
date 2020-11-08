package com.tpvtcdim.demo.repository;

import com.tpvtcdim.demo.model.AssocLoanConductor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface AssocLoanConductorRepository extends JpaRepository<AssocLoanConductor, Integer> {

    AssocLoanConductor findAssocLoanConductorByConductorIdAndAndLoanId(Integer id, Integer id2);
}
