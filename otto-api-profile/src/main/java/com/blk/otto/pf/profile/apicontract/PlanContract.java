package com.blk.otto.pf.profile.apicontract;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanContract {
	
	@ApiModelProperty(notes = "Plan Name")
	private String name;
	
	@ApiModelProperty(notes = "Min age to subscribe the plan")
	private int minAge;
	
	@ApiModelProperty(notes = "Max age to subscribe the plan")
	private int maxAge;	
	
}
