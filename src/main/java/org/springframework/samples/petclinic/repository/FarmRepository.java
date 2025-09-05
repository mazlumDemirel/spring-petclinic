package org.springframework.samples.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.model.FarmEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmRepository extends JpaRepository<FarmEntity, Long> {

}
