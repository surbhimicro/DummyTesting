package com.blk.otto.pf.profile.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.blk.otto.pf.profile.entity.Plan;
import com.blk.otto.pf.profile.repository.IPlanRepository;

@Repository
public class PlanRepositoy implements IPlanRepository {
	
	private List<Plan> planList;

	public PlanRepositoy() {
		planList = new ArrayList<>();
		planList.add(new Plan(1L, "microsoft", 10, 20));
		planList.add(new Plan(2L, "blackrock", 20, 30));
	}

	@Override
	public Plan save(Plan entity) {
		entity.setId(Long.valueOf((long) (Math.random() * 1000 + 1)));
		planList.add(entity);
		return entity;
	}

	@Override
	public Optional<Plan> findById(Long id) {
		return planList.stream().filter(u -> u.getId().equals(id)).findFirst();
	}

	@Override
	public boolean existsById(Long id) {
		return planList.stream().filter(u -> u.getId().equals(id)).count() == 1;
	}


	@Override
	public long count() {
		return planList.size();
	}

	@Override
	public void deleteById(Long id) {
		planList.remove(this.findById(id).orElse(null));
	}

	@Override
	public void delete(Plan entity) {
		planList.remove(entity);
	}

	@Override
	public void deleteAll() {
		planList.clear();
	}

	@Override
	public List<Plan> findAll() {
		return planList;
	}

}
