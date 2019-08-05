package com.blk.otto.pf.profile.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plan {
	
	private Long id;

	private String name;

	private int minAge;

	private int maxAge;
	
}
