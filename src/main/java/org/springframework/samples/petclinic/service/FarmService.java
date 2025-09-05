package org.springframework.samples.petclinic.service;

import java.util.Collection;
import org.springframework.samples.petclinic.model.FarmEntity;
import org.springframework.samples.petclinic.repository.FarmRepository;
import org.springframework.stereotype.Service;

@Service
public class FarmService {
	private final FarmRepository farmRepository;

	public FarmService(FarmRepository farmRepository) {
		this.farmRepository = farmRepository;
	}

	public Collection<FarmEntity> findAll() {
		return farmRepository.findAll();
	}

	public FarmEntity findById(long id) {
		return farmRepository.findById(id).orElseThrow();
	}

	public void save(FarmEntity farm) {
		farmRepository.save(farm);
	}

	public void delete(FarmEntity farm) {
		farmRepository.delete(farm);
	}





}
