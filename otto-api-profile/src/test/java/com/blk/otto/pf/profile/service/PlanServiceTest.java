package com.blk.otto.pf.profile.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.blk.otto.pf.profile.entity.Plan;
import com.blk.otto.pf.profile.repository.IPlanRepository;
import com.blk.otto.pf.profile.service.impl.PlanService;

@SpringBootTest
public class PlanServiceTest {

	@MockBean
	private IPlanRepository planRepository;

	@Autowired
	private PlanService planService;

	@Test
	public void testAddToAge() {
		Optional<Plan> plan = Optional.of(new Plan(1L, "otto", 20, 30));

		when(planRepository.findById(1L)).thenReturn(plan);
		planService.addToAge(1, 10);

		verify(planRepository, times(1)).save(plan.orElse(null));
	}

	@Test
	public void testSubtractFromAge() {
		Optional<Plan> plan = Optional.of(new Plan(1L, "otto", 20, 30));

		when(planRepository.findById(1L)).thenReturn(plan);
		planService.subtractFromAge(1, 10);

		verify(planRepository, times(1)).save(plan.orElse(null));
	}

}
