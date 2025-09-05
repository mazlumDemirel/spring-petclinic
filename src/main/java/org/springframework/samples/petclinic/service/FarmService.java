package org.springframework.samples.petclinic.service;

import java.util.Collection;
import org.springframework.samples.petclinic.model.Farm;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.samples.petclinic.repository.FarmRepository;
import org.springframework.samples.petclinic.repository.FarmRepository;

public class FarmService {
	private final FarmRepository farmRepository;

  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  public Collection<Farm> findAll() {
    return farmRepository.findAll();
  }

	public Farm findById(long id) {
		return farmRepository.findById(id).orElseThrow();
  }

  public void save(Farm farm) {
    farmRepository.save(farm);
  }

  public void delete(Farm farm) {
    farmRepository.delete(farm);
  }




}
