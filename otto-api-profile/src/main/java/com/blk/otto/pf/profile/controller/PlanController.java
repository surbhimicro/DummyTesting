package com.blk.otto.pf.profile.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blk.otto.pf.profile.apicontract.PlanContract;
import com.blk.otto.pf.profile.entity.Plan;
import com.blk.otto.pf.profile.service.IPlanService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("plan")
public class PlanController {

	private IPlanService planService;
	
	private ModelMapper modelMapper;

	/** 
	 * constructor injection
	 * @param planRepository
	 * @param planService
	 * @param modelMapper
	 */
	@Autowired
	public PlanController(IPlanService planService, ModelMapper modelMapper) {
		this.planService = planService;
		this.modelMapper = modelMapper;
	}

	/**
	 * @return: get all plan available
	 */
	@ApiOperation("Get all plans")
	@GetMapping
	public List<Plan> getPlans() {
		return planService.findAll();
	}

	/**
	 * @param id
	 * @return: get plan for the requested id
	 */
	@ApiOperation("Get plan from id")
	@GetMapping("{id}")
	public Plan getPlan(@PathVariable("id") Long id) {
		return planService.findById(id).orElse(new Plan());
	}

	/**
	 * Plan entity in request body to add plan
	 * @param plan
	 */
	@ApiOperation("Add a new plan")
	@PostMapping
	public void addPlan(@RequestBody PlanContract planContract) {
		planService.save(modelMapper.map(planContract, Plan.class));
	}


	/**
	 * Id to delete plan
	 * @param id
	 */
	@ApiOperation("Delete a plan from id")
	@DeleteMapping("{id}")
	public void deletePlan(@PathVariable("id") Long id) {
		planService.deleteById(id);
	}

	
	/**
	 * Adds the passed age to minAge and maxAge of plan id
	 * @param id: id of the plan
	 * @param age: age to add
	 */
	@ApiOperation("Add age to minAge and maxAge of plan")
	@PutMapping("addAge/{age}/id/{id}")
	public void addToAge(@PathVariable("id") Long id, @PathVariable("age") int age) {
		planService.addToAge(id, age);
	}

	/**
	 * Subtracts the passed age from minAge and maxAge of plan id
	 * @param id: id of the plan
	 * @param age: age to add
	 */
	@ApiOperation("Subtract age from minAge and maxAge of plan")
	@PutMapping("subtractAge/{age}/id/{id}")
	public void subtractFromAge(@PathVariable("id") Long id, @PathVariable("age") int age) {
		planService.subtractFromAge(id, age);
	}
}
