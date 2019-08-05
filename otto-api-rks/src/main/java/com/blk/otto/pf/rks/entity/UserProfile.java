package com.blk.otto.pf.rks.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {

	private String participantId;
	
	private String azureB2CId;
	
	private String appuserId;
	
	private String employmentStatus;
	
	private String employmentStatusEffectiveDate;
	
	private String emailAddress;
	
	private Integer retirementAge;
	
	private BigDecimal salary;
	
	private BigDecimal annualBonusAmount;
	
	private Boolean jointLife;
	
	private Boolean cola;
	
	private Boolean socialSecurity;
	
	private String maritalStatus;
	
	private String participantDOB;
	
	private String spouseDOB;
	
	private String alternateEmail;

}
