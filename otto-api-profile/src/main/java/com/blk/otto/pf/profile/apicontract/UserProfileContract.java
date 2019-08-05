package com.blk.otto.pf.profile.apicontract;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileContract {
	
	@ApiModelProperty(notes = "User email address")
	private String emailAddress;
	
	@ApiModelProperty(notes = "User retirement age")
	private Integer retirementAge;
	
	@ApiModelProperty(notes = "User marital status")
	private String maritalStatus;
	
}
