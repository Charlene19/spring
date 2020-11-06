package com.vtctuto.vtctuto;

import org.springframework.data.repository.CrudRepository;

public interface LoanEntityRepository extends CrudRepository<LoanEntity, Integer> {

    LoanEntity findLoanEntitiesByLoanId(Integer id);
}
