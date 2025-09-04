package org.springframework.samples.petclinic.rest;

import java.util.Collection;
import org.springframework.samples.petclinic.model.FarmEntity;
import org.springframework.samples.petclinic.service.FarmService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.model.Farm;

@RequestMapping("/farms")
@RestController
public class FarmController {
//deneme salak sacma gelisiguzel coommmentler


public FarmController(FarmService farmService) {
		this.farmService = farmService;
	}

	@GetMapping()
	public Collection<FarmEntity> getAllFarms() {
		return farmService.findAll();
	}

	@GetMapping("/{farmId}")
	public FarmEntity getFarmById(@PathVariable Integer farmId) {
	//todo: do whatever you want with farmId
	return farmService.findById(farmId);
	}

	private final FarmService farmService;
}
