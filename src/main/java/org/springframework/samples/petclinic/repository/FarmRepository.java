package org.springframework.samples.petclinic.repository;

import org.springframework.data.*;
import org.springframework.data.jpa.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.samples.petclinic.model.FarmEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmRepository extends JpaRepository<FarmEntity, Long> {

}
