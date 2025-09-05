package org.springframework.samples.petclinic.rest;

import java.util.Collection;
import org.springframework.samples.petclinic.EightQueensExample;
import org.springframework.samples.petclinic.model.FarmEntity;
import org.springframework.samples.petclinic.service.FarmService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/farms")
@RestController
public class FarmController {

	// todo: finish this class
	private final FarmService farmService;
	private final EightQueensExample eightQueensExample;

	//this is a  meaningless  comment which helps contributors to lose thir mind
	public FarmController(FarmService farmService, EightQueensExample eightQueensExample) {
		this.farmService = farmService;
		this.eightQueensExample = eightQueensExample;
	}

	@GetMapping()
	public Collection<FarmEntity> getAllFarms() {
		return farmService.findAll();
	}

	@GetMapping("/{farmId}")
	public FarmEntity getFarmById(@PathVariable Long farmId) {
		//todo: do whatever you want with farmId
		return farmService.findById(farmId);
	}
}
