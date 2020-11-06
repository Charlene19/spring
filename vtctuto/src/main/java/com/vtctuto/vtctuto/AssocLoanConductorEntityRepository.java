package com.vtctuto.vtctuto;

import org.springframework.data.repository.CrudRepository;

public interface AssocLoanConductorEntityRepository extends CrudRepository<AssocLoanConductorEntity, Integer> {

    AssocLoanConductorEntity findAssocLoanConductorEntitiesByLoanIdAndConductorId(Integer id, Integer id2);
}
