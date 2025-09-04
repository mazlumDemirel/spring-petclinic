package org.springframework.samples.petclinic.service;

public class FarmService {
	private final FarmRepository farmRepository;

  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  public Collection<Farm> findAll() {
    return farmRepository.findAll();
  }

  public Farm findById(Integer id) {
    return farmRepository.findById(id);
  }

  public void save(Farm farm) {
    farmRepository.save(farm);
  }

  public void delete(Farm farm) {
    farmRepository.delete(farm);
  }
}
