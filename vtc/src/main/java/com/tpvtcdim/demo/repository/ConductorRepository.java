package com.tpvtcdim.demo.repository;

import com.tpvtcdim.demo.model.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConductorRepository extends JpaRepository<Conductor, Integer> {
}
