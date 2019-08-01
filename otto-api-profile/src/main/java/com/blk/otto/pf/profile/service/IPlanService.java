package com.blk.otto.pf.profile.service;

import com.blk.otto.pf.profile.common.IOperations;
import com.blk.otto.pf.profile.entity.Plan;

public interface IPlanService extends IOperations<Plan, Long> {

	public void addToAge(long id, int age);
	public void subtractFromAge(long id, int age);
	
}
