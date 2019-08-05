package com.blk.otto.pf.profile.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blk.otto.pf.profile.entity.Plan;
import com.blk.otto.pf.profile.repository.IPlanRepository;
import com.blk.otto.pf.profile.service.IPlanService;

@Service
public class PlanService implements IPlanService{
	
	private IPlanRepository planRepository;
	
	/**
	 * @param planRepository: constructor injection
	 */
	@Autowired
	public PlanService(IPlanRepository planRepository) {
		this.planRepository = planRepository;
	}

	/**
	 * Method to add age to minAge and maxAge
	 * @param id
	 * @param age
	 */
	@Override
	public void addToAge(long id, int age) {
		Plan plan = planRepository.findById(id).orElseThrow();
		plan.setMaxAge(plan.getMaxAge() + age);
		plan.setMinAge(plan.getMinAge() + age);
		planRepository.save(plan);
	}
	
	/**
	 * Method to subtract age from minAge and maxAge
	 * @param id
	 * @param age
	 */
	@Override
	public void subtractFromAge(long id, int age) {
		Plan plan = planRepository.findById(id).orElseThrow();
		plan.setMaxAge(plan.getMaxAge() - age);
		plan.setMinAge(plan.getMinAge() - age);
		planRepository.save(plan);
	}

	@Override
	public Plan save(Plan entity) {
		return planRepository.save(entity);
	}

	@Override
	public Optional<Plan> findById(Long id) {
		return planRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return planRepository.existsById(id);
	}

	@Override
	public long count() {
		return planRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		planRepository.deleteById(id);
	}

	@Override
	public void delete(Plan entity) {
		planRepository.delete(entity);
	}

	@Override
	public void deleteAll() {
		planRepository.deleteAll();
	}

	@Override
	public List<Plan> findAll() {
		return planRepository.findAll();
	}
}
