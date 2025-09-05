package org.springframework.samples.petclinic.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/farms")
@RestController
public class FarmController {

	private final FarmService farmService;

	public FarmController(FarmService farmService) {
		this.farmService = farmService;
	}

	@GetMapping()
	public Collection<Farm> getAllFarms() {
		return farmService.findAll();
	}

	@GetMapping("/{farmId}")
	public Farm getFarmById(@PathVariable Integer farmId) {
		return farmService.findById(farmId);
	}
}
