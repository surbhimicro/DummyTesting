package com.blk.otto.pf.profile.repository;

import java.util.List;
import java.util.Optional;

import com.blk.otto.pf.profile.entity.Plan;

public interface IPlanRepository {

	public Plan save(Plan entity);

	public Optional<Plan> findById(Long id);

	public boolean existsById(Long id);

	public long count();

	public void deleteById(Long id);

	public void delete(Plan entity);

	public void deleteAll();

	public List<Plan> findAll();
	
}
