package com.vtctuto.vtctuto;

import org.springframework.data.repository.CrudRepository;

public interface ConductorEntityRepository extends CrudRepository<ConductorEntity, Integer> {

    ConductorEntity findConductorEntitiesByConductorId(Integer id);
}
